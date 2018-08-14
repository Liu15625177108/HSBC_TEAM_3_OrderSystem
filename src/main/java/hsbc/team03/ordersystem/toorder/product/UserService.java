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
package hsbc.team03.ordersystem.toorder.product;

/**
 * @description<br>
 * 〈the service of user〉
 *
 * @author Chen
 * @create 2018/8/3
 * @since 1.0.0
 */
public interface UserService {
    
    boolean toValidateMoney(UserInfo userInfo,ProductInfo productInfo);
    /**
     * @Author Chen
     * @Description //TODO To validate pay password
     * @Date 5:56 2018/8/3
     * @Param [UserInfo userInfo,String payPassword]
     * @return boolean
     **/
    boolean toValidatePayPassword(UserInfo userInfo,String payPassword);
    
    /**
     * @Author Chen
     * @Description //TODO to get userinfo by userid
     * @Date 12:36 2018/8/9
     * @Param [userId]
     * @return UserInfo
     **/
    UserInfo getUserInfoByUserId(String userId);

    /**
     * @Author Chen
     * @Description //TODO test
     * @Date 14:24 2018/8/13
     * @Param
     * @return
     **/
    void addTest(UserInfo userInfo);
    
    /**
     * @Author Chen
     * @Description //TODO rollbackMoney when cancel order
     * @Date 9:08 2018/8/14
     * @Param [orderId]
     * @return boolean
     **/
//    boolean rollbackMoney(String orderId);
}
 
