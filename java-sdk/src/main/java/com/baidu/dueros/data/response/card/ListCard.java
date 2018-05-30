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
 * 标准列表卡片
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonTypeName("list")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListCard extends Card {
    // token
    private String token;
    // 列表里的item
    private List<StandardCardInfo> list = new ArrayList<StandardCardInfo>();
    // 链接地址
    private String url;
    // 链接文本
    private String anchorText;
    // 引导话术，引导用户进行下一轮对话的文字
    private List<String> cueWords = new ArrayList<String>();

    /**
     * 默认构造方法
     */
    public ListCard() {
        this.token = genToken();
    }

    /**
     * 构造方法
     * 
     * @param list
     *            标准列表卡片信息列表
     */
    public ListCard(final List<StandardCardInfo> list) {
        this.token = genToken();
        this.list = list;
    }

    /**
     * 获取list的getter方法
     * 
     * @return list 标准列表卡片信息列表
     */
    public List<StandardCardInfo> getList() {
        return list;
    }

    /**
     * 设置标准卡片信息列表的setter方法
     * 
     * @param list
     *            标准卡片信息列表
     */
    public void setList(final List<StandardCardInfo> list) {
        this.list = list;
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
     * 获取链接文本的getter方法
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
     * 获取引导话术的getter方法
     * 
     * @return cueWords 引导话术
     */
    public List<String> getCueWords() {
        return cueWords;
    }

    /**
     * 设置引导话术的setter方法
     * 
     * @param cueWords
     *            引导话术
     */
    public void setCueWords(final List<String> cueWords) {
        this.cueWords = cueWords;
    }

    /**
     * 添加标准卡片信息列表
     * 
     * @param standardCardInfo
     *            标准卡片信息列表
     */
    public void addStandardCardInfo(final StandardCardInfo standardCardInfo) {
        this.list.add(standardCardInfo);
    }

    /**
     * 添加标准卡片信息列表
     * 
     * @param title
     *            标题
     * @param content
     *            内容
     */
    public void addStandardCardInfo(final String title, final String content) {
        StandardCardInfo standardCardInfo = new StandardCardInfo(title, content);
        this.list.add(standardCardInfo);
    }

    /**
     * 添加引导话术
     * 
     * @param cueWord
     *            添加引导话术
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
