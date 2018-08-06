/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: UserService
 * Author:   ca
 * Date:     2018/8/3 5:11
 * Description: the service of user
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/3 5:11     1.0              the service of user
 */
package hsbc.team03.ordersystem.product;

/**
 * @description<br>
 * 〈the service of user〉
 *
 * @author Chen
 * @create 2018/8/3
 * @since 1.0.0
 */
public interface UserService {
    
    /**
     * @Author Chen
     * @Description //TODO To get money
     * @Date 5:56 2018/8/3
     * @Param [UserInfo userInfo]
     * @return double
     **/
    double getMoney();
    
    /**
     * @Author Chen
     * @Description //TODO To validate pay password
     * @Date 5:56 2018/8/3
     * @Param [payPassword,userInfo]
     * @return boolean
     **/
    boolean toValidatePayPassword();
}
 
