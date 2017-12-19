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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SessionEndedRequest
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月9日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionEndedRequest extends RequestBody {

    /** Session结束的原因 */
    private final Type reason;
    /** Session结束信息 */
    private final SessionEndedErrorMessage error;

    /**
     * 返回一个用来构造{@code SessionEndedRequest}的{@code Builder}
     * 
     * @return Builder 用来构造{@code SessionEndedRequest}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    private SessionEndedRequest(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp, @JsonProperty("type") final String type,
            @JsonProperty("reason") final Type reason, @JsonProperty("error") final SessionEndedErrorMessage error) {
        super(requestId, timestamp);
        this.reason = reason;
        this.error = error;
    }

    private SessionEndedRequest(final Builder builder) {
        super(builder);
        reason = builder.reason;
        error = builder.error;
    }

    /**
     * 获取reason的getter方法
     * 
     * @return Type Session结束的原因
     */
    public Type getReason() {
        return reason;
    }

    /**
     * 获取error的getter方法
     * 
     * @return SessionEndedErrorMessage Session结束信息
     */
    public SessionEndedErrorMessage getError() {
        return error;
    }

    /**
     * Session结束的原因
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月9日
     */
    public enum Type {
        /** 用户退出 */
        USER_INITIATED,
        /** 用户无输入祸多次输入无法理解 */
        EXCEEDED_MAX_REPROMPTS,
        /** 系统错误 */
        ERROR,
    }

    /**
     * 用来构造{@code SessionEndedRequest}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月9日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, SessionEndedRequest> {

        private Type reason;
        private SessionEndedErrorMessage error;

        /**
         * 设置reason的setter方法
         * 
         * @param reason
         *            Session结束原因
         * @return Builder 用来构造{@code SessionEndedRequest}
         */
        public Builder setType(final Type reason) {
            this.reason = reason;
            return this;
        }

        /**
         * 设置error的setter方法
         * 
         * @param error
         *            Session结束信息
         * @return Builder 用来构造{@code SessionEndedRequest}
         */
        public Builder setSessionEndedErrorMessage(final SessionEndedErrorMessage error) {
            this.error = error;
            return this;
        }

        /**
         * 调用{@code SessionEndedRequest}的私有构造方法构造{@code SessionEndedRequest}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        public SessionEndedRequest build() {
            return new SessionEndedRequest(this);
        }

    }

}
