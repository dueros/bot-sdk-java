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

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 槽位
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slot {

    // 槽位名称
    private final String name;
    // 槽位值
    private final String value;
    // 槽位确认状态
    private final ConfirmationStatus confirmationStatus;
    // 槽位置信度
    private final int score;
    // 槽位值列表
    private final ArrayList<String> values;

    /**
     * 返回一个用来构造{@code Slot}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Slot}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private Slot(final Builder builder) {
        this.name = builder.name;
        this.value = builder.value;
        this.confirmationStatus = builder.confirmationStatus;
        this.score = builder.score;
        this.values = builder.values;
    }

    private Slot(@JsonProperty("name") final String name, @JsonProperty("value") final String value,
            @JsonProperty("confirmationStatus") final ConfirmationStatus confirmationStatus,
            @JsonProperty("score") final int score, @JsonProperty("values") final ArrayList<String> values) {
        this.name = name;
        this.value = value;
        this.confirmationStatus = confirmationStatus;
        this.score = score;
        this.values = values;
    }

    /**
     * 获取槽位名
     * 
     * @return String 槽位名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取槽位值
     * 
     * @return String 槽位值
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取槽位值列表
     * 
     * @return ArrayList 槽位值列表
     */
    public ArrayList<String> getValues() {
        return values;
    }

    /**
     * 获取槽位确认状态
     * 
     * @return ConfirmationStatus 槽位确认状态
     */
    public ConfirmationStatus getConfirmationStatus() {
        return confirmationStatus;
    }

    /**
     * 获取槽位置信度
     * 
     * @return int 槽位置信度
     */
    public int getScore() {
        return score;
    }

    /**
     * 用来构造{@code Slot}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public static final class Builder {

        private String name;
        private String value;
        private ConfirmationStatus confirmationStatus;
        private int score;
        private ArrayList<String> values;

        /**
         * 设置槽位名
         * 
         * @param name
         *            槽位名
         * @return 构造Slot的Builder
         */
        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * 设置槽位值
         * 
         * @param value
         *            槽位值
         * @return 构造Slot的Builder
         */
        public Builder setValue(final String value) {
            this.value = value;
            return this;
        }

        /**
         * 设置槽位确认状态
         * 
         * @param confirmationStatus
         *            槽位确认状态
         * @return 构造Slot的Builder
         */
        public Builder setConfirmationStatus(final ConfirmationStatus confirmationStatus) {
            this.confirmationStatus = confirmationStatus;
            return this;
        }

        /**
         * 设置槽位置信度
         * 
         * @param score
         *            槽位置信度
         * @return 构造Slot的Builder
         */
        public Builder setScore(final int score) {
            this.score = score;
            return this;
        }

        /**
         * 设置槽位值列表
         * 
         * @param values
         *            槽位值列表
         * @return 构造Slot的Builder
         */
        public Builder setValues(final ArrayList<String> values) {
            this.values = values;
            return this;
        }

        /**
         * 调用{@code Slot}的私有构造方法构造{@code Application}
         * 
         * @return Slot 构造一个Slot
         */
        public Slot build() {
            return new Slot(this);
        }

    }
}
