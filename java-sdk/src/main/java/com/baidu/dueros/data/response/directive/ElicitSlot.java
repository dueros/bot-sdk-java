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

package com.baidu.dueros.data.response.directive;

import com.baidu.dueros.nlu.Intent;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 询问一个Slot指令
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonTypeName("Dialog.ElicitSlot")
public class ElicitSlot extends DialogDirective {

    // 需要询问的槽位
    private String slotToElicit;

    /**
     * 默认构造方法
     */
    public ElicitSlot() {

    }

    /**
     * 构造方法
     * 
     * @param slotToElicit
     *            需要询问的槽位
     */
    public ElicitSlot(final String slotToElicit) {
        this.slotToElicit = slotToElicit;
    }

    /**
     * 构造方法
     * 
     * @param updatedIntent
     *            反馈的意图信息
     * @param slotToElicit
     *            需要询问的槽位
     */
    public ElicitSlot(final Intent updatedIntent, final String slotToElicit) {
        super(updatedIntent);
        this.slotToElicit = slotToElicit;
    }

    /**
     * 获取需要询问槽位的getter方法
     * 
     * @return String 需要询问的槽位
     */
    public String getSlotToElicit() {
        return slotToElicit;
    }

    /**
     * 设置需要询问槽位的setter方法
     * 
     * @param slotToElicit
     *            需要询问的槽位
     */
    public void setSlotToElicit(final String slotToElicit) {
        this.slotToElicit = slotToElicit;
    }

}
