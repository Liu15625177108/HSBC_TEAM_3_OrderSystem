package hsbc.team03.ordersystem.loginregister.pojo;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
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

    @Null
    private String userId;

    @NotNull
    @Size(min = 6, max = 20)
    private String username;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private String realName;

    private int gender;

    @DecimalMax("99")
    private int age;

    private String position;

    private String income;

    @NotNull
    private Map<String, String> securityQuestions;

    public UserInfo() {
    }

    public UserInfo(String userId, String username, String password, String realName, int gender,
                    int age, String position, String income, Map<String, String> securityQuestions) {
        this.userId = userId;
        this.username = username;
        this.password = password;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", income='" + income + '\'' +
                ", securityQuestions=" + securityQuestions +
                '}';
    }
}
