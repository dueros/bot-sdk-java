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
package com.baidu.dueros.data.request.videoplayer.event;

import com.baidu.dueros.data.request.RequestBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 视频播放器上报的事件的基类
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年5月7日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoPlayerEvent extends RequestBody {

    /**
     * 构造方法
     * 
     * @param builder
     *            用于构造{@code VideoPlayerEvent}
     */
    protected VideoPlayerEvent(final RequestBodyBuilder builder) {
        super(builder);
    }

    /**
     * 构造方法
     * 
     * @param requestId
     *            每个request会有不同的requestId
     * @param timestamp
     *            request时间，Bot结合http header一起用于做安全检查
     * @param dialogRequestId
     *            dialogRequestId
     */
    protected VideoPlayerEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId) {
        super(requestId, timestamp, dialogRequestId);
    }
}
