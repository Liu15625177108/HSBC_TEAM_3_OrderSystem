package hsbc.team03.ordersystem.loginregister;

import java.util.List;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: login service interface for implement
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 10:32:43
 **/
public interface LoginServices {
    /**
     * @param : []
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.UserInfo>
     * @Description to get the list of all user
     */
    List<UserInfo> findAllUser();

    /**
     * @param : [username]
     * @return hsbc.team03.ordersystem.loginregister.UserInfo
     * @Description to get a user by username
     */
    UserInfo findUserByUsername(String username);
}
