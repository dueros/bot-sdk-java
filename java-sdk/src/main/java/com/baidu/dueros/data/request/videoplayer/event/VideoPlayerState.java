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
package com.baidu.dueros.data.request.videoplayer.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 端上报的状态
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年5月2日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoPlayerState {

    // 正在播放中的audio item的token
    private final String token;
    // 当前的播放进度
    private final int offsetInMilliseconds;
    // 视频播放器当前状态
    private final String playerActivity;
    // 错误信息
    private final Error error;

    /**
     * 返回一个用来构造{@code VideoPlayerState}的{@code Builder}
     * 
     * @return Builder 用来构造{@code VideoPlayerState}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private VideoPlayerState(final Builder builder) {
        token = builder.token;
        offsetInMilliseconds = builder.offsetInMilliseconds;
        playerActivity = builder.playerActivity;
        error = builder.error;
    }

    private VideoPlayerState(@JsonProperty("token") final String token,
            @JsonProperty("offsetInMilliseconds") final int offsetInMilliseconds,
            @JsonProperty("playerActivity") final String playerActivity, @JsonProperty("error") final Error error) {
        this.token = token;
        this.offsetInMilliseconds = offsetInMilliseconds;
        this.playerActivity = playerActivity;
        this.error = error;
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
     * 获取offsetInMilliseconds的getter方法
     * 
     * @return int 当前的播放进度
     */
    public int getOffsetInMilliseconds() {
        return offsetInMilliseconds;
    }

    /**
     * 获取playerActivity的getter方法
     * 
     * @return String 视频播放器当前状态
     */
    public String getPlayerActivity() {
        return playerActivity;
    }

    /**
     * 获取错误信息 error 的getter方法
     * 
     * @return Error 错误信息
     */
    public Error getError() {
        return error;
    }

    /**
     * 视频播放器当前状态
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public enum PlayerActivity {
        // 空闲状态
        IDLE,
        // 正在缓冲
        BUFFER_UNDER_RUN,
        // 正在播放
        PLAYING,
        // 中断播放：被高优事件入闹钟中断
        PAUSED,
        // 停止播放：指令停止
        STOPPED,
        // 播放完成
        FINISHED,
    }

    /**
     * 用来构造{@code VideoPlayerState}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder {

        private String token;
        private int offsetInMilliseconds;
        private String playerActivity;
        private Error error;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            正在播放中的audio item的token
         * @return Builder 用来构造{@code VideoPlayerState}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置offsetInMilliseconds的setter方法
         * 
         * @param offsetInMilliseconds
         *            当前的播放进度
         * @return Builder 用来构造{@code VideoPlayerState}
         */
        public Builder setOffsetInMilliseconds(final int offsetInMilliseconds) {
            this.offsetInMilliseconds = offsetInMilliseconds;
            return this;
        }

        /**
         * 设置playerActivity的setter方法
         * 
         * @param playerActivity
         *            视频播放器当前状态
         * @return Builder 用来构造{@code VideoPlayerState}
         */
        public Builder setPlayerActivity(final String playerActivity) {
            this.playerActivity = playerActivity;
            return this;
        }

        /**
         * 设置error的setter方法
         * 
         * @param error
         *            错误信息
         * @return Builder 用来构造{@code VideoPlayerState}
         */
        public Builder setError(final Error error) {
            this.error = error;
            return this;
        }

        /**
         * 调用{@code VideoPlayerState}的私有构造方法构造{@code VideoPlayerState}
         * 
         * @return VideoPlayerState 构造一个VideoPlayerState
         */
        public VideoPlayerState build() {
            return new VideoPlayerState(this);
        }
    }
}
