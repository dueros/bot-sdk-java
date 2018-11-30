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
public class Baidu {
    // 地理坐标信息
    private final String baiduUid;

    /**
     * 返回一个用来构造{@code Baidu}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Baidu}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取baiduUid的getter方法
     * 
     * @return String baiduUid
     */
    public String getBaiduUid() {
        return baiduUid;
    }

    private Baidu(final Builder builder) {
        baiduUid = builder.baiduUid;
    }

    private Baidu(@JsonProperty("baiduUid") String baiduUid) {
        this.baiduUid = baiduUid;
    }

    /**
     * 用来构造{@code Baidu}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // 地理坐标信息
        private String baiduUid;

        /**
         * 设置baiduUid的setter方法
         * 
         * @param baiduUid
         *            地理坐标信息
         * @return Builder 用来构造{@code Baidu}
         */
        public Builder setBaiduUid(final String baiduUid) {
            this.baiduUid = baiduUid;
            return this;
        }

        /**
         * 调用{@code Baidu}的私有构造方法构造{@code Baidu}
         * 
         * @return Baidu 构造一个Baidu
         */
        public Baidu build() {
            return new Baidu(this);
        }
    }
}
