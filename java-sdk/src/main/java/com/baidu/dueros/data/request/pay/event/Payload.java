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
public class Payload {

    // 授权信息
    private AuthorizationDetails authorizationDetails;
    // 此次交易百度生成的订单ID
    private String baiduOrderReferenceId;
    // 对应支付的订单ID
    private String sellerOrderId;
    // 此次支付结果。(SUCCESS 支付成功;ERROR 支付发生错误)
    private String purchaseResult;
    // 支付状态对应的消息
    private String message;

    /**
     * 通过{@code Builder}来构造{@code PayLoad}
     * 
     * @param builder
     *            用来构造{@code PayLoad}
     */
    public Payload(Builder builder) {
        authorizationDetails = builder.authorizationDetails;
        baiduOrderReferenceId = builder.baiduOrderReferenceId;
        sellerOrderId = builder.sellerOrderId;
        purchaseResult = builder.purchaseResult;
        message = builder.message;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param authorizationDetails
     *            authorizationDetails
     * @param baiduOrderReferenceId
     *            baiduOrderReferenceId
     * @param sellerOrderId
     *            sellerOrderId
     * @param purchaseResult
     *            purchaseResult
     * @param message
     *            message
     */
    public Payload(@JsonProperty("authorizationDetails") final AuthorizationDetails authorizationDetails,
            @JsonProperty("baiduOrderReferenceId") final String baiduOrderReferenceId,
            @JsonProperty("sellerOrderId") final String sellerOrderId,
            @JsonProperty("purchaseResult") final String purchaseResult,
            @JsonProperty("message") final String message) {
        this.authorizationDetails = authorizationDetails;
        this.baiduOrderReferenceId = baiduOrderReferenceId;
        this.sellerOrderId = sellerOrderId;
        this.purchaseResult = purchaseResult;
        this.message = message;
    }

    /**
     * 返回一个用来构造{@code PayLoad}的{@code Builder}
     * 
     * @return Builder 用来构造{@code PayLoad}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取authorizationDetails的getter方法
     * 
     * @return String authorizationDetails
     */
    public AuthorizationDetails getAuthorizationDetails() {
        return authorizationDetails;
    }

    /**
     * 获取baiduOrderReferenceId的getter方法
     * 
     * @return String baiduOrderReferenceId
     */
    public String getBaiduOrderReferenceId() {
        return baiduOrderReferenceId;
    }

    /**
     * 获取sellerOrderId的getter方法
     * 
     * @return String sellerOrderId
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * 获取purchaseResult的getter方法
     * 
     * @return String purchaseResult
     */
    public String getPurchaseResult() {
        return purchaseResult;
    }

    /**
     * 获取message的getter方法
     * 
     * @return String message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 用来构造{@code PayLoad}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder {

        private AuthorizationDetails authorizationDetails;
        private String baiduOrderReferenceId;
        private String sellerOrderId;
        private String purchaseResult;
        private String message;

        private Builder setAuthorizationDetails(AuthorizationDetails authorizationDetails) {
            this.authorizationDetails = authorizationDetails;
            return this;
        }

        private Builder setBaiduOrderReferenceId(String baiduOrderReferenceId) {
            this.baiduOrderReferenceId = baiduOrderReferenceId;
            return this;
        }

        private Builder setSellerOrderId(String sellerOrderId) {
            this.sellerOrderId = sellerOrderId;
            return this;
        }

        private Builder setPurchaseResult(String purchaseResult) {
            this.purchaseResult = purchaseResult;
            return this;
        }

        private Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Payload build() {
            return new Payload(this);
        }

    }
}
