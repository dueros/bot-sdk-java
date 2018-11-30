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
 * 系统信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class System {

    // 用户信息
    private final User user;
    // Bot信息
    private final Application application;
    // 端上设备信息
    private final Device device;
    // apiAccessToken
    private final String apiAccessToken;
    // apiEndPoint
    private final String apiEndPoint;

    /**
     * 返回一个用来构造{@code System}的{@code Builder}
     * 
     * @return Builder 用来构造{@code System}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private System(final Builder builder) {
        user = builder.user;
        application = builder.application;
        device = builder.device;
        apiAccessToken = builder.apiAccessToken;
        apiEndPoint = builder.apiEndPoint;
    }

    private System(@JsonProperty("user") final User user, @JsonProperty("application") final Application application,
            @JsonProperty("device") final Device device, @JsonProperty("apiAccessToken") final String apiAccessToken,
            @JsonProperty("apiEndPoint") final String apiEndPoint) {
        this.user = user;
        this.application = application;
        this.device = device;
        this.apiAccessToken = apiAccessToken;
        this.apiEndPoint = apiEndPoint;
    }

    /**
     * 获取applicationId的getter方法
     * 
     * @return User 用户信息
     */
    public User getUser() {
        return user;
    }

    /**
     * 获取applicationId的getter方法
     * 
     * @return Application Bot信息
     */
    public Application getApplication() {
        return application;
    }

    /**
     * 获取applicationId的getter方法
     * 
     * @return Device 端上设备信息
     */
    public Device getDevice() {
        return device;
    }

    /**
     * 获取apiAccessToken的getter方法
     * 
     * @return String apiAccessToken
     */
    public String getApiAccessToken() {
        return apiAccessToken;
    }

    /**
     * 获取apiEndPoint的getter方法
     * 
     * @return String apiEndPoint
     */
    public String getApiEndPoint() {
        return apiEndPoint;
    }

    /**
     * 用来构造{@code System}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        private User user;
        private Application application;
        private Device device;
        private String apiAccessToken;
        private String apiEndPoint;

        /**
         * 设置user的setter方法
         * 
         * @param user
         *            用户信息
         * @return Builder 用来构造{@code System}
         */
        public Builder setUser(final User user) {
            this.user = user;
            return this;
        }

        /**
         * 设置application的setter方法
         * 
         * @param application
         *            Bot信息
         * @return Builder 用来构造{@code System}
         */
        public Builder setApplicaton(final Application application) {
            this.application = application;
            return this;
        }

        /**
         * 设置device的setter方法
         * 
         * @param device
         *            端上设备信息
         * @return Builder 用来构造{@code System}
         */
        public Builder setDevice(final Device device) {
            this.device = device;
            return this;
        }

        /**
         * 设置apiAccessToken的setter方法
         * 
         * @param apiAccessToken
         *            apiAccessToken
         * @return Builder 用来构造{@code System}
         */
        public Builder setApiAccessToken(final String apiAccessToken) {
            this.apiAccessToken = apiAccessToken;
            return this;
        }

        /**
         * 设置apiEndPoint的setter方法
         * 
         * @param apiEndPoint
         *            apiEndPoint
         * @return Builder 用来构造{@code System}
         */
        public Builder setApiEndPoint(final String apiEndPoint) {
            this.apiEndPoint = apiEndPoint;
            return this;
        }

        /**
         * 调用{@code System}的私有构造方法构造{@code System}
         * 
         * @return System 构造一个System
         */
        public System build() {
            return new System(this);
        }
    }
}
