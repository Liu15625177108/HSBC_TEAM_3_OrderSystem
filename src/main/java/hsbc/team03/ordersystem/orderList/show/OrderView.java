package hsbc.team03.ordersystem.orderList.show;

import java.util.Date;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:25
 * Description://订单视图信息, 包含订单日期,订单地址, 订单号, 以及详细订单信息
 */
public class OrderView {

    //订单日期
    private Date orderTime;

    //订单地址
    private String address;

    //订单号
    private String orderId;

    //订单详细信息
    private OrderInfo orderInfo;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
