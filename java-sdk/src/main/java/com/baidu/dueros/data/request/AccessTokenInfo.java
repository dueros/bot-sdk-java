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
 * AccessToken授权信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年11月16日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessTokenInfo {

    // oauthInfoId
    private final String oauthInfoId;
    // accessToken
    private final String accessToken;

    /**
     * 返回一个用来构造{@code ApplicaAccessTokenInfotion}的{@code Builder}
     * 
     * @return Builder 用来构造{@code AccessTokenInfo}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取oauthInfoId的getter方法
     * 
     * @return String oauthInfoId
     */
    public String getOauthInfoId() {
        return oauthInfoId;
    }

    /**
     * 获取accessToken的getter方法
     * 
     * @return String accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    private AccessTokenInfo(@JsonProperty("oauthInfoId") final String oauthInfoId,
            @JsonProperty("accessToken") final String accessToken) {
        this.oauthInfoId = oauthInfoId;
        this.accessToken = accessToken;
    }

    private AccessTokenInfo(final Builder builder) {
        oauthInfoId = builder.oauthInfoId;
        accessToken = builder.accessToken;
    }

    /**
     * 用来构造{@code AccessTokenInfo}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {
        // oauthInfoId
        private String oauthInfoId;
        // accessToken
        private String accessToken;

        /**
         * 设置oauthInfoId的setter方法
         * 
         * @param oauthInfoId
         *            oauthInfoId
         * @return Builder 用来构造{@code AccessTokenInfo}
         */
        public Builder setOauthInfoId(final String oauthInfoId) {
            this.oauthInfoId = oauthInfoId;
            return this;
        }

        /**
         * 设置accessToken的setter方法
         * 
         * @param accessToken
         *            accessToken
         * @return Builder 用来构造{@code AccessTokenInfo}
         */
        public Builder setAccessToken(final String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * 调用{@code AccessTokenInfo}的私有构造方法构造{@code AccessTokenInfo}
         * 
         * @return AccessTokenInfo 构造一个AccessTokenInfo
         */
        public AccessTokenInfo build() {
            return new AccessTokenInfo(this);
        }
    }
}
