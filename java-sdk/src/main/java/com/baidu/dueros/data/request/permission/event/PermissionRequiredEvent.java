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

package com.baidu.dueros.data.request.permission.event;

import java.util.ArrayList;
import java.util.List;

import com.baidu.dueros.data.request.events.CommonEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 当技能返回了录音等需要权限才可以使用的指令时，但是没有录音等权限时会收到该事件，需要技能返回Permission.
 * AskForPermissionsConsent指令申请用户录音等权限。
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2018年06月29日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Permission.PermissionRequired")
public class PermissionRequiredEvent extends CommonEvent {

    // 对应支付指令的token
    private String token;
    private List<String> permissions = new ArrayList<>();

    /**
     * 返回一个用来构造{@code PermissionRequiredEvent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code PermissionRequiredEvent}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code PermissionRequiredEvent}
     * 
     * @param builder
     *            用来构造{@code PermissionRequiredEvent}
     */
    protected PermissionRequiredEvent(Builder builder) {
        super(builder);
        this.token = builder.token;
        this.permissions = builder.permissions;
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
     * @param token
     *            token
     * @param permissions
     *            permissions
     */
    protected PermissionRequiredEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("permissions") final List<String> permissions) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.permissions = permissions;
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
     * 获取permissions的getter方法
     * 
     * @return List permissions
     */
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * 用来构造{@code PermissionRequiredEvent}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, PermissionRequiredEvent> {

        public String token;
        public List<String> permissions = new ArrayList<>();

        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        public Builder setPermissions(final List<String> permissions) {
            this.permissions = permissions;
            return this;
        }

        @Override
        public PermissionRequiredEvent build() {
            return new PermissionRequiredEvent(this);
        }

    }
}
