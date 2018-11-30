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
package com.baidu.dueros.data.response.directive.pay;

public class Payload {

    private ChargeBaiduPay chargeBaiduPay = new ChargeBaiduPay();

    /**
     * 构造方法
     */
    public Payload() {

    }

    /**
     * 构造方法
     * 
     * @param amount
     *            价格信息
     * @param sellerOrderId
     *            订单号
     * @param productName
     *            商品名称
     * @param description
     *            商品描述
     */
    public Payload(String amount, String sellerOrderId, String productName, String description) {
        this.chargeBaiduPay = new ChargeBaiduPay(amount, sellerOrderId, productName, description);
    }

    /**
     * 设置amount的setter方法
     * 
     * @param amount
     *            价格信息
     * @return PayLoad
     */
    public Payload setAmount(String amount) {
        this.chargeBaiduPay.setAmount(amount);
        return this;
    }

    /**
     * 设置sellerOrderId的setter方法
     * 
     * @param sellerOrderId
     *            订单ID
     * @return PayLoad
     */
    public Payload setSellerOrderId(String sellerOrderId) {
        this.chargeBaiduPay.setSellerOrderId(sellerOrderId);
        return this;
    }

    /**
     * 设置productName的setter方法
     * 
     * @param productName
     *            商品名称
     * @return PayLoad
     */
    public Payload setProductName(String productName) {
        this.chargeBaiduPay.setProductName(productName);
        return this;
    }

    /**
     * 设置description的setter方法
     * 
     * @param description
     *            商品描述
     * @return PayLoad
     */
    public Payload setDescription(String description) {
        this.chargeBaiduPay.setDescription(description);
        return this;
    }

    /**
     * 设置currencyCode的setter方法
     * 
     * @param currencyCode
     *            币种
     * @return PayLoad
     */
    public Payload setCurrencyCode(String currencyCode) {
        this.chargeBaiduPay.setCurrencyCode(currencyCode);
        return this;
    }

    /**
     * 设置sellerAuthorizationNote的setter方法
     * 
     * @param sellerAuthorizationNote
     *            授权信息
     * @return PayLoad
     */
    public Payload setSellerAuthorizationNote(String sellerAuthorizationNote) {
        this.chargeBaiduPay.setSellerAuthorizationNote(sellerAuthorizationNote);
        return this;
    }

    /**
     * 设置sellerNote的setter方法
     * 
     * @param sellerNote
     *            商品描述
     * @return PayLoad
     */
    public Payload setSellerNote(String sellerNote) {
        this.chargeBaiduPay.setSellerNote(sellerNote);
        return this;
    }

    /**
     * getter方法
     * 
     * @return PayLoad
     */
    public ChargeBaiduPay getChargeBaiduPay() {
        return chargeBaiduPay;
    }
}
