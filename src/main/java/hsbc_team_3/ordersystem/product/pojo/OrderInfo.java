/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderInfo
 * Author:   ca
 * Date:     2018/8/1 21:52
 * Description: the pojo of order
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/1 21:52     1.0              the pojo of order
 */
package hsbc_team_3.ordersystem.product.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description〈the pojo of order〉
 * @author Chen
 * @create 2018/8/1
 * @since 1.0.0
 */
public class OrderInfo {
//    the id of order
    @JsonProperty("orderId")
    private String orderId;
//    the name of buyer
    @JsonProperty("buyerName")
    private String buyerName;
//    the phone of buyer
    @JsonProperty("buyerPhone")
    private String buyerPhone;
//    the address of buyer
    @JsonProperty("buyerAddress")
    private String buyerAddress;
//    the operid of buyer
    @JsonProperty("buyerOperId")
    private String buyerOperId;
//    the amount of order
    @JsonProperty("orderAmount")
    private int orderAmount;
//    the status of order
    @JsonProperty("orderStatus")
    private int orderStatus;
//    the status of pay
    @JsonProperty("payStatus")
    private int payStatus;
//    the time where be ceated
    @JsonProperty("createTime")
    private Date createTime;
//    the tiem where be update
    @JsonProperty("updateTime")
    private Date updateTime;
//    the list of orderdetail
    @JsonProperty("orderDetailInfoList")
    private List<OrderDetailInfo> orderDetailInfoList;
    /**
        have all arguments constructor
     **/
    public OrderInfo(String orderId, String buyerName, String buyerPhone,
                     String buyerAddress, String buyerOperId, int orderAmount,
                     int orderStatus, int payStatus, Date createTime, 
                     Date updateTime, List<OrderDetailInfo> orderDetailInfoList) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOperId = buyerOperId;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.orderDetailInfoList = orderDetailInfoList;
    }
}