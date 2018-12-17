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

package com.baidu.dueros.data.request.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Form.RadioButtonClicked")
public class RadioButtonClickedEvent extends CommonEvent {
    private final String token;
    private final String name;
    private final String selectedValue;

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            每个request会有不同的requestId
     * @param timestamp
     *            request时间，Bot结合http header一起用于做安全检查
     * @param token
     *            点击列表项对应的token
     */
    private RadioButtonClickedEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("name") final String name, @JsonProperty("selectedValue") final String selectedValue) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.name = name;
        this.selectedValue = selectedValue;
    }

    /**
     * 私有构造方法
     * 
     * @param builder
     *            用来构造{@code RadioButtonClickedEvent}的{@code Builder}
     */
    private RadioButtonClickedEvent(final Builder builder) {
        super(builder);
        token = builder.token;
        name = builder.name;
        selectedValue = builder.selectedValue;
    }

    /**
     * 获取点击列表项的name字段
     * 
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * 获取点击列表项的token字段
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取点击列表项的selectedValue字段
     * 
     * @return String selectedValue
     */
    public String getSelectedValue() {
        return selectedValue;
    }

    /**
     * 用来构造{@code RadioButtonClickedEvent}
     * 
     * @author hujie08
     * @version 1.0
     * @since 2018年5月23日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, RadioButtonClickedEvent> {
        private String token;
        private String name;
        private String selectedValue;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            展现列表中对应的token
         * @return Builder 用来构造{@code RadioButtonClickedEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置name的setter方法
         * 
         * @param name
         *            展现列表中对应的name
         * @return Builder 用来构造{@code RadioButtonClickedEvent}
         */
        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * 设置selectedValue的setter方法
         * 
         * @param selectedValue
         *            展现列表中对应的selectedValue
         * @return Builder 用来构造{@code RadioButtonClickedEvent}
         */
        public Builder setSelectedValue(final String selectedValue) {
            this.selectedValue = selectedValue;
            return this;
        }

        /*
         * RadioButtonClickedEvent 调用{@code
         * RadioButtonClickedEvent}的私有构造方法构造{@code ElementSelectedEvent}
         * 
         * @see
         * com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        @Override
        public RadioButtonClickedEvent build() {
            return new RadioButtonClickedEvent(this);
        }
    }
}
