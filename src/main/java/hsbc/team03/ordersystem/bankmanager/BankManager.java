package hsbc.team03.ordersystem.bankmanager;

import java.io.Serializable;

/**
 * @ClassName BankManager
 * @Author:Jerry.Liu;
 * @Description:  The class describe the person who is the bank manager.
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/2 11:06
 */
public class BankManager implements Serializable {

    private String  workerNum;                              //bank manager's work number
    private String  workerName;                             //bacnk manager's name;
    private String  workerDepartment;                       // the department of bank manager
//    private String  loginPassword;                          // the login password of the manager

    public BankManager(String workerNum, String workerName, String workerDepartment) {
        this.workerNum = workerNum;
        this.workerName = workerName;
        this.workerDepartment = workerDepartment;

    }

    public BankManager(){}

    public String getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(String workerNum) {
        this.workerNum = workerNum;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerDepartment() {
        return workerDepartment;
    }

    public void setWorkerDepartment(String workerDepartment) {
        this.workerDepartment = workerDepartment;
    }

//    public String getLoginPassword() {
//        return loginPassword;
//    }
//
//    public void setLoginPassword(String loginPassword) {
//        this.loginPassword = loginPassword;
//    }
}
