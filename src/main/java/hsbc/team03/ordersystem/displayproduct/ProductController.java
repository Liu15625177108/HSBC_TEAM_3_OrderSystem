package hsbc.team03.ordersystem.displayproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author:Evan
 * @Date:2018/8/2 14:47
 * @Describe：
 * @Return:
 * @Param:
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    ProductRepository productRepository;
    private int pageNum;

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
    public ModelAndView productIndex() {
        ModelAndView mv = new ModelAndView("displayProduct.html");
        return mv;
    }

    @RequestMapping(value = "/user/get/products", method = RequestMethod.POST)
    @ResponseBody
    public Page<Product> getProduct(@RequestParam(name = "pageNumber", defaultValue = "0") int pageNum, @RequestParam(name = "dataCount", defaultValue = "2") int dataCount, @RequestParam(name = "productType", defaultValue = "短期型") String productType) {
        System.out.println(productType);
        //        List<Product> list = this.productService.getAllProduct();
        //*sort by product's type*//*
//        SortUtils.sort(list, "type", null);
//       PageRequest request = PageRequest.of(pageNum, 2, sort);
        // @RequestParam(value = "pageNum", defaultValue = "0") int pageNum
//        Page<Product> products = productService.getProductListByPage(request);

        Sort sort = Sort.by("productType");
        Page<Product> products = productService.getProductListByPage(pageNum,productType,dataCount, sort);

        return products;
    }
}
