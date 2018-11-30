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
package com.baidu.dueros.data.response.directive.display;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * hint内容的结构体
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年4月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HintContent {
    private static final String type = "PlainText";
    private String text;

    /**
     * 构造函数
     * 
     * @param text
     *            hint话术
     */
    public HintContent(String text) {
        this.text = text;
    }

    /**
     * 获取hint话术的getter方法
     * 
     * @return String hint话术
     */
    public String getText() {
        return text;
    }

    /**
     * 设置hint话术的setter方法
     * 
     * @param text
     *            hint话术
     * @return HintContent
     */
    public HintContent setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * 获取话术类型的getter方法
     * 
     * @return String hint话术类型
     */
    public String getType() {
        return type;
    }
}
