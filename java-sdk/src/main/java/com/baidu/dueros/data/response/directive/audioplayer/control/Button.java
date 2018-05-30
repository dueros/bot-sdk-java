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

public abstract class Button extends BaseButton {
    // 按钮是否可点击，true为可点击，false不可点击
    protected boolean enable = false;
    // 按钮是否要渲染为选中状态， true为需要渲染为选中状态， false为渲染为非选择状态
    protected boolean selected = false;
    // 控件类型，对于button按钮而言，控件类型为固定值BUTTON
    private static final String type = "BUTTON";

    /**
     * 构造方法
     * 
     * @param name
     *            按钮名称
     */
    public Button(String name) {
        super(type, name);
        this.enable = true;
        this.selected = false;
    }

    /**
     * 获取按钮是否可点击的getter方法
     * 
     * @return boolean 是否可点击
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * 设置按钮的可点击状态的setter方法
     * 
     * @param enable
     *            是否可点击
     * @return Button
     */
    public Button setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * 获取按钮是否要渲染成选中状态的getter方法
     * 
     * @return boolean 是否要渲染成选中
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * 设置按钮是否要渲染成选中状态的setter方法
     * 
     * @param selected
     *            是否要渲染成选中
     * @return Button
     */
    public Button setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

}
