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
 * 定义文本类型结构体
 * 
 * @author hujie08
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextStructure {
    // 文本类型
    private TextType type;
    // 文本内容
    private String text;

    /**
     * 默认构造函数
     */
    public TextStructure() {
    }

    /**
     * 构造函数
     * 
     * @param type
     *            文本类型
     * @param text
     *            文本内容
     */
    public TextStructure(TextType type, String text) {
        this.type = type;
        this.text = text;
    }

    /**
     * 构造函数
     * 
     * @param text
     *            文本内容
     */
    public TextStructure(String text) {
        this.type = TextType.PlainText;
        this.text = text;
    }

    /**
     * 获取文本类型的getter方法
     * 
     * @return TextType 文本类型
     */
    public TextType getType() {
        return type;
    }

    /**
     * 设置文本类型的setter方法
     * 
     * @param type
     *            文本类型
     * @return TextStructure
     */
    public TextStructure setType(TextType type) {
        this.type = type;
        return this;
    }

    /**
     * 获取文本内容的getter方法
     * 
     * @return String 文本内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置文本内容的setter方法
     * 
     * @param text
     *            文本内容
     * @return TextStructure
     */
    public TextStructure setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * 文本的类型，枚举类型
     * 
     * @author hujie08
     */
    public enum TextType {
        // 纯文本
        PlainText,
        // 富文本
        RichText
    }
}
