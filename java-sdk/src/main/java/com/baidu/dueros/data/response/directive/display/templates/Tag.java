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
 * 定义标签结构
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

    // 标签类型
    private String type;
    // 文本内容
    private String text;
    // 标签字体颜色
    private String color;
    // 标签背景色
    private String backgroundColor;
    // 位置的枚举值
    private String position;
    // 设置圆角边框
    private int borderRadius;

    /**
     * 构造函数
     * 
     * @param type
     *            标签类型
     * @param text
     *            文本内容
     */
    public Tag(String type, String text) {
        this.type = type;
        this.text = text;
    }

    /**
     * 获取type的getter方法
     * 
     * @return String type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type的setter方法
     * 
     * @param type
     *            type
     * @return Tag
     */
    public Tag setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 获取text的getter方法
     * 
     * @return String text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置text的setter方法
     * 
     * @param text
     *            text
     * @return Tag
     */
    public Tag setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * 获取color的getter方法
     * 
     * @return String color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置color的setter方法
     * 
     * @param color
     *            color
     * @return Tag
     */
    public Tag setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * 获取backgroundColor的getter方法
     * 
     * @return String backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 设置backgroundColor的setter方法
     * 
     * @param backgroundColor
     *            backgroundColor
     * @return Tag
     */
    public Tag setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * 获取position的getter方法
     * 
     * @return String position
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置position的setter方法
     * 
     * @param position
     *            position
     * @return Tag
     */
    public Tag setPosition(String position) {
        this.position = position;
        return this;
    }

    /**
     * 获取borderRadius的getter方法
     * 
     * @return String borderRadius
     */
    public int getBorderRadius() {
        return borderRadius;
    }

    /**
     * 设置borderRadius的setter方法
     * 
     * @param borderRadius
     *            borderRadius
     * @return Tag
     */
    public Tag setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

}
