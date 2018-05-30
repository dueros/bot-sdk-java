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
package com.baidu.dueros.data.response.directive.audioplayer.control;

public abstract class BaseButton {
    // 控件类型
    protected String type = "";
    // 控件名称
    protected String name = "";

    /**
     * 构造方法
     * 
     * @param type
     *            控件类型
     * @param name
     *            控件名称
     */
    public BaseButton(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 获取控件类型的getter方法
     * 
     * @return String 控件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置控件类型的setter方法
     * 
     * @param type
     *            控件类型
     * @return BaseButton
     */
    public BaseButton setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 获取控件的名称getter方法
     * 
     * @return String 控件类型
     */
    public String getName() {
        return name;
    }

    /**
     * 设置控制名称的setter方法
     * 
     * @param name
     *            控件名称
     * @return BaseButton
     */
    public BaseButton setName(String name) {
        this.name = name;
        return this;
    }
}
