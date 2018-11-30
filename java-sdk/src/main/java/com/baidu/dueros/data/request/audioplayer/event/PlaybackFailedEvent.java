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

package com.baidu.dueros.data.request.audioplayer.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PlaybackFailed事件
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("AudioPlayer.PlaybackFailed")
public class PlaybackFailedEvent extends AudioPlayerEvent {

    // 正在播放中的audio item的token
    private final String token;
    // 错误信息
    private final Error error;

    /**
     * 返回一个用来构造{@code PlaybackFailedEvent}的{@code Builder}
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
     *            正在播放中的audio item的token
     * @param error
     *            错误信息
     */
    private PlaybackFailedEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("error") final Error error) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.error = error;
    }

    private PlaybackFailedEvent(final Builder builder) {
        super(builder);
        token = builder.token;
        error = builder.error;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String 正在播放中的audio item的token
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取error的getter方法
     * 
     * @return Error 当前的播放进度
     */
    public Error getError() {
        return error;
    }

    /**
     * 用来构造{@code PlaybackFailedEvent}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, PlaybackFailedEvent> {

        private String token;
        private Error error;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            正在播放中的audio item的token
         * @return Builder 用来构造{@code PlaybackFailedEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置error的setter方法
         * 
         * @param error
         *            错误信息
         * @return Builder 用来构造{@code PlaybackFailedEvent}
         */
        public Builder setError(final Error error) {
            this.error = error;
            return this;
        }

        /**
         * 调用{@code PlaybackFailedEvent}的私有构造方法构造{@code PlaybackFailedEvent}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        public PlaybackFailedEvent build() {
            return new PlaybackFailedEvent(this);
        }
    }

}
