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

public class AuthorizationAmount {

    // 扣款金额
    private String amount;
    // 枚举类型,目前只能为CNY
    private String currencyCode = "CNY";

    /**
     * 构造方法
     */
    public AuthorizationAmount() {

    }

    /**
     * 构造方法
     */
    public AuthorizationAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 构造方法
     */
    public AuthorizationAmount(String amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    /**
     * 设置扣款金额的setter方法
     * 
     * @param amount
     *            扣款金额
     * @return AuthorizationAmount
     */
    public AuthorizationAmount setAmout(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * 设置币种的setter方法
     * 
     * @param currencyCode
     *            币种
     * @return AuthorizationAmount
     */
    public AuthorizationAmount setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getAmount() {
        return amount;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

}
