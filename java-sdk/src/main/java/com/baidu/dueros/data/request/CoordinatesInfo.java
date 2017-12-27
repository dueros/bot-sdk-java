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
 * 经纬度
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordinatesInfo {

    // 经度
    private final double longitude;
    // 纬度
    private final double latitude;

    /**
     * 返回一个用来构造{@code CoordinatesInfo}的{@code Builder}
     * 
     * @return Builder 用来构造{@code CoordinatesInfo}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 获取longitude的getter方法
     * 
     * @return double 返回经度
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * 获取latitude的getter方法
     * 
     * @return double 返回纬度
     */
    public double getLatitude() {
        return latitude;
    }

    private CoordinatesInfo(@JsonProperty("longitude") final double longitude,
            @JsonProperty("latitude") final double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    private CoordinatesInfo(final Builder builder) {
        longitude = builder.longitude;
        latitude = builder.latitude;
    }

    /**
     * 用来构造{@code CoordinatesInfo}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年11月16日
     */
    public static final class Builder {
        // 经度
        private double longitude;
        // 纬度
        private double latitude;

        /**
         * 设置longitude的setter方法
         * 
         * @param longitude
         *            经度
         * @return Builder 用来构造{@code CoordinatesInfo}
         */
        public Builder setLongitude(final double longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * 设置latitude的setter方法
         * 
         * @param latitude
         *            纬度
         * @return Builder 用来构造{@code CoordinatesInfo}
         */
        public Builder setLatitude(final double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * 调用{@code CoordinatesInfo}的私有构造方法构造{@code CoordinatesInfo}
         * 
         * @return CoordinatesInfo 构造一个CoordinatesInfo
         */
        public CoordinatesInfo build() {
            return new CoordinatesInfo(this);
        }
    }

}
