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

package com.baidu.dueros.data.response.directive.pay;

import java.util.UUID;

import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 如果开发者选择在DuerOS商品库中注册商品，则可以使用本指令发起支付扣款
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月5日
 */
@JsonTypeName("Connections.SendRequest.Buy")
public class Buy extends Directive {
    private String token;
    private Payload payload;

    public Buy(String productId) {
        this.payload = new Payload(productId);
        token = UUID.randomUUID().toString();
    }

    public Buy(String productId, String token) {
        this.payload = new Payload(productId);
        this.token = token;
    }

    public Buy(String token, Payload payload) {
        this.payload = payload;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload {
        private String productId;

        public Payload(String productId) {
            this.productId = productId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

    }
}
