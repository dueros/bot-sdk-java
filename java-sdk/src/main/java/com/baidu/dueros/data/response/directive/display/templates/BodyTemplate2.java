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
package com.baidu.dueros.data.response.directive.display.templates;

import com.baidu.dueros.data.response.directive.display.templates.TextStructure.TextType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 定义图片文本展现模板，图片在文字内容上方，即上图下文
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月27日
 */
@JsonTypeName("BodyTemplate2")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyTemplate2 extends TextImageTemplate {
    /**
     * 构造函数
     */
    public BodyTemplate2() {
    }

    /**
     * 构造函数
     * 
     * @param title
     *            卡片的标题
     * @param textType
     *            文本结构，支持纯文本和富文本两种格式
     * @param text
     *            文字内容
     */
    public BodyTemplate2(String title, TextType textType, String text) {
        super(title, textType, text);
    }
}
