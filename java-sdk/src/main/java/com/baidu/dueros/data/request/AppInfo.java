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
 * 应用信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年11月16日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInfo {

    // 应用名称
    private final String appName;
    // 应用包名
    private final String packageName;
    // 应用版本号
    private final String versionCode;
    // 应用版本名称
    private final String versionName;

    public static Builder newBuilder() {
        return new Builder();
    }

    private AppInfo(@JsonProperty("appName") final String appName,
            @JsonProperty("packageName") final String packageName,
            @JsonProperty("versionCode") final String versionCode,
            @JsonProperty("versionName") final String versionName) {
        this.appName = appName;
        this.packageName = packageName;
        this.versionCode = versionCode;
        this.versionName = versionName;
    }

    private AppInfo(final Builder builder) {
        appName = builder.appName;
        packageName = builder.packageName;
        versionCode = builder.versionCode;
        versionName = builder.versionName;
    }

    /**
     * 获取appName的getter方法
     * 
     * @return String appName应用名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 获取packageName的getter方法
     * 
     * @return String packageName应用包名
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 获取versionCode的getter方法
     * 
     * @return String versionCode应用版本号
     */
    public String getVersionCode() {
        return versionCode;
    }

    /**
     * 获取versionName的getter方法
     * 
     * @return String versionName应用版本名称
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * 用来构造{@code AppInfo}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // 应用名称
        private String appName;
        // 应用包名
        private String packageName;
        // 应用版本号
        private String versionCode;
        // 应用版本名称
        private String versionName;

        /**
         * 设置appName的setter方法
         * 
         * @param appName
         *            应用名称
         * @return Builder 用来构造{@code AppInfo}
         */
        public Builder setAppName(final String appName) {
            this.appName = appName;
            return this;
        }

        /**
         * 设置packageName的setter方法
         * 
         * @param packageName
         *            应用包名
         * @return Builder 用来构造{@code AppInfo}
         */
        public Builder setPackageName(final String packageName) {
            this.packageName = packageName;
            return this;
        }

        /**
         * 设置versionCode的setter方法
         * 
         * @param versionCode
         *            应用版本号
         * @return Builder 用来构造{@code AppInfo}
         */
        public Builder setVersionCode(final String versionCode) {
            this.versionCode = versionCode;
            return this;
        }

        /**
         * 设置versionName的setter方法
         * 
         * @param versionName
         *            应用版本名称
         * @return Builder 用来构造{@code AppInfo}
         */
        public Builder setVersionName(final String versionName) {
            this.versionName = versionName;
            return this;
        }

        /**
         * 调用{@code AppInfo}的私有构造方法构造{@code AppInfo}
         * 
         * @return AppInfo 构造一个AppInfo
         */
        public AppInfo build() {
            return new AppInfo(this);
        }
    }

}