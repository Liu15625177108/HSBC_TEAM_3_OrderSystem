package hsbc_team_3.ordersystem.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Information
 * @Author:Jerry.Liu;
 * @Description://imformation实体类，包含状态码，信息，食物列表。
 * @Author:Administrator
 * @Package com.example.demo.model
 * @Date 2018/7/31 16:02
 */
public class Information implements Serializable {
    String code;                        // 状态码 String
    String msg;                         // 信息  String
    List<Food> foodList;                //食物列表，List

    public Information(){}
    public Information(String code, String msg, List<Food> foodList) {
        this.code = code;
        this.msg = msg;
        this.foodList = foodList;
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

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
