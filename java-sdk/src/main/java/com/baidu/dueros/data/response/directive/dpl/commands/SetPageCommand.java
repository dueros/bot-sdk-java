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
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 将pager组件的视图切换到中指定页面，index值表示pager的页面序号
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetPageCommand extends BaseCommand {

    private Position position;
    // 翻页步长, 假如有N个页, 取值0到N-1
    private int value;

    public SetPageCommand() {
        super("SetPage");
    }

    public Position getPosition() {
        return position;
    }

    public SetPageCommand setPosition(Position position) {
        this.position = position;
        return this;
    }

    public int getValue() {
        return value;
    }

    public SetPageCommand setValue(int value) {
        this.value = value;
        return this;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public enum Position {
        RELATIVE("relative"), ABSOLUTE("absolute");

        @JsonValue
        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        private String position;

        private Position(String position) {
            this.position = position;
        }
    }
}
