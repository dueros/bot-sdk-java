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

import java.util.UUID;

/**
 * 多媒体流信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class Stream {

    // 链接地址
    private String url = "";
    // 播放的音频流的格式,默认
    private STREAM_FORMAT streamFormat = STREAM_FORMAT.MP3;
    // 播放进度
    private int offsetInMilliSeconds = 0;
    // 正在播放中的audio item的token
    private String token = "";
    // 定时上报ProgressReportIntervalElapsed事件的间隔时间
    private int progressReportIntervalMs = 0;

    /**
     * 默认构造方法
     */
    public Stream() {
        token = genToken();
    }

    /**
     * 构造方法
     * 
     * @param url
     *            链接地址
     */
    public Stream(final String url) {
        this();
        this.url = url;
    }

    /**
     * 构造方法
     * 
     * @param url
     *            链接地址
     * @param offsetInMilliSeconds
     *            播放进度
     */
    public Stream(final String url, final int offsetInMilliSeconds) {
        this(url);
        this.offsetInMilliSeconds = offsetInMilliSeconds;
    }

    /**
     * 构造方法
     * 
     * @param url
     *            链接地址
     * @param offsetInMilliSeconds
     *            播放进度
     * @param progressReportIntervalMs
     *            定时上报事件的时间间隔
     */
    public Stream(String url, int offsetInMilliSeconds, int progressReportIntervalMs) {
        this(url, offsetInMilliSeconds);
        this.progressReportIntervalMs = progressReportIntervalMs;
    }

    /**
     * 获取链接地址的getter方法
     * 
     * @return String 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址的setter方法
     * 
     * @param url
     *            链接地址
     * @return Stream
     */
    public Stream setUrl(final String url) {
        this.url = url;
        return this;
    }

    /**
     * 获取当前播放进度的getter方法
     * 
     * @return int 当前播放进度
     */
    public int getOffsetInMilliSeconds() {
        return offsetInMilliSeconds;
    }

    /**
     * 设置播放进度的setter方法
     * 
     * @param offsetInMilliSeconds
     *            播放进度
     * @return Stream
     */
    public Stream setOffsetInMilliSeconds(final int offsetInMilliSeconds) {
        this.offsetInMilliSeconds = offsetInMilliSeconds;
        return this;
    }

    /**
     * 获取音频流格式的getter方法
     * 
     * @return STREAM_FORMAT 音频流格式
     */
    public STREAM_FORMAT getStreamFormat() {
        return streamFormat;
    }

    /**
     * 设置音频流格式的setter方法
     * 
     * @param streamFormat
     *            音频流格式
     * @return Stream
     */
    public Stream setStreamFormat(STREAM_FORMAT streamFormat) {
        this.streamFormat = streamFormat;
        return this;
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
     * @return Stream
     */
    public Stream setToken(final String token) {
        this.token = token;
        return this;
    }

    /**
     * 获取定时上报ProgressReportIntervalElapsed事件的间隔时间的getter方法
     * 
     * @return int 定时上报ProgressReportIntervalElapsed事件的间隔时间
     */
    public int getProgressReportIntervalMs() {
        return progressReportIntervalMs;
    }

    /**
     * 设置定时上报ProgressReportIntervalElapsed事件的间隔时间的setter方法
     * 
     * @param progressReportIntervalMs
     *            定时上报ProgressReportIntervalElapsed事件的间隔时间
     * @return Stream
     */
    public Stream setProgressReportIntervalMs(int progressReportIntervalMs) {
        this.progressReportIntervalMs = progressReportIntervalMs;
        return this;
    }

    /**
     * 随机生成一个token
     * 
     * @return String token
     */
    private String genToken() {
        return UUID.randomUUID().toString();
    }

    /**
     * 音频流格式定义
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    private enum STREAM_FORMAT {
        MP3, M3U8, M4A
    }

}
