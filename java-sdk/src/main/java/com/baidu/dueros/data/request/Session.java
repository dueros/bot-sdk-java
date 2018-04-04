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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户会话信息,一个session表示用户与Bot的一次会话，Session开始：用户主动说“打开Bot”；Session结束：
 * <ul>
 * <li>1.Bot返回shouldEndSession为TRUE
 * <li>2.用户主动说“关闭Bot”
 * <li>3.用户三次Reprompt均出错（无输入或系统不理解）
 * <li>4.其他系统错误
 * </ul>
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {

    // 当用户发起对话时，isNew为true
    private final boolean isNew;
    // sessionId为一个唯一ID，用于标识此次对话
    private final String sessionId;
    // 用户可以在response中返回attributes，DuerOS会存储下来，并在本次对话的下一个request中发送给Bot
    private Map<String, String> attributes = new HashMap<String, String>();

    /**
     * 返回一个用来构造{@code Session}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Session}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Session}来构造{@code Application}
     * 
     * @param builder
     *            用来构造{@code Session}
     */
    private Session(final Builder builder) {
        isNew = builder.isNew;
        sessionId = builder.sessionId;
        attributes = builder.attributes;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param isNew
     *            当用户发起对话时，isNew为true
     * @param sessionId
     *            sessionId为一个唯一ID，用于标识此次对话
     * @param attributes
     *            用户可以在response中返回attributes
     */
    private Session(@JsonProperty("new") final boolean isNew, @JsonProperty("sessionId") final String sessionId,
            @JsonProperty("attributes") final Map<String, String> attributes) {
        this.isNew = isNew;
        this.sessionId = sessionId;
        if (attributes != null) {
            this.attributes = attributes;
        }
    }

    /**
     * 获取isNew的getter方法
     * 
     * @return boolean 当用户发起对话时，isNew为true
     */
    public boolean isNew() {
        return isNew;
    }

    /**
     * 获取sessionId的getter方法
     * 
     * @return String sessionId为一个唯一ID，用于标识此次对话
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 获取attributes的getter方法
     * 
     * @return attributes 用户可以在response中返回attributes
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * 用来构造{@code Session}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        private boolean isNew = false;
        private String sessionId;
        private Map<String, String> attributes = new HashMap<>();

        /**
         * 设置isNew的setter方法
         * 
         * @param isNew
         *            当用户发起对话时，isNew为true
         * @return Builder 用来构造{@code Session}
         */
        public Builder setIsNew(final boolean isNew) {
            this.isNew = isNew;
            return this;
        }

        /**
         * 设置sessionId的setter方法
         * 
         * @param sessionId
         *            sessionId为一个唯一ID，用于标识此次对话
         * @return Builder 用来构造{@code Session}
         */
        public Builder setSessionId(final String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /**
         * 设置attributes的setter方法
         * 
         * @param attributes
         *            用户可以在response中返回attributes
         * @return Builder 用来构造{@code Session}
         */
        public Builder setAttributes(final Map<String, String> attributes) {
            this.attributes = attributes;
            return this;
        }

        /**
         * 调用{@code Session}的私有构造方法构造{@code Session}
         * 
         * @return Session
         */
        public Session build() {
            return new Session(this);
        }

    }

}
