package hsbc.team03.ordersystem.orderList.show;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:25
 * Description://订单视图信息, 包含订单日期,订单地址, 订单号, 以及详细订单信息
 */
public class OrderView {

    @JsonProperty("Order")
    private List<OrderInfo> orderInfoList;

    public void setOrderInfoList(List<OrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }

    public List<OrderInfo> getOrderInfoList() {
        return orderInfoList;
    }
}
