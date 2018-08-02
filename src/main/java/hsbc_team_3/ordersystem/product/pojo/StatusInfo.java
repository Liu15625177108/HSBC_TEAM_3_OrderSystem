/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: StatusInfo
 * Author:   ca
 * Date:     2018/8/1 22:01
 * Description: the pojo of status
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/1 22:01     1.0              the pojo of status
 */
package hsbc_team_3.ordersystem.product.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @description〈the pojo of status〉
 * @author Chen
 * @create 2018/8/1
 * @since 1.0.0
 */
public class StatusInfo {
//    the codeid
    @JsonProperty("code")
    private int code;
//    the msg to remind
    @JsonProperty("msg")
    private String msg;
//    the list of orderinfo
    @JsonProperty("data")
    private List<OrderInfo> orderInfoList;
    /**
     have all arguments constructor
     **/
    public StatusInfo(int code, String msg, List<OrderInfo> orderInfoList) {
        this.code = code;
        this.msg = msg;
        this.orderInfoList = orderInfoList;
    }
}