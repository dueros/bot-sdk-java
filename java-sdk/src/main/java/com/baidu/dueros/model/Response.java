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

package com.baidu.dueros.model;

import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.Reprompt;
import com.baidu.dueros.data.response.Resource;
import com.baidu.dueros.data.response.card.Card;

/**
 * Bot构造的Response
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class Response {

    // 在需要用户输入时，如果用户没有输入或用户输入内容系统不理解，则播报reprompt内容
    private Reprompt reprompt;
    // 表示本次返回结果中需要播报的语音信息
    private OutputSpeech outputSpeech;
    // 卡片
    private Card card;
    // 定义Bot输出Resource的数据结构
    private Resource resource = new Resource();

    /**
     * 默认构造方法
     */
    public Response() {

    }

    /**
     * 构造方法
     * 
     * @param outputSpeech
     *            返回的语音信息
     */
    public Response(final OutputSpeech outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    /**
     * 构造方法
     * 
     * @param outputSpeech
     *            返回的语音信息
     * @param card
     *            卡片
     */
    public Response(final OutputSpeech outputSpeech, final Card card) {
        this.card = card;
        this.outputSpeech = outputSpeech;
    }

    /**
     * 构造方法
     * 
     * @param outputSpeech
     *            返回的语音信息
     * @param card
     *            卡片
     * @param reprompt
     *            reprompt内容
     */
    public Response(final OutputSpeech outputSpeech, final Card card, final Reprompt reprompt) {
        this.card = card;
        this.outputSpeech = outputSpeech;
        this.reprompt = reprompt;
    }

    /**
     * 获取reprompt内容的getter方法
     * 
     * @return Reprompt reprompt内容
     */
    public Reprompt getReprompt() {
        return reprompt;
    }

    /**
     * 设置reprompt内容的setter方法
     * 
     * @param reprompt
     *            reprompt内容
     */
    public void setReprompt(final Reprompt reprompt) {
        this.reprompt = reprompt;
    }

    /**
     * 获取语音内容的getter方法
     * 
     * @return OutputSpeech 返回的语音信息
     */
    public OutputSpeech getOutputSpeech() {
        return outputSpeech;
    }

    /**
     * 设置语音内容的setter方法
     * 
     * @param outputSpeech
     *            返回的语音信息
     */
    public void setOutputSpeech(final OutputSpeech outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    /**
     * 获取卡片的getter方法
     * 
     * @return Card 卡片信息
     */
    public Card getCard() {
        return card;
    }

    /**
     * 设置卡片的setter方法
     * 
     * @param card
     *            卡片信息
     */
    public void setCard(final Card card) {
        this.card = card;
    }

    /**
     * 获取resource的getter方法
     * 
     * @return Resource resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * 设置resource的setter方法
     * 
     * @param resource
     *            resource
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

}
