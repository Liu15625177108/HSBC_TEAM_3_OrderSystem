/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrdersInfo
 * Author:   ca
 * Date:     2018/8/2 17:36
 * Description: the pojo of order
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:36     1.0              the pojo of order
 */
package hsbc.team03.ordersystem.toorder.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Chen
 * @description〈the pojo of order〉
 * @create 2018/8/2
 * @since 1.0.0
 */
@Data
//@Entity
public class OrdersInfo implements Serializable {
    /**
     * orderid
     */
//    @Id
    @JsonProperty(value = "orderid")
    private String orderId;
    /**
     * productname
     */
//    @Column(nullable = true)
    @JsonProperty(value = "productname")
    private String productName;
    /**
     * productnumber
     */
//    @Column(nullable = true)
    @JsonProperty(value = "productnumber")
    private int productNumber;
    /**
     * username
     */
//    @Column(nullable = true)
    @JsonProperty(value = "username")
    private String userName;
    /**
     * userphone
     */
//    @Column(nullable = true)
    @JsonProperty(value = "userphone")
    private String userPhone;
    /**
     * useraddress
     */
//    @Column(nullable = true)
    @JsonProperty(value = "useraddress")
    private String userAddress;
    /**
     * one product price
     */
//    @Column(nullable = true)
    @JsonProperty(value = "productprice")
    private double productPrice;
    /**
     * the status of order ，1 is open,2 is undetermined,0 is close
     */
//    @Column(nullable = true)
    @JsonProperty(value = "orderstatus")
    private int orderStatus;
    /**
     * the time of to order
     */
//    @Column(nullable = true)
    @JsonProperty(value = "starttime")
    private Date startTime;
    
//    @Column(nullable = true)
    @JsonProperty(value = "totalmoney")
    private double totalMoney;

    public OrdersInfo(String orderId, String productName, int productNumber, String userName,
                      String userPhone, String userAddress, double productPrice, int orderStatus,
                      Date startTime,double totalMoney) {
        this.orderId = orderId;
        this.productName = productName;
        this.productNumber = productNumber;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.productPrice = productPrice;
        this.orderStatus = orderStatus;
        this.startTime = startTime;
        this.totalMoney = totalMoney;
    }


}