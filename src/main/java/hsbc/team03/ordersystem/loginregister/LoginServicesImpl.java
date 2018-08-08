package hsbc.team03.ordersystem.loginregister;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: login service implement
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 10:32:43
 **/
@Service
public class LoginServicesImpl implements LoginServices {

    /**
     * @param : []
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.UserInfo>
     * @Description to get all the user
     */
    @Override
    public List<UserInfo> findAllUser() {
        return null;
    }

    /**
     * @Description to get a user by username
     * @param : [username]
     * @return hsbc.team03.ordersystem.loginregister.UserInfo
     *
     */
    @Override
    public UserInfo findUserByUsername(String username) {
        return null;
    }
}
