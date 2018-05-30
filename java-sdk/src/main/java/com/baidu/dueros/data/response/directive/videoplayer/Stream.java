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

import java.util.UUID;

/**
 * 视频流信息
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月27日
 */
public class Stream {
    // 视频流地址
    private String url;
    // 视频播放起始点
    private int offsetInMilliSeconds;
    // ISO8601格式，表示stream过期时间
    private String expiryTime;
    // 事件上报间隔时间类
    private ProgressReport progressReport = new ProgressReport();
    // 唯一标识此次directive中播放的视频流
    private String token;
    // 如果此字段存在，则应当匹配前一个video item中的token，如果不匹配则端不会执行本Play指令
    private String expectedPreviousToken;

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
     *            视频流地址
     */
    public Stream(final String url) {
        this();
        this.url = url;
    }

    /**
     * 构造函数
     * 
     * @param url
     *            视频流地址
     * @param offsetInMilliSeconds
     *            视频播放起点
     */
    public Stream(final String url, final int offsetInMilliSeconds) {
        this(url);
        this.offsetInMilliSeconds = offsetInMilliSeconds;
    }

    /**
     * 构造函数
     * 
     * @param url
     *            视频url地址
     * @param offsetInMilliSeconds
     *            视频播放起点
     * @param expiryTime
     *            stream过期时间
     */
    public Stream(final String url, final int offsetInMilliSeconds, final String expiryTime) {
        this(url, offsetInMilliSeconds);
        this.expiryTime = expiryTime;
    }

    /**
     * 获取视频流地址的getter方法
     * 
     * @return String 视频流地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置视频流地址的setter方法
     * 
     * @param url
     *            视频流地址
     * @return Stream
     */
    public Stream setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * 获取视频播放起始点的getter方法
     * 
     * @return int 视频播放起始点
     */
    public int getOffsetInMilliSeconds() {
        return offsetInMilliSeconds;
    }

    /**
     * 设置视频播放起始点的setter方法
     * 
     * @param offsetInMilliSeconds
     *            视频播放起始点
     * @return Stream
     */
    public Stream setOffsetInMilliSeconds(int offsetInMilliSeconds) {
        this.offsetInMilliSeconds = offsetInMilliSeconds;
        return this;
    }

    /**
     * 获取stream过期时间的getter方法
     * 
     * @return String stream过期时间(ISO8601格式)
     */
    public String getExpiryTime() {
        return expiryTime;
    }

    /**
     * 设置stream过期时间的setter方法
     * 
     * @param expiryTime
     *            stream过期时间(ISO8601格式)
     * @return Stream
     */
    public Stream setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
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
    public Stream setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * 获取expectedPreviousToken的getter方法
     * 
     * @return String expectedPreviousToken
     */
    public String getExpectedPreviousToken() {
        return expectedPreviousToken;
    }

    /**
     * 设置expectedPreviousToken的setter方法
     * 
     * @param expectedPreviousToken
     *            expectedPreviousToken
     * @return Stream
     */
    public Stream setExpectedPreviousToken(String expectedPreviousToken) {
        this.expectedPreviousToken = expectedPreviousToken;
        return this;
    }

    /**
     * 获取事件上报事件间隔类的getter方法
     * 
     * @return ProgressReport 事件上报事件间隔类
     */
    public ProgressReport getProgressReport() {
        return progressReport;
    }

    /**
     * 设置事件ProgressReportDelayElapsed上报的时间间隔
     * 
     * @param progressReportDelayInMilliseconds
     *            上报的时间间隔
     * @return Stream
     */
    public Stream setProgressReportDelayInMilliseconds(int progressReportDelayInMilliseconds) {
        progressReport.setProgressReportDelayInMilliseconds(progressReportDelayInMilliseconds);
        return this;
    }

    /**
     * 设置事件ProgressReportIntervalElapsed上报的时间间隔
     * 
     * @param progressReportIntervalInMilliseconds
     *            上报的时间间隔
     * @return Stream
     */
    public Stream setProgressReportIntervalInMilliseconds(int progressReportIntervalInMilliseconds) {
        progressReport.setProgressReportIntervalInMilliseconds(progressReportIntervalInMilliseconds);
        return this;
    }

    /**
     * 设置事件上报事件间隔的setter方法
     * 
     * @param progressReportDelayInMilliseconds
     *            上报ProgressReportDelayElapsed事件的时间间隔
     * @param progressReportIntervalInMilliseconds
     *            上报ProgressReportIntervalElapsed事件的时间间隔
     */
    public void setProgressReport(final int progressReportDelayInMilliseconds,
            final int progressReportIntervalInMilliseconds) {
        progressReport = new ProgressReport(progressReportDelayInMilliseconds, progressReportIntervalInMilliseconds);
    }

    /**
     * 设置事件上报事件间隔类的setter方法
     * 
     * @param progressReport
     *            事件上报事件间隔类
     * @return Stream
     */
    public Stream setProgressReport(ProgressReport progressReport) {
        this.progressReport = progressReport;
        return this;
    }

    /**
     * 该类包含一些上报事件间隔时间的信息
     * 
     * @author hujie08
     */
    public class ProgressReport {
        // 如果此字段存在，则设备端在播放该video
        // item时，播放到所指定时间之后会上报ProgressReportDelayElapsed事件；不存在则不上报此事件
        private int progressReportDelayInMilliseconds = 0;
        // 如果此字段存在，则设备端在播放该video
        // item时，每隔指定时间上报ProgressReportIntervalElapsed事件，不存在则不上报此事件
        private int progressReportIntervalInMilliseconds = 0;

        /**
         * 默认构造方法
         */
        public ProgressReport() {
        }

        /**
         * 构造函数
         * 
         * @param progressReportDelayInMilliseconds
         *            事件ProgressReportDelayElapsed上报的时间间隔
         * @param progressReportIntervalInMilliseconds
         *            事件ProgressReportIntervalElapsed上报的时间间隔
         */
        public ProgressReport(int progressReportDelayInMilliseconds, int progressReportIntervalInMilliseconds) {
            this.progressReportDelayInMilliseconds = progressReportDelayInMilliseconds;
            this.progressReportIntervalInMilliseconds = progressReportIntervalInMilliseconds;
        }

        /**
         * 获取事件ProgressReportDelayElapsed上报的时间间隔的getter方法
         * 
         * @return int 事件ProgressReportDelayElapsed上报的时间间隔(ms)
         */
        public int getProgressReportDelayInMilliseconds() {
            return progressReportDelayInMilliseconds;
        }

        /**
         * 设置事件ProgressReportDelayElapsed上报的时间间隔的setter方法
         * 
         * @param progressReportDelayInMilliseconds
         *            上报的时间间隔
         * @return ProgressReport
         */
        public ProgressReport setProgressReportDelayInMilliseconds(int progressReportDelayInMilliseconds) {
            this.progressReportDelayInMilliseconds = progressReportDelayInMilliseconds;
            return this;
        }

        /**
         * 获取事件ProgressReportIntervalElapsed上报的时间间隔的getter方法
         * 
         * @return int 事件ProgressReportIntervalElapsed上报的时间间隔(ms)
         */
        public int getProgressReportIntervalInMilliseconds() {
            return progressReportIntervalInMilliseconds;
        }

        /**
         * 设置事件ProgressReportIntervalElapsed上报的时间间隔的setter方法
         * 
         * @param progressReportIntervalInMilliseconds
         *            上报的时间间隔
         * @return ProgressReport
         */
        public ProgressReport setProgressReportIntervalInMilliseconds(int progressReportIntervalInMilliseconds) {
            this.progressReportIntervalInMilliseconds = progressReportIntervalInMilliseconds;
            return this;
        }
    }

    /**
     * 随机生成一个token
     * 
     * @return String token
     */
    private String genToken() {
        return UUID.randomUUID().toString();
    }

}
