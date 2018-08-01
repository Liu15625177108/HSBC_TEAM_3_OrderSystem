package hsbc_team_3.ordersystem.model;

import java.io.Serializable;

/**
 * @ClassName Food
 * @Author:Jerry.Liu;
 * @Description: food 实体类，包含食物各种属性。
 * @Author:Administrator
 * @Package com.example.demo.model
 * @Date 2018/7/31 15:58
 */
public class Food implements Serializable {

    private  String foodId;                 // 食物id号 String
    private String foodName;                // 食物名称，String
    private String foodPrice;               // 食物价格，String
    private String description;             // 食物描述，String
    private String icon;                    // 食物Icon链接，String

    public Food(){}
    public Food(String foodId, String foodName, String foodPrice, String description, String icon) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.description = description;
        this.icon = icon;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
