package hsbc.team03.ordersystem.loginregister;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: register service implement
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 10:36:04
 **/
@Service
public class RegisterServicesImpl implements RegisterServices {

    /**
     * @param : []
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.UserInfo>
     * @Description to get all user implement
     */
    @Override
    public List<UserInfo> findAllUser() {
        return null;
    }

    /**
     * @Description to get user by username
     * @param : [username]
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.UserInfo>
     *
     */
    @Override
    public UserInfo findUserByUsername(String username) {
        return null;
    }

    /**
     * @Description
     * @param : [userInfo]
     * @return boolean
     *
     */
    @Override
    public boolean addUser(UserInfo userInfo) {
        return false;
    }

}
