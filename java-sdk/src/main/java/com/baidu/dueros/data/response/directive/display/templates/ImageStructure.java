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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 定义图片结构
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageStructure {
    // 图片地址，要求为https的地址
    private String url = "";
    // 图片的宽度，单位像素
    private int widthPixels;
    // 图片的高度，单位像素
    private int heightPixels;
    // 标签
    private List<Tag> tags = new ArrayList<>();

    /**
     * 默认构造函数
     */
    public ImageStructure() {
    }

    /**
     * 构造函数
     * 
     * @param url
     *            图片地址，要求为https的地址
     */
    public ImageStructure(String url) {
        this.url = url;
    }

    /**
     * 构造函数
     * 
     * @param url
     *            图片地址
     * @param widthPixels
     *            图片的宽度，单位像素
     * @param heightPixels
     *            图片的高度，单位像素
     */
    public ImageStructure(String url, int widthPixels, int heightPixels) {
        this.url = url;
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
    }

    /**
     * 获取图片地址的getter方法
     * 
     * @return String url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片地址的setter方法
     * 
     * @param url
     *            图片地址
     * @return ImageStructure
     */
    public ImageStructure setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * 获取图片像素宽度的getter方法
     * 
     * @return int 图片像素宽度
     */
    public int getWidthPixels() {
        return widthPixels;
    }

    /**
     * 设置图片像素宽度的setter方法
     * 
     * @param widthPixels
     *            图片像素宽度
     * @return ImageStructure
     */
    public ImageStructure setWidthPixels(int widthPixels) {
        this.widthPixels = widthPixels;
        return this;
    }

    /**
     * 获取图片像素高度的getter方法
     * 
     * @return int 图片像素高度
     */
    public int getHeightPixels() {
        return heightPixels;
    }

    /**
     * 设置图片像素高度的setter方法
     * 
     * @param heightPixels
     *            图片像素高度
     * @return ImageStructure
     */
    public ImageStructure setHeightPixels(int heightPixels) {
        this.heightPixels = heightPixels;
        return this;
    }

    /**
     * 设置标签的getter方法
     * 
     * @return List
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 设置标签的setter方法
     * 
     * @param tags
     *            标签列表
     * @return ImageStructure ImageStructure
     */
    public ImageStructure setTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * 设置标签的setter方法
     * 
     * @param tag
     *            标签
     * @return ImageStructure ImageStructure
     */
    public ImageStructure addTag(Tag tag) {
        tags.add(tag);
        return this;
    }

}
