/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderView
 * Author:   ca
 * Date:     2018/8/13 10:36
 * Description: the view
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/13 10:36     1.0              the view
 */
package hsbc.team03.ordersystem.toorder.result;

import hsbc.team03.ordersystem.toorder.commonsutils.CommonsUtils;
import hsbc.team03.ordersystem.toorder.commonsutils.DataUtils;
import hsbc.team03.ordersystem.toorder.product.OrdersInfo;
import hsbc.team03.ordersystem.toorder.product.ProductInfo;
import hsbc.team03.ordersystem.toorder.product.UserInfo;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description〈the view〉
 * @author Chen
 * @create 2018/8/13
 * @since 1.0.0
 */
@Component
public class OrderView {
    
    /**
     * @Author Chen
     * @Description //TODO  get orderInfo
     * @Date 11:28 2018/8/15
     * @Param [productInfo, userInfo]
     * @return hsbc.team03.ordersystem.toorder.product.OrdersInfo
     **/
    public OrdersInfo getOrderInfo(ProductInfo productInfo, UserInfo userInfo){
        OrdersInfo orderInfo=new OrdersInfo(CommonsUtils.getUUID(),productInfo.getProductName(),
                productInfo.getProductNumber(),userInfo.getUserName(),userInfo.getUserPhone(),
                userInfo.getUserAddress(),productInfo.getProductPrice(),1, DataUtils.getCurrentTime(),
                productInfo.getProductNumber()*productInfo.getProductPrice());
        return  orderInfo;
    }
}