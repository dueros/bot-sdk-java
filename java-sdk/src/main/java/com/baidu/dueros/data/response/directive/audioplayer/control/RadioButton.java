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

public abstract class RadioButton extends BaseButton {

    // 选中的选项值，设备端应该根据此选项值把对应的按钮渲染为选中状态
    protected String selectedValue = "";
    // 控件类型，对于RadioButton按钮而言，控件类型为固定值RADIO_BUTTON
    protected static final String type = "RADIO_BUTTON";

    /**
     * radio button 的默认构造函数
     * 
     * @param name
     *            控件名称
     */
    public RadioButton(String name) {
        super(type, name);
    }

    /**
     * radio button 的构造函数
     * 
     * @param name
     *            控件名称
     * @param selectedValue
     *            选中的选项值，设备端应该根据此选项值把对应的按钮渲染为选中状态
     */
    public RadioButton(String name, String selectedValue) {
        super(type, name);
        this.selectedValue = selectedValue;
    }

    /**
     * 获取控件当前选中的选项值的getter犯法
     * 
     * @return String 选中的选项值
     */
    public String getSelectedValue() {
        return selectedValue;
    }

    /**
     * 设置控件要选中的选项的setter方法
     * 
     * @param selectedValue
     *            要选中的选项值
     */
    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

}
