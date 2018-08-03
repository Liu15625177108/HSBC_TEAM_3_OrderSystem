package hsbc_team_3.ordersystem.bankmanager;

import java.io.Serializable;

/**
 * @ClassName ReturnValue
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 10:39
 */
public class ReturnValue implements Serializable {
    private String code;                // the code of server return
    private String msg;                 //  the message of the login's status.
    private BankManager bankManager;    //  the information of login's manager

    public  ReturnValue(){}

    public ReturnValue(String code, String msg, BankManager bankManager) {
        this.code = code;
        this.msg = msg;
        this.bankManager = bankManager;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BankManager getBankManager() {
        return bankManager;
    }

    public void setBankManager(BankManager bankManager) {
        this.bankManager = bankManager;
    }
}
