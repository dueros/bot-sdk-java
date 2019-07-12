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

package com.baidu.dueros.data.response.directive.videoplayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 渲染视频列表状态的指令
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RenderVideoListVideoItem {
    // 视频项目的标题，比如新闻的标题
    private String title;
    // 视频的播放时间，单位为ms
    private long mediaLengthInMilliseconds;
    // 视频项目的子标题1，比如新闻的副标题
    private String titleSubtext1;
    // 视频项目的子标题2，比如新闻的作者和时间等
    private String titleSubtext2;
    // 视频项目的唯一标识token
    private String token;
    // 视频缩略图
    private Image image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getMediaLengthInMilliseconds() {
        return mediaLengthInMilliseconds;
    }

    public void setMediaLengthInMilliseconds(long mediaLengthInMilliseconds) {
        this.mediaLengthInMilliseconds = mediaLengthInMilliseconds;
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
