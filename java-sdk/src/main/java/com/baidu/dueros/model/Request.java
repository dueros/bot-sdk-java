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

package com.baidu.dueros.model;

import com.baidu.dueros.data.request.Context;
import com.baidu.dueros.data.request.RequestBody;
import com.baidu.dueros.data.request.Session;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DuerOS向Bot发送的Request请求
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    // 协议版本
    private final String version;
    // 会话信息
    private final Session session;
    // 端和系统状态信息
    private final Context context;
    // Request请求体
    private final RequestBody request;

    /**
     * 返回一个用来构造{@code Request}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Request}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private Request(final Builder builder) {
        version = builder.version;
        session = builder.session;
        context = builder.context;
        request = builder.request;
    }

    private Request(@JsonProperty("version") final String version, @JsonProperty("session") final Session session,
            @JsonProperty("context") final Context context, @JsonProperty("request") final RequestBody request) {
        this.version = version;
        this.session = session;
        this.context = context;
        this.request = request;
    }

    /**
     * 获取version的getter方法
     * 
     * @return String 版本信息
     */
    public String getVersion() {
        return version;
    }

    /**
     * 获取session的getter方法
     * 
     * @return Session 会话信息
     */
    public Session getSession() {
        return session;
    }

    /**
     * 获取context的getter方法
     * 
     * @return Context 端和系统状态信息
     */
    public Context getContext() {
        return context;
    }

    /**
     * 获取request的getter方法
     * 
     * @return RequestBody 请求体
     */
    public RequestBody getRequest() {
        return request;
    }

    /**
     * 用来构造{@code Request}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public static final class Builder {

        private String version;
        private Session session;
        private Context context;
        private RequestBody request;

        /**
         * 设置协议版本的的setter方法
         * 
         * @param version
         *            协议版本
         * @return Builder 用来构造{@code Request}
         */
        public Builder setVersion(final String version) {
            this.version = version;
            return this;
        }

        /**
         * 设置会话信息的setter方法
         * 
         * @param session
         *            会话信息
         * @return Builder 用来构造{@code Request}
         */
        public Builder setSession(final Session session) {
            this.session = session;
            return this;
        }

        /**
         * 设置端和系统状态信息的setter方法
         * 
         * @param context
         *            端和系统状态信息
         * @return Builder 用来构造{@code Request}
         */
        public Builder setContext(final Context context) {
            this.context = context;
            return this;
        }

        /**
         * 设置请求体的setter方法
         * 
         * @param request
         *            请求体
         * @return Builder 用来构造{@code Request}
         */
        public Builder setRequest(final RequestBody request) {
            this.request = request;
            return this;
        }

        /**
         * 调用{@code Request}的私有构造方法构造{@code Request}
         * 
         * @return Request 请求体
         */
        public Request build() {
            return new Request(this);
        }
    }
}
