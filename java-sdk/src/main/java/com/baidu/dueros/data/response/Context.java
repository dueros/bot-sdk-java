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

import com.baidu.dueros.nlu.Intent;

/**
 * 反馈给DuerOS的意图信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class Context {

    // Bot反馈给DuerOS的信息，例如Bot根据自身资源情况对原始Request信息中Intent的进行了修改
    private Intent intent;
    // afterSearchScore
    private float afterSearchScore = 1.0f;
    private List<ExpectResponse> expectResponse = new ArrayList<ExpectResponse>();

    /**
     * 默认构造方法
     */
    public Context() {

    }

    /**
     * 构造方法
     * 
     * @param intent
     *            需要反馈的意图
     */
    public Context(final Intent intent) {
        this.intent = intent;
    }

    /**
     * 获取intent的getter方法
     * 
     * @return intent 需要反馈的意图
     */
    public Intent getIntent() {
        return intent;
    }

    /**
     * 设置意图的setter方法
     * 
     * @param intent
     *            需要反馈的意图
     */
    public void setIntent(final Intent intent) {
        this.intent = intent;
    }

    /**
     * 获取afterSearchScore的getter方法
     * 
     * @return afterSearchScore afterSearchScore
     */
    public float getAfterSearchScore() {
        return afterSearchScore;
    }

    /**
     * 设置意图的afterSearchScore方法
     * 
     * @param afterSearchScore
     *            afterSearchScore
     */
    public void setAfterSearchScore(float afterSearchScore) {
        this.afterSearchScore = afterSearchScore;
    }

    public void setExpectResponses(List<ExpectResponse> expectResponses) {
        this.expectResponse = expectResponses;
    }

    public List<ExpectResponse> getExpectResponse() {
        return expectResponse;
    }
}
