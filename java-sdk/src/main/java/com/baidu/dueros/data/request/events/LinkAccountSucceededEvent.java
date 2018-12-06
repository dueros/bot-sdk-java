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

package com.baidu.dueros.data.request.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 当用户授权完成之后，技能会收到此事件
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年5月23日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Connections.Response")
public class LinkAccountSucceededEvent extends CommonEvent {
    // 点击列表项对应的token
    private final String token;
    private final String name;

    /**
     * 返回一个用来构造{@code LinkAccountSucceededEvent}的{@code Builder}
     * 
     * @return Builder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            每个request会有不同的requestId
     * @param timestamp
     *            request时间，Bot结合http header一起用于做安全检查
     * @param token
     *            点击列表项对应的token
     * @param name
     *            name
     */
    private LinkAccountSucceededEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("name") final String name) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.name = name;
    }

    /**
     * 私有构造方法
     * 
     * @param builder
     *            用来构造{@code LinkAccountSucceededEvent}的{@code Builder}
     */
    private LinkAccountSucceededEvent(final Builder builder) {
        super(builder);
        token = builder.token;
        name = builder.name;
    }

    /**
     * 获取点击列表项的token字段
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    /**
     * name
     * 
     * @return String name
     */
    public String getNam() {
        return name;
    }

    /**
     * 用来构造{@code LinkAccountSucceededEvent}
     * 
     * @author hujie08
     * @version 1.0
     * @since 2018年5月23日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, LinkAccountSucceededEvent> {
        private String token;
        private String name;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            展现列表中对应的token
         * @return Builder 用来构造{@code LinkAccountSucceededEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置name的setter方法
         * 
         * @param name
         *            name
         * @return Builder 用来构造{@code LinkAccountSucceededEvent}
         */
        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        /*
         * 调用{@code LinkAccountSucceededEvent}的私有构造方法构造{@code
         * LinkAccountSucceededEvent}
         * 
         * @see
         * com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        @Override
        public LinkAccountSucceededEvent build() {
            return new LinkAccountSucceededEvent(this);
        }
    }
}
