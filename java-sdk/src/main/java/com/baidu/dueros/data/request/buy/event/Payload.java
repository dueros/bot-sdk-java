package com.baidu.dueros.data.request.buy.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {
    // 此次交易百度生成的订单ID
    private String baiduOrderReferenceId;
    // 此次支付结果
    private PurchaseResult purchaseResult;
    // 支付状态对应的信息
    private String message;

    public Payload(@JsonProperty("baiduOrderReferenceId") final String baiduOrderReferenceId,
            @JsonProperty("PurchaseResult") final PurchaseResult purchaseResult,
            @JsonProperty("message") final String message) {
        this.baiduOrderReferenceId = baiduOrderReferenceId;
        this.purchaseResult = purchaseResult;
        this.message = message;
    }

    public String getBaiduOrderReferenceId() {
        return baiduOrderReferenceId;
    }

    public void setBaiduOrderReferenceId(String baiduOrderReferenceId) {
        this.baiduOrderReferenceId = baiduOrderReferenceId;
    }

    public PurchaseResult getPurchaseResult() {
        return purchaseResult;
    }

    public void setPurchaseResult(PurchaseResult purchaseResult) {
        this.purchaseResult = purchaseResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public enum PurchaseResult {
        // 支付成功
        SUCCESS("SUCCESS"),
        // 内部错误
        ERROR_SERVER("ERROR_SERVER"),
        // 商品不存在
        ERROR_PRODUCT_NOT_EXIST("ERROR_PRODUCT_NOT_EXIST"),
        // 商品未发布上线，不允许购买
        ERROR_PRODUCT_NOT_PUBLISHED("ERROR_PRODUCT_NOT_PUBLISHED"),
        // 用户之前已购买过，无需再次购买
        ERROR_REPEAT_PURCHASE("ERROR_REPEAT_PURCHASE");

        private String purchaseResult;

        private PurchaseResult(String purchaseResult) {
            this.purchaseResult = purchaseResult;
        }

        public String getPurchaseResult() {
            return purchaseResult;
        }

        public void setPurchaseResult(String purchaseResult) {
            this.purchaseResult = purchaseResult;
        }
    }

}