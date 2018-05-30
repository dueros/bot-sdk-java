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

import com.baidu.dueros.data.request.audioplayer.event.AudioPlayerState;
import com.baidu.dueros.data.request.videoplayer.event.VideoPlayerState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 记录的是服务和设备的状态
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Context {

    // 端设备信息和用户信息
    private final System system;
    // 端上报的音频播放的状态
    private final AudioPlayerState audioPlayer;
    // 端上报的视频播放的状态
    private final VideoPlayerState videoPlayer;
    // 端屏幕显示信息
    private final Screen screen;

    /**
     * 返回一个构造{@code Context}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Context}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}构造{@code Context}
     * 
     * @param builder
     *            用来构造{@code Context}
     */
    private Context(final Builder builder) {
        system = builder.system;
        audioPlayer = builder.audioPlayer;
        videoPlayer = builder.videoPlayer;
        screen = builder.screen;
    }

    /**
     * 获取system的getter方法
     * 
     * @return System 获取system成员
     */
    public System getSystem() {
        return system;
    }

    /**
     * 获取audioPlayer的getter方法
     * 
     * @return AudioPlayer 获取audioPlayer成员
     */
    public AudioPlayerState getAudioPlayer() {
        return audioPlayer;
    }

    /**
     * 获取videoPlayer的getter方法
     * 
     * @return VideoPlayer 获取videoPlayer成员
     */
    public VideoPlayerState getVideoPlayer() {
        return videoPlayer;
    }

    /**
     * 获取screen的getter方法
     * 
     * @return Screen 获取到的屏幕信息
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param system
     *            端设备信息和用户信息
     * @param audioPlayer
     *            端上报的音频播放状态
     * @param videoPlayer
     *            端上报的视频播放状态
     * @param screen
     *            端屏幕显示信息
     */
    public Context(@JsonProperty("System") final System system,
            @JsonProperty("AudioPlayer") final AudioPlayerState audioPlayer,
            @JsonProperty("VideoPlayer") final VideoPlayerState videoPlayer,
            @JsonProperty("Screen") final Screen screen) {
        this.system = system;
        this.audioPlayer = audioPlayer;
        this.videoPlayer = videoPlayer;
        this.screen = screen;
    }

    /**
     * 用来构造{@code Context}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // 端设备信息和用户信息
        private System system;
        // 端上报的音频播放的状态
        private AudioPlayerState audioPlayer;
        // 端上报的视频播放的状态
        private VideoPlayerState videoPlayer;
        // 端屏幕显示信息
        private Screen screen;

        /**
         * 设置system的setter方法
         * 
         * @param system
         *            端设备信息和用户信息
         * @return Builder 用来构造{@code Context}
         */
        public Builder setSystem(final System system) {
            this.system = system;
            return this;
        }

        /**
         * 设置audioPlayer的setter方法
         * 
         * @param audioPlayer
         *            端上报的状态
         * @return Builder 用来构造{@code Context}
         */
        public Builder setAudioPlayer(final AudioPlayerState audioPlayer) {
            this.audioPlayer = audioPlayer;
            return this;
        }

        /**
         * 设置videoPlayer的setter方法
         * 
         * @param videoPlayer
         *            端上报的状态
         * @return Builder 用来构造{@code Context}
         */
        public Builder setVideoPlayer(final VideoPlayerState videoPlayer) {
            this.videoPlayer = videoPlayer;
            return this;
        }

        /**
         * 设置screen的setter方法
         * 
         * @param screen
         *            屏幕显示信息
         * @return Builder 用来构造{@code Context}
         */
        public Builder setScreen(final Screen screen) {
            this.screen = screen;
            return this;
        }

        /**
         * 调用{@code Context}的私有构造方法构造{@code Context}
         * 
         * @return Context 返回构造的{@code Context}对象
         */
        public Context build() {
            return new Context(this);
        }
    }

}
