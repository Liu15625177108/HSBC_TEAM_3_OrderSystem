package hsbc.team03.ordersystem.loginregister.services;

import hsbc.team03.ordersystem.loginregister.pojo.UserInfo;
import hsbc.team03.ordersystem.loginregister.repo.UserInfoRepository;
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

    private UserInfoRepository userInfoRepository;

    /**
     * @param : []
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.pojo.UserInfo>
     * @Description to get all user implement
     */
    @Override
    public List<UserInfo> findAllUser() {
        return userInfoRepository.getAllUserInfo();
    }

    /**
     * @Description to get user by username
     * @param : [username]
     * @return java.util.List<hsbc.team03.ordersystem.loginregister.pojo.UserInfo>
     *
     */
    @Override
    public UserInfo findUserByUsername(String username) {
        return userInfoRepository.getUserInfoByName(username);
    }

    /**
     * @Description
     * @param : [userInfo]
     * @return boolean
     *
     */
    @Override
    public boolean addUser(UserInfo userInfo) {
        return userInfoRepository.addUserInfo(userInfo);
    }

}
