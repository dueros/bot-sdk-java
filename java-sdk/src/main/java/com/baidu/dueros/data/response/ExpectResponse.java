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

public class ExpectResponse {
    // 输出类型
    private ExpectResponseType type;
    // 文本内容
    private String text = "";
    // 槽位名称
    private String slot = "";

    /**
     * 默认构造方法
     */
    public ExpectResponse() {

    }

    /**
     * 构造方法
     * 
     * @param type
     *            输出类型
     * @param content
     *            输出内容
     */
    public ExpectResponse(final ExpectResponseType type, final String content) {
        this.type = type;
        if (type == ExpectResponseType.Text) {
            this.text = content;
        } else if (type == ExpectResponseType.Slot) {
            this.slot = content;
        }
    }

    /**
     * 获取type的getter方法
     * 
     * @return type 获取输出类型
     */
    public ExpectResponseType getType() {
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
    public String getSlot() {
        return slot;
    }

    /**
     * 设置输出类型的setter方法
     * 
     * @param type
     *            设置输出类型
     */
    public void setType(final ExpectResponseType type) {
        this.type = type;
    }

    /**
     * 设置输出类型的setter方法
     * 
     * @param text
     *            文本内容
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * 设置输出类型的setter方法
     * 
     * @param slot
     *            槽位值
     */
    public void setSlot(final String slot) {
        this.slot = slot;
    }

    /**
     * ExpectResponse类型
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public enum ExpectResponseType {
        // 文本类型
        Text,
        // 槽位类型
        Slot,
    }
}
