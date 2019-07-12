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

package com.baidu.dueros.samples.audioplayer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.baidu.dueros.bot.AudioPlayer;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackNearlyFinishedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStartedEvent;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.OutputSpeech.SpeechType;
import com.baidu.dueros.data.response.Reprompt;
import com.baidu.dueros.data.response.card.TextCard;
import com.baidu.dueros.data.response.directive.AudioPlayerDirective.PlayBehaviorType;
import com.baidu.dueros.data.response.directive.audioplayer.RenderAudioList;
import com.baidu.dueros.data.response.directive.audioplayer.RenderAudioListAudioItem;
import com.baidu.dueros.data.response.directive.Play;
import com.baidu.dueros.model.Response;

/**
 * 处理端上报事件例子，继承{@code AudioPlayer}类
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月6日
 */
public class AudioPlayerBot extends AudioPlayer {

    /**
     * 重写构造方法
     * 
     * @param request
     *            HttpServletRequest作为参数类型
     * @throws IOException
     *             抛出异常
     */
    public AudioPlayerBot(HttpServletRequest request) throws IOException {
        super(request);
    }

    /**
     * 重写onLaunch方法，处理LaunchRequest事件
     * 
     * @param launchRequest
     *            LaunchRequest请求体
     * @see com.baidu.dueros.bot.BaseBot#onLaunch(com.baidu.dueros.data.request.LaunchRequest)
     */
    @Override
    protected Response onLaunch(LaunchRequest launchRequest) {

        // 构造TextCard
        TextCard textCard = new TextCard();
        textCard.setContent("处理端上报事件");
        textCard.setUrl("www:....");
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("端上报事件");

        // 构造OutputSpeech
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "处理端上报事件");

        // 构造Reprompt
        Reprompt reprompt = new Reprompt(outputSpeech);

        // 构造Response
        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

    @Override
    protected Response onInent(IntentRequest intentRequest) {
        if ("play".equals(intentRequest.getIntentName())) {
            Play play = new Play("https://.mp3");
            this.addDirective(play);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "开始播放");
            Response response = new Response(outputSpeech);
            return response;
        } else if ("play_list".equals(intentRequest.getIntentName())) {
            RenderAudioListAudioItem renderAudioListAudioItem1 = new RenderAudioListAudioItem();
            renderAudioListAudioItem1
                    .setImage(new com.baidu.dueros.data.response.directive.audioplayer.Image("https://.jpg"));
            renderAudioListAudioItem1.setTitle("测试");
            renderAudioListAudioItem1.setTitleSubtext1("测试");
            renderAudioListAudioItem1.setTitleSubtext2("测试");
            renderAudioListAudioItem1.setToken("123");

            RenderAudioListAudioItem renderAudioListAudioItem2 = new RenderAudioListAudioItem();
            renderAudioListAudioItem2
                    .setImage(new com.baidu.dueros.data.response.directive.audioplayer.Image("https://.jpg"));
            renderAudioListAudioItem2.setTitle("测试");
            renderAudioListAudioItem2.setTitleSubtext1("测试");
            renderAudioListAudioItem2.setTitleSubtext2("测试");
            renderAudioListAudioItem2.setToken("123");

            RenderAudioList renderAudioList = new RenderAudioList();
            renderAudioList.addAudioItem(renderAudioListAudioItem1);
            renderAudioList.addAudioItem(renderAudioListAudioItem2);

            this.addDirective(renderAudioList);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "播放列表");
            Response response = new Response(outputSpeech);
            return response;

        }
        return null;
    }

    /**
     * 重写onPlaybackNearlyFinishedEvent方法，处理onPlaybackNearlyFinishedEvent端上报事件
     * 
     * @param playbackNearlyFinishedEvent
     *            PlaybackNearlyFinishedEvent请求体
     * @see com.baidu.dueros.bot.AudioPlayer#onPlaybackNearlyFinishedEvent(com.baidu.dueros.data.request.audioplayer.event.PlaybackNearlyFinishedEvent)
     */
    @Override
    protected Response onPlaybackNearlyFinishedEvent(PlaybackNearlyFinishedEvent playbackNearlyFinishedEvent) {

        TextCard textCard = new TextCard();
        textCard.setContent("处理即将播放完成事件");
        textCard.setUrl("www:...");
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("即将完成");

        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "处理即将播放完成事件");

        // 新建Play指令
        Play play = new Play(PlayBehaviorType.ENQUEUE, "url", 1000);
        // 添加返回的指令
        this.addDirective(play);

        Reprompt reprompt = new Reprompt(outputSpeech);

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

    /**
     * 重写onPlaybackStartedEvent方法，处理PlaybackStartedEvent事件
     * 
     * @param playbackStartedEvent
     *            PlaybackStartedEvent事件
     * 
     * @see com.baidu.dueros.bot.AudioPlayer#onPlaybackStartedEvent(com.baidu.dueros.data.request.audioplayer.event.PlaybackStartedEvent)
     */
    @Override
    protected Response onPlaybackStartedEvent(PlaybackStartedEvent playbackStartedEvent) {

        TextCard textCard = new TextCard();
        textCard.setContent("处理开始播放完成事件");
        textCard.setUrl("www:...");
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("开始播放");

        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "处理开始播放完成事件");

        Play play = new Play(PlayBehaviorType.ENQUEUE, "url", 1000);

        this.addDirective(play);

        Reprompt reprompt = new Reprompt(outputSpeech);

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

}
