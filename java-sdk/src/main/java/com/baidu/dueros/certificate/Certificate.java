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

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.apache.commons.codec.binary.Base64;
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
    public boolean isEnable() {
        return this.enable;
    }

    /**
     * 验证签名
     * 
     * @return boolean 是否通过验证
     */
    public boolean verify() {
        try {
            // 从证书中获取publickey
            PublicKey publicKey = this.getPublicKey();
            if (publicKey != null) {
                Signature sign = Signature.getInstance("SHA1WithRSA");
                sign.initVerify(publicKey);
                sign.update(this.message.getBytes("UTF-8"));
                // 认证签名
                return sign.verify(Base64.decodeBase64(signature.getBytes("UTF-8")));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 从证书获取公钥
     * 
     * @return PublicKey 公钥
     */
    public PublicKey getPublicKey() {
        try {
            // 根据signaturecerturl获取证书
            URL url = new URL(this.signaturecerturl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3 * 1000);
            InputStream inputStream = connection.getInputStream();

            // 从证书获取publickey
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
            PublicKey publicKey = certificate.getPublicKey();
            return publicKey;
        } catch (CertificateException e) {
            logger.warn("get publickey faield " + e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
