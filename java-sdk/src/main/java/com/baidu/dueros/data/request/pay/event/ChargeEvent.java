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

import com.baidu.dueros.data.request.events.ConnectionsResponseEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 扣款事件
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2018年06月29日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeEvent extends ConnectionsResponseEvent {

    private Payload payload;

    /**
     * 获取payload的getter方法
     * 
     * @return Payload payload
     */
    public Payload getPayload() {
        return payload;
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
    public ChargeEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("name") final String name,
            @JsonProperty("token") final String token, @JsonProperty("payload") final Payload payload) {
        super(requestId, timestamp, dialogRequestId, name, token);
        this.payload = payload;
    }

    /**
     * 通过{@code Builder}来构造{@code ChargeEvent}
     * 
     * @param builder
     *            用来构造{@code ChargeEvent}
     */
    protected ChargeEvent(Builder builder) {
        super(builder);
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

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

}
