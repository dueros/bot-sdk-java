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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 标准卡片信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardCardInfo {

    // 卡片标题
    private String title;
    // 卡片内容
    private String content;
    // 图片
    private String image;
    // url存在时有效，展示链接显示的文本。如果不设置，展现“查看更多”
    private String url;

    /**
     * 默认构造方法
     */
    public StandardCardInfo() {

    }

    /**
     * 构造方法
     * 
     * @param title
     *            卡片标题
     * @param content
     *            卡片内容
     */
    public StandardCardInfo(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * 获取title的getter方法
     * 
     * @return String 返回卡片标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置title的setter方法
     * 
     * @param title
     *            卡片标题
     */
    public void setTitle(final String title) {
        this.title = title;
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
     * 设置content的setter方法
     * 
     * @param content
     *            卡片内容
     */
    public void setContent(final String content) {
        this.content = content;
    }

    /**
     * 获取image的getter方法
     * 
     * @return String 返回图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置image的setter方法
     * 
     * @param image
     *            图片
     */
    public void setImage(final String image) {
        this.image = image;
    }

    /**
     * 获取url的getter方法
     * 
     * @return String 返回url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置image的setter方法
     * 
     * @param url
     *            url
     */
    public void setUrl(final String url) {
        this.url = url;
    }

}
