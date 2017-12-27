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

package com.baidu.dueros.nlu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 意图
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intent {

    // 意图名称
    private final String name;
    // 意图确认状态
    private final ConfirmationStatus confirmationStatus;
    // 意图中的槽位
    private final Map<String, Slot> slots;
    // 意图置信度
    private final int score;

    /**
     * 返回一个用来构造{@code Intent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Intent}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private Intent(final Builder builder) {
        name = builder.name;
        confirmationStatus = builder.confirmationStatus;
        slots = Collections.unmodifiableMap(builder.slots);
        score = builder.score;
    }

    private Intent(@JsonProperty("name") final String name,
            @JsonProperty("confirmationStatus") final ConfirmationStatus confirmationStatus,
            @JsonProperty("slots") final Map<String, Slot> slots, @JsonProperty("score") final int score) {
        this.name = name;
        this.confirmationStatus = confirmationStatus;
        this.score = score;
        this.slots = slots;
    }

    /**
     * 设置槽位信息
     * 
     * @param slot
     *            槽位
     */
    public void setSlot(final Slot slot) {
        this.slots.put(slot.getName(), slot);
    }

    /**
     * 获取意图名称
     * 
     * @return String 意图名称
     */
    public String getName() {
        return name;
    }

    /**
     * 获取意图确认状态
     * 
     * @return ConfirmationStatus 意图确认状态
     */
    public ConfirmationStatus getConfirmationStatus() {
        return confirmationStatus;
    }

    /**
     * 获取槽位信息
     * 
     * @return slots 槽位信息
     */
    public Map<String, Slot> getSlots() {
        return slots;
    }

    /**
     * 获取意图置信度
     * 
     * @return int 意图置信度
     */
    public int getScore() {
        return score;
    }

    /**
     * 用来构造{@code Intent}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public static final class Builder {

        private String name;
        private final Map<String, Slot> slots = new HashMap<>();
        private ConfirmationStatus confirmationStatus;
        private int score;

        /**
         * 设置意图名称
         * 
         * @param name
         *            意图名称
         * @return Builder 构造Intent的Builder
         */
        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * 设置意图确认状态
         * 
         * @param confirmationStatus
         *            意图确认状态
         * @return Builder 构造Intent的Builder
         */
        public Builder setConfirmationStatus(final ConfirmationStatus confirmationStatus) {
            this.confirmationStatus = confirmationStatus;
            return this;
        }

        /**
         * 设置槽位信息
         * 
         * @param slots
         *            槽位信息列表
         * @return Builder 构造Intent的Builder
         */
        public Builder setSlots(final Map<String, Slot> slots) {
            this.slots.putAll(slots);
            return this;
        }

        /**
         * 设置意图置信度
         * 
         * @param score
         *            意图置信度
         * @return Builder 构造Intent的Builder
         */
        public Builder setScore(final int score) {
            this.score = score;
            return this;
        }

        /**
         * 调用{@code Intent}的私有构造方法构造{@code Application}
         * 
         * @return Intent 构造一个Intent
         */
        public Intent build() {
            return new Intent(this);
        }
    }
}
