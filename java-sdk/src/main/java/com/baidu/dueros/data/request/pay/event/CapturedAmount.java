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

package com.baidu.dueros.data.request.pay.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CapturedAmount {

    // 商品价格
    private String amount;
    // 币种信息
    private String currencyCode;

    /**
     * 通过{@code Builder}来构造{@code CapturedAmount}
     * 
     * @param builder
     *            用来构造{@code CapturedAmount}
     */
    private CapturedAmount(Builder builder) {
        amount = builder.amount;
        currencyCode = builder.currencyCode;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param amount
     *            amount
     * @param currencyCode
     *            currencyCode
     */
    private CapturedAmount(@JsonProperty("amount") final String amount,
            @JsonProperty("currencyCode") final String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    /**
     * 获取amount的getter方法
     * 
     * @return String amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 获取currencyCode的getter方法
     * 
     * @return String currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 返回一个用来构造{@code CapturedAmount}的{@code Builder}
     * 
     * @return Builder 用来构造{@code CapturedAmount}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 用来构造{@code CapturedAmount}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder {

        private String amount;
        private String currencyCode;

        private Builder setAmount(String amount) {
            this.amount = amount;
            return this;
        }

        private Builder setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public CapturedAmount build() {
            return new CapturedAmount(this);
        }

    }
}
