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

package com.baidu.dueros.samples.permission;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PermissionAction
 */
@WebServlet("/PermissionAction")
public class PermissionAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PermissionAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doHead(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doHead(HttpServletRequest requestm, HttpServletResponse response) {
        response.setStatus(204);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest requestm, HttpServletResponse response) {
        response.setStatus(204);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 根据request创建Bot
        PermissionBot bot;
        try {
            bot = new PermissionBot(request);
            // 线下调试时，可以关闭签名验证
            // bot.enableVerify();
            bot.disableVerify();

            // 调用bot的run方法
            String responseJson = bot.run();
            // 设置response的编码UTF-8
            response.setCharacterEncoding("UTF-8");
            // 返回response
            response.getWriter().append(responseJson);

            // 打开签名验证
            // bot.enableVerify();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append(e.toString());
        }
    }

}
