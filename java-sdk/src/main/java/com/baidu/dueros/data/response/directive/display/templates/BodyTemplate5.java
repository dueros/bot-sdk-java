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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 定义图片模板
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月27日
 */
@JsonTypeName("BodyTemplate5")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyTemplate5 extends BaseTemplate {
    // 展现的图片列表
    private ArrayList<ImageStructure> images = new ArrayList<>();

    /**
     * 构造函数
     */
    public BodyTemplate5() {
    }

    /**
     * 构造函数
     * 
     * @param title
     *            卡片的标题
     */
    public BodyTemplate5(String title) {
        super(title);
    }

    /**
     * 获取图片列表信息的getter方法
     * 
     * @return ArrayList 图片列表信息
     */
    public ArrayList<ImageStructure> getImages() {
        return images;
    }

    /**
     * 设置图片列表信息的setter方法
     * 
     * @param images
     *            图片列表信息
     * @return BodyTemplate5
     */
    public BodyTemplate5 setImages(ArrayList<ImageStructure> images) {
        this.images = images;
        return this;
    }

    /**
     * 添加图片
     * 
     * @param image
     *            ImageStructure结构的图片
     * @return BodyTemplate5
     */
    public BodyTemplate5 addImage(ImageStructure image) {
        images.add(image);
        return this;
    }

    /**
     * 利用图url添加图片
     * 
     * @param url
     *            图片地址
     * @return BodyTemplate5
     */
    public BodyTemplate5 addImage(String url) {
        images.add(new ImageStructure(url));
        return this;
    }

    /**
     * 设置图片列表信息的setter方法
     * 
     * @param urls
     *            图片url列表信息
     */
    public void setImageUrls(ArrayList<String> urls) {
        for (String url : urls) {
            ImageStructure image = new ImageStructure(url);
            images.add(image);
        }
    }
}
