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
 * 图片卡片
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonTypeName("image")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageCard extends Card {
    // token
    private String token;
    // 列表里的item
    private List<ImageCardInfo> list = new ArrayList<ImageCardInfo>();
    // 引导用户进行下一轮对话的文字，提示用户的输入example，用户可以点击其中一个item，快速输入
    private List<String> cueWords = new ArrayList<String>();

    /**
     * 默认构造方法
     */
    public ImageCard() {
        this.token = genToken();
    }

    /**
     * 构造方法
     * 
     * @param list
     *            列表里的item
     * @param cueWords
     *            用户引导
     */
    public ImageCard(final List<ImageCardInfo> list, final List<String> cueWords) {
        this.token = genToken();
        this.list = list;
        this.cueWords = cueWords;
    }

    /**
     * 获取列表里item list的getter方法
     * 
     * @return list 获取列表里的item的列表
     */
    public List<ImageCardInfo> getList() {
        return list;
    }

    /**
     * 设置图片卡片列表的setter方法
     * 
     * @param list
     *            图片卡片的item列表
     */
    public void setList(final List<ImageCardInfo> list) {
        this.list = list;
    }

    /**
     * 获取引导话术的getter方法
     * 
     * @return cueWords 图片卡片引导话术列表
     */
    public List<String> getCueWords() {
        return cueWords;
    }

    /**
     * 设置图片卡片引导话术的setter方法
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
     * @param cueWords
     *            引导话术
     */
    public void addCueWords(final String cueWords) {
        this.cueWords.add(cueWords);
    }

    /**
     * 添加图片卡片信息
     * 
     * @param imageCardInfo
     *            图片卡片信息
     */
    public void addImageCardInfo(final ImageCardInfo imageCardInfo) {
        this.list.add(imageCardInfo);
    }

    /**
     * 添加图片卡片信息
     * 
     * @param src
     *            图片的地址
     * @param thumb
     *            缩略图地址
     */
    public void addImageCardInfo(final String src, final String thumb) {
        ImageCardInfo imageCardInfo = new ImageCardInfo(src, thumb);
        this.addImageCardInfo(imageCardInfo);
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
