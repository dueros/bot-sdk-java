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
 * 用户查询的Query
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月4日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {

    // Query类型
    private final Type type;
    // 原始Query
    private final String original;
    // 被改写后的Query
    private final String rewritten;

    /**
     * 返回一个用来构造{@code Query}的{@code Builder}
     * 
     * @return Builder 用来构造{@code Query}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Query类型
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public enum Type {
        // 文本Query，内容为相应的UTF-8文本
        TEXT,
        // 图片Query, 内容为图片链接
        IMAGE,
        // 表情Query, 内容为表情对应的Unicode
        EMOJI,
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param type
     *            Query类型
     * @param original
     *            原始Query
     * @param rewritten
     *            被改写后的Query
     */
    private Query(@JsonProperty("type") final Type type, @JsonProperty("original") final String original,
            @JsonProperty("rewritten") final String rewritten) {
        this.type = type;
        this.original = original;
        this.rewritten = rewritten;
    }

    /**
     * 通过{@code Builder}来构造{@code Query}
     * 
     * @param builder
     *            用来构造{@code Query}
     */
    private Query(final Builder builder) {
        type = builder.type;
        original = builder.original;
        rewritten = builder.rewritten;
    }

    /**
     * 获取type的getter方法
     * 
     * @return Type Query类型
     */
    public Type getType() {
        return type;
    }

    /**
     * 获取original的getter方法
     * 
     * @return String original原始Query
     */
    public String getOriginal() {
        return original;
    }

    /**
     * 获取type的getter方法
     * 
     * @return String rewritten被改写后的Query
     */
    public String getRewritten() {
        return rewritten;
    }

    /**
     * 用来构造{@code Query}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月4日
     */
    public static final class Builder {

        private Type type;
        private String original;
        private String rewritten;

        /**
         * 设置type的setter方法
         * 
         * @param type
         *            Query类型
         * @return Builder 用来构造{@code Query}
         */
        public Builder setType(final Type type) {
            this.type = type;
            return this;
        }

        /**
         * 设置original的setter方法
         * 
         * @param original
         *            原始Query
         * @return Builder 用来构造{@code Query}
         */
        public Builder setOriginal(final String original) {
            this.original = original;
            return this;
        }

        /**
         * 设置rewritten的setter方法
         * 
         * @param rewritten
         *            被改写后的Query
         * @return Builder 用来构造{@code Query}
         */
        public Builder setRewritten(final String rewritten) {
            this.rewritten = rewritten;
            return this;
        }

        /**
         * 调用{@code Query}的私有构造方法构造{@code Query}
         * 
         * @return Query 构造一个Query
         */
        public Query build() {
            return new Query(this);
        }

    }
}
