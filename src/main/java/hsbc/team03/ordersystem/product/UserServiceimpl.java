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
package hsbc.team03.ordersystem.product;

import net.bytebuddy.dynamic.TypeResolutionStrategy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description〈the impl of userservice〉
 * @author Chen
 * @create 2018/8/3
 * @since 1.0.0
 */
@Service
public class UserServiceimpl implements  UserService{

    /**
     * @Author Chen
     * @Description //TODO get user money
     * @Date 5:19 2018/8/3
     * @Param [UserInfo userInfo]
     * @return double
     **/
    @Override
    public double getMoney() {
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUserMoney(1000000.0);
        
//        double userMoney = userInfo.getUserMoney();
        return 0;
    }
    /**
     * @Author Chen
     * @Description //TODO To validate paypassword
     * @Date 5:55 2018/8/3
     * @Param [payPassword]
     * @return boolean
     **/
    @Override
    public boolean toValidatePayPassword() {
//        System.out.println(payPassword);
//        userInfo.setPayPassword("123");
        
//        if(payPassword!=null||!payPassword.equals("")){
//            if(payPassword.equals(userInfo.getPayPassword())){
//                return true;
//            }
//            return false;
//        }xxx
        return false;
    }
}