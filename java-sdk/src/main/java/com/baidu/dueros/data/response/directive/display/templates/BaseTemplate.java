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
/**
 * 
 */
package com.baidu.dueros.data.response.directive.display.templates;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 抽象模板基类
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月26日
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = BodyTemplate1.class), @Type(value = BodyTemplate2.class),
        @Type(value = BodyTemplate3.class), @Type(value = BodyTemplate4.class), @Type(value = BodyTemplate5.class),
        @Type(value = BodyTemplate6.class), @Type(value = ListTemplate1.class), @Type(value = ListTemplate2.class),
        @Type(value = ListTemplate3.class), @Type(value = ListTemplate4.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseTemplate {
    // 唯一标识这个模板
    private String token;
    // 背景图片
    private ImageStructure backgroundImage = new ImageStructure();
    // 卡片的标题
    private String title;

    /**
     * 默认构造函数
     */
    public BaseTemplate() {
        this.token = genToken();
    }

    /**
     * 构造函数
     * 
     * @param title
     *            卡片的标题
     */
    public BaseTemplate(String title) {
        this.token = genToken();
        this.title = title;
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
     * @return BaseTemplate
     */
    public BaseTemplate setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * 设置图片的setter方法
     * 
     * @return ImageStructure 图片结构体
     */
    public ImageStructure getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * 设置背景图片信息的setter方法
     * 
     * @param backgroundImage
     *            图片信息
     * @return BaseTemplate
     */
    public BaseTemplate setBackgroundImage(ImageStructure backgroundImage) {
        this.backgroundImage = backgroundImage;
        return this;
    }

    /**
     * 设置背景图片信息的setter方法
     * 
     * @param url
     *            背景图片地址，要求为https的地址
     * @return BaseTemplate
     */
    public BaseTemplate setBackgroundImageUrl(String url) {
        this.backgroundImage = new ImageStructure(url);
        return this;
    }

    /**
     * 获取标题的getter方法
     * 
     * @return String 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题的setter方法
     * 
     * @param title
     *            标题
     * @return BaseTemplate
     */
    public BaseTemplate setTitle(String title) {
        this.title = title;
        return this;
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
