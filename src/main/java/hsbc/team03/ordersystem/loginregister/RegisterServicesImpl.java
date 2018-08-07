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
    @Override
    public List<UserInfo> findAllUser() {
        return null;
    }

    @Override
    public List<UserInfo> findUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean addUser(UserInfo userInfo) {
        return false;
    }

}
