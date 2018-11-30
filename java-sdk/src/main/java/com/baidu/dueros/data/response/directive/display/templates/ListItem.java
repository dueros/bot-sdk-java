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

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 定义列表中的一个元素的结构
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListItem {
    // 唯一标识当前元素
    private String token;
    // 图片
    private ImageStructure image;
    // 文本内容
    private TextContent textContent = new TextContent();
    // anchorWord
    private String anchorWord;

    /**
     * 构造函数
     */
    public ListItem() {
        token = genToken();
    }

    /**
     * 构造函数
     * 
     * @param primaryText
     *            一级文本内容
     */
    public ListItem(String primaryText) {
        token = genToken();
        textContent.setPlainPrimaryText(primaryText);
    }

    /**
     * 获取图片信息的getter方法
     * 
     * @return ImageStructure image
     */
    public ImageStructure getImage() {
        return image;
    }

    /**
     * 设置图片信息的setter方法
     * 
     * @param image
     *            ImageStructure
     * @return ListItem
     */
    public ListItem setImage(ImageStructure image) {
        this.image = image;
        return this;
    }

    /**
     * 设置图片信息的setter方法
     * 
     * @param url
     *            图片地址url
     * @return ListItem
     */
    public ListItem setImageUrl(String url) {
        image = new ImageStructure(url);
        return this;
    }

    /**
     * 获取文本内容结构的getter方法
     * 
     * @return TextContent 文本内容结构体
     */
    public TextContent getTextContent() {
        return textContent;
    }

    /**
     * 设置文本内容结构的setter方法
     * 
     * @param textContent
     *            文本内容结构体TextContent
     * @return ListItem
     */
    public ListItem setTextContent(TextContent textContent) {
        this.textContent = textContent;
        return this;
    }

    /**
     * 设置一级纯文本内容
     * 
     * @param primaryText
     *            一级纯文本内容
     * @return ListItem
     */
    public ListItem setPlainPrimaryText(String primaryText) {
        textContent.setPlainPrimaryText(primaryText);
        return this;
    }

    /**
     * 设置二级纯文本内容
     * 
     * @param secondaryText
     *            二级纯文本内容
     * @return ListItem
     */
    public ListItem setPlainSecondaryText(String secondaryText) {
        textContent.setPlainSecondaryText(secondaryText);
        return this;
    }

    /**
     * 设置三级纯文本内容
     * 
     * @param tertiaryText
     *            三级纯文本内容
     * @return ListItem
     */
    public ListItem setPlainTertiaryText(String tertiaryText) {
        textContent.setPlainTertiaryText(tertiaryText);
        return this;
    }

    /**
     * 获取列表项token的getter方法
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置列表项token的setter方法
     * 
     * @param token
     *            唯一标识的token值
     * @return ListItem
     */
    public ListItem setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * 设置列表项anchorWord的setter方法
     * 
     * @param anchorWord
     *            anchorWord
     * @return ListItem
     */
    public ListItem setAnchorWord(String anchorWord) {
        this.anchorWord = anchorWord;
        return this;
    }

    /**
     * 获取列表项AnchorWord的getter方法
     * 
     * @return String AnchorWord
     */
    public String getAnchorWord() {
        return anchorWord;
    }

    /**
     * 生成token的方法
     * 
     * @return String token
     */
    private String genToken() {
        return UUID.randomUUID().toString();
    }
}
