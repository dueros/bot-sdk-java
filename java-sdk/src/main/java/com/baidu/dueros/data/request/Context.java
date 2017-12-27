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
    // 端上报的状态
    private final AudioPlayerState audioPlayerState;

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
        audioPlayerState = builder.audioPlayerState;
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
     * 获取audioPlayerState的getter方法
     * 
     * @return AudioPlayerState 获取audioPlayerState成员
     */
    public AudioPlayerState getAudioPlayerState() {
        return audioPlayerState;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param system
     *            端设备信息和用户信息
     * @param audioPlayerState
     *            端上报的状态
     */
    public Context(@JsonProperty("System") final System system,
            @JsonProperty("audioPlayerState") final AudioPlayerState audioPlayerState) {
        this.system = system;
        this.audioPlayerState = audioPlayerState;
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
        // 端上报的状态
        private AudioPlayerState audioPlayerState;

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
         * 设置audioPlayerState的setter方法
         * 
         * @param audioPlayerState
         *            端上报的状态
         * @return Builder 用来构造{@code Context}
         */
        public Builder setAudioPlayerState(final AudioPlayerState audioPlayerState) {
            this.audioPlayerState = audioPlayerState;
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
