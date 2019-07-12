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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Session结束信息描述
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月9日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionEndedErrorMessage {

    // 错误类型
    private final Type type;
    // 错误信息，可打印
    private final String message;

    /**
     * 返回一个用来构造{@code SessionEndedErrorMessage}的{@code Builder}
     * 
     * @return Builder 用来构造{@code SessionEndedErrorMessage}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private SessionEndedErrorMessage(@JsonProperty("type") final Type type,
            @JsonProperty("message") final String message) {
        this.type = type;
        this.message = message;
    }

    private SessionEndedErrorMessage(final Builder builder) {
        type = builder.type;
        message = builder.message;
    }

    /**
     * 获取type的getter方法
     * 
     * @return Type 错误类型
     */
    public Type getType() {
        return type;
    }

    /**
     * 获取message的getter方法
     * 
     * @return String 错误信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 错误类型
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月9日
     */
    public enum Type {
        // Bot返回了无效的响应
        INVALID_RESPONSE,
        // DuerOS与端通信异常
        DEVICE_COMMUNICATION_ERROR,
        // 其他DuerOS系统错误
        INTERNAL_ERROR,
    }

    /**
     * 用来构造{@code SessionEndedErrorMessage}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月9日
     */
    public static final class Builder {

        private Type type;
        private String message;

        /**
         * 设置type的setter方法
         * 
         * @param type
         *            错误类型
         * @return Builder 用来构造{@code SessionEndedErrorMessage}
         */
        public Builder setType(final Type type) {
            this.type = type;
            return this;
        }

        /**
         * 设置message的setter方法
         * 
         * @param message
         *            错误信息
         * @return Builder 用来构造{@code SessionEndedErrorMessage}
         */
        public Builder setMessage(final String message) {
            this.message = message;
            return this;
        }

        /**
         * 调用{@code SessionEndedErrorMessage}的私有构造方法构造
         * {@code SessionEndedErrorMessage}
         * 
         * @return SessionEndedErrorMessage
         */
        public SessionEndedErrorMessage build() {
            return new SessionEndedErrorMessage(this);
        }
    }
}
