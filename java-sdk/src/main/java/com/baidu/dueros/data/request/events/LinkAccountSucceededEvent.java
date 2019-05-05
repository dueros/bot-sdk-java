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

/**
 * 当用户授权完成之后，技能会收到此事件
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年5月23日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkAccountSucceededEvent extends ConnectionsResponseEvent {

    /**
     * 通过{@code Builder}来构造{@code LinkAccountSucceededEvent}
     * 
     * @param builder
     *            用来构造{@code LinkAccountSucceededEvent}
     */
    protected LinkAccountSucceededEvent(Builder builder) {
        super(builder);
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            requestId
     * @param timestamp
     *            timestamp
     * @param dialogRequestId
     *            dialogRequestId
     * @param name
     *            name
     * @param token
     *            token
     */
    public LinkAccountSucceededEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("name") final String name,
            @JsonProperty("token") final String token) {
        super(requestId, timestamp, dialogRequestId, name, token);
    }

}
