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
import com.baidu.dueros.data.response.directive.display.templates.BaseTemplate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 屏幕信息
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年5月3日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Screen {
    // token
    private final String token;
    // 屏幕卡片信息
    private final Card card;
    // 模板信息（card和template是互斥的 优先出template，没有template出card）
    private final BaseTemplate template;

    /**
     * 返回一个用来构造{@code Screen}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Screen}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code Screen}
     * 
     * @param builder
     *            用来构造{@code Screen}
     */
    private Screen(final Builder builder) {
        token = builder.token;
        card = builder.card;
        template = builder.template;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param token
     *            token
     * @param card
     *            屏幕卡片信息
     */
    private Screen(@JsonProperty("token") final String token, @JsonProperty("card") final Card card,
            @JsonProperty("template") final BaseTemplate template) {
        this.token = token;
        this.card = card;
        this.template = template;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取屏幕card信息的getter方法
     * 
     * @return Card 屏幕卡片信息
     */
    public Card getCard() {
        return card;
    }

    /**
     * 获取屏幕template信息的getter方法
     * 
     * @return BaseTemplate 屏幕展现模板的信息
     */
    public BaseTemplate getTemplate() {
        return template;
    }

    /**
     * 用来构造{@code Screen}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder {
        // token
        private String token;
        // 卡片
        private Card card;
        // 模板
        private BaseTemplate template;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            token
         * @return Builder 用来构造{@code Screen}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置card的setter方法
         * 
         * @param card
         *            屏幕展现的卡片信息
         * @return Builder 用来构造{@code Screen}
         */
        public Builder setCard(final Card card) {
            this.card = card;
            return this;
        }

        /**
         * 设置template 的setter方法
         * 
         * @param template
         *            屏幕展现的模板信息
         * @return Builder 用来构造{@code Screen}
         */
        public Builder setTemplate(final BaseTemplate template) {
            this.template = template;
            return this;
        }

        /**
         * 调用{@code Screen}的私有构造方法构造{@code Screen}
         * 
         * @return Screen 构造一个Screen
         */
        public Screen build() {
            return new Screen(this);
        }
    }
}
