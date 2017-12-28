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

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.commons.codec.binary.Base64;

/**
 * 认证签名
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年12月28日
 */
public class Verfity {

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
     * 签名认证
     * 
     * @param certificate
     *            签名对象
     * @return boolean
     */
    public static boolean verify(Certificate certificate, String message) {
        if (certificate.isEnable() == false) {
            return true;
        }
        return verify(message, certificate.getSignature(), certificate.getPublicKey());
    }

    /**
     * 根据证书地址获取公钥
     * 
     * @param signaturecerturl
     *            证书地址
     * @return PublicKey 公钥
     */
    public static PublicKey getPublicKey(String signaturecerturl) {
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
            return false;
        }
    }
}
