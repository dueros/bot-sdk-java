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
 * 用户信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    // 每次enable skill产生一个新的userId
    private final String userId;
    // 用户用于做OAuth 2.0认证的access token
    private final String accessToken;
    // 用户授权提供给Bot的详细信息
    private final UserInfo userInfo;

    /**
     * 返回一个用来构造{@code User}的{@code Builder}
     * 
     * @return Builder 用来构造{@code User}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private User(final Builder builder) {
        userId = builder.userId;
        accessToken = builder.accessToken;
        userInfo = builder.userInfo;
    }

    private User(@JsonProperty("userId") final String userId, @JsonProperty("accessToken") final String accessToken,
            @JsonProperty("userInfo") final UserInfo userInfo) {
        // @JsonProperty("userInfo") final UserInfo userInfo) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.userInfo = userInfo;
    }

    /**
     * 获取userId的getter方法
     * 
     * @return userId 每次enable skill产生一个新的userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 获取accessToken的getter方法
     * 
     * @return accessToken 用户用于做OAuth 2.0认证的access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 获取UserInfo的getter方法
     * 
     * @return userInfo 用户授权提供给Bot的详细信息
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * 用来构造{@code User}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        private String userId;
        private String accessToken;
        private UserInfo userInfo;

        /**
         * 设置userId的setter方法
         * 
         * @param userId
         *            每次enable skill产生一个新的userId
         * @return Builder 用来构造{@code User}
         */
        public Builder setUserId(final String userId) {
            this.userId = userId;
            return this;
        }

        /**
         * 设置accessToken的setter方法
         * 
         * @param accessToken
         *            用户用于做OAuth 2.0认证的access token
         * @return Builder 用来构造{@code User}
         */
        public Builder setAccessToken(final String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * 设置userInfo的setter方法
         * 
         * @param userInfo
         *            用户授权提供给Bot的详细信息
         * @return Builder 用来构造{@code User}
         */
        public Builder setUserInfo(final UserInfo userInfo) {
            this.userInfo = userInfo;
            return this;
        }

        /**
         * 调用{@code User}的私有构造方法构造{@code User}
         * 
         * @return User
         */
        public User build() {
            return new User(this);
        }
    }

}
