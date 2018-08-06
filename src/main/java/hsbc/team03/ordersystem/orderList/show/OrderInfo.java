package hsbc.team03.ordersystem.orderList.show;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.orderList
 * Author:Alan Ruan
 * Date:2018-08-03 17:30
 * Description:// 订单中的详细信息
 */
public class OrderInfo {

    //顾客姓名
    @JsonProperty("ConsumerName")
    private String consumerName;

    //商品名称
    @JsonProperty("ProductName")
    private String productName;

    //商品数量
    @JsonProperty("ProductNum")
    private int productNum;

    //订单日期
    @JsonProperty("OrderTime")
    private Date orderTime;

    //订单地址
    @JsonProperty("Address")
    private String address;

    //订单号
    @JsonProperty("OrderId")
    private String orderId;


    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public int getProductNum() {
        return productNum;
    }

    public String getAddress() {
        return address;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }
}
