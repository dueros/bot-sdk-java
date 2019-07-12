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
 * 用户授权提供给Bot的详细信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    private final LocationInfo location;
    private final Account account;

    public static Builder newBuilder() {
        return new Builder();
    }

    private UserInfo(@JsonProperty("location") final LocationInfo location,
            @JsonProperty("account") final Account account) {
        this.location = location;
        this.account = account;
    }

    private UserInfo(final Builder builder) {
        location = builder.location;
        account = builder.account;
    }

    public LocationInfo getLocation() {
        return location;
    }

    public Account getAccount() {
        return account;
    }

    public static final class Builder {
        private LocationInfo location;
        private Account account;

        public Builder setLocation(final LocationInfo location) {
            this.location = location;
            return this;
        }

        public Builder setAccount(final Account account) {
            this.account = account;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }

}
