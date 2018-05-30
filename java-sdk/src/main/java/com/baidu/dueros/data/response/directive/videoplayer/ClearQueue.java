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
package com.baidu.dueros.data.response.directive.videoplayer;

import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 用于清除播放队列的指令
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年5月7日
 */
@JsonTypeName("VideoPlayer.ClearQueue")
public class ClearQueue extends Directive {

    /**
     * 清除行为: CLEAR_ENQUEUED: 用于清除队列但保留当前正在播放的video item; CLEAR_ALL:
     * 用于清除播放队列并停止当前播放的video item。
     */
    private String clearBehavior;

    /**
     * 清除播放队列指令构造函数
     * 
     * @param clearBehavior
     *            清除行为(CLEAR_ENQUEUED,CLEAR_ALL)
     */
    public ClearQueue(String clearBehavior) {
        this.clearBehavior = clearBehavior;
    }

    /**
     * 获取clearBehavior的getter方法
     * 
     * @return 清除行为
     */
    public String getClearBehavior() {
        return clearBehavior;
    }

    /**
     * 设置clearBehavior的setter方法
     * 
     * @param clearBehavior
     *            清除行为
     */
    public void setClearBehavior(String clearBehavior) {
        this.clearBehavior = clearBehavior;
    }

}
