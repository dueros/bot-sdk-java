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
 * 图片Card列表信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageCardInfo {

    // 图片的地址
    private String src;
    // 缩略图地址
    private String thumb;

    /**
     * 默认构造方法
     */
    public ImageCardInfo() {

    }

    /**
     * 构造方法
     * 
     * @param src
     *            图片的地址
     * @param thumb
     *            缩略图地址
     */
    public ImageCardInfo(final String src, final String thumb) {
        this.src = src;
        this.thumb = thumb;
    }

    /**
     * 获取src的getter方法
     * 
     * @return String 返回图片地址
     */
    public String getSrc() {
        return src;
    }

    /**
     * 设置图片地址的setter方法
     * 
     * @param src
     *            图片地址
     */
    public void setSrc(final String src) {
        this.src = src;
    }

    /**
     * 获取thumb的getter方法
     * 
     * @return String 返回缩略图地址
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * 设置缩略图地址的setter的方法
     * 
     * @param thumb
     *            缩略图地址
     */
    public void setThumb(final String thumb) {
        this.thumb = thumb;
    }

}
