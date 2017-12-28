/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.dueros.certificate;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * 签名认证
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年12月26日
 */
public class Certificate {

    private static final Logger logger = Logger.getLogger(Certificate.class.getName());

    // HTTP请求body
    private String message;
    // 签名
    private String signature;
    // 证书地址
    private String signaturecerturl;
    // 是否验证请求参数，默认为false，不验证
    private boolean enable = false;

    /**
     * 构造方法
     * 
     * @param message
     *            HTTP请求body
     * @param signature
     *            签名
     * @param signaturecerturl
     *            证书地址
     */
    public Certificate(final String message, final String signature, final String signaturecerturl) {
        this.message = message;
        this.signature = signature;
        this.signaturecerturl = signaturecerturl;
    }

    /**
     * 默认构造方法
     */
    public Certificate() {

    }

    /**
     * 打开验证请求参数
     * 
     * @return void
     */
    public void enableCertificate() {
        this.enable = true;
    }

    /**
     * 关闭验证请求参数
     * 
     * @return void
     */
    public void disableCertificate() {
        this.enable = false;
    }

    /**
     * 是否需要验证请求参数
     * 
     * @return boolean 是否需要验证请求参数
     */
    private boolean isEnable() {
        return this.enable;
    }

    /**
     * 验证签名
     * 
     * @return boolean 是否通过验证
     */
    public boolean verify() {
        // 如果不开启验证，则直接返回TRUE
        if (!isEnable()) {
            return true;
        }

        // 从证书中获取publickey
        PublicKey publicKey = this.getPublicKey();
        if (publicKey == null) {
            return false;
        }

        // 认证签名
        try {
            Signature sign = Signature.getInstance("SHA1WithRSA");
            sign.initVerify(publicKey);
            sign.update(message.getBytes("UTF-8"));
            return sign.verify(Base64.decodeBase64(signature.getBytes("UTF-8")));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * 从证书获取公钥
     * 
     * @return PublicKey 公钥
     */
    private PublicKey getPublicKey() {
        // 校验signaturecerturl是否为百度域
        if (!isBaiduDomain()) {
            logger.info("signaturecerturl is invalid url!");
            return null;
        }

        // 读取临时目录
        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println(tmpdir);

        try {
            // 根据signaturecerturl计算md5
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(signaturecerturl.getBytes());
            String md5 = new BigInteger(1, messageDigest.digest()).toString();
            String path = tmpdir + "/" + md5;
            File file = new File(path);

            // 如果不存在这个文件，需要从url中获取
            if (!file.exists()) {
                InputStream inputStream = this.download(signaturecerturl);
                this.putContentFile(path, IOUtils.toString(inputStream));
                return this.getPublicKeyFromUrl(inputStream);
            } else {
                // 如果存在这个文件，则从文件中直接读取
                return this.getPublicKeyFromString(this.getContentFromFile(path));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据inputStream获取publickey
     * 
     * @return PublicKey 公钥
     */
    private PublicKey getPublicKeyFromUrl(InputStream inputStream) {
        // 校验signaturecerturl是否为百度域
        if (!isBaiduDomain()) {
            logger.info("signaturecerturl is invalid url!");
            return null;
        }

        // 从证书inputStream中获取publickey
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
            PublicKey publicKey = certificate.getPublicKey();
            return publicKey;
        } catch (Exception exception) {
            logger.warn("get publickey faield " + exception);
        }
        return null;
    }

    /**
     * 根据signaturecerturl获取证书内容
     * 
     * @param signaturecerturl
     *            证书地址
     * @return InputStream
     */
    private InputStream download(String signaturecerturl) {
        try {
            URL url = new URL(signaturecerturl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3 * 1000);
            InputStream inputStream = connection.getInputStream();
            return inputStream;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从字符串中获取PublicKey
     * 
     * @param content
     *            字符串内容
     * @throws TODO
     * @return PublicKey
     */
    private PublicKey getPublicKeyFromString(String content) {
        try {
            InputStream inputStream = new ByteArrayInputStream(content.getBytes());
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
            PublicKey publicKey = certificate.getPublicKey();
            return publicKey;
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据文件路径获取文件内容
     * 
     * @param path
     *            文件路径
     * @return String 文件内容
     */
    private String getContentFromFile(String path) {
        try {
            return new Scanner(new File(path)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入文件内容
     * 
     * @param path
     *            文件路径
     * @param content
     *            文件内容
     * @return void
     */
    private void putContentFile(String path, String content) {
        File file = new File(path);
        try {
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 校验signaturecerturl是否为百度域以及HTTPS协议
     * 
     * @return boolean 是否为百度域
     */
    private boolean isBaiduDomain() {
        try {
            URL url = new URL(signaturecerturl);
            String protocol = url.getProtocol();
            // 必须是HTTPS协议
            if (!"https".equals(protocol.toLowerCase())) {
                return false;
            }
            // 域名必须是duer.bdstatic.com
            String host = url.getHost();
            if (!"duer.bdstatic.com".equals(host)) {
                return false;
            }
            // path必须以/saiya/flow/开头
            String path = url.getPath();
            if (!path.startsWith("/saiya/flow/")) {
                return false;
            }
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
