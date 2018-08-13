package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
     * @Description: get products and sort by product's type
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:14
     * @UpdateDate: 2018/8/5 22:14
     * @Version: 1.0
     */

    @GetMapping("/productIndex")
    public ModelAndView productIndex(){
        ModelAndView mv=new ModelAndView("displayProduct.html");
        return mv;
    }

    @RequestMapping(value = "/user/get/products", method = RequestMethod.GET)
    public List<Product> getProduct() {
       List<Product> list = this.productService.getAllProduct();
         //*sort by product's type*//*
        SortUtils.sort(list, "type", null);
        Sort sort = Sort.by("type");

//        PageRequest request = PageRequest.of(pageNum, 2, sort);
       // @RequestParam(value = "pageNum", defaultValue = "0") int pageNum
//        Page<Product> products = productService.getProductListByPage(request);
        return list;
    }
}
