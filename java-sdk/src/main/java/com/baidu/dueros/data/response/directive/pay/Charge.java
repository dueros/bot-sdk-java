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

import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 发起支付扣款指令
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonTypeName("Connections.SendRequest")
public class Charge extends Directive {
    // 请求的动作，此处为Charge
    private String name = "Charge";
    // 唯一标识此指令
    private String token;
    private Payload payload = new Payload();

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
    public Charge(String amount, String sellerOrderId, String productName, String description) {
        this.payload.setAmount(amount).setSellerOrderId(sellerOrderId).setProductName(productName)
                .setDescription(description);
    }

    /**
     * 设置currencyCode的setter方法
     * 
     * @param currencyCode
     *            币种信息
     * @return Charge
     */
    public Charge setCurrencyCode(String currencyCode) {
        this.payload.setCurrencyCode(currencyCode);
        return this;
    }

    /**
     * 设置sellerAuthorizationNote的setter方法
     * 
     * @param sellerAuthorizationNote
     *            订单授权信息
     * @return Charge
     */
    public Charge setSellerAuthorizationNote(String sellerAuthorizationNote) {
        this.payload.setSellerAuthorizationNote(sellerAuthorizationNote);
        return this;
    }

    /**
     * 设置sellerNote的setter方法
     * 
     * @param sellerNote
     *            订单授权信息
     * @return Charge
     */
    public Charge setSellerNote(String sellerNote) {
        this.payload.setSellerNote(sellerNote);
        return this;
    }

    /**
     * 设置token的setter方法
     * 
     * @param token
     *            token
     * @return Charge
     */
    public Charge setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getToken() {
        return token;
    }

    /**
     * getter方法
     * 
     * @return PayLoad
     */
    public Payload getPayload() {
        return payload;
    }

}
