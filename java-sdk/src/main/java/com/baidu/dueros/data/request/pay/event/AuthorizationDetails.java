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

package com.baidu.dueros.data.request.pay.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationDetails {

    private AuthorizationAmount authorizationAmount;
    private CapturedAmount capturedAmount;

    /**
     * 通过{@code Builder}来构造{@code AuthorizationDetails}
     * 
     * @param builder
     *            用来构造{@code AuthorizationDetails}
     */
    private AuthorizationDetails(Builder builder) {
        authorizationAmount = builder.authorizationAmount;
        capturedAmount = builder.capturedAmount;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param authorizationAmount
     *            authorizationAmount
     * @param capturedAmount
     *            capturedAmount
     */
    private AuthorizationDetails(@JsonProperty("authorizationAmount") final AuthorizationAmount authorizationAmount,
            @JsonProperty("capturedAmount") final CapturedAmount capturedAmount) {
        this.authorizationAmount = authorizationAmount;
        this.capturedAmount = capturedAmount;
    }

    /**
     * 返回一个用来构造{@code AuthorizationDetails}的{@code Builder}
     * 
     * @return Builder 用来构造{@code AuthorizationDetails}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取authorizationAmount的getter方法
     * 
     * @return AuthorizationAmount authorizationAmount
     */
    public AuthorizationAmount getAuthorizationAmount() {
        return authorizationAmount;
    }

    /**
     * 获取capturedAmount的getter方法
     * 
     * @return CapturedAmount capturedAmount
     */
    public CapturedAmount getCapturedAmount() {
        return capturedAmount;
    }

    /**
     * 用来构造{@code AuthorizationDetails}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder {

        private AuthorizationAmount authorizationAmount;
        private CapturedAmount capturedAmount;

        private Builder setAuthorizationAmount(AuthorizationAmount authorizationAmount) {
            this.authorizationAmount = authorizationAmount;
            return this;
        }

        private Builder setCapturedAmount(CapturedAmount capturedAmount) {
            this.capturedAmount = capturedAmount;
            return this;
        }

        private AuthorizationDetails build() {
            return new AuthorizationDetails(this);
        }
    }
}
