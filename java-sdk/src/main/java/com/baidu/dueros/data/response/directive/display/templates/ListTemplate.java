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

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 列表模板的基类
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月27日
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = ListTemplate1.class), @Type(value = ListTemplate2.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ListTemplate extends BaseTemplate {
    // 列表项
    private ArrayList<ListItem> listItems = new ArrayList<>();

    /**
     * 构造函数
     */
    public ListTemplate() {
    }

    /**
     * 获取列表项list的getter方法
     * 
     * @return ArrayList 列表项list
     */
    public ArrayList<ListItem> getListItems() {
        return listItems;
    }

    /**
     * 设置列表项列表的setter方法
     * 
     * @param listItems
     *            列表项list
     */
    public void setListItems(ArrayList<ListItem> listItems) {
        this.listItems = listItems;
    }

    /**
     * 添加列表项
     * 
     * @param listItem
     *            添加的列表项
     */
    public void addListItem(ListItem listItem) {
        listItems.add(listItem);
    }
}
