/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderController
 * Author:   ca
 * Date:     2018/8/1 20:56
 * Description: the controller class of order
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/1 20:56     1.0              the controller class of order
 */
package hsbc_team_3.ordersystem.product.controller;

import hsbc_team_3.ordersystem.product.pojo.OrderInfo;
import hsbc_team_3.ordersystem.product.pojo.StatusInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description〈the controller class of order〉
 * @author Chen
 * @create 2018/8/1
 * @since 1.0.0
 */

@Controller
public class OrderController {
   /**
     * @Author Chen
     * @Description //TODO the method to get orderlist
     * @Date 22:31 2018/8/1
     * @Param []
     * @return StatusInfo type josn
     **/
   @GetMapping(value="/getorderlist")
    public @ResponseBody
    StatusInfo getOrderList(){
        List<OrderInfo> orderInfoList=new ArrayList<>();
        OrderInfo orderInfo1=new OrderInfo("161873371171128075",
                "张三","18869977111",
                "GangDing Station","1212121",
                0,0,0,new Date(),
                new Date(),null);
        OrderInfo orderInfo2=new OrderInfo("161873371171128076",
                "张三","18865577111",
                "Baiyun Station","132222121",
                0,0,0,new Date(),
                new Date(),null);
        orderInfoList.add(orderInfo1);
        orderInfoList.add(orderInfo2);
        StatusInfo statusInfo=new StatusInfo(0,"成功",orderInfoList);
        return  statusInfo;
    }
}