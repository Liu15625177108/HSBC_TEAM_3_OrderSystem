package hsbc.team03.ordersystem.loginregister.repo;


import hsbc.team03.ordersystem.loginregister.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author : Jeff.Li
 * @Package: hsbc.team03.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: user info dao
 * @date : 2018年08月10日 09:40:01
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {


    /**
     * to add a user information
     *
     * @param userInfo user information
     * @return boolean
     */
    boolean addUserInfo(UserInfo userInfo);

    /**
     * @param userInfo user information
     * @return boolean
     * @Description
     */
    boolean deleteUserInfo(UserInfo userInfo);

    boolean updateUserInfo(UserInfo userInfo);

    ArrayList<UserInfo> getAllUserInfo();

    UserInfo getUserInfoByName(String username);

    UserInfo getUserInfoById(String id);
}
