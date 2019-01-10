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
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 定义图片文本展现模板
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月27日
 */
@JsonTypeName("BodyTemplate6")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyTemplate6 extends BaseTemplate {

    // 展现的图片
    private ImageStructure image;
    // 模板超时时间，默认30秒
    private int duration = 30000;
    // 文本结构，支持纯文本和富文本两种格式
    private TextStructure content;

    /**
     * 构造函数
     */
    public BodyTemplate6() {

    }

    /**
     * 构造函数
     * 
     * @param title
     *            卡片的标题
     * @param url
     *            展现图片的地址
     * @param content
     *            文本结构
     */
    public BodyTemplate6(String title, String url, String content) {
        super(title);
        this.image = new ImageStructure(url);
        this.content = new TextStructure(content);
    }

    /**
     * 设置文本结构的setter方法
     * 
     * @param content
     *            文本结构
     * @return BodyTemplate6
     */
    public BodyTemplate6 setContent(TextStructure content) {
        this.content = content;
        return this;
    }

    /**
     * 设置图片信息的setter方法
     * 
     * @param image
     *            图片信息
     * @return BodyTemplate6
     */
    public BodyTemplate6 setImage(ImageStructure image) {
        this.image = image;
        return this;
    }

    /**
     * 设置模板超时时间的setter方法
     * 
     * @param duration
     *            模板超时时间
     * @return BodyTemplate6
     */
    public BodyTemplate6 setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * 图片信息的getter方法
     * 
     * @return ImageStructure 图片列表信息
     */
    public ImageStructure getImage() {
        return image;
    }

    /**
     * 模板超时时间的getter方法
     * 
     * @return int 模板超时时间
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 文本结构的getter方法
     * 
     * @return TextStructure 文本结构
     */
    public TextStructure getContent() {
        return content;
    }

}
