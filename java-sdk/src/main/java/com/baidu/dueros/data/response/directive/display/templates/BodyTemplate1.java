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

import com.baidu.dueros.data.response.directive.display.templates.TextStructure.TextType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 定义文本展现模板
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月27日
 */
@JsonTypeName("BodyTemplate1")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyTemplate1 extends BaseTemplate {
    // 文本结构，支持纯文本和富文本两种格式
    private Tpl1Content textContent;

    /**
     * 默认构造函数
     */
    public BodyTemplate1() {
        super();
    }

    /**
     * @param title
     *            标题
     */
    public BodyTemplate1(String title) {
        super(title);
    }

    /**
     * @param title
     *            卡片的标题
     * @param textType
     *            文本结构，支持纯文本和富文本两种格式
     * @param text
     *            文字内容
     */
    public BodyTemplate1(String title, TextType textType, String text) {
        super(title);
        this.textContent = new Tpl1Content(textType, text);
    }

    /**
     * 构造函数
     * 
     * @param title
     *            卡片的标题
     * @param textContent
     *            文本结构体
     */
    public BodyTemplate1(String title, Tpl1Content textContent) {
        super(title);
        this.textContent = textContent;
    }

    /**
     * 获取文本结构体的getter方法
     * 
     * @return TextContent 文本结构体
     */
    public Tpl1Content getTextContent() {
        return textContent;
    }

    /**
     * 设置普通文本的setter方法
     * 
     * @param textContent
     *            content内容
     * @return BodyTemplate1
     */
    public BodyTemplate1 setPlainContent(String textContent) {
        this.textContent = new Tpl1Content(TextType.PlainText, textContent);
        return this;
    }

    /**
     * 文本位置枚举
     * 
     * @author hujie08
     */
    public enum PositionType {
        TOP_LEFT("TOP-LEFT"), CENTER("CENTER"), BOTTOM_LEFT("BOTTOM-LEFT");

        private String position = "BOTTOM-LEFT";

        private PositionType(String position) {
            this.position = position;
        }

        @JsonValue
        public String jsonValue() {
            return this.position;
        }

        /**
         * 获取位置枚举变量的实际的值
         * 
         * @return String 文本位置
         */
        public String getPosition() {
            return position;
        }
    }
}
