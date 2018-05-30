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

import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 视频的播放指令
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonTypeName("VideoPlayer.Play")
public class Play extends Directive {
    // 控制端播放的behavior
    private PlayBehaviorType playBehavior;
    // 多媒体信息
    private VideoItem videoItem = new VideoItem();

    /**
     * 默认构造函数
     */
    public Play() {
    }

    /**
     * 构造函数
     * 
     * @param url
     *            视频地址
     */
    public Play(String url) {
        Stream stream = videoItem.getStream();
        stream.setUrl(url);
        videoItem.setStream(stream);
    }

    /**
     * 构造函数
     * 
     * @param playBehavior
     *            控制端播放的behavior
     * @param videoItem
     *            多媒体信息
     */
    public Play(final PlayBehaviorType playBehavior, final VideoItem videoItem) {
        this.playBehavior = playBehavior;
        this.videoItem = videoItem;
    }

    /**
     * 构造函数
     * 
     * @param playBehavior
     *            控制端播放的behavior
     * @param videoItemId
     *            多媒体信息id
     * @param url
     *            视频流地址
     * @param offsetInMilliSeconds
     *            视频播放起始点
     */
    public Play(final PlayBehaviorType playBehavior, final String videoItemId, final String url,
            final int offsetInMilliSeconds) {
        this.playBehavior = playBehavior;
        this.videoItem = new VideoItem(videoItemId, url, offsetInMilliSeconds);
    }

    /**
     * 构造函数
     * 
     * @param playBehavior
     *            控制端播放的behavior
     * @param videoItemId
     *            多媒体信息id
     * @param url
     *            视频流地址
     * @param offsetInMilliSeconds
     *            视频播放起始点
     * @param expiryTime
     *            ISO8601格式，表示stream过期时间
     */
    public Play(final PlayBehaviorType playBehavior, final String videoItemId, final String url,
            final int offsetInMilliSeconds, final String expiryTime) {
        this.playBehavior = playBehavior;
        this.videoItem = new VideoItem(videoItemId, url, offsetInMilliSeconds, expiryTime);
    }

    /**
     * 获取PlayBehavior的getter方法
     * 
     * @return PlayBehaviorType 控制端播放的behavior
     */
    public PlayBehaviorType getPlayBehavior() {
        return playBehavior;
    }

    /**
     * 设置PlayBehavior的setter方法
     * 
     * @param playBehavior
     *            控制端播放的behavior
     * @return Play
     */
    public Play setPlayBehavior(PlayBehaviorType playBehavior) {
        this.playBehavior = playBehavior;
        return this;
    }

    /**
     * 获取多媒体信息的getter方法
     * 
     * @return VideoItem 多媒体信息
     */
    public VideoItem getVideoItem() {
        return videoItem;
    }

    /**
     * 设置多媒体信息的setter方法
     * 
     * @param videoItem
     *            多媒体信息
     * @return Play
     */
    public Play setVideoItem(VideoItem videoItem) {
        this.videoItem = videoItem;
        return this;
    }

    /**
     * 设置视频流地址
     * 
     * @param url
     *            视频流地址
     * @return Play
     */
    public Play setUrl(String url) {
        Stream stream = videoItem.getStream();
        stream.setUrl(url);
        videoItem.setStream(stream);
        return this;
    }

    /**
     * 设置视频播放起始点
     * 
     * @param offsetInMilliSeconds
     *            视频播放起始点
     * @return Play
     */
    public Play setOffsetInMilliSeconds(int offsetInMilliSeconds) {
        Stream stream = videoItem.getStream();
        stream.setOffsetInMilliSeconds(offsetInMilliSeconds);
        videoItem.setStream(stream);
        return this;
    }

    /**
     * 设置stream过期时间
     * 
     * @param expiryTime
     *            stream过期时间(ISO8601格式)
     * @return Play
     */
    public Play setExpiryTime(String expiryTime) {
        Stream stream = videoItem.getStream();
        stream.setExpiryTime(expiryTime);
        videoItem.setStream(stream);
        return this;
    }

    /**
     * 设置token
     * 
     * @param token
     *            token
     * @return Play
     */
    public Play setToken(String token) {
        Stream stream = videoItem.getStream();
        stream.setToken(token);
        videoItem.setStream(stream);
        return this;
    }

    /**
     * 设置expectedPreviousToken
     * 
     * @param expectedPreviousToken
     *            expectedPreviousToken
     * @return Play
     */
    public Play setExpectedPreviousToken(String expectedPreviousToken) {
        Stream stream = videoItem.getStream();
        stream.setExpectedPreviousToken(expectedPreviousToken);
        videoItem.setStream(stream);
        return this;
    }

    /**
     * 设置事件ProgressReportDelayElapsed上报的时间间隔
     * 
     * @param progressReportDelayInMilliseconds
     *            上报的时间间隔
     * @return Play
     */
    public Play setProgressReportDelayInMilliseconds(int progressReportDelayInMilliseconds) {
        Stream stream = videoItem.getStream();
        stream.setProgressReportDelayInMilliseconds(progressReportDelayInMilliseconds);
        videoItem.setStream(stream);
        return this;
    }

    /**
     * 设置事件ProgressReportIntervalElapsed上报的时间间隔
     * 
     * @param progressReportIntervalInMilliseconds
     *            上报的时间间隔
     * @return Play 当前play指令
     */
    public Play setProgressReportIntervalInMilliseconds(int progressReportIntervalInMilliseconds) {
        Stream stream = videoItem.getStream();
        stream.setProgressReportIntervalInMilliseconds(progressReportIntervalInMilliseconds);
        videoItem.setStream(stream);
        return this;
    }

    /**
     * 设置videoItemId
     * 
     * @param videoItemId
     *            videoItemId
     * @return Play 当前play指令
     */
    public Play setVideoItemId(String videoItemId) {
        videoItem.setVideoItemId(videoItemId);
        return this;
    }

    /**
     * 控制端播放的behavior
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年4月27日
     */
    public enum PlayBehaviorType {
        // 立即停止当前播放（如有必要，发送PlaybackStopped事件）并清除播放队列，立即播放指令中的video item
        REPLACE_ALL,
        // 将video item添加到当前队列的尾部
        ENQUEUE,
        // 替换播放队列中的所有video item，但不影响当前正在播放的video item
        REPLACE_ENQUEUED,
    }
}
