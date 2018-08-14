/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderServiceImpl
 * Author:   ca
 * Date:     2018/8/2 17:36
 * Description: the impl of orderservice
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:36     1.0              the impl of orderservice
 */
package hsbc.team03.ordersystem.toorder.product;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description〈the impl of orderservice〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {


//    @Autowired
//    private OrdersRepository ordersRepository;

//    @Autowired
//    private UserRepository userRepository;

    /**
     * @Author Chen
     * @Description //TODO TO place the order
     * @Date 5:53 2018/8/3
     * @Param [ProductInfo productInfo,UserInfo userInfo]
     * @return java.lang.Object
     **/
    @Override

    public boolean insertOrder(ProductInfo productInfo, UserInfo userInfo) {
        return true;

    }
    /**
     * @Author Chen
     * @Description //TODO To get orderprice
     * @Date 5:54 2018/8/3
     * @Param [int productNumber,double productPrice]
     * @return double
     **/
    @Override
    public double getOrderPrice(int productNumber,double productPrice) {

        double orderPice=productNumber*productPrice;
        return orderPice;
    }

    /**
     * @return boolean
     * @Author Chen
     * @Description //TODO
     * @Date 10:21 2018/8/10
     * @Param [orderId]
     **/
    @Override
    public boolean determineTime(String orderId) {
        OrdersInfo orderInfo = getOrderInfoByOrderId(orderId);
        Date date = new Date();
        Date date1 = new Date(date.getTime() - 7 * 60 * 60 * 1000);
        System.out.println(date1 + "@111111");
        if (date1.before(orderInfo.getStartTime())) {
            return true;
        }
        return false;
    }

    /**
     * @return hsbc.team03.ordersystem.toorder.product.OrderInfo
     * @Author Chen
     * @Description //TODO get orderInfo by orderid
     * @Date 11:38 2018/8/10
     * @Param [orderId]
     **/
    @Override
    public OrdersInfo getOrderInfoByOrderId(String orderId) {
        return null;
    }

    /**
     * @return boolean
     * @Author Chen
     * @Description //TODO update OrderStatus to 2
     * @Date 11:39 2018/8/10
     * @Param [OrderId]
     **/
    @Override
    public boolean updateOrderStatus(String orderId) {
        return false;
    }


}