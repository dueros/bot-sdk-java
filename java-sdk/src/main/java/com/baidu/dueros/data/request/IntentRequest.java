/** 
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

package com.baidu.dueros.data.request;

import java.util.List;

import com.baidu.dueros.nlu.Intent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * IntentRequest
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntentRequest extends RequestBody {

    /** 本次请求的Query */
    private final Query query;
    /** 当前会话状态 */
    private final DialogState dialogState;
    /** 用于US在召回多个Bot时，表示本次召回的Bot是否可以做带有副作用的操作 */
    private final boolean determined;
    /** 本次下发的Intents，da可能对一个Query解析出多个Intent */
    private final List<Intent> intents;

    /**
     * 返回一个用来构造{@code IntentRequest}的{@code Builder}
     * 
     * @return Builder 用来构造{@code IntentRequest}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code IntentRequest}
     * 
     * @param builder
     *            用来构造{@code IntentRequest}
     */
    private IntentRequest(final Builder builder) {
        super(builder);
        query = builder.query;
        dialogState = builder.dialogState;
        determined = builder.determined;
        intents = builder.intents;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            本次请求的Query
     * @param timestamp
     *            request时间，Bot结合http header一起用于做安全检查
     * @param query
     *            用户查询的Query
     * @param dialogState
     *            对话状态，这里的对话表示一次服务端发起的多轮填槽对话
     * @param determined
     *            用于US在召回多个Bot时，表示本次召回的Bot是否可以做带有副作用的操作
     * @param intents
     *            本次下发的Intents，da可能对一个Query解析出多个Intent
     */
    private IntentRequest(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp, @JsonProperty("query") final Query query,
            @JsonProperty("dialogState") final DialogState dialogState,
            @JsonProperty("determined") final boolean determined, @JsonProperty("intents") final List<Intent> intents) {
        super(requestId, timestamp);
        this.query = query;
        this.dialogState = dialogState;
        this.determined = determined;
        this.intents = intents;
    }

    /**
     * 获取query的getter方法
     * 
     * @return Query 用户查询的Query
     */
    public Query getQuery() {
        return query;
    }

    /**
     * 获取dialogState的getter方法
     * 
     * @return DialogState 当前会话状态
     */
    public DialogState getDialogState() {
        return dialogState;
    }

    /**
     * 获取determined的getter方法
     * 
     * @return boolean 用于US在召回多个Bot时，表示本次召回的Bot是否可以做带有副作用的操作
     */
    public boolean isDetermined() {
        return determined;
    }

    /**
     * 获取intents的getter方法
     * 
     * @return intents 本次下发的Intents，da可能对一个Query解析出多个Intent
     */
    public List<Intent> getIntents() {
        return intents;
    }

    /**
     * 获取意图名称
     * 
     * @return String intentname
     */
    public String getIntentName() {
        return intents.get(0).getName();
    }

    /**
     * 根据槽位名，获取槽位值
     * 
     * @param slot
     *            槽位名
     * @return String 槽位值
     */
    public String getSlot(String slot) {
        return intents.get(0).getSlots().get(slot).getName();
    }

    /**
     * 获取某个意图的槽位值
     * 
     * @param slot
     *            槽位名
     * @param index
     *            意图位置
     * @return String 槽位名对应的槽位值
     */
    public String getSlot(String slot, int index) {
        return intents.get(index).getSlots().get(slot).getName();
    }

    /**
     * 当前会话状态
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public enum DialogState {
        /** 开始 */
        STARTED,
        /** 进行中 */
        IN_PROGRESS,
        /** 结束 */
        COMPLETED,
    }

    /**
     * 用来构造{@code IntentRequest}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, IntentRequest> {

        private Query query;
        private DialogState dialogState;
        private boolean determined;
        private List<Intent> intents;

        /**
         * 设置query的setter方法
         * 
         * @param query
         *            本次请求的Query
         * @return Builder 用来构造{@code IntentRequest}
         */
        public Builder setQuery(final Query query) {
            this.query = query;
            return this;
        }

        /**
         * 设置dialogState的setter方法
         * 
         * @param dialogState
         *            当前会话状态
         * @return Builder 用来构造{@code IntentRequest}
         */
        public Builder setDialogState(final DialogState dialogState) {
            this.dialogState = dialogState;
            return this;
        }

        /**
         * 设置determined的setter方法
         * 
         * @param determined
         *            是否可以做带有副作用的操作
         * @return Builder 用来构造{@code IntentRequest}
         */
        public Builder setDetermined(final boolean determined) {
            this.determined = determined;
            return this;
        }

        /**
         * 设置intents的setter方法
         * 
         * @param intents
         *            本次下发的Intents
         * @return Builder 用来构造{@code IntentRequest}
         */
        public Builder setIntents(final List<Intent> intents) {
            this.intents = intents;
            return this;
        }

        /**
         * 调用{@code IntentRequest}的私有构造方法构造{@code IntentRequest}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         * @return IntentRequest 返回构造的IntentRequest
         */
        @Override
        public IntentRequest build() {
            return new IntentRequest(this);
        }

    }

}
