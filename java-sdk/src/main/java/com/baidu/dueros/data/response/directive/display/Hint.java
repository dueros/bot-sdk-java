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

import java.util.ArrayList;
import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * hint指令
 * 
 * @author hujie08
 * @version 1.0
 * @since 2018年4月26日
 */
@JsonTypeName("Hint")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hint extends Directive {
    // 话术列表
    private ArrayList<HintContent> hints = new ArrayList<>();

    /**
     * 构造函数
     * 
     * @param hints
     *            String话术数组
     */
    public Hint(ArrayList<String> hints) {
        for (String hint : hints) {
            HintContent hintContent = new HintContent(hint);
            this.hints.add(hintContent);
        }
    }

    /**
     * 获取提示话术数组的getter方法
     * 
     * @return ArrayList 话术数组
     */
    public ArrayList<HintContent> getHints() {
        return hints;
    }

    /**
     * 设置提示话术数组的setter方法
     * 
     * @param hints
     *            提示话术数组
     * @return Hint
     */
    public Hint setHints(ArrayList<String> hints) {
        for (String hint : hints) {
            HintContent hintContent = new HintContent(hint);
            this.hints.add(hintContent);
        }
        return this;
    }

    /**
     * 设置提示话术数组的setter方法
     * 
     * @param hint
     *            提示话术
     * @return Hint
     */
    public Hint addHint(String hint) {
        HintContent hintContent = new HintContent(hint);
        hints.add(hintContent);
        return this;
    }
}
