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
package com.baidu.dueros.data.response.directive.display;

import com.baidu.dueros.data.response.directive.Directive;
import com.baidu.dueros.data.response.directive.display.templates.BaseTemplate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * RenderTemplate(模板渲染)指令
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年4月26日
 */
@JsonTypeName("Display.RenderTemplate")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RenderTemplate extends Directive {
    // 模板
    private BaseTemplate template;

    /**
     * 默认构造函数
     */
    public RenderTemplate() {
        super();
    }

    /**
     * 构造函数
     * 
     * @param template
     *            模板
     */
    public RenderTemplate(BaseTemplate template) {
        super();
        this.template = template;
    }

    /**
     * 获取模板的getter方法
     * 
     * @return BaseTemplate 模板
     */
    public BaseTemplate getTemplate() {
        return template;
    }

    /**
     * 设置模板列表的setter方法
     * 
     * @param template
     *            模板
     */
    public void setTemplate(BaseTemplate template) {
        this.template = template;
    }

}
