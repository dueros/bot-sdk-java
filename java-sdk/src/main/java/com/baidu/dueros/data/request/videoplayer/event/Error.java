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
 * VideoPlayer 上报状态中的错误信息
 * 
 * @author hujie08
 * @version V1.0
 * @since 2018年5月2日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {
    // 错误类型
    private String type;
    // 错误描述
    private String message;

    /**
     * 私有构造函数，提供给builder使用
     * 
     * @param builder
     */
    private Error(Builder builder) {
        type = builder.type;
        message = builder.message;
    }

    /**
     * 私有构造函数，提供给builder使用
     * 
     * @param builder
     */
    private Error(@JsonProperty("type") final String type, @JsonProperty("message") final String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * 返回一个用来构造{@code Error}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Error}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取视频播放错误类型的getter方法
     * 
     * @return String 错误类型
     */
    public String getType() {
        return type;
    }

    /**
     * 获取视频播放错误信息的getter方法
     * 
     * @return String 错误信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 用来构造{@code Builder}
     * 
     * @author hujie08
     * @version V1.0
     * @since 2018年5月2日
     */
    public static final class Builder {
        // 错误类型
        private String type;
        // 错误描述
        private String message;

        /**
         * 设置视频播放错误类型的setter方法
         * 
         * @param type
         *            错误类型
         * @return Builder 用来构造{@code Error}
         */
        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        /**
         * 设置视频播放错误信息的setter方法
         * 
         * @param message
         *            错误信息
         * @return Builder 用来构造{@code Error}
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * 调用{@code Error}的私有构造方法构造{@code Error}
         * 
         * @return Error 构造一个Error
         */
        public Error build() {
            return new Error(this);
        }
    }

    /**
     * 视频播放相关错误类型
     * 
     * @author hujie08
     */
    public enum ErrorType {
        // 未知错误
        MEDIA_ERROR_UNKNOWN,
        // stream服务端返回请求无效 (可能的情况有bad request, unauthorized, forbidden, not
        // found等等)
        MEDIA_ERROR_INVALID_REQUEST,
        // 设备端无法连接stream服务端
        MEDIA_ERROR_SERVICE_UNAVAILABLE,
        // stream服务端接受请求，但未能正确处理
        MEDIA_ERROR_INTERNAL_SERVER_ERROR,
        // 设备端内部错误
        MEDIA_ERROR_INTERNAL_DEVICE_ERROR,
    }
}
