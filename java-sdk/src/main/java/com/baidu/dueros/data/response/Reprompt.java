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

/**
 * 在需要用户输入时，如果用户没有输入或用户输入内容系统不理解，则播报reprompt内容
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class Reprompt {

    /** 表示本次返回结果中需要播报的语音信息 */
    private OutputSpeech outputSpeech;

    /**
     * 默认构造方法
     */
    public Reprompt() {

    }

    /**
     * 构造方法
     * 
     * @param outputSpeech
     *            语音内容
     */
    public Reprompt(final OutputSpeech outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    /**
     * 设置outputSpeech的setter方法
     * 
     * @param outputSpeech
     *            需要返回的语音内容
     */
    public void setOutputSpeech(final OutputSpeech outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    /**
     * 获取outputSpeech的getter方法
     * 
     * @return outputSpeech 获取需要返回的语音内容
     */
    public OutputSpeech getOutputSpeech() {
        return outputSpeech;
    }
}
