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

package com.baidu.dueros.samples.tax;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import com.baidu.dueros.bot.BaseBot;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.request.SessionEndedRequest;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.OutputSpeech.SpeechType;
import com.baidu.dueros.data.response.Reprompt;
import com.baidu.dueros.data.response.card.ListCard;
import com.baidu.dueros.data.response.card.StandardCardInfo;
import com.baidu.dueros.data.response.card.TextCard;
import com.baidu.dueros.model.Response;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 查询个税Bot例子，继承{@code BaseBot}类
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class TaxBot extends BaseBot {

    /**
     * 重写BaseBot构造方法
     * 
     * @param request
     *            servlet Request作为参数
     * @throws IOException
     *             抛出异常
     * @throws JsonMappingException
     *             抛出异常
     */
    public TaxBot(HttpServletRequest request) throws IOException, JsonMappingException {
        super(request);
    }

    /**
     * 重写BaseBot构造方法
     * 
     * @param request
     *            Request字符串
     * @throws IOException
     *             抛出异常
     */
    public TaxBot(String request) throws IOException {
        super(request);
    }

    /**
     * 重写onLaunch方法，处理onLaunch对话事件
     * 
     * @param launchRequest
     *            LaunchRequest请求体
     * @see com.baidu.dueros.bot.BaseBot#onLaunch(com.baidu.dueros.data.request.LaunchRequest)
     */
    @Override
    protected Response onLaunch(LaunchRequest launchRequest) {
        // 新建文本卡片
        TextCard textCard = new TextCard("所得税为您服务");
        // 设置链接地址
        textCard.setUrl("www:....");
        // 设置链接内容
        textCard.setAnchorText("setAnchorText");
        // 添加引导话术
        textCard.addCueWord("欢迎进入");

        // 新建返回的语音内容
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "所得税为您服务");

        // 构造返回的Response
        Response response = new Response(outputSpeech, textCard);
        return response;
    }

    /**
     * 重写onInent方法，处理onInent对话事件
     * 
     * @param intentRequest
     *            IntentRequest请求体
     * @see com.baidu.dueros.bot.BaseBot#onInent(com.baidu.dueros.data.request.IntentRequest)
     */
    @Override
    protected Response onInent(IntentRequest intentRequest) {
        System.out.println(123123);
        // 判断NLU解析的意图名称是否匹配 inquiry
        if ("inquiry".equals(intentRequest.getIntentName())) {
            // 判断NLU解析解析后是否存在这个槽位
            if (getSlot("monthlysalary") == null) {
                // 询问月薪槽位monthlysalary
                ask("monthlysalary");
                return askSalary();
            } else if (getSlot("location") == null) {
                // 询问城市槽位location
                ask("location");
                return askLocation();
            } else if (getSlot("compute_type") == null) {
                // 询问查询种类槽位compute_type
                ask("compute_type");
                return askComputeType();
            } else {
                // 具体计算方法
                return compute();
            }
        }

        return null;
    }

    /**
     * 重写onSessionEnded事件，处理onSessionEnded对话事件
     * 
     * @param sessionEndedRequest
     *            SessionEndedRequest请求体
     * @see com.baidu.dueros.bot.BaseBot#onSessionEnded(com.baidu.dueros.data.request.SessionEndedRequest)
     */
    @Override
    protected Response onSessionEnded(SessionEndedRequest sessionEndedRequest) {

        // 构造TextCard
        TextCard textCard = new TextCard("感谢使用所得税服务");
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("欢迎再次使用");

        // 构造OutputSpeech
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎再次使用所得税服务");

        ListCard listCard = new ListCard();
        StandardCardInfo item1 = new StandardCardInfo("title1", "content1");
        StandardCardInfo item2 = new StandardCardInfo("title2", "content2");
        listCard.addStandardCardInfo(item1);
        listCard.addStandardCardInfo(item2);

        // 构造Response
        Response response = new Response(outputSpeech, textCard);

        return response;
    }

    /**
     * 询问城市信息
     * 
     * @return Response 返回Response
     */
    private Response askLocation() {

        TextCard textCard = new TextCard("您所在的城市是哪里呢?");
        textCard.setUrl("www:......");
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("您所在的城市是哪里呢?");

        setSessionAttribute("key_1", "value_1");
        setSessionAttribute("key_2", "value_2");

        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "您所在的城市是哪里呢?");

        Reprompt reprompt = new Reprompt(outputSpeech);

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

    /**
     * 询问月薪
     * 
     * @return Response 返回Response
     */
    private Response askSalary() {

        TextCard textCard = new TextCard("您的税前工资是多少呢?");
        textCard.setUrl("www:......");
        textCard.setAnchorText("链接文本");
        textCard.addCueWord("您的税前工资是多少呢?");

        // 设置会话信息
        setSessionAttribute("key_1", "value_1");
        setSessionAttribute("key_2", "value_2");

        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "您的税前工资是多少呢?");

        // 构造reprompt
        Reprompt reprompt = new Reprompt(outputSpeech);

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

    /**
     * 询问个税种类
     * 
     * @return Response 返回Response
     */
    private Response askComputeType() {
        TextCard textCard = new TextCard("请选择您要查询的种类");
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("请选择您要查询的种类");

        setSessionAttribute("key_1", "value_1");
        setSessionAttribute("key_2", "value_2");

        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "请选择您要查询的种类");

        Reprompt reprompt = new Reprompt(outputSpeech);

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

    protected Response onDefaultEvent() {
        TextCard textCard = new TextCard("请选择您要查询的种类");
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("请选择您要查询的种类");

        setSessionAttribute("key_1", "value_1");
        setSessionAttribute("key_2", "value_2");

        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "请选择您要查询的种类");

        Reprompt reprompt = new Reprompt(outputSpeech);

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

    /**
     * 计算个税
     * 
     * @return Response
     */
    private Response compute() {
        // 获取多轮槽位值：月薪值、城市信息、查询种类
        String monthlysalary = getSlot("monthlysalary");
        String location = getSlot("location");
        String type = getSlot("compute_type");
        String ret = "月薪" + monthlysalary + "城市" + location + "个税种类" + type;

        TextCard textCard = new TextCard(ret);
        textCard.setAnchorText("setAnchorText");
        textCard.addCueWord("查询成功");

        setSessionAttribute("key_1", "value_1");
        setSessionAttribute("key_2", "value_2");

        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, ret);

        Reprompt reprompt = new Reprompt(outputSpeech);

        // 主动结束会话
        this.endDialog();

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }
}
