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

package com.baidu.dueros.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * HTTP响应数据
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpBody {

    // HTTP响应数据(data)的类型
    private final String dataType;
    // HTTP响应数据内容
    private final String data;

    /**
     * 返回一个用来构造{@code HttpBody}的{@code Builder}
     * 
     * @return Builder 用来构造{@code HttpBody}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param dataType
     *            HTTP响应数据(data)的类型
     * @param data
     *            HTTP响应数据内容
     */
    private HttpBody(@JsonProperty("dataType") final String dataType, @JsonProperty("data") final String data) {
        this.dataType = dataType;
        this.data = data;
    }

    /**
     * 通过{@code Builder}来构造{@code HttpBody}
     * 
     * @param builder
     *            用来构造{@code HttpBody}
     */
    private HttpBody(final Builder builder) {
        dataType = builder.dataType;
        data = builder.data;
    }

    /**
     * 获取dataType的getter方法
     * 
     * @return String dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 获取data的getter方法
     * 
     * @return String data
     */
    public String getData() {
        return data;
    }

    /**
     * 用来构造{@code HttpBody}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        // HTTP响应数据(data)的类型
        private String dataType;
        // HTTP响应数据内容
        private String data;

        /**
         * 设置dataType的setter方法
         * 
         * @param dataType
         *            HTTP响应数据(data)的类型
         * @return Builder 用来构造{@code HttpBody}
         */
        public Builder setDataType(final String dataType) {
            this.dataType = dataType;
            return this;
        }

        /**
         * 设置data的setter方法
         * 
         * @param data
         *            HTTP响应数据内容
         * @return Builder 用来构造{@code HttpBody}
         */
        public Builder setData(final String data) {
            this.data = data;
            return this;
        }

        /**
         * 调用{@code HttpBody}的私有构造方法构造{@code HttpBody}
         * 
         * @return HttpBody 构造一个{@code HttpBody}
         */
        public HttpBody build() {
            return new HttpBody(this);
        }
    }

}
