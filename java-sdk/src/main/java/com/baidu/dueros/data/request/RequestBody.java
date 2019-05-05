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

import com.baidu.dueros.data.request.events.ButtonClickedEvent;
import com.baidu.dueros.data.request.events.ConnectionsResponseEvent;
import com.baidu.dueros.data.request.events.ElementSelectedEvent;
import com.baidu.dueros.data.request.events.LinkClickedEvent;
import com.baidu.dueros.data.request.events.RadioButtonClickedEvent;
import com.baidu.dueros.data.request.permission.event.PermissionGrantFailedEvent;
import com.baidu.dueros.data.request.permission.event.PermissionGrantedEvent;
import com.baidu.dueros.data.request.permission.event.PermissionRejectedEvent;
import com.baidu.dueros.data.request.permission.event.PermissionRequiredEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackFinishedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackNearlyFinishedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackPausedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackQueueClearedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackResumedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStartedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStoppedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStutterFinishedEvent;
import com.baidu.dueros.data.request.videoplayer.event.PlaybackStutterStartedEvent;
import com.baidu.dueros.data.request.videoplayer.event.ProgressReportDelayElapsedEvent;
import com.baidu.dueros.data.request.videoplayer.event.ProgressReportIntervalElapsedEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * RequestBody请求内容
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = IntentRequest.class), @Type(value = LaunchRequest.class),
        @Type(value = SessionEndedRequest.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackStartedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackStoppedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackFinishedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackNearlyFinishedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackPausedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackFailedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackResumedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackStutterStartedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.ProgressReportDelayElapsedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.ProgressReportIntervalElapsedEvent.class),
        @Type(value = com.baidu.dueros.data.request.audioplayer.event.PlaybackStutterFinishedEvent.class),
        @Type(value = PlaybackStartedEvent.class), @Type(value = PlaybackStoppedEvent.class),
        @Type(value = PlaybackFinishedEvent.class), @Type(value = PlaybackNearlyFinishedEvent.class),
        @Type(value = ProgressReportIntervalElapsedEvent.class), @Type(value = ProgressReportDelayElapsedEvent.class),
        @Type(value = PlaybackStutterStartedEvent.class), @Type(value = PlaybackStutterFinishedEvent.class),
        @Type(value = PlaybackPausedEvent.class), @Type(value = PlaybackResumedEvent.class),
        @Type(value = PlaybackQueueClearedEvent.class), @Type(value = ElementSelectedEvent.class),
        @Type(value = LinkClickedEvent.class), @Type(value = ConnectionsResponseEvent.class),
        @Type(value = PermissionGrantFailedEvent.class), @Type(value = PermissionRejectedEvent.class),
        @Type(value = PermissionGrantedEvent.class), @Type(value = PermissionRequiredEvent.class),
        @Type(value = ButtonClickedEvent.class), @Type(value = RadioButtonClickedEvent.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestBody {

    // 每个request会有不同的requestId
    private final String requestId;
    // request时间，Bot结合http header一起用于做安全检查
    private final String timestamp;
    private final String dialogRequestId;

    /**
     * 通过{@code Builder}来构造{@code RequestBody}
     * 
     * @param builder
     *            用来构造RequestBody
     */
    protected RequestBody(final RequestBodyBuilder builder) {
        requestId = builder.requestId;
        timestamp = builder.timestamp;
        dialogRequestId = builder.dialogRequestId;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            每个request会有不同的requestId
     * @param timestamp
     *            request时间，Bot结合http header一起用于做安全检查
     * @param dialogRequestId
     *            dialogRequestId
     */
    protected RequestBody(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.dialogRequestId = dialogRequestId;
    }

    /**
     * 获取requestId的getter方法
     * 
     * @return String requestId每个request会有不同的requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 获取timestamp的getter方法
     * 
     * @return String timestamprequest时间，Bot结合http header一起用于做安全检查
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 获取timestamp的getter方法
     * 
     * @return String timestamprequest时间，Bot结合http header一起用于做安全检查
     */
    public String getDialogRequestId() {
        return dialogRequestId;
    }

    /**
     * 用来构造{@code RequestBody}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static abstract class RequestBodyBuilder<T extends RequestBodyBuilder, S extends RequestBody> {

        private String requestId;
        private String timestamp;
        private String dialogRequestId;

        /**
         * 设置requestId的setter方法
         * 
         * @param requestId
         *            每个request会有不同的requestId
         * @return T
         */
        public T setRequestId(final String requestId) {
            this.requestId = requestId;
            return (T) this;
        }

        /**
         * 设置timestamp的setter方法
         * 
         * @param timestamp
         *            request时间
         * @return T
         */
        public T setTimestamp(final String timestamp) {
            this.timestamp = timestamp;
            return (T) this;
        }

        public T setDialogRequestId(final String dialogRequestId) {
            this.dialogRequestId = dialogRequestId;
            return (T) this;
        }

        /**
         * 用来构造S泛型类
         * 
         * @return S 返回一个S泛型类
         */
        public abstract S build();

    }
}
