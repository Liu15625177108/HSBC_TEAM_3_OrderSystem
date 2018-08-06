/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderInfo
 * Author:   ca
 * Date:     2018/8/2 17:36
 * Description: the pojo of order
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:36     1.0              the pojo of order
 */
package hsbc.team03.ordersystem.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description〈the pojo of order〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
@Data
public class OrderInfo implements Serializable {
    /**
     * orderid
     */
    @JsonProperty(value = "orderid")
    private String orderId;
    /**
     * productname
     */
    @JsonProperty(value = "productname")
    private String productName;
    /**
     * productnumber
     */
    @JsonProperty(value = "productnumber")
    private int productNumber;
    /**
     * username
     */
    @JsonProperty(value = "username")
    private String userName;
    /**
     * userphone
     */
    @JsonProperty(value = "userphone")
    private String userPhone;
    /**
     * useraddress
     */
    @JsonProperty(value = "useraddress")
    private String userAddress;
    /**
     * one product price
     */
    @JsonProperty(value = "productprice")
    private double productPrice;
    
    public OrderInfo(String orderId, String productName, int productNumber, String userName,
                     String userPhone, String userAddress, double productPrice) {
        this.orderId = orderId;
        this.productName = productName;
        this.productNumber = productNumber;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.productPrice=productPrice;
    }


}