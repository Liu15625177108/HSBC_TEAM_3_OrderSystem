package hsbc.team03.ordersystem.orderList.show;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:30
 * Description://TODO
 */
public interface OrderService {

    //列出所有订单
    List<OrderView> findAllOrder();

}
