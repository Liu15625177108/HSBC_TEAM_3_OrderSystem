/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: UserServiceimpl
 * Author:   ca
 * Date:     2018/8/3 5:14
 * Description: the impl
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/3 5:14     1.0              the impl
 */
package hsbc.team03.ordersystem.toorder.product;

import org.springframework.stereotype.Service;

/**
 * @author Chen
 * @description〈the impl of userservice〉
 * @create 2018/8/3
 * @since 1.0.0
 */
@Service
public class UserServiceimpl implements UserService {

//    @Autowired
//    private UserRepository userRepository;
//    
//    @Autowired
//    private OrdersRepository ordersRepository;

    @Override
    public boolean toValidateMoney(UserInfo userInfo, ProductInfo productInfo) {
        if(userInfo.getUserMoney() >productInfo.getProductNumber()*productInfo.getProductPrice()){
            return true;
        }
        return false;
    }

    /**
     * @return boolean
     * @Author Chen
     * @Description //TODO To validate paypassword
     * @Date 5:55 2018/8/3
     * @Param [UserInfo userInfo,String payPassword]
     **/
    @Override
    public boolean toValidatePayPassword(UserInfo userInfo, String payPassword) {

        if (payPassword != null || !payPassword.equals(" ")) {
            if (payPassword.equals(userInfo.getPayPassword())) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * @Author Chen
     * @Description //TODO to get userinfo by userid
     * @Date 12:38 2018/8/9
     * @Param [userId]
     * @return UserInfo
     **/
    @Override
    public UserInfo getUserInfoByUserId(String userId) {
            UserInfo userInfo =new UserInfo(userId,"Chen",10000000.0,"123","13244444444","岗顶");
            return userInfo;

    }
}