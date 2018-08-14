/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: ProductInfo
 * Author:   ca
 * Date:     2018/8/7 9:43
 * Description: the pojo of Product
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/7 9:43     1.0              the pojo of Product
 */
package hsbc.team03.ordersystem.toorder.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description〈the pojo of Product〉
 * @author Chen
 * @create 2018/8/7
 * @since 1.0.0
 */
//@Entity
@Data
public class ProductInfo {
    /**
     * productId
     */
//    @Id
    @JsonProperty(value = "productid")
    private String productId;
    /**
     * productNumber
     */
    @JsonProperty(value = "productnumber")
    private int productNumber;
    /**
     * productPrice
     */
    @JsonProperty(value = "productprice")
    private double productPrice;
    /**
     * productName
     */
    @JsonProperty(value = "productname")
    private String productName;

    public ProductInfo(String productId, int productNumber, double productPrice, String productName) {
        this.productId = productId;
        this.productNumber = productNumber;
        this.productPrice = productPrice;
        this.productName = productName;
    }
}