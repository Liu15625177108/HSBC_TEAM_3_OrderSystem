package hsbc.team03.ordersystem.common;

import hsbc.team03.ordersystem.displayproduct.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/2 15:36
 * @Describe：
 * @Return:
 * @Param:
 */
public class PackProductModel {
    public static List<Product> packProductModel(){
        List<Product> list=new ArrayList<>();
        list.add(new Product(UUIDUtils.getUUID(),"200873", "中海基金",20.8,"稳健型","这是一个值得1","http://8080","2018-7-1","2018-8-10", "2018-7-3",1));
        list.add(new Product(UUIDUtils.getUUID(),"200872", "国风基金",20.8,"波动型","这是一个值得2","http://8080","2018-7-17","2018-8-27", "2018-7-5",1));
        list.add(new Product(UUIDUtils.getUUID(),"200873", "中海基金",20.8,"稳健型","这是一个值得3","http://8080","2018-7-24","2018-8-17", "2018-7-12",1));
        list.add(new Product(UUIDUtils.getUUID(),"200873", "中海基金",20.8,"股票型","这是一个值得4","http://8080","2018-7-23","2018-8-16", "2018-7-4",1));
        list.add(new Product(UUIDUtils.getUUID(),"200873", "中海基金",20.8,"股票型","这是一个值得5","http://8080","2018-7-19","2018-8-23", "2018-7-28",1));
        return list;
    }
}
