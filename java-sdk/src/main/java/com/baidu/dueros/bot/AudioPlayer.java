/** 
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
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStartedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStoppedEvent;
import com.baidu.dueros.model.Request;
import com.baidu.dueros.model.Response;

/**
 * {@code AudioPlayer}继承自{@link Base}类，用于处理端上报的audioplayer事件
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
public class AudioPlayer extends Base {

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
     * @param playbackNearlyFinishedEvent
     *            PlaybackStartedEvent事件
     * @return Response 返回的Response
     */
    protected Response onPlaybackStartedEvent(final PlaybackStartedEvent playbackNearlyFinishedEvent) {
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

}
