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

package com.baidu.dueros.data.response.card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @title:StandardCard
 * @desc:TODO
 */
/**
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonTypeName("standard")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardCard extends Card {
    // token
    private String token;
    // 卡片标题
    private String title;
    // 卡片内容
    private String content;
    // 图片
    private String image;
    // 卡片链接
    private String url;
    // 链接文本
    private String anchorText;
    // 引导话术
    private List<String> cueWords = new ArrayList<String>();

    /**
     * 默认构造方法
     */
    public StandardCard() {
        this.token = genToken();
    }

    /**
     * 构造方法
     * 
     * @param title
     *            卡片标题
     * @param content
     *            卡片内容
     */
    public StandardCard(final String title, final String content) {
        this.token = genToken();
        this.title = title;
        this.content = content;
    }

    /**
     * 获取title的getter方法
     * 
     * @return String 卡片标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置卡片标题的setter方法
     * 
     * @param title
     *            卡片标题
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * 获取卡片内容的getter方法
     * 
     * @return String 卡片内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置卡片内容的setter方法
     * 
     * @param content
     *            卡片内容
     */
    public void setContent(final String content) {
        this.content = content;
    }

    /**
     * 获取图片的getter方法
     * 
     * @return String 图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片的setter方法
     * 
     * @param image
     *            图片
     */
    public void setImage(final String image) {
        this.image = image;
    }

    /**
     * 获取链接地址的getter方法
     * 
     * @return String 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址的setter方法
     * 
     * @param url
     *            链接地址
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * 获取链接文本anchorText的getter方法
     * 
     * @return String 链接文本
     */
    public String getAnchorText() {
        return anchorText;
    }

    /**
     * 设置链接文本的setter方法
     * 
     * @param anchorText
     *            链接文本
     */
    public void setAnchorText(final String anchorText) {
        this.anchorText = anchorText;
    }

    /**
     * 获取引导话术列表的getter方法
     * 
     * @return cueWords 引导话术列表
     */
    public List<String> getCueWords() {
        return cueWords;
    }

    /**
     * 设置引导话术的setter方法
     * 
     * @param cueWords
     *            引导话术列表
     */
    public void setCueWords(final List<String> cueWords) {
        this.cueWords = cueWords;
    }

    /**
     * 添加引导话术
     * 
     * @param cueWord
     *            引导话术
     */
    public void addCueWords(final String cueWord) {
        this.cueWords.add(cueWord);
    }

    /**
     * 获取token的getter方法
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token的setter方法
     * 
     * @param token
     *            token
     */
    public void setToken(String token) {
        this.token = token;
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
