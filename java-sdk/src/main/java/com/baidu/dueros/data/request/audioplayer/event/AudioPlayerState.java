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

/**
 * 端上报的状态
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioPlayerState {

    // 正在播放中的audio item的token
    private final String token;
    // 当前的播放进度
    private final int offsetInMilliSeconds;
    // 音频播放器当前状态
    private final String playerActivity;

    /**
     * 返回一个用来构造{@code AudioPlayerState}的{@code Builder}
     * 
     * @return Builder 用来构造{@code AudioPlayerState}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private AudioPlayerState(final Builder builder) {
        token = builder.token;
        offsetInMilliSeconds = builder.offsetInMilliSeconds;
        playerActivity = builder.playerActivity;
    }

    private AudioPlayerState(@JsonProperty("token") final String token,
            @JsonProperty("offsetInMilliSeconds") final int offsetInMilliSeconds,
            @JsonProperty("playerActivity") final String playerActivity) {
        this.token = token;
        this.offsetInMilliSeconds = offsetInMilliSeconds;
        this.playerActivity = playerActivity;
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
     * 获取offsetInMilliSeconds的getter方法
     * 
     * @return int 当前的播放进度
     */
    public int getOffsetInMilliSeconds() {
        return offsetInMilliSeconds;
    }

    /**
     * 获取playActivity的getter方法
     * 
     * @return String 音频播放器当前状态
     */
    public String getPlayerActivity() {
        return playerActivity;
    }

    /**
     * 音频播放器当前状态
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public enum PlayActivity {
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
     * 用来构造{@code AudioPlayerState}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        private String token;
        private int offsetInMilliSeconds;
        private String playerActivity;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            正在播放中的audio item的token
         * @return Builder 用来构造{@code AudioPlayerState}
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
         * @return Builder 用来构造{@code AudioPlayerState}
         */
        public Builder setOffsetInMilliSeconds(final int offsetInMilliSeconds) {
            this.offsetInMilliSeconds = offsetInMilliSeconds;
            return this;
        }

        /**
         * 设置playerActivity的setter方法
         * 
         * @param playerActivity
         *            音频播放器当前状态
         * @return Builder 用来构造{@code AudioPlayerState}
         */
        public Builder setPlayerActivity(final String playerActivity) {
            this.playerActivity = playerActivity;
            return this;
        }

        /**
         * 调用{@code AudioPlayerState}的私有构造方法构造{@code AudioPlayerState}
         * 
         * @return AudioPlayerState 构造一个AudioPlayerState
         */
        public AudioPlayerState build() {
            return new AudioPlayerState(this);
        }

    }

}
