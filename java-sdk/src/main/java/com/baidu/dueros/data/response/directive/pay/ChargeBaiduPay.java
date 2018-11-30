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

public class ChargeBaiduPay {

    private AuthorizeAttributes authorizeAttributes = new AuthorizeAttributes();
    private SellerOrderAttributes sellerOrderAttributes = new SellerOrderAttributes();

    /**
     * 构造方法
     */
    public ChargeBaiduPay() {

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
    public ChargeBaiduPay(String amount, String sellerOrderId, String productName, String description) {
        this.authorizeAttributes.setAmount(amount);
        this.sellerOrderAttributes.setSellerOrderId(sellerOrderId).setProductName(productName)
                .setDescription(description);
    }

    /**
     * 设置amount的setter方法
     * 
     * @param amount
     *            价格信息
     * @return ChargeBaiduPay
     */
    public ChargeBaiduPay setAmount(String amount) {
        this.authorizeAttributes.setAmount(amount);
        return this;
    }

    /**
     * 设置sellerOrderId的setter方法
     * 
     * @param sellerOrderId
     *            订单ID信息
     * @return ChargeBaiduPay
     */
    public ChargeBaiduPay setSellerOrderId(String sellerOrderId) {
        this.sellerOrderAttributes.setSellerOrderId(sellerOrderId);
        return this;
    }

    /**
     * 设置productName的setter方法
     * 
     * @param productName
     *            商品名称
     * @return ChargeBaiduPay
     */
    public ChargeBaiduPay setProductName(String productName) {
        this.sellerOrderAttributes.setProductName(productName);
        return this;
    }

    /**
     * 设置description的setter方法
     * 
     * @param description
     *            商品描述
     * @return ChargeBaiduPay
     */
    public ChargeBaiduPay setDescription(String description) {
        this.sellerOrderAttributes.setDescription(description);
        return this;
    }

    /**
     * 设置sellerNote的setter方法
     * 
     * @param sellerNote
     *            商品描述
     * @return ChargeBaiduPay
     */
    public ChargeBaiduPay setSellerNote(String sellerNote) {
        this.sellerOrderAttributes.setSellerNote(sellerNote);
        return this;
    }

    /**
     * 设置currencyCode的setter方法
     * 
     * @param currencyCode
     *            币种
     * @return ChargeBaiduPay
     */
    public ChargeBaiduPay setCurrencyCode(String currencyCode) {
        this.authorizeAttributes.setCurrencyCode(currencyCode);
        return this;
    }

    /**
     * 设置sellerAuthorizationNote的setter方法
     * 
     * @param sellerAuthorizationNote
     *            授权信息
     * @return ChargeBaiduPay
     */
    public ChargeBaiduPay setSellerAuthorizationNote(String sellerAuthorizationNote) {
        this.authorizeAttributes.setSellerAuthorizationNote(sellerAuthorizationNote);
        return this;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public AuthorizeAttributes getAuthorizeAttributes() {
        return authorizeAttributes;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public SellerOrderAttributes getSellerOrderAttributes() {
        return sellerOrderAttributes;
    }
}
