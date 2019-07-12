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

package com.baidu.dueros.samples.charge;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.baidu.dueros.bot.BaseBot;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.request.buy.event.BuyEvent;
import com.baidu.dueros.data.request.pay.event.ChargeEvent;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.Reprompt;
import com.baidu.dueros.data.response.OutputSpeech.SpeechType;
import com.baidu.dueros.data.response.card.TextCard;
import com.baidu.dueros.data.response.directive.pay.Buy;
import com.baidu.dueros.data.response.directive.pay.Charge;
import com.baidu.dueros.model.Response;

/**
 * 返回支付相关的例子，继承{@code BaseBot}类
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
public class ChargeBot extends BaseBot {

    protected ChargeBot(HttpServletRequest request) throws IOException {
        super(request);
    }

    protected Response onLaunch(LaunchRequest launchRequest) {

        TextCard textCard = new TextCard("欢迎来到测试支付");
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎来到测试支付");
        // 构造返回的Response
        Response response = new Response(outputSpeech, textCard);
        return response;
    }

    @Override
    protected Response onInent(IntentRequest intentRequest) {
        // 判断NLU解析的意图名称是否匹配 charge
        if ("charge".equals(intentRequest.getIntentName())) {

            // 构造返回的charge指令
            Charge charge = new Charge("0.01", "sellerOrderId", "productName", "description");
            charge.setSellerNote("sellerNote");
            charge.setSellerAuthorizationNote("sellerAuthorizationNote");
            charge.setToken("token");

            // 添加返回的charge指令
            this.addDirective(charge);

            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎购买商品");
            // 构造返回的Response
            Response response = new Response(outputSpeech);
            return response;
        } else if ("buy".equals(intentRequest.getIntentName())) {
            Buy buy = new Buy("token", "productId");
            this.addDirective(buy);
            OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎购买商品");
            // 构造返回的Response
            Response response = new Response(outputSpeech);
            return response;

        }

        return null;
    }

    @Override
    protected Response onChargeEvent(ChargeEvent chargeEvent) {

        // 支付成功后，会收到ChargeEvent事件
        String purchaseResult = chargeEvent.getPurchaseResult();
        // 可以从chargeEvent中获取到对应charge指令的token
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, purchaseResult);
        TextCard textCard = new TextCard(purchaseResult);
        Reprompt reprompt = new Reprompt(outputSpeech);

        Response response = new Response(outputSpeech, textCard, reprompt);

        return response;
    }

    @Override
    protected Response onBuyEvent(final BuyEvent buyEvent) {
        String purchaseResult = buyEvent.getPayload().getPurchaseResult().getPurchaseResult();
        String baiduOrderReferenceId = buyEvent.getPayload().getBaiduOrderReferenceId();
        OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, purchaseResult + baiduOrderReferenceId);

        Response response = new Response(outputSpeech);
        return response;
    }

}
