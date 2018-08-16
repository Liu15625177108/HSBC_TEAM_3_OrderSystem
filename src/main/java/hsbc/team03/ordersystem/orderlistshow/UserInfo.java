package hsbc.team03.ordersystem.orderlistshow;

import lombok.Getter;
import lombok.Setter;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderlistshow
 * Author:Alan Ruan
 * Date:2018-08-16 10:36
 * Description://TODO
 */
public class UserInfo {

    @Getter
    @Setter
    private String userId;
    private String userName;

    public UserInfo(){}

    public UserInfo(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }
}
