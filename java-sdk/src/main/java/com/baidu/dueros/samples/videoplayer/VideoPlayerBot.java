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
package com.baidu.dueros.samples.videoplayer;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import com.baidu.dueros.bot.VideoPlayer;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.request.SessionEndedRequest;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackFinishedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackNearlyFinishedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackPausedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackQueueClearedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackResumedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStartedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStoppedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStutterFinishedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStutterStartedEvent;
import com.baidu.dueros.data.request.videoplayer.event.ProgressReportDelayElapsedEvent;
import com.baidu.dueros.data.request.videoplayer.event.ProgressReportIntervalElapsedEvent;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.Reprompt;
import com.baidu.dueros.data.response.OutputSpeech.SpeechType;
import com.baidu.dueros.data.response.card.TextCard;
import com.baidu.dueros.data.response.directive.videoplayer.ClearQueue;
import com.baidu.dueros.data.response.directive.videoplayer.Image;
import com.baidu.dueros.data.response.directive.videoplayer.Play;
import com.baidu.dueros.data.response.directive.videoplayer.Play.PlayBehaviorType;
import com.baidu.dueros.data.response.directive.videoplayer.RenderVideoList;
import com.baidu.dueros.data.response.directive.videoplayer.RenderVideoList.RenderVideoListPlayBehaviorType;
import com.baidu.dueros.data.response.directive.videoplayer.RenderVideoListVideoItem;
import com.baidu.dueros.data.response.directive.videoplayer.Stop;
import com.baidu.dueros.model.Response;

/**
 * 视频播放相关的意图，事件上报的例子 继承{@code VideoPlayer}类
 * 
 * @author hujie08
 * @version 1.0
 * @since v1.1.1
 */
public class VideoPlayerBot extends VideoPlayer {

    /**
     * 重写构造方法
     * 
     * @param request
     *            HttpServletRequest作为参数类型
     * @throws IOException
     *             抛出的异常
     */
    public VideoPlayerBot(HttpServletRequest request) throws IOException {
        super(request);
    }

    /*
     * 重写onLaunch方法，处理launchRequest事件
     * 
     * @param launchRequest aunchRequest请求体
     * 
     * @see com.baidu.dueros.bot.BaseBot#onLaunch(com.baidu.dueros.data.request.
     * LaunchRequest)
     */
    @Override
    protected Response onLaunch(LaunchRequest launchRequest) {
        // 构造TextCard
        TextCard textCard = new TextCard();
        textCard.setContent("欢迎使用视频播放");
        textCard.setUrl("http:....");
        textCard.setAnchorText("setAnchorText");
        // 构造OutputSpeech
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎使用视频播放");
        // 构造Reprompt
        Reprompt reprompt = new Reprompt(outputSpeech);
        // 构造Response
        Response response = new Response(outputSpeech, textCard, reprompt);
        return response;
    }

    /*
     * 重写onInent方法，处理onInent对话事件
     * 
     * @see com.baidu.dueros.bot.BaseBot#onInent(com.baidu.dueros.data.request.
     * IntentRequest)
     */
    @Override
    protected Response onInent(IntentRequest intentRequest) {
        // 判断NLU解析的意图名称是否匹配 video_play_intent
        if ("video_play_intent".equals(intentRequest.getIntentName())) {
            Play play = new Play("http:.....mp4");
            play.setPlayBehavior(PlayBehaviorType.REPLACE_ALL);
            play.setToken("token");
            // 也可以链式set信息
            play.setOffsetInMilliSeconds(1000).setVideoItemId("video_1");
            this.addDirective(play);

            // 同时返回播放列表RenderVideoList
            RenderVideoListVideoItem renderVideoListVideoItem = new RenderVideoListVideoItem();
            renderVideoListVideoItem.setTitle("卖火柴的小女孩");
            renderVideoListVideoItem.setMediaLengthInMilliseconds(1000);
            renderVideoListVideoItem.setTitleSubtext1("卖火柴的小女孩");
            renderVideoListVideoItem.setTitleSubtext2("卖火柴的小女孩");
            renderVideoListVideoItem.setImage(new Image("http:.....png"));
            renderVideoListVideoItem.setToken("123");

            RenderVideoListVideoItem renderVideoListVideoItem1 = new RenderVideoListVideoItem();
            renderVideoListVideoItem1.setTitle("卖火柴的小女孩");
            renderVideoListVideoItem1.setMediaLengthInMilliseconds(1000);
            renderVideoListVideoItem1.setTitleSubtext1("卖火柴的小女孩");
            renderVideoListVideoItem1.setTitleSubtext2("卖火柴的小女孩");
            renderVideoListVideoItem1.setImage(new Image("http:.....png"));
            renderVideoListVideoItem1.setToken("123");

            RenderVideoList renderVideoList = new RenderVideoList();
            renderVideoList.setBehavior(RenderVideoListPlayBehaviorType.REPLACE);
            renderVideoList.setToken("456");
            renderVideoList.setSize(2);
            renderVideoList.setTitle("查看播放列表");
            renderVideoList.addVideoItem(renderVideoListVideoItem);
            renderVideoList.addVideoItem(renderVideoListVideoItem1);

            this.addDirective(renderVideoList);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "开始播放");
            Response response = new Response(outputSpeech);
            return response;
        }
        // 判断NLU解析的意图名称是否匹配 video_stop_intent
        else if ("video_stop_intent".equals(intentRequest.getIntentName())) {
            Stop stop = new Stop();
            this.addDirective(stop);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "即将为您停止播放视频");
            Response response = new Response(outputSpeech);
            return response;
        }
        // 判断NLU解析的意图名称是否匹配 video_stop_intent
        else if ("video_clearqueue_intent".equals(intentRequest.getIntentName())) {
            ClearQueue clear = new ClearQueue("CLEAR_ALL");
            this.addDirective(clear);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "即将为您清除播放队列");
            Response response = new Response(outputSpeech);
            return response;
        } else {
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "视频bot默认意图");
            Response response = new Response(outputSpeech);
            return response;
        }
    }

    /*
     * 重写onPlaybackStutterStartedEvent方法，处理playbackStutterStartedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onPlaybackStutterStartedEvent(com.baidu.
     * dueros.data.request.videoplayer.event.PlaybackStutterStartedEvent)
     */
    @Override
    protected Response onPlaybackStutterStartedEvent(PlaybackStutterStartedEvent playbackStutterStartedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackStartedEvent方法，处理PlaybackStartedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onPlaybackStartedEvent(com.baidu.dueros.
     * data .request.videoplayer.event.PlaybackStartedEvent)
     */
    @Override
    protected Response onPlaybackStartedEvent(PlaybackStartedEvent playbackStartedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackStoppedEvent方法，处理PlaybackStoppedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onPlaybackStoppedEvent(com.baidu.dueros.
     * data .request.videoplayer.event.PlaybackStoppedEvent)
     */
    @Override
    protected Response onPlaybackStoppedEvent(PlaybackStoppedEvent playbackStoppedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackNearlyFinishedEvent方法，处理PlaybackNearlyFinishedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onPlaybackNearlyFinishedEvent(com.baidu.
     * dueros.data.request.videoplayer.event.PlaybackNearlyFinishedEvent)
     */
    @Override
    protected Response onPlaybackNearlyFinishedEvent(PlaybackNearlyFinishedEvent playbackNearlyFinishedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackFinishedEvent方法，处理PlaybackFinishedEvent事件
     * 
     * @see com.baidu.dueros.bot.VideoPlayer#onPlaybackFinishedEvent(com.baidu.
     * dueros. data.request.videoplayer.event.PlaybackFinishedEvent)
     */
    @Override
    protected Response onPlaybackFinishedEvent(PlaybackFinishedEvent playbackFinishedEvent) {
        return getResponse();
    }

    /*
     * 重写onProgressReportIntervalElapsedEvent方法，
     * 处理ProgressReportIntervalElapsedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onProgressReportIntervalElapsedEvent(
     * com. baidu.dueros.data.request.videoplayer.event.
     * ProgressReportIntervalElapsedEvent)
     */
    @Override
    protected Response onProgressReportIntervalElapsedEvent(
            ProgressReportIntervalElapsedEvent progressReportIntervalElapsedEvent) {
        return getResponse();
    }

    /*
     * 重写onProgressReportDelayElapsedEvent方法，处理ProgressReportDelayElapsedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onProgressReportDelayElapsedEvent(com.
     * baidu.
     * dueros.data.request.videoplayer.event.ProgressReportDelayElapsedEvent)
     */
    @Override
    protected Response onProgressReportDelayElapsedEvent(
            ProgressReportDelayElapsedEvent progressReportDelayElapsedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackStutterFinishedEvent方法，处理PlaybackStutterFinishedEvent事件
     * 
     * @see com.baidu.dueros.bot.VideoPlayer#onPlaybackStutterFinishedEvent(com.
     * baidu.
     * dueros.data.request.videoplayer.event.PlaybackStutterFinishedEvent)
     */
    @Override
    protected Response onPlaybackStutterFinishedEvent(PlaybackStutterFinishedEvent playbackStutterFinishedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackPausedEvent方法，处理PlaybackPausedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onPlaybackPausedEvent(com.baidu.dueros.
     * data. request.videoplayer.event.PlaybackPausedEvent)
     */
    @Override
    protected Response onPlaybackPausedEvent(PlaybackPausedEvent playbackPausedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackResumedEvent方法，处理PlaybackResumedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onPlaybackResumedEvent(com.baidu.dueros.
     * data .request.videoplayer.event.PlaybackResumedEvent)
     */
    @Override
    protected Response onPlaybackResumedEvent(PlaybackResumedEvent playbackResumedEvent) {
        return getResponse();
    }

    /*
     * 重写onPlaybackQueueClearedEvent方法，处理PlaybackQueueClearedEvent事件
     * 
     * @see
     * com.baidu.dueros.bot.VideoPlayer#onPlaybackQueueClearedEvent(com.baidu.
     * dueros .data.request.videoplayer.event.PlaybackQueueClearedEvent)
     */
    @Override
    protected Response onPlaybackQueueClearedEvent(PlaybackQueueClearedEvent playbackQueueClearedEvent) {
        return getResponse();
    }

    /*
     * 重写onSessionEnded方法，处理SessionEndedRequest对话事件
     * 
     * @see com.baidu.dueros.bot.BaseBot#onSessionEnded(com.baidu.dueros.data.
     * request. SessionEndedRequest)
     */
    @Override
    protected Response onSessionEnded(SessionEndedRequest sessionEndedRequest) {
        return super.onSessionEnded(sessionEndedRequest);
    }

    /*
     * 重写onDefaultEvent方法，处理没有订阅的事件
     * 
     * @see com.baidu.dueros.bot.BaseBot#onDefaultEvent()
     */
    @Override
    protected Response onDefaultEvent() {
        this.waitAnswer();
        this.setExpectSpeech(false);
        return new Response();
    }

    /**
     * 用于测试视频播放的相关事件，事件都返回一个播放指令
     * 
     * @return Response 响应
     */
    protected Response getResponse() {
        // Stream stream = new
        // Stream("http://dueroscdn.ubestkid.com/blk/m/526_mhcdxnh.mp4", 0);
        // stream.setExpectedPreviousToken("expectedPreviousToken");
        // stream.setProgressReport(400, 500);
        // VideoItem videoItem = new VideoItem("id:12345", stream);
        // Play play = new Play(PlayBehaviorType.ENQUEUE, videoItem);
        // this.addDirective(play);
        // OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText,
        // "即将为您播放视频");

        this.waitAnswer();
        Response response = new Response();
        return response;
    }
}
