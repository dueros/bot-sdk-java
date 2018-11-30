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
 * 端上设备信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    // 设备Id
    private final String deviceId;
    // 设备信息
    private final DeviceInfo deviceInfo;
    // 原始的设备Id
    private final String originalDeviceId;
    // 端支持的接口类型,如果支持则value不为空，具体含义如以上Message定义
    private final SupportedInterfaces supportedInterfaces;

    /**
     * 返回一个构造{@code Device}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Device}
     */
    public static Builder newBuild() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}构造{@code Device}
     * 
     * @param builder
     *            用来构造{@code Device}
     */
    private Device(final Builder builder) {
        deviceId = builder.deviceId;
        deviceInfo = builder.deviceInfo;
        originalDeviceId = builder.originalDeviceId;
        supportedInterfaces = builder.supportedInterfaces;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param deviceId
     *            设备Id
     * @param deviceInfo
     *            设备信息
     */
    private Device(@JsonProperty("deviceId") final String deviceId,
            @JsonProperty("deviceInfo") final DeviceInfo deviceInfo,
            @JsonProperty("originalDeviceId") final String originalDeviceId,
            @JsonProperty("supportedInterfaces") final SupportedInterfaces supportedInterfaces) {
        this.deviceId = deviceId;
        this.deviceInfo = deviceInfo;
        this.originalDeviceId = originalDeviceId;
        this.supportedInterfaces = supportedInterfaces;
    }

    /**
     * 获取deviceId的getter方法
     * 
     * @return String 获取deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 获取deviceInfo的getter方法
     * 
     * @return DeviceInfo 获取deviceInfo
     */
    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public String getOriginalDeviceId() {
        return originalDeviceId;
    }

    public SupportedInterfaces getSupportedInterfaces() {
        return supportedInterfaces;
    }

    /**
     * 用来构造{@code Device}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {
        // 设备Id
        private String deviceId;
        // 设备信息
        private DeviceInfo deviceInfo;
        // 原始的设备Id
        private String originalDeviceId;
        // 端支持的接口类型,如果支持则value不为空，具体含义如以上Message定义
        private SupportedInterfaces supportedInterfaces;

        /**
         * 设置deviceId的setter方法
         * 
         * @param deviceId
         *            设备ID
         * @return Builder 用来构造{@code Device}
         */
        public Builder setDeviceId(final String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * 设置deviceInfo的setter方法
         * 
         * @param deviceInfo
         *            设备信息
         * @return Builder 用来构造{@code Device}
         */
        public Builder setDeviceInfo(final DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
            return this;
        }

        /**
         * 设置originalDeviceId的setter方法
         * 
         * @param originalDeviceId
         *            原始的设备Id
         * @return Builder 用来构造{@code Device}
         */
        public Builder setOriginalDeviceId(final String originalDeviceId) {
            this.originalDeviceId = originalDeviceId;
            return this;
        }

        public Builder setSupportedInterfaces(final SupportedInterfaces supportedInterfaces) {
            this.supportedInterfaces = supportedInterfaces;
            return this;
        }

        /**
         * 调用{@code Device}的私有构造方法构造{@code Device}
         * 
         * @return Device 构造一个Device
         */
        public Device build() {
            return new Device(this);
        }

    }
}
