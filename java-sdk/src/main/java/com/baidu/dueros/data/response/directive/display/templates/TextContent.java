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
package com.baidu.dueros.data.response.directive.display.templates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ListItem 中定义文本内容的结构体（包含一级，二级，三级文本内容）
 * 
 * @author hujie08
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextContent {
    // 一级文本内容
    private TextStructure primaryText;
    // 二级文本内容
    private TextStructure secondaryText;
    // 三级文本内容
    private TextStructure tertiaryText;

    /**
     * 默认构造函数
     */
    public TextContent() {
    }

    /**
     * 构造函数
     * 
     * @param primaryText
     *            一级文本内容
     */
    public TextContent(String primaryText) {
        this.primaryText = new TextStructure(primaryText);
    }

    /**
     * 获取一级文本内容的getter方法
     * 
     * @return 一级文本内容
     */
    public TextStructure getPrimaryText() {
        return primaryText;
    }

    /**
     * 设置一级文本内容的setter方法
     * 
     * @param primaryText
     *            一级纯文本内容
     * @return TextContent
     */
    public TextContent setPlainPrimaryText(String primaryText) {
        this.primaryText = new TextStructure(primaryText);
        return this;
    }

    /**
     * 获取二级文本内容的getter方法
     * 
     * @return String 二级文本内容
     */
    public TextStructure getSecondaryText() {
        return secondaryText;
    }

    /**
     * 设置二级文本内容的setter方法
     * 
     * @param secondaryText
     *            二级纯文本内容
     * @return TextContent
     */
    public TextContent setPlainSecondaryText(String secondaryText) {
        this.secondaryText = new TextStructure(secondaryText);
        return this;
    }

    /**
     * 获取三级文本内容的getter方法
     * 
     * @return String 三级文本内容
     */
    public TextStructure getTertiaryText() {
        return tertiaryText;
    }

    /**
     * 设置三级文本内容的setter方法
     * 
     * @param tertiaryText
     *            三级纯文本内容
     * @return TextContent
     */
    public TextContent setPlainTertiaryText(String tertiaryText) {
        this.tertiaryText = new TextStructure(tertiaryText);
        return this;
    }

}
