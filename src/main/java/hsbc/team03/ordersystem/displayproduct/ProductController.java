package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/2 14:47
 * @Describe：
 * @Return:
 * @Param:
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    /**
    * @Description:  get products and sort by product's type
    * @Author:        @Evan
    * @CreateDate:   2018/8/5 22:14
    * @UpdateDate:   2018/8/5 22:14
    * @Version:      1.0
    */
    @RequestMapping(value = "/user/get/products", method = RequestMethod.GET)
    public List<Product> getProduct() {
      /*  List<Product> list = this.productService.getAllProduct();
        *//*sort by product's type*//*
        SortUtils.sort(list, "type", null);
       */
        Product product1 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz1", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        Product product2 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz2", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        Product product3 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz3", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
       List<Product> list=new ArrayList<>();
       list.add(product1);
       list.add(product2);
       list.add(product3);
        return list;
    }
}
