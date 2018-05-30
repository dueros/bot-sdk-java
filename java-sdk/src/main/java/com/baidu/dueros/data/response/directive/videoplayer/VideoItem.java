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

/**
 * VideoItem
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月26日
 */
public class VideoItem {
    // video item的id
    private String videoItemId;
    // 视频流信息
    private Stream stream = new Stream();

    /**
     * 默认构造方法
     */
    public VideoItem() {
    }

    /**
     * 构造函数
     * 
     * @param videoItemId
     *            videoitem的id
     * @param stream
     *            视频流信息
     */
    public VideoItem(String videoItemId, Stream stream) {
        this.videoItemId = videoItemId;
        this.stream = stream;
    }

    /**
     * 构造函数
     * 
     * @param videoItemId
     *            videoitem的id
     * @param url
     *            视频流地址
     * @param offsetInMilliSeconds
     *            视频播放起始点
     */
    public VideoItem(final String videoItemId, final String url, final int offsetInMilliSeconds) {
        Stream stream = new Stream(url, offsetInMilliSeconds);
        this.stream = stream;
        this.videoItemId = videoItemId;
    }

    /**
     * 构造函数
     * 
     * @param videoItemId
     *            videoitem的id
     * @param url
     *            视频流地址
     * @param offsetInMilliSeconds
     *            视频播放起始点
     * @param expiryTime
     *            ISO8601格式，stream过期时间
     */
    public VideoItem(final String videoItemId, final String url, final int offsetInMilliSeconds,
            final String expiryTime) {
        Stream stream = new Stream(url, offsetInMilliSeconds, expiryTime);
        this.stream = stream;
        this.videoItemId = videoItemId;
    }

    /**
     * 获取videoItemId的getter方法
     * 
     * @return String videoItemId
     */
    public String getVideoItemId() {
        return videoItemId;
    }

    /**
     * 设置videoItemId的setter方法
     * 
     * @param videoItemId
     *            videoItemId
     * @return VideoItem
     */
    public VideoItem setVideoItemId(String videoItemId) {
        this.videoItemId = videoItemId;
        return this;
    }

    /**
     * 获取视频流信息的getter方法
     * 
     * @return Stream 视频流信息
     */
    public Stream getStream() {
        return stream;
    }

    /**
     * 设置视频流信息的setter方法
     * 
     * @param stream
     *            视频流信息
     * @return VideoItem
     */
    public VideoItem setStream(Stream stream) {
        this.stream = stream;
        return this;
    }

}
