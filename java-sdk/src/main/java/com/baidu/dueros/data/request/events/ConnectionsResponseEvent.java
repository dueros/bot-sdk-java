package com.baidu.dueros.data.request.events;

import com.baidu.dueros.data.request.RequestBody;
import com.baidu.dueros.data.request.pay.event.ChargeEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeName("Connections.Response")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({ @Type(value = ChargeEvent.class), @Type(value = LinkAccountSucceededEvent.class) })
public class ConnectionsResponseEvent extends RequestBody {

    // 请求的动作
    private String name;
    // 对应支付指令的token
    private String token;

    /**
     * 返回一个用来构造{@code ConnectionsResponseEvent}的{@code Builder}
     * 
     * @return Builder 用来构造{@code ConnectionsResponseEvent}
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 通过{@code Builder}来构造{@code ConnectionsResponseEvent}
     * 
     * @param builder
     *            用来构造{@code ConnectionsResponseEvent}
     */
    protected ConnectionsResponseEvent(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.token = builder.token;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            requestId
     * @param timestamp
     *            timestamp
     * @param dialogRequestId
     *            dialogRequestId
     * @param name
     *            name
     * @param token
     *            token
     */
    protected ConnectionsResponseEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("name") final String name,
            @JsonProperty("token") final String token) {
        super(requestId, timestamp, dialogRequestId);
        this.name = name;
        this.token = token;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String token
     */
    public String getName() {
        return name;
    }

    /**
     * 获取token的getter方法
     * 
     * @return String token
     */
    public String getToken() {
        return token;
    }

    /**
     * 用来构造{@code ConnectionsResponseEvent}
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version V1.0
     * @since 2018年5月3日
     */
    public static class Builder extends RequestBodyBuilder<Builder, ConnectionsResponseEvent> {

        public String name;
        public String token;
        public String type;

        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setType(final String type) {
            this.type = type;
            return this;
        }

        @Override
        public ConnectionsResponseEvent build() {
            return new ConnectionsResponseEvent(this);
        }

    }

}
