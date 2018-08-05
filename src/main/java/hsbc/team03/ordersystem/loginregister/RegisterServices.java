package hsbc.team03.ordersystem.loginregister;

import java.util.List;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: register service interface
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 10:32:43
 **/
public interface RegisterServices {
    /**
     * @param : []
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.UserInfo>
     * @Description to get all the user
     */
    List<UserInfo> findAllUser();

    /**
     * @param : [username]
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.UserInfo>
     * @Description to get user by username
     */
    List<UserInfo> findUserByUsername(String username);

    /**
     * @param : [userInfo]
     * @return boolean
     * @Description to add a user
     */
    boolean addUser(UserInfo userInfo);
}
