package hsbc_team_3.ordersystem.controller;



import hsbc_team_3.ordersystem.model.Food;
import hsbc_team_3.ordersystem.model.Information;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @ClassName MyController
 * @Author:Jerry.Liu;
 * @Description：controller层，用于表明映射对于方法。
 * @Author:Administrator
 * @Package com.example.controller
 * @Date 2018/7/30 10:45
 */
@RestController
public class MyController {

    /**
    *@Author Jerry.Liu
    *@Description://方法show 映射localhost:8080/show，返回Json格式
    *@Parameter []
    *@Date:13:21 2018/8/1
    *@Package: com.example.test.controller
    */
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public Information show(){
        Food food1 = new Food("101","桂林米粉","15Yuan","好好吃","www.XXX.com");
        Food food2 = new Food("102","米粉","12Yuan","差评","www.AAA.com");
        ArrayList<Food> list=new ArrayList<Food>();
        list.add(food1);
        list.add(food2);
        Information information=new Information("1","俊锋米粉店",list);
        return information;
    }
}