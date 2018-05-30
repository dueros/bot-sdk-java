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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bot信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

    // applicationId是一个DBP平台生成的UUID，用于唯一标识一个Bot
    private final String applicationId;
    private final List<String> botConfigList;

    /**
     * 返回一个用来构造{@code Application}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Application}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code Application}
     * 
     * @param Builder
     *            用来构造{@code Application}
     */
    private Application(final Builder builder) {
        applicationId = builder.applicationId;
        botConfigList = builder.botConfigList;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param applicationId
     *            DBP平台生成的UUID，用于唯一标识一个Bot
     */
    private Application(@JsonProperty("applicationId") final String applicationId,
            @JsonProperty("bot_config_list") final List<String> botConfigList) {
        this.applicationId = applicationId;
        this.botConfigList = botConfigList;
    }

    /**
     * 获取applicationId的getter方法
     * 
     * @return String applicationId
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 获取botConfigList的getter方法
     * 
     * @return List botConfigList
     */
    public List<String> getBotConfigList() {
        return botConfigList;
    }

    /**
     * 用来构造{@code Application}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // applicationId是一个DBP平台生成的UUID，用于唯一标识一个Bot
        private String applicationId;
        private List<String> botConfigList;

        /**
         * 设置applicationId的setter方法
         * 
         * @param applicationId
         *            唯一标识一个Bot
         * @return Builder 用来构造{@code Application}
         */
        public Builder setApplicationId(final String applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        /**
         * 设置botConfigList的setter方法
         * 
         * @param botConfigList
         *            botConfigList
         * @return Builder 用来构造{@code Application}
         */
        public Builder setBotConfigList(final List<String> botConfigList) {
            this.botConfigList = botConfigList;
            return this;
        }

        /**
         * 调用{@code Application}的私有构造方法构造{@code Application}
         * 
         * @return Application 构造一个Application
         */
        public Application build() {
            return new Application(this);
        }

    }
}
