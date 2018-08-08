/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrdersService
 * Author:   ca
 * Date:     2018/8/2 17:37
 * Description: the interface of orderservice
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:37     1.0              the interface of orderservice
 */
package hsbc.team03.ordersystem.toorder.product;

/**
 * @description<br>
 * 〈the interface of orderservice〉
 *
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
public interface OrdersService {
   /**
    * @Author Chen
    * @Description //TODO To place an order
    * @Date 21:12 2018/8/2
    * @Param [ProductInfo productInfo,UserInfo userInfo]
    * @return Object
    **/
    Object toOrder(ProductInfo productInfo, UserInfo userInfo);
 
    /**
     * @Author Chen
     * @Description //TODO To get all order price
     * @Date 21:12 2018/8/2
     * @Param [int productNumber,double productPrice]
     * @return double
     **/
    double getOrderPrice(int productNumber, double productPrice);
}
 
