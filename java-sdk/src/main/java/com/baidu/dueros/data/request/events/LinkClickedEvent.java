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

import com.baidu.dueros.data.request.events.CommonEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 在有屏设备端（companion app除外），如果卡片或者卡片列表配置了URL地址，
 * 当用户点击卡片或者卡片列表时，DuerOS会向技能发送Screen.LinkClicked事件。
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年5月23日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Screen.LinkClicked")
public class LinkClickedEvent extends CommonEvent {
    // 点击列表项对应的token
    private final String token;

    /**
     * 返回一个用来构造{@code LinkClickedEvent}的{@code Builder}
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
     */
    private LinkClickedEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
    }

    /**
     * 私有构造方法
     * 
     * @param builder
     *            用来构造{@code LinkClickedEvent}的{@code Builder}
     */
    private LinkClickedEvent(final Builder builder) {
        super(builder);
        token = builder.token;
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
     * 用来构造{@code LinkClickedEvent}
     * 
     * @author hujie08
     * @version 1.0
     * @since 2018年5月23日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, LinkClickedEvent> {
        private String token;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            展现列表中对应的token
         * @return Builder 用来构造{@code LinkClickedEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /*
         * 调用{@code LinkClickedEvent}的私有构造方法构造{@code LinkClickedEvent}
         * 
         * @see
         * com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        @Override
        public LinkClickedEvent build() {
            return new LinkClickedEvent(this);
        }
    }
}
