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
package com.baidu.dueros.samples.directive;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import com.baidu.dueros.bot.BaseBot;
import com.baidu.dueros.data.request.Context;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.events.ElementSelectedEvent;
import com.baidu.dueros.data.request.events.LinkClickedEvent;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.OutputSpeech.SpeechType;
import com.baidu.dueros.data.response.card.StandardCard;
import com.baidu.dueros.data.response.directive.audioplayer.AudioPlayerDirective.PlayBehaviorType;
import com.baidu.dueros.data.response.directive.audioplayer.Play;
import com.baidu.dueros.data.response.directive.audioplayer.PlayerInfo;
import com.baidu.dueros.data.response.directive.audioplayer.Stop;
import com.baidu.dueros.data.response.directive.audioplayer.control.PlayPauseButton;
import com.baidu.dueros.data.response.directive.audioplayer.control.PreviousButton;
import com.baidu.dueros.data.response.directive.display.Hint;
import com.baidu.dueros.data.response.directive.display.RenderTemplate;
import com.baidu.dueros.data.response.directive.display.templates.BaseTemplate;
import com.baidu.dueros.data.response.directive.display.templates.BodyTemplate1;
import com.baidu.dueros.data.response.directive.display.templates.ListItem;
import com.baidu.dueros.data.response.directive.display.templates.ListTemplate2;
import com.baidu.dueros.model.Response;

public class TestDirectiveBot extends BaseBot {

    protected TestDirectiveBot(HttpServletRequest request) throws IOException {
        super(request);
    }

    /*
     * 重写onInent方法，处理onInent对话事件
     * 
     * @see com.baidu.dueros.bot.BaseBot#onInent(com.baidu.dueros.data.request.
     * IntentRequest)
     */
    @Override
    protected Response onInent(IntentRequest intentRequest) {

        // 判断NLU解析的意图名称是否匹配 inquiry
        if ("test_Hint".equals(intentRequest.getIntentName())) {
            ArrayList<String> hints = new ArrayList<>();
            hints.add("提示1");
            hints.add("提示2");
            hints.add("提示3");
            Hint hint = new Hint(hints);

            // 添加返回的指令
            this.addDirective(hint);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "这是hint指令测试");
            Response response = new Response(outputSpeech);
            return response;
        }
        if ("test_RenderTemplate".equals(intentRequest.getIntentName())) {
            ListTemplate2 listTemplate = new ListTemplate2();
            listTemplate.setTitle("title");
            listTemplate.setToken("token");
            // 设置模版列表数组listItems其中一项，即列表的一个元素
            ListItem listItem = new ListItem();
            listItem.setPlainPrimaryText("一级标题");
            // 也可以链式设置信息
            listItem.setPlainSecondaryText("二级标题").setPlainTertiaryText("三级标题")
                    .setImageUrl("https://skillstore.cdn.bcebos.com/icon/100/c709eed1-c07a-be4a-b242-0b0d8b777041.jpg");
            // 把listItem添加到模版listTemplate
            listTemplate.addListItem(listItem);
            // 定义RenderTemplate指令
            RenderTemplate renderTemplate = new RenderTemplate(listTemplate);
            this.addDirective(renderTemplate);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "BodyTemplate2 模板");
            Response response = new Response(outputSpeech);
            return response;

        }
        // 判断NLU解析的意图名称是否匹配 inquiry
        if ("test_Context".equals(intentRequest.getIntentName())) {
            Context context = this.getRequest().getContext();
            // System.out.println("context 中音频播放器状态：");
            // AudioPlayerState audioPlayerState = context.getAudioPlayer();
            // System.out.println(audioPlayerState.getOffsetInMilliSeconds());
            // System.out.println(audioPlayerState.getPlayerActivity());
            // System.out.println(audioPlayerState.getToken());
            //
            // System.out.println("context 中视频播放器状态：");
            // VideoPlayerState videoPlayerState = context.getVideoPlayer();
            // System.out.println(videoPlayerState.getPlayerActivity());
            // System.out.println(videoPlayerState.getError().getType());
            // System.out.println(videoPlayerState.getError().getMessage());
            // System.out.println(videoPlayerState.getOffsetInMilliseconds());
            // System.out.println(videoPlayerState.getToken());

            System.out.println("context 中视屏幕状态信息：");
            // 获取屏幕中卡片信息
            // Screen screen = context.getScreen();
            // Card card = screen.getCard();
            // TextCard textCard = (TextCard) card;
            // System.out.println(textCard.getUrl());
            // System.out.println(textCard.getToken());

            // StandardCard standardCard = (StandardCard) card;
            // System.out.println(standardCard.getToken());
            // System.out.println(standardCard.getTitle());
            // System.out.println(standardCard.getContent());

            // ImageCard imageCard = (ImageCard) card;
            // System.out.println(imageCard.getCueWords());
            // System.out.println(imageCard.getList());
            // System.out.println(imageCard.getToken());

            // 屏幕中的是template时，获取template信息
            BaseTemplate template = context.getScreen().getTemplate();
            BodyTemplate1 bodyTemplate1 = (BodyTemplate1) template;
            System.out.println(bodyTemplate1.getBackgroundImage().getUrl());
            System.out.println(bodyTemplate1.getTitle());
            System.out.println(bodyTemplate1.getToken());
            System.out.println(bodyTemplate1.getTextContent().getPosition());

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "这是获取请求中context的测试");
            Response response = new Response(outputSpeech);
            return response;
        }
        // 判断NLU解析的意图名称是否匹配 inquiry
        if ("test_playerinfo".equals(intentRequest.getIntentName())) {
            // 新建Play指令
            Play play = new Play("http://www.music");
            play.setPlayBehavior(PlayBehaviorType.ENQUEUE);
            // 音频播放器的主界面
            PlayerInfo playerInfo = new PlayerInfo();
            // 创建按钮
            PlayPauseButton playpause = new PlayPauseButton();
            PreviousButton previous = new PreviousButton();

            // 设置PlayerInfo的按钮
            playerInfo.addButton(playpause);
            playerInfo.addButton(previous);

            playerInfo.setTitle("周杰伦");
            playerInfo.setTitleSubtext1("七里香");
            // 也可以链式set信息
            playerInfo.setLyric("www.lyric...").setTitleSubtext2("周文山");
            // 设置Play指令的PlayerInfo
            play.setPlayerInfo(playerInfo);
            // 添加返回的指令
            this.addDirective(play);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "这是测试音频播放器play指令中增加playerinfo的信息");
            Response response = new Response(outputSpeech);
            return response;
        }
        // 判断NLU解析的意图名称是否匹配 inquiry
        if ("test_audiostop".equals(intentRequest.getIntentName())) {
            // 新建stop指令
            Stop stop = new Stop();
            this.addDirective(stop);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "这是测试音频播放器play指令中增加playerinfo的信息");
            Response response = new Response(outputSpeech);
            return response;
        }
        if ("test_needDetermine".equals(intentRequest.getIntentName())) {
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "测试");
            Response response = new Response(outputSpeech);
            this.declareEffect();
            return response;
        }
        return null;
    }

    /*
     * 重写onElementSelectedEvent方法，处理Display.ElementSelected 事件
     * 
     * @see
     * com.baidu.dueros.bot.BaseBot#onElementSelectedEvent(com.baidu.dueros.
     * data. request.events.ElementSelectedEvent)
     */
    @Override
    protected Response onElementSelectedEvent(ElementSelectedEvent elementSelectedEvent) {
        StandardCard card = new StandardCard();
        card.setTitle("测试列表模板点击事件");
        card.setImage("https://skillstore.cdn.bcebos.com/icon/100/c709eed1-c07a-be4a-b242-0b0d8b777041.jpg");
        card.setContent("该例子中，点击后返回的列表项保持被点击项的token");
        card.setToken(elementSelectedEvent.getToken());
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "测试Display.ElementSelected 事件");
        Response response = new Response(outputSpeech, card);
        return response;
    }

    /*
     * 重写onLinkClickedEvent方法，处理Screen.LinkClicked事件
     * 
     * @see
     * com.baidu.dueros.bot.BaseBot#onLinkClickedEvent(com.baidu.dueros.data.
     * request .events.LinkClickedEvent)
     */
    @Override
    protected Response onLinkClickedEvent(LinkClickedEvent linkClickedEvent) {
        StandardCard card = new StandardCard();
        card.setTitle("测试listcard点击事件");
        card.setImage("https://skillstore.cdn.bcebos.com/icon/100/c709eed1-c07a-be4a-b242-0b0d8b777041.jpg");
        card.setContent("该例子中，点击后返回的列表项保持被点击项的token");
        card.setToken(linkClickedEvent.getToken());
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "测试Screen.LinkClicked事件");
        Response response = new Response(outputSpeech, card);
        return response;
    }

}
