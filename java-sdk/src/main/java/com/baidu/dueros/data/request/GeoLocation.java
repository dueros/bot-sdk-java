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
 * 地理位置坐标
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {

    // 百度球面坐标
    private final CoordinatesInfo bd09ll;
    // GPS球面坐标
    private final CoordinatesInfo wgs84;
    // 百度墨卡托坐标
    private final CoordinatesInfo bd09mc;

    /**
     * 返回一个用来构造{@code Application}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Application}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private GeoLocation(@JsonProperty("bd09ll") final CoordinatesInfo bd09ll,
            @JsonProperty("wgs84") final CoordinatesInfo wgs84, @JsonProperty("bd09mc") final CoordinatesInfo bd09mc) {
        this.bd09ll = bd09ll;
        this.wgs84 = wgs84;
        this.bd09mc = bd09mc;
    }

    private GeoLocation(final Builder builder) {
        bd09ll = builder.bd09ll;
        wgs84 = builder.wgs84;
        bd09mc = builder.bd09mc;
    }

    /**
     * 获取bd09ll的getter方法
     * 
     * @return String bd09ll百度球面坐标
     */
    public CoordinatesInfo getBd09ll() {
        return bd09ll;
    }

    /**
     * 获取wgs84的getter方法
     * 
     * @return String wgs84 GPS球面坐标
     */
    public CoordinatesInfo getWgs84() {
        return wgs84;
    }

    /**
     * 获取bd09mc的getter方法
     * 
     * @return String bd09mc百度墨卡托坐标
     */
    public CoordinatesInfo getBd09mc() {
        return bd09mc;
    }

    /**
     * 用来构造{@code GeoLocation}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {
        // 百度球面坐标
        private CoordinatesInfo bd09ll;
        // GPS球面坐标
        private CoordinatesInfo wgs84;
        // 百度墨卡托坐标
        private CoordinatesInfo bd09mc;

        /**
         * 设置bd09ll的setter方法
         * 
         * @param bd09ll
         *            百度球面坐标
         * @return Builder 用来构造{@code GeoLocation}
         */
        public Builder setBd09ll(final CoordinatesInfo bd09ll) {
            this.bd09ll = bd09ll;
            return this;
        }

        /**
         * 设置wgs84的setter方法
         * 
         * @param wgs84
         *            GPS球面坐标
         * @return Builder 用来构造{@code GeoLocation}
         */
        public Builder setWgs84(final CoordinatesInfo wgs84) {
            this.wgs84 = wgs84;
            return this;
        }

        /**
         * 设置bd09mc的setter方法
         * 
         * @param bd09mc
         *            百度墨卡托坐标
         * @return Builder 用来构造{@code GeoLocation}
         */
        public Builder setBd09mc(final CoordinatesInfo bd09mc) {
            this.bd09mc = bd09mc;
            return this;
        }

        /**
         * 调用{@code GeoLocation}的私有构造方法构造{@code GeoLocation}
         * 
         * @return GeoLocation 构造一个GeoLocation
         */
        public GeoLocation build() {
            return new GeoLocation(this);
        }

    }
}
