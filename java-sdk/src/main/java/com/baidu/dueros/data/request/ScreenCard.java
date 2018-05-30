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
package com.baidu.dueros.data.request;

import com.baidu.dueros.data.response.card.Card;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 屏幕中卡片和技能图标信息
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年5月3日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreenCard {
    // 屏幕中卡片信息
    private final Card card;
    // 技能信息
    private final SkillInfo skillInfo;

    /**
     * 返回一个用来构造{@code ScreenCard}的{@code Builder}
     * 
     * @return Builder 用来构造{@code ScreenCard}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code ScreenCard}
     * 
     * @param builder
     *            用来构造{@code ScreenCard}
     */
    private ScreenCard(Builder builder) {
        card = builder.card;
        skillInfo = builder.skillInfo;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param card
     *            屏幕中卡片信息
     * @param skillInfo
     *            技能信息
     */
    private ScreenCard(@JsonProperty("card") final Card card, @JsonProperty("skillInfo") final SkillInfo skillInfo) {
        this.card = card;
        this.skillInfo = skillInfo;
    }

    /**
     * 获取屏幕中卡片信息的getter方法
     * 
     * @return Card 屏幕中卡片信息
     */
    public Card getCard() {
        return card;
    }

    /**
     * 获取技能图标信息的getter方法
     * 
     * @return SkillInfo 技能图标信息
     */
    public SkillInfo getSkillInfo() {
        return skillInfo;
    }

    /**
     * 用来构造{@code ScreenCard}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder {
        // 屏幕中卡片信息
        private Card card;
        // 技能信息
        private SkillInfo skillInfo;

        /**
         * 设置屏幕中卡片信息的setter方法
         * 
         * @param card
         *            卡片信息
         * @return 构造ScreenCard的builder
         */
        public Builder setCard(Card card) {
            this.card = card;
            return this;
        }

        /**
         * @param skillInfo
         *            技能信息
         * @return 构造ScreenCard的builder
         */
        public Builder setSkillInfo(SkillInfo skillInfo) {
            this.skillInfo = skillInfo;
            return this;
        }

        /**
         * 调用{@code SkillInfo}的私有构造方法构造{@code SkillInfo}
         * 
         * @return SkillInfo 构造一个SkillInfo
         */
        public ScreenCard build() {
            return new ScreenCard(this);
        }
    }

}
