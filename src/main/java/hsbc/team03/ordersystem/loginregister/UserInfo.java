package hsbc.team03.ordersystem.loginregister;

import java.io.Serializable;
import java.util.Map;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: info of users' login
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 10:23:24
 **/
public class UserInfo implements Serializable {
    private long userId;
    private String username;
    private String passord;
    private String realName;
    private int gender;
    private int age;
    private String position;
    private String income;
    private Map<String, String> securityQuestions;

    public UserInfo() {
    }

    public UserInfo(long userId, String username, String passord, String realName, int gender,
                    int age, String position, String income, Map<String, String> securityQuestions) {
        this.userId = userId;
        this.username = username;
        this.passord = passord;
        this.realName = realName;
        this.gender = gender;
        this.age = age;
        this.position = position;
        this.income = income;
        this.securityQuestions = securityQuestions;
    }

    public Map<String, String> getSecurityQuestions() {
        return securityQuestions;
    }

    public void setSecurityQuestions(Map<String, String> securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
