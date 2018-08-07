package hsbc.team03.ordersystem.orderList.show;

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
     * @Return java.util.List<hsbc.team03.ordersystem.orderList.show.OrderInfo>
     */
    List<OrderInfo> findAllOrder();

}
