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

public class SellerOrderAttributes {

    // 此笔交易，在商家这边的订单ID。当用户付款成功后，会带有此ID通知技能
    private String sellerOrderId;
    // 商品名称
    private String productName;
    // 商品描述信息。对商品的简单介绍
    private String description;
    // 商品的备注信息
    private String sellerNote;

    /**
     * 构造方法
     */
    public SellerOrderAttributes() {

    }

    /**
     * 默认构造方法
     * 
     * @param sellerOrderId
     *            此笔交易，在商家这边的订单ID
     * @param productName
     *            商品名称
     * @param description
     *            商品描述信息。对商品的简单介绍
     */
    public SellerOrderAttributes(String sellerOrderId, String productName, String description) {
        this.sellerOrderId = sellerOrderId;
        this.productName = productName;
        this.description = description;
    }

    /**
     * 设置订单ID的setter方法
     * 
     * @param sellerOrderId
     *            订单ID
     * @return SellerOrderAttributes
     */
    public SellerOrderAttributes setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    /**
     * 设置商品名称的setter方法
     * 
     * @param productName
     *            商品名称
     * @return SellerOrderAttributes
     */
    public SellerOrderAttributes setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * 设置商品描述信息的setter方法
     * 
     * @param description
     *            商品描述信息
     * @return SellerOrderAttributes
     */
    public SellerOrderAttributes setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 设置商品备注信息的setter方法
     * 
     * @param sellerNote
     *            商品备注信息
     * @return SellerOrderAttributes
     */
    public SellerOrderAttributes setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getProductName() {
        return productName;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * getter方法
     * 
     * @return String
     */
    public String getSellerNote() {
        return sellerNote;
    }

}
