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

package com.baidu.dueros.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * HttpRequestFailedEvent
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月9日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpRequestFailedEvent extends RequestBody {

    // 本次请求的唯一标识
    private final String token;
    // 请求失败的原因
    private final String reason;
    // HTTP 请求失败时的消息描述，是可打印的字符串
    private final String errorMessage;

    /**
     * 返回一个用来构造{@code HttpRequestFailedEvent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code HttpRequestFailedEvent}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private HttpRequestFailedEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp, @JsonProperty("token") final String token,
            @JsonProperty("reason") final String reason, @JsonProperty("errorMessage") final String errorMessage) {
        super(requestId, timestamp);
        this.token = token;
        this.reason = reason;
        this.errorMessage = errorMessage;
    }

    private HttpRequestFailedEvent(final Builder builder) {
        super(builder);
        token = builder.token;
        reason = builder.reason;
        errorMessage = builder.errorMessage;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String 本次请求的唯一标识
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取reason的getter方法
     * 
     * @return String 请求失败的原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 获取errorMessage的getter方法
     * 
     * @return String 返回请求失败时的消息描述
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 用来构造{@code HttpRequestFailedEvent}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月9日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, HttpRequestFailedEvent> {

        // 本次请求的唯一标识
        private String token;
        // 请求失败的原因
        private String reason;
        // HTTP 请求失败时的消息描述，是可打印的字符串
        private String errorMessage;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            本次请求的唯一标识
         * @return Builder 用来构造{@code HttpRequestFailedEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置reason的setter方法
         * 
         * @param reason
         *            请求失败的原因
         * @return Builder 用来构造{@code HttpRequestFailedEvent}
         */
        public Builder setReason(final String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * 设置errorMessage的setter方法
         * 
         * @param errorMessage
         *            请求失败时的消息描述
         * @return Builder 用来构造{@code HttpRequestFailedEvent}
         */
        public Builder setErrorMessage(final String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        /**
         * 调用{@code HttpRequestFailedEvent}的私有构造方法构造
         * {@code HttpRequestFailedEvent}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        public HttpRequestFailedEvent build() {
            return new HttpRequestFailedEvent(this);
        }
    }
}
