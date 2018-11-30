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

package com.baidu.dueros.data.request.audioplayer.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    private String type;
    private String message;

    public static Builder newBuilder() {
        return new Builder();
    }

    public Error(Builder builder) {
        type = builder.type;
        message = builder.message;
    }

    public Error(@JsonProperty("type") final String type, @JsonProperty("message") final String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public static final class Builder {

        private String type;
        private String message;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Error build() {
            return new Error(this);
        }
    }
}
