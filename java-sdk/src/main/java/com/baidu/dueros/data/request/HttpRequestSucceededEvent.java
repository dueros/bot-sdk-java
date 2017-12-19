/** 
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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * HttpRequestSucceededEvent
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月9日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpRequestSucceededEvent extends RequestBody {

    /** 本次Http请求操作的唯一标识 */
    private final String token;
    /** 本次Http响应的返回码 */
    private final String code;
    /** 本次Http响应的header信息 */
    private final Map<String, String> headers = new HashMap<String, String>();
    /** 本次Http的响应结果 */
    private final HttpBody body;

    /**
     * 返回一个用来构造{@code HttpRequestSucceededEvent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code HttpRequestSucceededEvent}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private HttpRequestSucceededEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp, @JsonProperty("token") final String token,
            @JsonProperty("code") final String code, @JsonProperty("headers") final Map<String, String> headers,
            @JsonProperty("body") final HttpBody body) {
        super(requestId, timestamp);
        this.token = token;
        this.code = code;
        this.headers.putAll(headers);
        this.body = body;
    }

    private HttpRequestSucceededEvent(final Builder builder) {
        super(builder);
        token = builder.token;
        code = builder.code;
        headers.putAll(builder.headers);
        ;
        body = builder.body;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String 本次Http请求操作的唯一标识
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取code的getter方法
     * 
     * @return String 本次Http响应的返回码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取headers的getter方法
     * 
     * @return headers 本次Http响应的header信息
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * 获取body的getter方法
     * 
     * @return HttpBody 本次Http的响应结果
     */
    public HttpBody getBody() {
        return body;
    }

    /**
     * 用来构造{@code HttpRequestSucceededEvent}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月9日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, HttpRequestSucceededEvent> {

        private String token;
        private String code;
        private Map<String, String> headers = new HashMap<>();
        private HttpBody body;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            本次Http请求操作的唯一标识
         * @return Builder 用来构造{@code HttpRequestSucceededEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置code的setter方法
         * 
         * @param code
         *            本次Http响应的返回码
         * @return Builder 用来构造{@code HttpRequestSucceededEvent}
         */
        public Builder setCode(final String code) {
            this.code = code;
            return this;
        }

        /**
         * 设置headers的setter方法
         * 
         * @param headers
         *            本次Http响应的header信息
         * @return Builder 用来构造{@code HttpRequestSucceededEvent}
         */
        public Builder setHeaders(final Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        /**
         * 设置body的setter方法
         * 
         * @param body
         *            本次Http的响应结果
         * @return Builder 用来构造{@code HttpRequestSucceededEvent}
         */
        public Builder setHttpBody(final HttpBody body) {
            this.body = body;
            return this;
        }

        /**
         * 调用{@code HttpRequestSucceededEvent}的私有构造方法构造
         * {@code HttpRequestSucceededEvent}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        public HttpRequestSucceededEvent build() {
            return new HttpRequestSucceededEvent(this);
        }
    }

}
