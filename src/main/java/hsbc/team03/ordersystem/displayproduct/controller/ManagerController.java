package hsbc.team03.ordersystem.displayproduct.controller;

import hsbc.team03.ordersystem.displayproduct.model.Product;
import hsbc.team03.ordersystem.displayproduct.service.ManagerService;
import hsbc.team03.ordersystem.displayproduct.serviceimpl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author @Evan
 * @return No such property: code for class: Script1
 * @exception
 * @date 2018/8/5 22:14
 */
@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    /**
     * @Description:
     * @Author: @Evan
     * @CreateDate: 2018/8/5 21:56
     * @UpdateDate: 2018/8/5 21:56
     * @Version: 1.0
     */
    @RequestMapping(value = "/login")
    public ModelAndView managerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("angular.html");
        return modelAndView;
    }

    /**
     * @Description: manager get all the production
     * @Author: @Evan
     * @CreateDate: 2018/8/5 21:56
     * @UpdateDate: 2018/8/5 21:56
     * @Version: 1.0
     */
    @RequestMapping(value = "/manager/productlist", method = RequestMethod.GET)
    public List<Product> getAllProduct() {
        List<Product> list = managerService.productList();
        return list;
    }

    /**
     * @Description: manager modify the products,inculde its name,productCode,price,and so on
     * @Author: @Evan
     * @CreateDate: 2018/8/5 21:57
     * @UpdateDate: 2018/8/5 21:57
     * @Version: 1.0
     */

    @RequestMapping(value = "/manager/modify/products", method = RequestMethod.POST)
    public boolean modifyProduct(@RequestBody Product product) {
//     Product product = new Product("ewfsdgsrhdfgxvadfgsfnxzdz", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        boolean tag = managerService.modifyProduct(product);
        return tag;
    }

    /**
     * @Description: manager add product
     * @Author: @Evan
     * @CreateDate: 2018/8/5 21:59
     * @UpdateDate: 2018/8/5 21:59
     * @Version: 1.0
     */
    @RequestMapping(value = "/manager/add/products", method = RequestMethod.POST)
    public Boolean addProduct(@RequestBody Product product) {
        //  Product product = new Product("ewfsdgsrhdfgxvadfgsfnxzdz", "200701", "中海", 20.8, "稳健型", "这是一个值得1", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        boolean tag;
        tag = managerService.addProduct(product);
        return tag;
    }

    /**
     * @Description: manager delete product by productCode,actually it is chance product's status
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:00
     * @UpdateDate: 2018/8/5 22:00
     * @Version: 1.0
     */
    @RequestMapping(value = "/manager/delete/products", method = RequestMethod.DELETE)
    public int deleteProductByProductCode(@RequestBody Product product) {
//        Product product = new Product("xdghhmbhnllllgcgxdf", "200871", "中海基金", 20.8, "稳健型", "这是一个值得1", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 0);
        int n = 0;
        n = managerService.deleteProductByProductCode(product);
        return n;
    }
}
