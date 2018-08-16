package hsbc.team03.ordersystem.orderlistshow;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:30
 * Description://
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public List<OrderInfo> findAllOrder() {
        return null;
    }

    @Override
    public List<OrderInfo> sortAllOrder(){return this.findAllOrder();}

    @Override
    public OrderInfo showOrderByUserId(String orderId){
        return this.matchOrderByUserId(orderId);
    }

    @Override
    public OrderInfo matchOrderByUserId(String orderId){
        for (OrderInfo x:this.findAllOrder()){
            if (x.getOrderId() == orderId){
                return x;
            }
        }
        return null;
    }

}
