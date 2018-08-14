package hsbc.team03.ordersystem.loginregister.services;

import hsbc.team03.ordersystem.loginregister.pojo.UserInfo;
import hsbc.team03.ordersystem.loginregister.repo.UserInfoRepository;
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

    private UserInfoRepository userInfoRepository;

    /**
     * @param : []
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.pojo.UserInfo>
     * @Description to get all the user
     */
    @Override
    public List<UserInfo> findAllUser() {
        return null;
    }

    /**
     * @Description to get a user by username
     * @param : [username]
     * @return hsbc.team03.ordersystem.loginregister.pojo.UserInfo
     *
     */
    @Override
    public UserInfo findUserByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("ljf");
        userInfo.setPassword("123456");
        userInfo.setUserId("111");
        return userInfo;
    }
}
