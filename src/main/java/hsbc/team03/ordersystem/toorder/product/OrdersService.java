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
    boolean toOrder(ProductInfo productInfo,UserInfo userInfo);
 
    /**
     * @Author Chen
     * @Description //TODO To get all order price
     * @Date 21:12 2018/8/2
     * @Param [int productNumber,double productPrice]
     * @return double
     **/
    double getOrderPrice(int productNumber,double productPrice );
    
    /**
     * @Author Chen
     * @Description //TODO cancelorder verify time
     * @Date 10:20 2018/8/10
     * @Param [orderId]
     * @return boolean
     **/
    boolean toCancelOrder(String orderId);
    
    /**
     * @Author Chen
     * @Description //TODO  get orderinfo by orderid
     * @Date 10:24 2018/8/10
     * @Param [orderId]
     * @return OrdersInfo
     **/
    OrdersInfo getOrderInfoByOrderId(String orderId);
    
    /**
     * @Author Chen
     * @Description //TODO 
     * @Date 11:36 2018/8/10
     * @Param [orderId]
     * @return boolean
     **/
    boolean updateOrderStatus(String orderId);
    

}
 
