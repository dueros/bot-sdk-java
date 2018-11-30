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
 * PlaybackStopped
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("AudioPlayer.PlaybackStopped")
public class PlaybackStoppedEvent extends AudioPlayerEvent {

    // 正在播放中的audio item的token
    private final String token;
    // 当前的播放进度
    private final int offsetInMilliSeconds;

    /**
     * 返回一个用来构造{@code PlaybackStoppedEvent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code PlaybackStoppedEvent}
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
     *            正在播放中的audioitem的token
     * @param offsetInMilliSeconds
     *            当前的播放进度
     */
    private PlaybackStoppedEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("offsetInMilliSeconds") final int offsetInMilliSeconds) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.offsetInMilliSeconds = offsetInMilliSeconds;
    }

    private PlaybackStoppedEvent(final Builder builder) {
        super(builder);
        token = builder.token;
        offsetInMilliSeconds = builder.offsetInMilliSeconds;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String 正在播放中的audioitem的token
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取offsetInMilliSeconds的getter方法
     * 
     * @return int 当前的播放进度
     */
    public int getOffsetInMilliSeconds() {
        return offsetInMilliSeconds;
    }

    /**
     * 用来构造{@code PlaybackStoppedEvent}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, PlaybackStoppedEvent> {

        private String token;
        private int offsetInMilliSeconds;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            正在播放中的audio item的token
         * @return Builder 用来构造{@code PlaybackStoppedEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置offsetInMilliSeconds的setter方法
         * 
         * @param offsetInMilliSeconds
         *            当前的播放进度
         * @return Builder 用来构造{@code PlaybackStoppedEvent}
         */
        public Builder setOffsetInMilliSeconds(final int offsetInMilliSeconds) {
            this.offsetInMilliSeconds = offsetInMilliSeconds;
            return this;
        }

        /**
         * 调用{@code PlaybackStoppedEvent}的私有构造方法构造{@code PlaybackStoppedEvent}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        public PlaybackStoppedEvent build() {
            return new PlaybackStoppedEvent(this);
        }
    }
}
