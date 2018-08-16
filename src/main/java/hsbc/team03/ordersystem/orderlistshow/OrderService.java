package hsbc.team03.ordersystem.orderlistshow;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:30
 * Description://order service, including findAllOrder method
 */
public interface OrderService {

    /**
     * @Method findAllOrder
     * @Description // show all order
     * @Author Alan Ruan
     * @Date 2018/08/07 09:34:43
     * @Param []
     * @Return java.util.List<OrderInfo>
     */
    List<OrderInfo> findAllOrder();

    /**
     * @Method sortAllOrder
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/08/16 10:19:20
     * @Param []
     * @Return java.util.List<hsbc.team03.ordersystem.orderlistshow.OrderInfo>
     */
    List<OrderInfo> sortAllOrder();

    /**
     * @Method showOrderByUserId
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/08/16 10:21:44
     * @Param [userId]
     * @Return hsbc.team03.ordersystem.orderlistshow.OrderInfo
     */
    OrderInfo showOrderByUserId(String orderId);

    /**
     * @Method matchOrderByUserId
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/08/16 10:45:07
     * @Param [orderId]
     * @Return hsbc.team03.ordersystem.orderlistshow.OrderInfo
     */
    OrderInfo matchOrderByUserId(String orderId);
}
