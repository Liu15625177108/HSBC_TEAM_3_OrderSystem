/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderService
 * Author:   ca
 * Date:     2018/8/2 17:37
 * Description: the interface of orderservice
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:37     1.0              the interface of orderservice
 */
package hsbc.team03.ordersystem.product;

import java.util.List;

/**
 * @description<br>
 * 〈the interface of orderservice〉
 *
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
public interface OrderService {
   /**
    * @Author Chen
    * @Description //TODO To place an order
    * @Date 21:12 2018/8/2
    * @Param [orderInfo]
    * @return Object
    **/
    Object toOrder();
 
    /**
     * @Author Chen
     * @Description //TODO To get all order price
     * @Date 21:12 2018/8/2
     * @Param []
     * @return double
     **/
    double getOrderPrice();
}
 
