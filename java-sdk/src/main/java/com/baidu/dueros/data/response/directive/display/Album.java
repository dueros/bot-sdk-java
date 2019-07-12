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

package com.baidu.dueros.data.response.directive.display;

import com.baidu.dueros.data.response.directive.display.templates.ImageStructure;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Album
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {
    // 编号
    private long numeration;
    // 专辑ID
    private String audioAlbumId;
    // 专辑的标题
    private String title;
    // 专辑的子标题1
    private String titleSubtext1;
    // 专辑的子标题2
    private String titleSubtext2;
    // url不需要渲染出来，点击专辑项目后上报LinkClicked事件给服务端，事件参数里带上此url
    private String url;
    // 专辑的图片
    private ImageStructure image;
    // url不需要渲染出来，需要直接播放此专辑，上报LinkClicked事件给服务端，事件参数里带上此url
    private String albumPlayUrl;

    public long getNumeration() {
        return numeration;
    }

    public void setNumeration(long numeration) {
        this.numeration = numeration;
    }

    public String getAudioAlbumId() {
        return audioAlbumId;
    }

    public void setAudioAlbumId(String audioAlbumId) {
        this.audioAlbumId = audioAlbumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleSubtext1() {
        return titleSubtext1;
    }

    public void setTitleSubtext1(String titleSubtext1) {
        this.titleSubtext1 = titleSubtext1;
    }

    public String getTitleSubtext2() {
        return titleSubtext2;
    }

    public void setTitleSubtext2(String titleSubtext2) {
        this.titleSubtext2 = titleSubtext2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageStructure getImage() {
        return image;
    }

    public void setImage(ImageStructure image) {
        this.image = image;
    }

    public String getAlbumPlayUrl() {
        return albumPlayUrl;
    }

    public void setAlbumPlayUrl(String albumPlayUrl) {
        this.albumPlayUrl = albumPlayUrl;
    }

}
