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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 图文模版的基类
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月26日
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = BodyTemplate2.class), @Type(value = BodyTemplate3.class),
        @Type(value = BodyTemplate4.class), @Type(value = BodyTemplate5.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TextImageTemplate extends BaseTemplate {
    // 展现的图片
    private ImageStructure image;
    // 文本结构，支持纯文本和富文本两种格式
    private TextStructure content;

    /**
     * 构造函数
     */
    public TextImageTemplate() {
    }

    /**
     * @param title
     *            卡片的标题
     * @param textType
     *            文本结构，支持纯文本和富文本两种格式
     * @param text
     *            文字内容
     */
    public TextImageTemplate(String title, TextType textType, String text) {
        super(title);
        this.content = new TextStructure(textType, text);
    }

    /**
     * 获取展现的图片的结构体
     * 
     * @return ImageStructure 展现的图片
     */
    public ImageStructure getImage() {
        return image;
    }

    /**
     * 设置展现的图片
     * 
     * @param image
     *            展现的图片结构体
     * @return TextImageTemplate
     */
    public TextImageTemplate setImage(ImageStructure image) {
        this.image = image;
        return this;
    }

    /**
     * 设置展现的图片
     * 
     * @param url
     *            展现图片的url地址
     * @return TextImageTemplate
     */
    public TextImageTemplate setImageUrl(String url) {
        image = new ImageStructure(url);
        return this;
    }

    /**
     * 获取卡片的内容
     * 
     * @return TextStructure 卡片的内容
     */
    public TextStructure getContent() {
        return content;
    }

    /**
     * 设置卡片纯文本内容
     * 
     * @param content
     *            卡片的纯文本内容
     * @return TextImageTemplate
     */
    public TextImageTemplate setPlainContent(String content) {
        this.content = new TextStructure(content);
        return this;
    }
}
