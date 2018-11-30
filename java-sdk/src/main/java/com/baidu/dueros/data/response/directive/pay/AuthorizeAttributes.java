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

public class AuthorizeAttributes {

    // 商品价格信息
    private AuthorizationAmount authorizationAmount = new AuthorizationAmount();
    // 商家授权信息备注
    private String sellerAuthorizationNote;

    /**
     * 构造方法
     */
    public AuthorizeAttributes() {

    }

    /**
     * 构造方法
     * 
     * @param amount
     *            价格信息
     */
    public AuthorizeAttributes(String amount) {
        this.authorizationAmount = new AuthorizationAmount(amount);
    }

    /**
     * 设置amout的setter方法
     * 
     * @param amount
     *            价格信息
     * @return AuthorizeAttributes
     */
    public AuthorizeAttributes setAmount(String amount) {
        this.authorizationAmount.setAmout(amount);
        return this;
    }

    /**
     * 设置currencyCode的setter方法
     * 
     * @param currencyCode
     *            币种信息
     * @return AuthorizeAttributes
     */
    public AuthorizeAttributes setCurrencyCode(String currencyCode) {
        this.authorizationAmount.setCurrencyCode(currencyCode);
        return this;
    }

    /**
     * 设置sellerAuthorizationNote的setter方法
     * 
     * @param sellerAuthorizationNote
     *            订单授权信息
     * @return AuthorizeAttributes
     */
    public AuthorizeAttributes setSellerAuthorizationNote(String sellerAuthorizationNote) {
        this.sellerAuthorizationNote = sellerAuthorizationNote;
        return this;
    }

    /**
     * getter方法
     * 
     * @return AuthorizationAmount
     */
    public AuthorizationAmount getAuthorizationAmount() {
        return authorizationAmount;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getSellerAuthorizationNote() {
        return sellerAuthorizationNote;
    }
}
