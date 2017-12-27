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

/**
 * 对话指令
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class DialogDirective extends Directive {

    // 反馈的意图
    private Intent updatedIntent;

    /**
     * 默认构造方法
     */
    public DialogDirective() {

    }

    /**
     * 构造方法
     * 
     * @param updatedIntent
     *            反馈的意图信息
     */
    public DialogDirective(final Intent updatedIntent) {
        this.updatedIntent = updatedIntent;
    }

    /**
     * 获取反馈意图的getter方法
     * 
     * @return Intent 反馈的意图信息
     */
    public Intent getUpdatedIntent() {
        return updatedIntent;
    }

    /**
     * 设置反馈意图的setter方法
     * 
     * @param updatedIntent
     *            反馈的意图信息
     */
    public void setUpdatedIntent(final Intent updatedIntent) {
        this.updatedIntent = updatedIntent;
    }

}
