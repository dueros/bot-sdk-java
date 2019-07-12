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

package com.baidu.dueros.samples.dpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baidu.dueros.bot.BaseBot;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.OutputSpeech.SpeechType;
import com.baidu.dueros.data.response.directive.dpl.Document;
import com.baidu.dueros.data.response.directive.dpl.ExecuteCommands;
import com.baidu.dueros.data.response.directive.dpl.RenderDocument;
import com.baidu.dueros.data.response.directive.dpl.commands.AnimationCommand;
import com.baidu.dueros.data.response.directive.dpl.commands.AnimationCommand.EasingType;
import com.baidu.dueros.data.response.directive.dpl.commands.AnimationCommand.RepeatMode;
import com.baidu.dueros.data.response.directive.dpl.commands.ControlMediaCommand;
import com.baidu.dueros.data.response.directive.dpl.commands.ControlMediaCommand.ControlMediaCommandType;
import com.baidu.dueros.data.response.directive.dpl.commands.ScrollToIndexCommand.AlignType;
import com.baidu.dueros.data.response.directive.dpl.commands.ScrollCommand;
import com.baidu.dueros.data.response.directive.dpl.commands.ScrollToIndexCommand;
import com.baidu.dueros.data.response.directive.dpl.commands.SetPageCommand;
import com.baidu.dueros.data.response.directive.dpl.commands.SetPageCommand.Position;
import com.baidu.dueros.data.response.directive.dpl.commands.SetStateCommand;
import com.baidu.dueros.data.response.directive.dpl.commands.UpdateComponentCommand;
import com.baidu.dueros.data.response.directive.dpl.event.UserEvent;
import com.baidu.dueros.model.Response;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 返回DPL相关的例子，继承{@code BaseBot}类
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class DplBot extends BaseBot {

    private static List<Video> videoList = new ArrayList<>();

    static {
        videoList.add(new Video("https://dbp-dict.bj.bcebos.com/video2.mp4", "video_list_1", "葡萄酒", "人生就像一杯酒"));
        videoList.add(new Video("https://dbp-dict.bj.bcebos.com/video4.mp4", "video_list_2", "初夏", "最美人间四月天"));
        videoList.add(new Video("https://dbp-dict.bj.bcebos.com/video3.mp4", "video_list_3", "海", "面向大海"));
        videoList.add(new Video("https://dbp-dict.bj.bcebos.com/video4.mp4", "video_list_4", "心动的感觉", "你知道我对你不仅仅是喜欢"));
        videoList.add(new Video("https://dbp-dict.bj.bcebos.com/video5.mp4", "video_list_5", "冷月",
                "曾经有一个美丽的女孩追求过我，但是我没有接受，现在后悔了"));
        videoList.add(new Video("https://dbp-dict.bj.bcebos.com/video6.mp4", "video_list_6", "给大家讲一个笑话吧", "你就是一个笑话"));
        videoList.add(new Video("https://dbp-dict.bj.bcebos.com/video7.mp4", "video_list_7", "加班，加班", "很可以"));
    }

    protected DplBot(HttpServletRequest request) throws IOException, JsonMappingException {
        super(request);
    }

    protected Response onLaunch(LaunchRequest launchRequest) {

        try {
            // 从json文件中初始化Document
            Document document = Document.getDocumentFromPath("../launch.json");

            // RenderDocument指令
            RenderDocument renderDocument = new RenderDocument();
            renderDocument.setDocument(document);

            this.addDirective(renderDocument);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎来到测试DPL");
            Response response = new Response(outputSpeech);
            return response;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    protected Response onInent(IntentRequest intentRequest) {
        if ("dpl_demo1".equals(intentRequest.getIntentName())) {
            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../demo1.json");

                // RenderDocument指令
                RenderDocument renderDocument = new RenderDocument();
                renderDocument.setDocument(document);

                this.addDirective(renderDocument);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "简单图片");
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("dpl_demo2".equals(intentRequest.getIntentName())) {
            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../demo2.json");

                // RenderDocument指令
                RenderDocument renderDocument = new RenderDocument();
                renderDocument.setDocument(document);

                this.addDirective(renderDocument);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "长文本");
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("dpl_demo3".equals(intentRequest.getIntentName())) {
            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../demo3.json");

                // RenderDocument指令
                RenderDocument renderDocument = new RenderDocument();
                renderDocument.setDocument(document);

                this.addDirective(renderDocument);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "短文本");
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("dpl_demo4".equals(intentRequest.getIntentName())) {
            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../demo4.json");

                // RenderDocument指令
                RenderDocument renderDocument = new RenderDocument();
                renderDocument.setDocument(document);

                this.addDirective(renderDocument);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "右图详情");
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("dpl_demo5".equals(intentRequest.getIntentName())) {
            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../demo5.json");

                // RenderDocument指令
                RenderDocument renderDocument = new RenderDocument();
                renderDocument.setDocument(document);

                this.addDirective(renderDocument);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "左图详情");
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("dpl_demo6".equals(intentRequest.getIntentName())) {

            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../demo6.json");

                // RenderDocument指令
                RenderDocument renderDocument = new RenderDocument();
                renderDocument.setDocument(document);

                this.addDirective(renderDocument);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "横向列表");
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("dpl_demo7".equals(intentRequest.getIntentName())) {

            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../demo7.json");

                // RenderDocument指令
                RenderDocument renderDocument = new RenderDocument();
                renderDocument.setDocument(document);

                this.addDirective(renderDocument);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "视频相册");
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("pull_scrollview".equals(intentRequest.getIntentName())) {
            ExecuteCommands executeCommands = new ExecuteCommands();
            ScrollCommand scrollCommand = new ScrollCommand();
            scrollCommand.setDistance("200dp").setComponentId("demo_pull_scrollview_compid");
            executeCommands.addCommand(scrollCommand);
            this.addDirective(executeCommands);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "滑动窗口滑动");
            Response response = new Response(outputSpeech);
            return response;
        } else if ("video_play".equals(intentRequest.getIntentName())) {
            try {
                // 从json文件中初始化Document
                Document document = Document.getDocumentFromPath("../update.json");

                String index = this.getSlot("index");
                int i = Integer.parseInt(index);
                i = (i - 1) > 0 ? (i - 1) : 0;

                Video video = videoList.get(i);

                Object mainTemplate = document.getMainTemplate();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode tree = objectMapper.readTree(objectMapper.writeValueAsString(mainTemplate));

                List<JsonNode> jsonNodes = tree.findValues("items").get(0).findValues("items");

                // 修改返回
                ((ObjectNode) (jsonNodes.get(0).get(0))).put("src", video.getSrc());
                ((ObjectNode) (jsonNodes.get(0).get(1).findValue("items").get(0))).put("text", video.getName());

                document.setMainTemplate(objectMapper.readValue(objectMapper.writeValueAsString(tree), Object.class));

                ExecuteCommands executeCommands = new ExecuteCommands();
                UpdateComponentCommand updateComponentCommand = new UpdateComponentCommand();
                updateComponentCommand.setComponentId("replaceComponentId");
                updateComponentCommand.setDocument(document);
                executeCommands.addCommand(updateComponentCommand);
                this.addDirective(executeCommands);

                OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "正在播放" + videoList.get(i).getName());
                Response response = new Response(outputSpeech);
                return response;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if ("move_list".equals(intentRequest.getIntentName())) {
            // 向上滑动列表
            String direction = this.getSlot("direction") != null ? this.getSlot("direction") : "下";
            String distance = "100dp";

            if (direction == "后" || direction == "下") {
                distance = "-100dp";
            }

            ExecuteCommands executeCommands = new ExecuteCommands();
            ScrollCommand scrollCommand = new ScrollCommand();
            scrollCommand.setComponentId("demo_list_compid");
            scrollCommand.setDistance(distance);
            executeCommands.addCommand(scrollCommand);

            this.addDirective(executeCommands);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "向" + direction + "滑动列表");
            Response response = new Response(outputSpeech);
            return response;
        } else if ("go_list_top".equals(intentRequest.getIntentName())) {
            // 回到列表顶部
            ExecuteCommands executeCommands = new ExecuteCommands();
            ScrollToIndexCommand scrollToIndexCommand = new ScrollToIndexCommand();
            scrollToIndexCommand.setAlign(AlignType.FIRST).setIndex(1).setComponentId("demo_list_compid");
            executeCommands.addCommand(scrollToIndexCommand);
            this.addDirective(executeCommands);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "回到列表顶部");
            Response response = new Response(outputSpeech);
            return response;
        } else if ("pause_video".equals(intentRequest.getIntentName())) {
            // 视频暂停
            ExecuteCommands executeCommands = new ExecuteCommands();

            ControlMediaCommand controlMediaCommand = new ControlMediaCommand();
            controlMediaCommand.setComponentId("demo_video_compid");
            controlMediaCommand.setCommand(ControlMediaCommandType.PAUSE);
            executeCommands.addCommand(controlMediaCommand);
            this.addDirective(executeCommands);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "视频暂停播放");
            Response response = new Response(outputSpeech);
            return response;
        } else if ("video_continue".equals(intentRequest.getIntentName())) {
            // 视频继续播放
            ExecuteCommands executeCommands = new ExecuteCommands();
            ControlMediaCommand controlMediaCommand = new ControlMediaCommand();
            controlMediaCommand.setCommand(ControlMediaCommandType.PLAY).setComponentId("demo_video_compid");
            executeCommands.addCommand(controlMediaCommand);
            this.addDirective(executeCommands);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "视频继续播放");
            Response response = new Response(outputSpeech);
            return response;
        } else if ("favourite_video".equals(intentRequest.getIntentName())) {
            // 收藏
            ExecuteCommands executeCommands = new ExecuteCommands();
            SetStateCommand setStateCommand = new SetStateCommand();
            setStateCommand.setState("src").setValue("https://dbp-dict.bj.bcebos.com/dpl%2F%E5%BF%83.png")
                    .setComponentId("demo_image_compid");

            AnimationCommand animationCommand = new AnimationCommand();
            animationCommand.setFrom("40dp").setTo("10dp").setEasing(EasingType.EASEIN).setAttribute("height")
                    .setDuration(500).setRepeatCount("9").setRepeatMode(RepeatMode.REVERSE)
                    .setComponentId("demo_image_compid");
            executeCommands.addCommand(setStateCommand).addCommand(animationCommand);
            this.addDirective(executeCommands);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "视频收藏");
            Response response = new Response(outputSpeech);
            return response;

        } else if ("move_page".equals(intentRequest.getIntentName())) {
            // 翻页
            String direction = this.getSlot("direction") != null ? this.getSlot("dire" + "ction") : "下";
            int value = 1;
            if (direction == "左") {
                value = -1;
            }

            ExecuteCommands executeCommands = new ExecuteCommands();

            SetPageCommand setPageCommand = new SetPageCommand();
            setPageCommand.setPosition(Position.RELATIVE).setValue(value).setComponentId("demo_move_page_compid");
            executeCommands.addCommand(setPageCommand);
            this.addDirective(executeCommands);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "向" + direction + "翻页");
            Response response = new Response(outputSpeech);
            return response;
        }
        return null;
    }

    protected Response onUserEvent(final UserEvent userEvent) {
        String type = userEvent.getPayload().getSource().getType();
        ExecuteCommands executeCommands = new ExecuteCommands();

        if ("Pager".equals(type)) {
            ControlMediaCommand controlMediaCommand = new ControlMediaCommand();
            controlMediaCommand.setComponentId("demo_video_compid");
            if ("0".equals(userEvent.getPayload().getSource().getValue())
                    || "2".equals(userEvent.getPayload().getSource().getValue())) {
                controlMediaCommand.setCommand(ControlMediaCommandType.PAUSE);
            }
            if ("1".equals(userEvent.getPayload().getSource().getValue())) {
                controlMediaCommand.setCommand(ControlMediaCommandType.PLAY);
            }
            executeCommands.addCommand(controlMediaCommand);
        }
        this.addDirective(executeCommands);

        Response response = new Response();
        return response;
    }
}
