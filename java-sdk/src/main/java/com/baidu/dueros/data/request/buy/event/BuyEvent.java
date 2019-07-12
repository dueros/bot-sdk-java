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

package com.baidu.dueros.data.request.buy.event;

import com.baidu.dueros.data.request.events.CommonEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Connections.Response.Buy")
/**
 * BuyEvent事件
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年5月23日
 */
public class BuyEvent extends CommonEvent {

    // Buy指令中提供的token
    private String token;
    // payload
    private Payload payload;

    private BuyEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("payload") final Payload payload) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.payload = payload;
    }

    /**
     * 私有构造方法
     * 
     * @param builder
     *            用来构造{@code BuyEvent}的{@code Builder}
     */
    private BuyEvent(final Builder builder) {
        super(builder);
        token = builder.token;
        payload = builder.payload;
    }

    /**
     * 获取token字段
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    public Payload getPayload() {
        return payload;
    }

    /**
     * 用来构造{@code BuyEvent}
     * 
     * @author hujie08
     * @version 1.0
     * @since 2018年5月23日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, BuyEvent> {
        private String token;
        private Payload payload;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            展现列表中对应的token
         * @return Builder 用来构造{@code BuyEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置payload的setter方法
         * 
         * @param payload
         *            展现列表中对应的payload
         * @return Builder 用来构造{@code BuyEvent}
         */
        public Builder setPayload(final Payload payload) {
            this.payload = payload;
            return this;
        }

        /*
         * BuyEvent 调用{@code UserEvent}的私有构造方法构造{@code BuyEvent}
         * 
         * @see
         * com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        @Override
        public BuyEvent build() {
            return new BuyEvent(this);
        }
    }

}
