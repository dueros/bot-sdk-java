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

package com.baidu.dueros.data.response.directive.permission;

import java.util.ArrayList;
import java.util.List;

import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Permission.AskForPermissionsConsent")
public class AskForPermissionsConsent extends Directive {

    // 唯一标识此指令
    private String token;
    private List<Permission> permissions = new ArrayList<>();

    public AskForPermissionsConsent() {

    }

    public AskForPermissionsConsent setToken(String token) {
        this.token = token;
        return this;
    }

    public AskForPermissionsConsent addPermission(String name) {
        Permission permission = new Permission(name);
        permissions.add(permission);
        return this;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions.clear();
        this.permissions.addAll(permissions);
    }

    public String getToken() {
        return token;
    }
}
