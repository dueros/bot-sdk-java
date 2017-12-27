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
 * LaunchRequest
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LaunchRequest extends RequestBody {

    /**
     * 返回一个用来构造{@code LaunchRequest}的{@code Builder}
     * 
     * @return Builder 用来构造{@code LaunchRequest}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code Application}
     * 
     * @param builder
     *            用来构造{@code LaunchRequest}
     */
    private LaunchRequest(final Builder builder) {
        super(builder);
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            每个request会有不同的requestId
     * @param timestamp
     *            request时间，Bot结合http header一起用于做安全检查
     */
    private LaunchRequest(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp) {
        super(requestId, timestamp);
    }

    /**
     * 用来构造{@code LaunchRequest}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, LaunchRequest> {

        /**
         * 调用{@code LaunchRequest}的私有构造方法构造{@code LaunchRequest}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        public LaunchRequest build() {
            return new LaunchRequest(this);
        }
    }
}
