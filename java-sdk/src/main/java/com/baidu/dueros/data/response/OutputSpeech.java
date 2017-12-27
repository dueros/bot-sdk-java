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
 * 表示本次返回结果中需要播报的语音信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class OutputSpeech {

    // 输出类型
    private SpeechType type;
    // 文本内容
    private String text = "";
    // SSML内容
    private String ssml = "";

    /**
     * 默认构造方法
     */
    public OutputSpeech() {

    }

    /**
     * 构造方法
     * 
     * @param type
     *            输出类型
     * @param content
     *            输出内容
     */
    public OutputSpeech(final SpeechType type, final String content) {
        this.type = type;
        if (type == SpeechType.PlainText) {
            this.text = content;
        } else if (type == SpeechType.SSML) {
            this.ssml = content;
        }
    }

    /**
     * 获取type的getter方法
     * 
     * @return type 获取输出类型
     */
    public SpeechType getType() {
        return type;
    }

    /**
     * 获取text的getter方法
     * 
     * @return text 获取输出文本内容
     */
    public String getText() {
        return text;
    }

    /**
     * 获取ssml的getter方法
     * 
     * @return ssml 获取SSML内容
     */
    public String getSsml() {
        return ssml;
    }

    /**
     * 设置输出类型的setter方法
     * 
     * @param type
     *            设置输出类型
     */
    public void setType(final SpeechType type) {
        this.type = type;
    }

    /**
     * 设置输出类型的setter方法
     * 
     * @param text
     *            设置输出文本内容
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * 设置输出类型的setter方法
     * 
     * @param ssml
     *            设置输出SSML内容
     */
    public void setSsml(final String ssml) {
        this.ssml = ssml;
    }

    /**
     * 语音内容输出类型
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public enum SpeechType {
        // 文本类型
        PlainText,
        // SSML类型
        SSML,
    }
}
