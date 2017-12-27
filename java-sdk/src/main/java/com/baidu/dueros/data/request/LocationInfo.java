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
 * 位置信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationInfo {

    // 地理坐标信息
    private final GeoLocation geo;

    /**
     * 返回一个用来构造{@code LocationInfo}的{@code Builder}
     * 
     * @return Builder 用来构造{@code LocationInfo}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取geo的getter方法
     * 
     * @return String geo地理坐标信息
     */
    public GeoLocation getGeo() {
        return geo;
    }

    private LocationInfo(final Builder builder) {
        geo = builder.geo;
    }

    private LocationInfo(@JsonProperty("geo") GeoLocation geo) {
        this.geo = geo;
    }

    /**
     * 用来构造{@code LocationInfo}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // 地理坐标信息
        private GeoLocation geo;

        /**
         * 设置geo的setter方法
         * 
         * @param geo
         *            地理坐标信息
         * @return Builder 用来构造{@code LocationInfo}
         */
        public Builder setGeo(final GeoLocation geo) {
            this.geo = geo;
            return this;
        }

        /**
         * 调用{@code LocationInfo}的私有构造方法构造{@code LocationInfo}
         * 
         * @return LocationInfo 构造一个LocationInfo
         */
        public LocationInfo build() {
            return new LocationInfo(this);
        }
    }
}
