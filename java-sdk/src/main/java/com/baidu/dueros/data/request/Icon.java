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
 * 屏幕显示中的技能卡片信息
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年5月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Icon {
    // 原始页面url
    private final String originPageUrl;
    // 图标地址
    private final String src;

    /**
     * 返回一个用来构造{@code Icon}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Icon}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code Icon}
     * 
     * @param builder
     *            用来构造{@code Icon}
     */
    private Icon(Builder builder) {
        originPageUrl = builder.originPageUrl;
        src = builder.src;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param originPageUrl
     *            页面url
     * @param src
     *            技能图标地址
     */
    private Icon(@JsonProperty("originPageUrl") final String originPageUrl, @JsonProperty("src") final String src) {
        this.originPageUrl = originPageUrl;
        this.src = src;
    }

    /**
     * 获取页面地址的getetr方法
     * 
     * @return String 页面地址
     */
    public String getOriginPageUrl() {
        return originPageUrl;
    }

    /**
     * 获取图标地址的getter方法
     * 
     * @return String 图标地址
     */
    public String getSrc() {
        return src;
    }

    /**
     * 用来构造{@code Icon}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月4日
     */
    public static final class Builder {
        // 原始页面url
        private String originPageUrl;
        // 图标地址
        private String src;

        /**
         * 设置原始页面url的setter方法
         * 
         * @param originPageUrl
         *            页面url
         * @return Builder 用来构造{@code Icon}
         */
        public Builder setOriginPageUrl(String originPageUrl) {
            this.originPageUrl = originPageUrl;
            return this;
        }

        /**
         * 设置图标地址的setter方法
         * 
         * @param src
         *            图标地址
         * @return Builder 用来构造{@code Icon}
         */
        public Builder setSrc(String src) {
            this.src = src;
            return this;
        }

        /**
         * 调用{@code Icon}的私有构造方法构造{@code Icon}
         * 
         * @return Icon 构造一个Icon
         */
        public Icon build() {
            return new Icon(this);
        }
    }

}
