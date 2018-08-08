/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: UserInfo
 * Author:   ca
 * Date:     2018/8/2 17:43
 * Description: the pojo of user
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:43     1.0              the pojo of user
 */
package hsbc.team03.ordersystem.toorder.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description〈the pojo of user〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
@Data
public class UserInfo {
    /**
     * userid
     */
    @JsonProperty(value="userid")
    private String userId;
    /**
     * username
     */
    @JsonProperty(value="username")
    private String userName;
    /**
     * usermoney
     */
    @JsonProperty(value="usermoney")
    private double userMoney;
    /**
     * user's paypassword
     */
    @JsonProperty(value="paypassword")
    private String payPassword;
    /**
     * userphone
     */
    @JsonProperty(value = "userphone")
    private String userPhone;
    /**
     * useraddress
     */
    @JsonProperty(value = "useraddress")
    private String userAddress;

    public UserInfo(String userId, String userName, 
                    double userMoney, String payPassword, 
                    String userPhone, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userMoney = userMoney;
        this.payPassword = payPassword;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }
}