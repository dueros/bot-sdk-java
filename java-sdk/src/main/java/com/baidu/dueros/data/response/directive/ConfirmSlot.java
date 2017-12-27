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
 * 确认槽位的对话指令,确认一个Slot,Slot的ConfirmationStatus将是CONFIRMED，否则将是DENIED
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonTypeName("Dialog.ConfirmSlot")
public class ConfirmSlot extends DialogDirective {

    // 需要确认的槽位
    private String slotToConfirm;

    /**
     * 默认构造方法
     */
    public ConfirmSlot() {

    }

    /**
     * 构造方法
     * 
     * @param slotToConfirm
     *            需要确认的槽位
     */
    public ConfirmSlot(final String slotToConfirm) {
        this.slotToConfirm = slotToConfirm;
    }

    /**
     * 构造方法
     * 
     * @param updatedIntent
     *            意图
     * @param slotToConfirm
     *            槽位
     */
    public ConfirmSlot(final Intent updatedIntent, final String slotToConfirm) {
        super(updatedIntent);
        this.slotToConfirm = slotToConfirm;
    }

    /**
     * 获取需要确认槽位值的getter方法
     * 
     * @return String 需要确认的槽位值
     */
    public String getSlotToConfirm() {
        return slotToConfirm;
    }

    /**
     * 设置需要确认槽位值的setter方法
     * 
     * @param slotToConfirm
     *            需要确认的槽位值
     */
    public void setSlotToConfirm(final String slotToConfirm) {
        this.slotToConfirm = slotToConfirm;
    }

}
