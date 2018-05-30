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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

/**
 * 签名认证
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年12月26日
 */
public class Certificate {

    // 签名
    private String signature;
    // 证书地址
    private String signaturecerturl;
    // HTTP请求body信息
    private String message;
    // 百度域名常量
    private static final String DOMAIN = "duer.bdstatic.com";

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
    public Certificate(final String signature, final String signaturecerturl, final String message) {
        this.signature = signature;
        this.signaturecerturl = signaturecerturl;
        this.message = message;
    }

    /**
     * 构造方法
     * 
     * @param request
     *            HttpServletRequest
     */
    public Certificate(HttpServletRequest request) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            Enumeration<String> headernames = request.getHeaderNames();
            while (headernames.hasMoreElements()) {
                String key = headernames.nextElement();
                String value = request.getHeader(key);
                map.put(key, value);
            }

            // 获取signature和signaturecerturl
            String signature = map.get("signature");
            String signaturecerturl = map.get("signaturecerturl");

            // 获取HTTP body
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
            StringBuffer stringBuffer = new StringBuffer("");
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuffer.append(temp);
            }
            String message = stringBuffer.toString();
            this.signature = signature;
            this.signaturecerturl = signaturecerturl;
            this.message = message;
        } catch (IOException e) {

        }

    }

    /**
     * 签名认证
     * 
     * @return boolean 验证是否正确
     */
    private static boolean verify(String body, String signature, PublicKey publicKey) {
        try {
            Signature sign = Signature.getInstance("SHA1WithRSA");
            sign.initVerify(publicKey);
            sign.update(body.getBytes("UTF-8"));
            return sign.verify(Base64.decodeBase64(signature.getBytes("UTF-8")));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 认证签名
     * 
     * @param cache
     *            缓存的认证信息
     * @param certificate
     *            认证对象
     * @return boolean
     */
    public static boolean verify(ConcurrentHashMap<String, PublicKey> cache, Certificate certificate) {
        if (cache == null) {
            return false;
        }
        return verify(certificate.getMessage(), certificate.getSignature(),
                cache.get(certificate.getSignaturecerturl()));
    }

    /**
     * 根据证书地址获取公钥
     * 
     * @param signaturecerturl
     *            证书地址
     * @return PublicKey 公钥
     */
    public static PublicKey getPublicKeyFromUrl(String signaturecerturl) {
        if (!isBaiduDomain(signaturecerturl)) {
            return null;
        }
        try {
            URL url = new URL(signaturecerturl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3 * 1000);
            InputStream inputStream = connection.getInputStream();
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
            PublicKey publicKey = certificate.getPublicKey();
            return publicKey;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验signaturecerturl是否为百度域以及HTTPS协议
     * 
     * @return boolean 是否为百度域
     */
    private static boolean isBaiduDomain(String signaturecerturl) {
        try {
            URL url = new URL(signaturecerturl);
            String protocol = url.getProtocol();
            // 必须是HTTPS协议
            if (!"https".equals(protocol.toLowerCase())) {
                return false;
            }
            // 域名必须是duer.bdstatic.com
            String host = url.getHost();
            if (!DOMAIN.equals(host)) {
                return false;
            }
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    /**
     * 获取签名
     * 
     * @return String 签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 获取证书地址
     * 
     * @return String 证书地址
     */
    public String getSignaturecerturl() {
        return signaturecerturl;
    }

    /**
     * 获取HTTP请求的body信息
     * 
     * @return String HTTP请求body信息
     */
    public String getMessage() {
        return message;
    }

}
