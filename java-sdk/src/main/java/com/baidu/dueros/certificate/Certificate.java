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

import java.security.PublicKey;

/**
 * 签名认证
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年12月26日
 */
public class Certificate {

    // 是否验证请求参数，默认为false
    private boolean enable = false;
    // 签名
    private String signature;
    // 证书地址
    private String signaturecerturl;
    // 证书公钥
    private PublicKey publicKey;

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
    public Certificate(final String signature, final String signaturecerturl) {
        this.signature = signature;
        this.signaturecerturl = signaturecerturl;
    }

    /**
     * 默认构造方法
     */
    public Certificate() {

    }

    /**
     * 拷贝构造法方法
     * 
     * @param certificate
     *            签名对象
     */
    public Certificate(Certificate certificate) {
        signature = certificate.signature;
        signaturecerturl = certificate.signaturecerturl;
        publicKey = certificate.publicKey;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignaturecerturl() {
        return signaturecerturl;
    }

    public void setSignaturecerturl(String signaturecerturl) {
        this.signaturecerturl = signaturecerturl;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

}
