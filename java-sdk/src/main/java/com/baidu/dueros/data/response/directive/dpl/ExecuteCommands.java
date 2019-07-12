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

package com.baidu.dueros.data.response.directive.dpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.baidu.dueros.data.response.directive.Directive;
import com.baidu.dueros.data.response.directive.dpl.commands.BaseCommand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 渲染后页面的交互指令
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonTypeName("DPL.ExecuteCommands")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecuteCommands extends Directive {

    // token
    private String token;
    // command类型
    private List<BaseCommand> commands = new ArrayList<>();

    public ExecuteCommands() {
        token = UUID.randomUUID().toString();
    }

    public ExecuteCommands(List<BaseCommand> commands) {
        this.commands = commands;
        token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<BaseCommand> getCommands() {
        return commands;
    }

    public void setCommands(List<BaseCommand> commands) {
        this.commands = commands;
    }

    public ExecuteCommands addCommand(BaseCommand command) {
        commands.add(command);
        return this;
    }

}
