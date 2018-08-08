package hsbc.team03.ordersystem.orderlistshow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.orderList
 * Author:Alan Ruan
 * Date:2018-08-03 17:30
 * Description:// Order‘s information
 */
public class OrderInfo {


    //Consumer's Name
    @JsonProperty("ConsumerName")
    private String consumerName;

    //Product's Name
    @JsonProperty("ProductName")
    private String productName;

    //Product’s Number
    @JsonProperty("ProductNum")
    private int productNum;

    //Order's address
    @JsonProperty("Address")
    private String address;

    //order's id
    @JsonProperty("OrderId")
    private String orderId;

    //order time
    @JsonProperty("OrderTime")
    private Date orderTime;

    /**
     * @Method set  &&   get  method
     * @Description //  set/get method
     * @Author Alan Ruan
     * @Date 2018/08/07 09:33:29
     * @Param []
     * @Return void
     */

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

    public String getProductName() {
        return productName;
    }

    public String getOrderId() {
        return orderId;

    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getAddress() {
        return address;
    }

    public int getProductNum() {
        return productNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }
}
