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

import hsbc.team03.ordersystem.toorder.commonsutils.CommonsUtils;
import hsbc.team03.ordersystem.toorder.commonsutils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Chen
 * @description〈the impl of orderservice〉
 * @create 2018/8/2
 * @since 1.0.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * @return java.lang.Object
     * @Author Chen
     * @Description //TODO TO place the order
     * @Date 5:53 2018/8/3
     * @Param [ProductInfo productInfo,UserInfo userInfo]
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized  boolean insertOrder(ProductInfo productInfo, UserInfo userInfo) {
            OrdersInfo ordersInfo = new OrdersInfo(CommonsUtils.getUUID(), productInfo.getProductName(),
                    productInfo.getProductNumber(), userInfo.getUserName(), userInfo.getUserPhone(),
                    userInfo.getUserAddress(), productInfo.getProductPrice(), 1,
                    DataUtils.getCurrentTime(), getOrderPrice(productInfo));
            ordersRepository.save(ordersInfo);
            double userMoney = userInfo.getUserMoney() - getOrderPrice(productInfo);
//        int i=1/0;
            //to reduce money
            userRepository.updateUserInfoByUserId(userInfo.getUserId(), userMoney);
        return true;
    }

    /**
     * @return double
     * @Author Chen
     * @Description //TODO To get orderprice
     * @Date 5:54 2018/8/3
     * @Param [int productNumber,double productPrice]
     **/
    @Override
    public double getOrderPrice(ProductInfo productInfo) {
        double orderPice = productInfo.getProductNumber() * productInfo.getProductPrice();
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
        OrdersInfo ordersInfo = ordersRepository.findByorderId(orderId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            //get order time
            Date date = simpleDateFormat.parse(ordersInfo.getStartTime());
            //get current time to reduce 7 days
            Date nowDate = new Date();
            Date beforeDate = new Date(nowDate.getTime() - (long)7 * 24 * 60 * 60 * 1000);
            if (beforeDate.before(date)) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @return hsbc.team03.ordersystem.toorder.product.OrdersInfo
     * @Author Chen
     * @Description //TODO get orderInfo by orderid
     * @Date 11:38 2018/8/10
     * @Param [orderId]
     **/
    @Override
    public OrdersInfo getOrderInfoByOrderId(String orderId) {
        return ordersRepository.findByorderId(orderId);
    }

    /**
     * @return boolean
     * @Author Chen
     * @Description //TODO update OrderStatus to 2 and rollback money when cancel order
     * @Date 11:39 2018/8/10
     * @Param [OrderId]
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateOrderStatus(String orderId) {
        OrdersInfo ordersInfo=ordersRepository.findByorderId(orderId);
        ordersInfo.setOrderStatus(2);
        ordersRepository.save(ordersInfo);
        //get userinfo by username in order to rollback money
        UserInfo userInfo=userRepository.findByUserName(ordersInfo.getUserName());
        double nowMoney=userInfo.getUserMoney();
        userInfo.setUserMoney(nowMoney+ordersInfo.getTotalMoney());
        userRepository.save(userInfo);
        return false;
    }

}