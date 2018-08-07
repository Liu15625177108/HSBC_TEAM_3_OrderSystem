package hsbc.team03.ordersystem.orderList.show;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:25
 * Description://order's information view
 */
public class OrderView {

    @JsonProperty("orderlist")
    private List<OrderInfo> orderInfoList;


    /**
     * @Method get / set
     * @Description //get &&  set method
     * @Author Alan Ruan
     * @Date 2018/08/07 09:37:05
     * @Param []
     */
    public List<OrderInfo> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<OrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }
}
