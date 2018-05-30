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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 记录Debug Bot的信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年11月16日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Debug {

    // 待debug的bot
    private final String smarthomeBotId;
    // 需要传给bot的OAuth info id
    private final String oauthInfoId;
    // 待debug的bot的debug访问地址
    private final String smarthomeWebServiceUrl;

    /**
     * 返回一个用来构造{@code Debug}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Debug}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private Debug(@JsonProperty("smarthome_bot_id") final String smarthomeBotId,
            @JsonProperty("oauth_info_id") final String oauthInfoId,
            @JsonProperty("smarthome_web_service_url") final String smarthomeWebServiceUrl) {
        this.smarthomeBotId = smarthomeBotId;
        this.oauthInfoId = oauthInfoId;
        this.smarthomeWebServiceUrl = smarthomeWebServiceUrl;
    }

    private Debug(final Builder builder) {
        smarthomeBotId = builder.smarthomeBotId;
        oauthInfoId = builder.oauthInfoId;
        smarthomeWebServiceUrl = builder.smarthomeWebServiceUrl;
    }

    /**
     * 获取smarthomeBotId的getter方法
     * 
     * @return String smarthomeBotId待debug的bot
     */
    public String getSmarthomeBotId() {
        return smarthomeBotId;
    }

    /**
     * 获取oauthInfoId的getter方法
     * 
     * @return String oauthInfoId需要传给bot的OAuth info id
     */
    public String getOauthInfoId() {
        return oauthInfoId;
    }

    /**
     * 获取smarthomeWebServiceUrl的getter方法
     * 
     * @return String smarthomeWebServiceUrl待debug的bot的debug访问地址
     */
    public String getSmarthomeWebServiceUrl() {
        return smarthomeWebServiceUrl;
    }

    /**
     * 用来构造{@code Debug}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // 待debug的bot
        private String smarthomeBotId;
        // 需要传给bot的OAuth info id
        private String oauthInfoId;
        // 待debug的bot的debug访问地址
        private String smarthomeWebServiceUrl;

        /**
         * 设置smarthomeBotId的setter方法
         * 
         * @param smarthomeBotId
         *            待debug的bot
         * @return Builder 用来构造{@code Debug}
         */
        public Builder setSmarthomeBotId(final String smarthomeBotId) {
            this.smarthomeBotId = smarthomeBotId;
            return this;
        }

        /**
         * 设置oauthInfoId的setter方法
         * 
         * @param oauthInfoId
         *            需要传给bot的OAuth info id
         * @return Builder 用来构造{@code Debug}
         */
        public Builder setOauthInfoId(final String oauthInfoId) {
            this.oauthInfoId = oauthInfoId;
            return this;
        }

        /**
         * 设置smarthomeWebServiceUrl的setter方法
         * 
         * @param smarthomeWebServiceUrl
         *            待debug的bot的debug访问地址
         * 
         * @return Builder 用来构造{@code Debug}
         */
        public Builder setSmarthomeWebServiceUrl(final String smarthomeWebServiceUrl) {
            this.smarthomeWebServiceUrl = smarthomeWebServiceUrl;
            return this;
        }

        /**
         * 调用{@code Debug}的私有构造方法构造{@code Debug}
         * 
         * @return Debug 构造一个Debug
         */
        public Debug build() {
            return new Debug(this);
        }
    }

}
