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
 * 文本卡片
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月9日
 */
@JsonTypeName("txt")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextCard extends Card {
    // token
    private String token;
    // 卡片内容
    private String content = "";
    // 卡片链接，可以跳转到对应的落地页
    private String url = "";
    // url存在时有效，展示链接显示的文本，如果不设置，展现“查看更多”
    private String anchorText = "";
    // 引导用户进行下一轮对话的文字
    private List<String> cueWords = new ArrayList<String>();

    /**
     * 默认构造方法
     */
    public TextCard() {
        this.token = genToken();
    }

    /**
     * 构造方法
     * 
     * @param content
     *            卡片内容
     */
    public TextCard(final String content) {
        this.token = genToken();
        this.content = content;
    }

    /**
     * 构造方法
     * 
     * @param content
     *            卡片内容
     * @param url
     *            卡片链接
     * @param anchorText
     *            链接文本
     */
    public TextCard(final String content, final String url, final String anchorText) {
        this.token = genToken();
        this.content = content;
        this.url = url;
        this.anchorText = anchorText;
    }

    /**
     * 获取content的getter方法
     * 
     * @return String 返回卡片内容
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
     * 获取url的getter方法
     * 
     * @return String 返回链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接的setter方法
     * 
     * @param url
     *            链接地址
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * 获取链接文本的getter方法
     * 
     * @return String 返回链接文本
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
     * 获取引导话术的getter方法
     * 
     * @return cueWords 返回引导话术列表
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
    public void addCueWord(final String cueWord) {
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
