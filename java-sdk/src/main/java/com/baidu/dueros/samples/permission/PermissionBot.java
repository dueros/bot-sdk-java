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

import javax.servlet.http.HttpServletRequest;

import com.baidu.dueros.bot.BaseBot;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.request.permission.event.PermissionGrantFailedEvent;
import com.baidu.dueros.data.request.permission.event.PermissionGrantedEvent;
import com.baidu.dueros.data.request.permission.event.PermissionRejectedEvent;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.OutputSpeech.SpeechType;
import com.baidu.dueros.data.response.card.TextCard;
import com.baidu.dueros.data.response.directive.permission.AskForPermissionsConsent;
import com.baidu.dueros.model.Response;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 返回权限相关的例子，继承{@code BaseBot}类
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class PermissionBot extends BaseBot {

    protected PermissionBot(HttpServletRequest request) throws IOException, JsonMappingException {
        super(request);
    }

    protected Response onLaunch(LaunchRequest launchRequest) {

        TextCard textCard = new TextCard("欢迎来到测试权限");
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎来到测试权限");
        // 构造返回的Response
        Response response = new Response(outputSpeech, textCard);
        return response;
    }

    @Override
    protected Response onInent(IntentRequest intentRequest) {
        // 判断NLU解析的意图名称是否匹配 charge
        if ("permission".equals(intentRequest.getIntentName())) {

            // 构造返回的AskForPermissionsConsent指令
            AskForPermissionsConsent askForPermissionsConsent = new AskForPermissionsConsent();
            askForPermissionsConsent.addPermission("READ::USER:PROFILE");
            askForPermissionsConsent.setToken("12312");
            // 添加返回的charge指令
            this.addDirective(askForPermissionsConsent);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "请授权");
            // 构造返回的Response
            setExpectSpeech(true);
            Response response = new Response(outputSpeech);
            return response;
        }

        return null;
    }

    /**
     * 处理表示用户同意授权事件 对应的事件是：Permission.Granted
     * 
     * @param permissionGrantedEvent
     *            表示用户同意授权
     * @return Response 返回的Response
     */
    @Override
    protected Response onPermissionGrantedEvent(PermissionGrantedEvent permissionGrantedEvent) {
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "授权成功");
        // 构造返回的Response
        setExpectSpeech(true);
        Response response = new Response(outputSpeech);
        return response;
    }

    /**
     * 处理表表示用户同意授权，但是由于其他原因导致授权失败事件 对应的事件是：Permission.Rejected
     * 
     * @param permissionRejectedEvent
     *            表示用户同意授权，但是由于其他原因导致授权失败
     * @return Response 返回的Response
     */
    @Override
    protected Response onPermissionRejectedEvent(PermissionRejectedEvent permissionRejectedEvent) {
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "取消授权");
        // 构造返回的Response
        setExpectSpeech(true);
        Response response = new Response(outputSpeech);
        return response;
    }

    /**
     * 处理表示用户拒绝授权事件 对应的事件是：Permission.GrantFailed
     * 
     * @param permissionGrantFailedEvent
     *            表示用户拒绝授权
     * @return Response 返回的Response
     */
    @Override
    protected Response onPermissionGrantFailedEvent(PermissionGrantFailedEvent permissionGrantFailedEvent) {
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "授权失败");
        // 构造返回的Response
        setExpectSpeech(true);
        Response response = new Response(outputSpeech);
        return response;
    }
}
