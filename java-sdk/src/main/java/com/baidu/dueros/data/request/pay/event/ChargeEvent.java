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

import com.baidu.dueros.data.request.RequestBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 扣款事件
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2018年06月29日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Connections.Response")
public class ChargeEvent extends RequestBody {

    // 请求的动作。此处为Charge
    private String name;
    // 对应支付指令的token
    private String token;
    // 详细信息
    private Payload payload;

    /**
     * 返回一个用来构造{@code ChargeEvent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code ChargeEvent}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code ChargeEvent}
     * 
     * @param builder
     *            用来构造{@code ChargeEvent}
     */
    protected ChargeEvent(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.token = builder.token;
        this.payload = builder.payload;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            requestId
     * @param timestamp
     *            timestamp
     * @param dialogRequestId
     *            dialogRequestId
     * @param name
     *            name
     * @param token
     *            token
     * @param payload
     *            payload
     */
    protected ChargeEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("name") final String name,
            @JsonProperty("token") final String token, @JsonProperty("payload") final Payload payload) {
        super(requestId, timestamp, dialogRequestId);
        this.name = name;
        this.token = token;
        this.payload = payload;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String token
     */
    public String getName() {
        return name;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取sellerOrderId的getter方法
     * 
     * @return String sellerOrderId
     */
    public String getSellerOrderId() {
        return payload.getSellerOrderId();
    }

    /**
     * 获取purchaseResult的getter方法
     * 
     * @return String purchaseResult
     */
    public String getPurchaseResult() {
        return payload.getPurchaseResult();
    }

    /**
     * 获取message的getter方法
     * 
     * @return String message
     */
    public String getMessage() {
        return payload.getMessage();
    }

    /**
     * 获取token的getter方法
     * 
     * @return String token
     */
    public Payload getPayload() {
        return payload;
    }

    /**
     * 用来构造{@code ChargeEvent}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, ChargeEvent> {

        public String name;
        public String token;
        public Payload payload;

        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setPayload(final Payload payload) {
            this.payload = payload;
            return this;
        }

        @Override
        public ChargeEvent build() {
            return new ChargeEvent(this);
        }

    }

}
