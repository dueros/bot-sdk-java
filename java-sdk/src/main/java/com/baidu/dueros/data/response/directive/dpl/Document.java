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

package com.baidu.dueros.data.response.directive.dpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * DPL Document
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {

    // 指令类型，即"DPL"
    private final String type = "DPL";
    // 指定版本信息
    private String version;
    private long duration;
    // 用户自定义style的属性常量
    private Object resources;
    // 用户自定义styles样式
    private Object styles;
    // 用户自定义的数据部分, 可以在COMPONENT中引用datasource, 引用方式${}
    private Object dataSource;
    // 用户自定义样式
    private Object layouts;
    // 样式解析入口
    private Object mainTemplate;

    public static Document getDocumentFromPath(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String str = new String(data, "UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        Document document = mapper.readValue(str, Document.class);
        return document;
    }

    public static Document getDocumentFromString(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Document document = mapper.readValue(str, Document.class);
        return document;
    }

    public String getVersion() {
        return version;
    }

    public Document setVersion(String version) {
        this.version = version;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public Document setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public Object getResources() {
        return resources;
    }

    public Document setResources(Object resources) {
        this.resources = resources;
        return this;
    }

    public Object getStyles() {
        return styles;
    }

    public Document setStyles(Object styles) {
        this.styles = styles;
        return this;
    }

    public Object getDataSource() {
        return dataSource;
    }

    public Document setDataSource(Object dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public Object getLayouts() {
        return layouts;
    }

    public Document setLayouts(Object layouts) {
        this.layouts = layouts;
        return this;
    }

    public Object getMainTemplate() {
        return mainTemplate;
    }

    public Document setMainTemplate(Object mainTemplate) {
        this.mainTemplate = mainTemplate;
        return this;
    }

    public String getType() {
        return type;
    }

    public class MainTemplate {
        private List<String> parameters;
        private List<Object> items;

        public MainTemplate() {
            parameters = new ArrayList<String>();
            parameters.add("payload");
            items = new ArrayList<Object>();
        }

        public List<String> getParameters() {
            return parameters;
        }

        public void setParameters(List<String> parameters) {
            this.parameters = parameters;
        }

        public void addParameters(String parameter) {
            this.parameters.add(parameter);
        }

        public void addItem(Object object) {
            this.items.add(object);
        }

        public List<Object> getItems() {
            return items;
        }

        public void setItems(List<Object> items) {
            this.items = items;
        }

    }

}
