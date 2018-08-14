package hsbc.team03.ordersystem.loginregister.pojo;

import lombok.Data;

/**
 * @author : Jeff.Li
 * @Package: hsbc.team03.ordersystem.loginregister.pojo
 * @Program: ordersystem
 * @Description: system role
 * @date : 2018年08月13日 10:37:15
 **/
@Data
public class SysRole {

    private String id;
    private String name;

    public SysRole(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
