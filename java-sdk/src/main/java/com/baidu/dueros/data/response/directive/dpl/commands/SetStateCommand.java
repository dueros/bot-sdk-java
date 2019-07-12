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

package com.baidu.dueros.data.response.directive.dpl.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 改变组件样式
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetStateCommand extends BaseCommand {

    // 属性名称
    private String state;
    // 对应的属性值, 可为空
    private String value;

    public SetStateCommand() {
        super("SetState");
    }

    public String getState() {
        return state;
    }

    public SetStateCommand setState(String state) {
        this.state = state;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SetStateCommand setValue(String value) {
        this.value = value;
        return this;
    }

}
