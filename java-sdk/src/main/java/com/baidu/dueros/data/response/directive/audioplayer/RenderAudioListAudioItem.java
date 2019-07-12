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

package com.baidu.dueros.data.response.directive.audioplayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 渲染音频列表状态的指令
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RenderAudioListAudioItem {
    // 音频项目的标题
    private String title;
    // 音频项目的子标题1
    private String titleSubtext1;
    // 音频项目的子标题2
    private String titleSubtext2;
    // 是否收藏音频
    private boolean isFavorited;
    // 是否为音乐MV资源
    private boolean isMusicVideo;
    // 音频项目的唯一标识token
    private String token;
    private Image image;

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

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean isFavorited) {
        this.isFavorited = isFavorited;
    }

    public boolean isMusicVideo() {
        return isMusicVideo;
    }

    public void setMusicVideo(boolean isMusicVideo) {
        this.isMusicVideo = isMusicVideo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
