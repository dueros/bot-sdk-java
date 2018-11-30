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
 * 技能信息
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年5月3日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkillInfo {
    // 技能图标信息
    private final Icon icon;
    // 技能名称
    private final String name;

    /**
     * 返回一个用来构造{@code SkillInfo}的{@code Builder}
     * 
     * @return Builder 用来构造{@code SkillInfo}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code SkillInfo}
     * 
     * @param builder
     *            用来构造{@code SkillInfo}
     */
    private SkillInfo(Builder builder) {
        icon = builder.icon;
        name = builder.name;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param icon
     *            技能图标信息
     * @param name
     *            技能名称
     */
    private SkillInfo(@JsonProperty("icon") final Icon icon, @JsonProperty("name") final String name) {
        this.icon = icon;
        this.name = name;
    }

    /**
     * 获取技能图标信息的getter方法
     * 
     * @return Icon 技能图标信息
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * 获取技能名称的getter方法
     * 
     * @return String 技能名称
     */
    public String getName() {
        return name;
    }

    /**
     * 用来构造{@code SkillInfo}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder {
        // 技能图标信息
        private Icon icon;
        // 技能名称
        private String name;

        /**
         * 设置技能图标的setter方法
         * 
         * @param icon
         *            技能图标信息
         * @return 构造SkillInfo的builder
         */
        public Builder setIcon(Icon icon) {
            this.icon = icon;
            return this;
        }

        /**
         * 设置技能名称的setter方法
         * 
         * @param name
         *            技能名称
         * @return 构造SkillInfo的builder
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * 调用{@code SkillInfo}的私有构造方法构造{@code SkillInfo}
         * 
         * @return SkillInfo 构造一个SkillInfo
         */
        public SkillInfo build() {
            return new SkillInfo(this);
        }
    }
}
