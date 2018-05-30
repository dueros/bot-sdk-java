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

package com.baidu.dueros.data.response;

import java.util.ArrayList;
import java.util.List;

import com.baidu.dueros.data.response.card.Card;
import com.baidu.dueros.data.response.directive.Directive;

/**
 * Bot的响应数据
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class ResponseBody {

    // 如果DuerOS仍然会选用当前Bot结果，应该再次下发请求，并将request.determined字段设置为true
    private boolean needDetermine;
    // 表示本次返回的结果是否为兜底结果
    private boolean fallBack;
    // 表示本次返回结果中需要播报的语音信息
    private OutputSpeech outputSpeech;
    // 在需要用户输入时，如果用户没有输入或用户输入内容系统不理解，则播报reprompt内容
    private Reprompt reprompt;
    // Bot输出的Resource内容
    private Resource resource;
    // Bot输出的Card内容，用于在有屏场景下展示
    private Card card;
    // Bot输出的指令，分为： 对DuerOS指令主要是对话指令;其他都是对端的指令
    private List<Directive> directives = new ArrayList<>();
    // 是否需要结束本次会话，DuerOS用于判断是否需要关闭某个打开的Bot，端用于关闭麦克风
    private boolean shouldEndSession;
    // 麦克风是否开启
    private boolean expectSpeech;

    /**
     * 默认构造方法
     */
    public ResponseBody() {

    }

    /**
     * 构造方法
     * 
     * @param outputSpeech
     *            表示本次返回结果中需要播报的语音信息
     * @param reprompt
     *            reprompt内容
     * @param card
     *            Card内容
     */
    public ResponseBody(final OutputSpeech outputSpeech, final Reprompt reprompt, Card card) {
        this.outputSpeech = outputSpeech;
        this.reprompt = reprompt;
        this.card = card;
    }

    /**
     * 获取needDetermine的getter方法
     * 
     * @return needDetermine 是否会发生副作用
     */
    public boolean isNeedDetermine() {
        return needDetermine;
    }

    /**
     * 设置needDetermine的setter方法
     * 
     * @param needDetermine
     *            是否会发生副作用
     */
    public void setNeedDetermine(final boolean needDetermine) {
        this.needDetermine = needDetermine;
    }

    /**
     * 获取fallBack的getter方法
     * 
     * @return fallBack 是否为兜底结果
     */
    public boolean isFallBack() {
        return fallBack;
    }

    /**
     * 设置fallBack的setter方法
     * 
     * @param fallBack
     *            是否为兜底结果
     */
    public void setFallBack(final boolean fallBack) {
        this.fallBack = fallBack;
    }

    /**
     * 获取outputSpeech的getter方法
     * 
     * @return outputSpeech 播报的语音信息
     */
    public OutputSpeech getOutputSpeech() {
        return outputSpeech;
    }

    /**
     * 设置outputSpeech的setter方法
     * 
     * @param outputSpeech
     *            播报的语音信息
     */
    public void setOutputSpeech(final OutputSpeech outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    /**
     * 获取reprompt的getter方法
     * 
     * @return reprompt 获取reprompt内容
     */
    public Reprompt getReprompt() {
        return reprompt;
    }

    /**
     * 设置reprompt的setter方法
     * 
     * @param reprompt
     *            设置reprompt内容
     */
    public void setReprompt(final Reprompt reprompt) {
        this.reprompt = reprompt;
    }

    /**
     * 获取resource的getter方法
     * 
     * @return resource Bot输出的Resource内容
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * 设置resource的setter方法
     * 
     * @param resource
     *            需要返回的Resource内容
     */
    public void setResource(final Resource resource) {
        this.resource = resource;
    }

    /**
     * 获取card的getter方法
     * 
     * @return card 获取card内容
     */
    public Card getCard() {
        return card;
    }

    /**
     * 设置card的setter方法
     * 
     * @param card
     *            Bot输出的Card内容
     */
    public void setCard(final Card card) {
        this.card = card;
    }

    /**
     * 获取directives的getter方法
     * 
     * @return directives Bot输出指令directives
     */
    public List<Directive> getDirectives() {
        return directives;
    }

    /**
     * 设置directives的setter方法
     * 
     * @param directives
     *            需要设置的Bot输出指令
     */
    public void setDirectives(final List<Directive> directives) {
        this.directives = directives;
    }

    /**
     * 获取shouldEndSession的getter方法
     * 
     * @return shouldEndSession 是否需要结束本次会话
     */
    public boolean isShouldEndSession() {
        return shouldEndSession;
    }

    /**
     * 设置shouldEndSession的setter方法
     * 
     * @param shouldEndSession
     *            是否需要结束本次会话
     */
    public void setShouldEndSession(final boolean shouldEndSession) {
        this.shouldEndSession = shouldEndSession;
    }

    /**
     * 获取麦克风开关状态
     * 
     * @return boolean 麦克风打开状态
     */
    public boolean isExpectSpeech() {
        return expectSpeech;
    }

    /**
     * 通过控制expectSpeech来控制麦克风开关
     * 
     * @param expectSpeech
     *            麦克风是否打开
     */
    public void setExpectSpeech(boolean expectSpeech) {
        this.expectSpeech = expectSpeech;
    }
}
