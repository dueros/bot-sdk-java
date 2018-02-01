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
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.baidu.dueros.certificate.Certificate;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.request.Query;
import com.baidu.dueros.data.request.RequestBody;
import com.baidu.dueros.data.request.SessionEndedRequest;
import com.baidu.dueros.data.request.audioplayer.event.AudioPlayerEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackFinishedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackNearlyFinishedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStartedEvent;
import com.baidu.dueros.data.request.audioplayer.event.PlaybackStoppedEvent;
import com.baidu.dueros.data.response.Context;
import com.baidu.dueros.data.response.ResponseBody;
import com.baidu.dueros.data.response.Session;
import com.baidu.dueros.data.response.directive.ConfirmIntent;
import com.baidu.dueros.data.response.directive.ConfirmSlot;
import com.baidu.dueros.data.response.directive.Delegate;
import com.baidu.dueros.data.response.directive.Directive;
import com.baidu.dueros.data.response.directive.ElicitSlot;
import com.baidu.dueros.model.Request;
import com.baidu.dueros.model.Response;
import com.baidu.dueros.model.ResponseEncapsulation;
import com.baidu.dueros.nlu.Intent;
import com.baidu.dueros.nlu.Slot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.baidu.apm.monitor.BotMonitor;

/**
 * {@code BaseBot}是所有Bot的基类，使用Bot-SDK开发的Bot需要继承这个类
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
public class BaseBot {

    private static final Logger logger = Logger.getLogger(BaseBot.class.getName());

    // Base子类构造的Response
    protected Response response;
    // Bot收到的Request请求
    private final Request request;
    // 会话信息
    private Session session = new Session();
    // 是否需要结束本次会话
    private boolean shouldEndSession = false;
    // 返回的指令
    private List<Directive> directives = new ArrayList<Directive>();
    // 通过NLU解析出来的Intent
    private Intent intent;

    // 是否打开参数验证，默认为false
    private boolean enableCertificate = false;
    // 认证签名
    private Certificate certificate;
    // 缓存认证相关信息
    private static ConcurrentHashMap<String, PublicKey> cache = new ConcurrentHashMap<>();
    // 数据统计信息
    public BotMonitor botMonitor;

    /**
     * Base构造方法
     * 
     * @param request
     *            为封装后的RequestEncapsulation
     * @throws IOException
     *             抛出的异常
     */
    protected BaseBot(Request request) throws IOException {
        this.request = request;
    }

    /**
     * Base构造方法
     * 
     * @param request
     *            字符串
     * @throws IOException
     *             抛出的异常
     */
    protected BaseBot(String request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.request = mapper.readValue(request, Request.class);
        this.botMonitor = new BotMonitor(request);
    }

    /**
     * BaseBot构造方法
     * 
     * @param certificate
     *            认证对象
     * @throws  IOException
     */
    protected BaseBot(Certificate certificate) throws IOException {
        this(certificate.getMessage());
    }

    /**
     * Base构造方法
     * 
     * @param request
     *            为Servlet的request
     * @throws IOException
     *             抛出异常
     */
    protected BaseBot(HttpServletRequest request) throws IOException {
        certificate = new Certificate(request);
        String message = certificate.getMessage();
        ObjectMapper mapper = new ObjectMapper();
        this.request = mapper.readValue(message, Request.class);
        this.botMonitor = new BotMonitor(message);
    }

    /**
     * 获取Request信息
     * 
     * @return Request Request信息
     */
    public Request getRequest() {
        return this.request;
    }

    /**
     * 获取session属性信息中某个字段的值
     * 
     * @param key
     *            属性信息的key
     * @return String 属性信息的值value
     */
    protected String getSessionAttribute(final String key) {
        return request.getSession().getAttributes().get(key);
    }

    /**
     * 设置session属性信息中某个字段的值
     * 
     * @param key
     *            属性信息的key
     * @param value
     *            属性信息的值value
     */
    protected void setSessionAttribute(final String key, final String value) {
        session.getAttributes().put(key, value);
    }

    /**
     * 清空session的属性信息
     */
    protected void clearSessionAttribute() {
        session.getAttributes().clear();
    }

    /**
     * 设置slot信息
     * 
     * @param slot
     *            需要设置的Slot
     */
    protected void setSlot(final Slot slot) {
        intent = getIntent();
        intent.setSlot(slot);
    }

    /**
     * 根据NLU返回的结果，获取槽位名slot对应的槽位值，默认获取第一个意图的槽位
     * 
     * @param slot
     *            槽位名称
     * @return String 槽位值
     */
    protected String getSlot(final String slot) {
        // 默认获取第一个意图
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        Map<String, Slot> slots = intent.getSlots();
        if (slots == null) {
            return null;
        }
        if (slots.get(slot) == null) {
            return null;
        }
        return slots.get(slot).getValue();
    }

    /**
     * 获取第index个意图的某个槽位值
     * 
     * @param slot
     *            槽位名称
     * @param index
     *            第几个意图
     * @return String 槽位值
     */
    protected String getSlot(final String slot, int index) {
        Intent intent = getIntent(index);
        if (intent == null) {
            return null;
        }
        Map<String, Slot> slots = intent.getSlots();
        if (slots == null) {
            return null;
        }
        if (slots.get(slot) == null) {
            return null;
        }
        return slots.get(slot).getValue();
    }

    /**
     * 询问某些槽位，如果询问一些槽位，表明多轮进行中
     * 
     * @param slot
     *            槽位名称
     */
    protected void ask(final String slot) {
        ElicitSlot elicitSlot = new ElicitSlot();
        elicitSlot.setSlotToElicit(slot);
        elicitSlot.setUpdatedIntent(getIntent());
        addDirective(elicitSlot);
    }

    /**
     * 设置delegate某个槽位或确认意图
     */
    protected void setDelegate() {
        Delegate delegate = new Delegate();
        delegate.setUpdatedIntent(getIntent());
        addDirective(delegate);
    }

    /**
     * 设置对一个槽位的确认
     * 
     * @param slot
     *            槽位名称
     */
    protected void setConfirmSlot(final String slot) {
        ConfirmSlot confirmSlot = new ConfirmSlot();
        confirmSlot.setSlotToConfirm(slot);
        confirmSlot.setUpdatedIntent(getIntent());
        addDirective(confirmSlot);
    }

    /**
     * 设置对一个意图的确认
     */
    protected void setConfirmIntent() {
        ConfirmIntent confirmIntent = new ConfirmIntent();
        confirmIntent.setUpdatedIntent(getIntent());
        addDirective(confirmIntent);
    }

    /**
     * 获取当前的一个intent名称，默认获取第一个Intent
     * 
     * @return Intent
     */
    protected Intent getIntent() {
        return getIntent(0);
    }

    /**
     * 获取第index个Intent
     * 
     * @param index
     *            Intent坐标
     * @return Intent
     */
    protected Intent getIntent(int index) {
        RequestBody requestBody = request.getRequest();
        IntentRequest intentRequest = null;
        Intent intent = null;
        if (requestBody instanceof IntentRequest) {
            intentRequest = (IntentRequest) requestBody;
            // 获取第index个Intent
            intent = intentRequest.getIntents().get(index);
        }
        return intent;
    }

    /**
     * 获取accessToken
     * 
     * @return String accessToken
     */
    protected String getAccessToken() {
        return request.getContext().getSystem().getUser().getAccessToken();
    }

    /**
     * 告诉DuerOS，在多轮对话中，等待用户的回答
     */
    protected void waitAnswer() {
        shouldEndSession = false;
    }

    /**
     * 告诉DuerOS，需要结束会话
     */
    protected void endDialog() {
        shouldEndSession = true;
    }

    /**
     * 获取原始Query信息
     * 
     * @return String 原始Query信息
     */
    protected String getQuery() {
        // 只有IntentRequest才有Query信息
        if (isIntentRequest() == true) {
            IntentRequest intentRequest = (IntentRequest) request.getRequest();
            Query query = intentRequest.getQuery();
            return query.getOriginal();
        }
        return null;
    }

    /**
     * 判断是否为IntentRequest
     * 
     * @return boolean 判断是否为IntentRequest
     */
    private boolean isIntentRequest() {
        RequestBody requestBody = request.getRequest();
        return (requestBody instanceof IntentRequest);
    }

    /**
     * 生成一个token
     * 
     * @return String 生成一个Token
     */
    protected String genToken() {
        return UUID.randomUUID().toString();
    }

    /**
     * 向Response中添加一个Directive指令
     * 
     * @param directive
     *            需要用户构造的指令，为Directive的子类
     */
    protected void addDirective(Directive directive) {
        directives.add(directive);
    }

    /**
     * 开启验证请求参数
     * 
     */
    public void enableVerify() {
        enableCertificate = true;
    }

    /**
     * 关闭验证请求参数
     * 
     */
    public void disableVerify() {
        enableCertificate = false;
    }

    /**
     * 设置Certificate对象
     * 
     * @param certificate
     *            认证签名
     */
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    /**
     * 签名验证
     * 
     * @return boolean 签名验证是否正确
     */
    private boolean verify() {
        // 首先检查是否打开请求参数验证
        if (enableCertificate == false) {
            return true;
        }
        String signaturecerturl = certificate.getSignaturecerturl();
        if (signaturecerturl == null) {
            return false;
        }
        if (!cache.containsKey(signaturecerturl)) {
            PublicKey publicKey = Certificate.getPublicKeyFromUrl(signaturecerturl);
            if (publicKey == null) {
                return false;
            }
            cache.put(signaturecerturl, publicKey);
        }
        return Certificate.verify(cache, certificate);
    }

    /**
     * 若请求不合法，则返回该Response
     * 
     * @return String 不合法返回的JSON数据
     */
    private String illegalRequest() {
        return "{\"status\":1,\"msg\":\"invalid request\"}";
    }

    /**
     * 在Bot没有返回的情况下，默认返回
     * 
     * @return String 默认返回
     */
    public String defaultResponse() {
        return "{\"status\":0,\"msg\":\"\"}";
    }

    /**
     * 根据Bot返回的Response转换为ResponseEncapsulation，然后序列化
     * 
     * @param response
     *            Bot返回的Response
     * @throws JsonProcessingException
     *             抛出异常
     * @return String 封装后的ResponseEncapsulation的序列化内容
     */
    protected String build(Response response) throws JsonProcessingException {
        if (response == null) {
            return defaultResponse();
        }
        Context context = new Context();
        if (isIntentRequest() == true) {
            context.setIntent(getIntent());
        }

        ResponseBody responseBody = new ResponseBody();
        responseBody.setDirectives(directives);
        if (response.getCard() != null) {
            responseBody.setCard(response.getCard());
        }
        if (response.getOutputSpeech() != null) {
            responseBody.setOutputSpeech(response.getOutputSpeech());
        }
        if (response.getReprompt() != null) {
            responseBody.setReprompt(response.getReprompt());
        }
        responseBody.setShouldEndSession(shouldEndSession);
        if (response.getResource() != null) {
            responseBody.setResource(response.getResource());
        }

        ResponseEncapsulation responseEncapsulation = new ResponseEncapsulation(context, session, responseBody);
        return new ObjectMapper().writeValueAsString(responseEncapsulation);
    }

    /**
     * 事件调度
     * 
     * @throws Exception
     *             抛出异常
     */
    private void dispatch() {
        RequestBody requestBody = request.getRequest();
        if (requestBody instanceof LaunchRequest) {
            LaunchRequest launchRequest = (LaunchRequest) requestBody;
            response = onLaunch(launchRequest);
        } else if (requestBody instanceof IntentRequest) {
            IntentRequest intentRequest = (IntentRequest) requestBody;
            response = onInent(intentRequest);
        } else if (requestBody instanceof SessionEndedRequest) {
            SessionEndedRequest sessionEndedRequest = (SessionEndedRequest) requestBody;
            response = onSessionEnded(sessionEndedRequest);
        } else if (requestBody instanceof AudioPlayerEvent) {
            AudioPlayer audioPlayer = (AudioPlayer) this;
            if (requestBody instanceof PlaybackNearlyFinishedEvent) {
                PlaybackNearlyFinishedEvent playbackNearlyFinishedEvent = (PlaybackNearlyFinishedEvent) requestBody;
                response = audioPlayer.onPlaybackNearlyFinishedEvent(playbackNearlyFinishedEvent);
            } else if (requestBody instanceof PlaybackStartedEvent) {
                PlaybackStartedEvent playbackStartedEvent = (PlaybackStartedEvent) requestBody;
                response = audioPlayer.onPlaybackStartedEvent(playbackStartedEvent);
            } else if (requestBody instanceof PlaybackStoppedEvent) {
                PlaybackStoppedEvent playbackStoppedEvent = (PlaybackStoppedEvent) requestBody;
                response = audioPlayer.onPlaybackStoppedEvent(playbackStoppedEvent);
            } else if (requestBody instanceof PlaybackFinishedEvent) {
                PlaybackFinishedEvent playbackFinishedEvent = (PlaybackFinishedEvent) requestBody;
                response = audioPlayer.onPlaybackFinishedEvent(playbackFinishedEvent);
            }
        }
    }

    /**
     * 处理IntentRequest请求
     * 
     * @param intentRequest
     *            收到的IntentRequest请求
     * @return Response 返回Response
     */
    protected Response onInent(final IntentRequest intentRequest) {
        return response;
    }

    /**
     * 处理LaunchRequest请求
     * 
     * @param launchRequest
     *            收到的LaunchRequest请求
     * @return Response 返回Response
     */
    protected Response onLaunch(final LaunchRequest launchRequest) {
        return response;
    }

    /**
     * 处理SessionEndedRequest请求
     * 
     * @param sessionEndedRequest
     *            收到的SessionEndedRequest请求
     * @return Response 返回Response
     */
    protected Response onSessionEnded(final SessionEndedRequest sessionEndedRequest) {
        return response;
    }

    /**
     * Bot子类调用
     * 
     * @return String 返回的response信息
     * @throws Exception
     *             抛出的异常
     */
    public String run() throws Exception {
        // 请求参数不合法
        if (verify() == false) {
            logger.warn("invalid request!");
            return this.illegalRequest();
        }

        this.dispatch();
        String responseStr = this.build(response);
        this.botMonitor.setResponse(responseStr);
        this.botMonitor.uploadData();
        return responseStr;
    }
}
