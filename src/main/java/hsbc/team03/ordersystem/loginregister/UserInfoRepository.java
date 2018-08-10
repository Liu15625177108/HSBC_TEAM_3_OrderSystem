package hsbc.team03.ordersystem.loginregister;


import java.util.ArrayList;

/**
 * @author : Jeff.Li
 * @Package: hsbc.team03.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: user info dao
 * @date : 2018年08月10日 09:40:01
 **/
public interface UserInfoRepository {

    boolean addUserInfo(UserInfo userInfo);

    boolean deleteUserInfo(UserInfo userInfo);

    boolean updateUserInfo(UserInfo userInfo);

    ArrayList<UserInfo> getAllUserInfo();

    UserInfo getUserInfoByName(String username);

    UserInfo getUserInfoById(String id);
}
