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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListItemWithListTemplate4 {

    // 唯一标识当前元素
    private String token;
    // 文本内容
    private TextStructure content = new TextStructure();

    // 图片
    private ImageStructure image;
    // anchorWord
    private String anchorWord;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TextStructure getContent() {
        return content;
    }

    public void setContent(TextStructure content) {
        this.content = content;
    }

    public ListItemWithListTemplate4 setAnchorWord(String anchorWord) {
        this.anchorWord = anchorWord;
        return this;
    }

    public ListItemWithListTemplate4 setImage(ImageStructure image) {
        this.image = image;
        return this;
    }

    public String getAnchorWord() {
        return anchorWord;
    }

    public ImageStructure getImage() {
        return image;
    }
}
