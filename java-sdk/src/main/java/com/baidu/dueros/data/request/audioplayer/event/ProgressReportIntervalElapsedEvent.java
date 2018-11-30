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

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("AudioPlayer.ProgressReportIntervalElapsed")
public class ProgressReportIntervalElapsedEvent extends AudioPlayerEvent {

    // 正在播放中的audio item的token
    private final String token;
    // 当前的播放进度
    private final int offsetInMilliSeconds;

    /**
     * 返回一个用来构造{@code ProgressReportIntervalElapsedEvent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code ProgressReportIntervalElapsedEvent}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    public ProgressReportIntervalElapsedEvent(Builder builder) {
        super(builder);
        token = builder.token;
        offsetInMilliSeconds = builder.offsetInMilliSeconds;
    }

    public ProgressReportIntervalElapsedEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("offsetInMilliSeconds") final int offsetInMilliSeconds) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.offsetInMilliSeconds = offsetInMilliSeconds;
    }

    public String getToken() {
        return token;
    }

    public int getOffsetInMilliSeconds() {
        return offsetInMilliSeconds;
    }

    public static final class Builder extends RequestBodyBuilder<Builder, ProgressReportIntervalElapsedEvent> {

        private String token;
        private int offsetInMilliSeconds;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            正在播放中的audio item的token
         * @return Builder 用来构造{@code ProgressReportIntervalElapsedEvent}
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
         * @return Builder 用来构造{@code ProgressReportIntervalElapsedEvent}
         */
        public Builder setOffsetInMilliSeconds(final int offsetInMilliSeconds) {
            this.offsetInMilliSeconds = offsetInMilliSeconds;
            return this;
        }

        public ProgressReportIntervalElapsedEvent build() {
            return new ProgressReportIntervalElapsedEvent(this);
        }

    }
}
