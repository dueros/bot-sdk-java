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

package com.baidu.dueros.data.response;

import java.util.HashMap;
import java.util.Map;

/**
 * 会话信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class Session {

    // Bot存储在DuerOS的临时数据，将在Request的session.attributes中被下发至Bot
    private final Map<String, String> attributes = new HashMap<>();

    /**
     * 默认构造方法
     */
    public Session() {

    }

    /**
     * 获取attributes的getter方法
     * 
     * @return attributes 获取attributes
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

}
