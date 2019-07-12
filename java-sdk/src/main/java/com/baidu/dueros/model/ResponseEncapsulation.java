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

package com.baidu.dueros.model;

import com.baidu.dueros.data.response.Context;
import com.baidu.dueros.data.response.ResponseBody;
import com.baidu.dueros.data.response.Session;

/**
 * Bot响应DuerOS的Response信息
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class ResponseEncapsulation {

    // 版本信息
    private static final String version = "2.0";
    // 反馈给DuerOS的意图信息
    private Context context;
    // 会话信息
    private Session session;
    // 响应数据
    private ResponseBody response;

    /**
     * 默认构造方法
     */
    public ResponseEncapsulation() {

    }

    public ResponseEncapsulation(ResponseBody responseBody) {
        response = responseBody;
    }

    /**
     * 构造方法
     * 
     * @param context
     *            反馈给DuerOS的意图信息
     * @param session
     *            会话信息
     * @param responseBody
     *            响应数据
     */
    public ResponseEncapsulation(final Context context, final Session session, final ResponseBody responseBody) {
        this.context = context;
        this.session = session;
        this.response = responseBody;
    }

    /**
     * 获取版本信息
     * 
     * @return String 版本信息
     */
    public String getVersion() {
        return version;
    }

    /**
     * 获取反馈给DuerOS的意图信息
     * 
     * @return Context 反馈给DuerOS的意图信息
     */
    public Context getContext() {
        return context;
    }

    /**
     * 设置反馈给DuerOS的意图信息
     * 
     * @param context
     *            反馈给DuerOS的意图信息
     */
    public void setContext(final Context context) {
        this.context = context;
    }

    /**
     * 获取会话信息
     * 
     * @return Session 会话信息
     */
    public Session getSession() {
        return session;
    }

    /**
     * 设置会话信息
     * 
     * @param session
     *            会话信息
     */
    public void setSession(final Session session) {
        this.session = session;
    }

    /**
     * 获取响应数据
     * 
     * @return ResponseBody 响应数据
     */
    public ResponseBody getResponse() {
        return response;
    }

    /**
     * 设置响应数据
     * 
     * @param response
     *            响应数据
     */
    public void setResponse(final ResponseBody response) {
        this.response = response;
    }

}
