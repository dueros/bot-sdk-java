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

package com.baidu.dueros.bot;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.baidu.dueros.data.request.audioplayer.event.PlaybackFinishedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackNearlyFinishedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackPausedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackResumedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStartedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStoppedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStutterFinishedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStutterStartedEvent;
import com.baidu.dueros.data.request.audioplayer.event.ProgressReportDelayElapsedEvent;
import com.baidu.dueros.data.request.audioplayer.event.ProgressReportIntervalElapsedEvent;
import com.baidu.dueros.model.Request;
import com.baidu.dueros.model.Response;

/**
 * {@code AudioPlayer}继承自{@link BaseBot}类，用于处理端上报的audioplayer事件
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.1.1
 * @since v1.1.1
 */
public class AudioPlayer extends BaseBot {

    /**
     * 构造方法，使用反序列化后的Request作为参数
     * 
     * @param request
     *            反序列化后的Request
     * @throws IOException
     *             抛出的异常
     */
    protected AudioPlayer(Request request) throws IOException {
        super(request);
    }

    /**
     * 构造方法，使用HttpServletRequest对象作为参数
     * 
     * @param request
     *            HttpServletRequest对象
     * @throws IOException
     *             抛出的异常
     */
    protected AudioPlayer(HttpServletRequest request) throws IOException {
        super(request);
    }

    /**
     * 构造方法，使用request字符串作为参数
     * 
     * @param request
     *            Request序列化后的字符串
     * @throws IOException
     *             抛出的异常
     */
    protected AudioPlayer(String request) throws IOException {
        super(request);
    }

    /**
     * 处理PlaybackStartedEvent事件
     * 
     * @param playbackStartedEvent
     *            PlaybackStartedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackStartedEvent(final PlaybackStartedEvent playbackStartedEvent) {
        return response;
    }

    /**
     * 处理PlaybackStoppedEvent事件
     * 
     * @param playbackStoppedEvent
     *            PlaybackStoppedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackStoppedEvent(final PlaybackStoppedEvent playbackStoppedEvent) {
        return response;
    }

    /**
     * 处理PlaybackNearlyFinishedEvent事件
     * 
     * @param playbackNearlyFinishedEvent
     *            PlaybackNearlyFinishedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackNearlyFinishedEvent(final PlaybackNearlyFinishedEvent playbackNearlyFinishedEvent) {
        return response;
    }

    /**
     * 处理PlaybackFinishedEvent事件
     * 
     * @param playbackFinishedEvent
     *            PlaybackFinishedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackFinishedEvent(final PlaybackFinishedEvent playbackFinishedEvent) {
        return response;
    }

    /**
     * 处理PlaybackPausedEvent事件
     * 
     * @param playbackPausedEvent
     *            PlaybackPausedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackPausedEvent(final PlaybackPausedEvent playbackPausedEvent) {
        return response;
    }

    /**
     * 处理PlaybackResumedEvent事件
     * 
     * @param playbackResumedEvent
     *            PlaybackResumedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackResumedEvent(final PlaybackResumedEvent playbackResumedEvent) {
        return response;
    }

    /**
     * 处理PlaybackStutterFinishedEvent事件
     * 
     * @param playbackStutterFinishedEvent
     *            PlaybackStutterFinishedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackStutterFinishedEvent(final PlaybackStutterFinishedEvent playbackStutterFinishedEvent) {
        return response;
    }

    /**
     * 处理onPlaybackStutterStartedEvent事件
     * 
     * @param playbackStutterStartedEvent
     *            playbackStutterStartedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackStutterStartedEvent(final PlaybackStutterStartedEvent playbackStutterStartedEvent) {
        return response;
    }

    /**
     * 处理ProgressReportDelayElapsedEvent事件
     * 
     * @param progressReportDelayElapsedEvent
     *            progressReportDelayElapsedEvent事件
     * @return Response 返回的Response
     */
    protected Response onProgressReportDelayElapsedEvent(
            final ProgressReportDelayElapsedEvent progressReportDelayElapsedEvent) {
        return response;
    }

    /**
     * 处理ProgressReportIntervalElapsedEvent事件
     * 
     * @param progressReportIntervalElapsedEvent
     *            ProgressReportIntervalElapsedEvent事件
     * @return Response 返回的Response
     */
    protected Response onProgressReportIntervalElapsedEvent(
            final ProgressReportIntervalElapsedEvent progressReportIntervalElapsedEvent) {
        return response;
    }

}
