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

import com.baidu.dueros.data.response.directive.display.templates.BodyTemplate1.PositionType;
import com.baidu.dueros.data.response.directive.display.templates.TextStructure.TextType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * BodyTemplate1 中需要的文本结构
 * 
 * @author hujie08
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tpl1Content {
    // 文本垂直方向的位置,默认置底左对齐
    private PositionType position;
    // 文字内容
    private TextStructure text;

    /**
     * 默认构造函数
     */
    public Tpl1Content() {
    }

    /**
     * 构造函数
     * 
     * @param text
     *            文字内容
     */
    public Tpl1Content(TextStructure text) {
        this.text = text;
        // 默认置底左对齐
        this.position = PositionType.BOTTOM_LEFT;
    }

    /**
     * 构造函数
     * 
     * @param type
     *            文本类型
     * @param text
     *            文字内容
     */
    public Tpl1Content(TextType type, String text) {
        this.text = new TextStructure(type, text);
        // 默认置底左对齐
        this.position = PositionType.BOTTOM_LEFT;
    }

    /**
     * 构造函数
     * 
     * @param text
     *            文字内容
     */
    public Tpl1Content(String text) {
        this.text = new TextStructure(TextType.PlainText, text);
        // 默认置底左对齐
        this.position = PositionType.BOTTOM_LEFT;
    }

    /**
     * 获取文本位置的getter方法
     * 
     * @return String 文本位置
     */
    public String getPosition() {
        return position.getPosition();
    }

    /**
     * 设置文本位置的setter方法
     * 
     * @param position
     *            文本位置
     * @return Tpl1Content
     */
    public Tpl1Content setPosition(PositionType position) {
        this.position = position;
        return this;
    }

    /**
     * 获取文本内容的getter方法
     * 
     * @return TextStructure 文本内容
     */
    public TextStructure getText() {
        return text;
    }

    /**
     * 设置文本内容的setter方法
     * 
     * @param text
     *            文本结构体
     * @return Tpl1Content
     */
    public Tpl1Content setText(TextStructure text) {
        this.text = text;
        return this;
    }
}
