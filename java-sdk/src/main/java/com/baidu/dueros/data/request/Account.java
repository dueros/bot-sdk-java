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

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    // 百度账号信息
    private final Baidu baidu;

    /**
     * 返回一个用来构造{@code Account}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Account}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取baidu的getter方法
     * 
     * @return String baidu地理坐标信息
     */
    public Baidu getBaidu() {
        return baidu;
    }

    private Account(final Builder builder) {
        baidu = builder.baidu;
    }

    private Account(@JsonProperty("baidu") Baidu baidu) {
        this.baidu = baidu;
    }

    /**
     * 用来构造{@code Baidu}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // 百度账号信息
        private Baidu baidu;

        /**
         * 设置baidu的setter方法
         * 
         * @param baidu
         *            百度账号信息
         * @return Builder 用来构造{@code Account}
         */
        public Builder setGeo(final Baidu baidu) {
            this.baidu = baidu;
            return this;
        }

        /**
         * 调用{@code Baidu}的私有构造方法构造{@code Baidu}
         * 
         * @return Baidu 构造一个Baidu
         */
        public Account build() {
            return new Account(this);
        }
    }
}
