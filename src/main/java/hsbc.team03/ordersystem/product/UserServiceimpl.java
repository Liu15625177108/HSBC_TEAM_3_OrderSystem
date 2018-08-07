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
import org.apache.catalina.User;
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
     * @Description //TODO To validate paypassword
     * @Date 5:55 2018/8/3
     * @Param [UserInfo userInfo,String payPassword]
     * @return boolean
     **/
    @Override
    public boolean toValidatePayPassword(UserInfo userInfo,String payPassword) {

        if(payPassword!=null||!payPassword.equals(" ")){
           if(payPassword.equals(userInfo.getPayPassword())){
                return true;
            }
            return false;
        }
        return false;
    }
}