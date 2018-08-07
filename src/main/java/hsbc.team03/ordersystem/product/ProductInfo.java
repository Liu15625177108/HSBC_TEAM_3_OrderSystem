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
package hsbc.team03.ordersystem.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description〈the pojo of Product〉
 * @author Chen
 * @create 2018/8/7
 * @since 1.0.0
 */
@Data
public class ProductInfo {
    /**
     * productId
     */
    @JsonProperty(value = "productid")
    private String productId;
    /**
     * productNumber
     */
    @JsonProperty(value = "prodcutnumber")
    private int prodcutNumber;
    /**
     * productPrice
     */
    @JsonProperty(value = "prodcutprice")
    private double prodcutPrice;
    /**
     * productName
     */
    @JsonProperty(value = "productname")
    private String productName;

    public ProductInfo(String productId, int prodcutNumber, double prodcutPrice, String productName) {
        this.productId = productId;
        this.prodcutNumber = prodcutNumber;
        this.prodcutPrice = prodcutPrice;
        this.productName = productName;
    }
}