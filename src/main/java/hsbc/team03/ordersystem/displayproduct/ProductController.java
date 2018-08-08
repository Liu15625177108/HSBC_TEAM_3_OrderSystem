package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.common.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
       /* @RequestParam(value = "pageNum",defaultValue = "0") */
        int pageNum=0;
        List<Product> list = this.productService.getAllProduct();
        /*sort by product's type*/
        Sort sort=Sort.by("type");
//        PageRequest request = new PageRequest(pageNum,2,sort);
//        PageRequest.of(pageNum,2,sort);
        Page<Product> page =productService.findAll( PageRequest.of(pageNum,2,sort));
        System.out.println(page);
        SortUtils.sort(list, "type", null);
        return list;
    }
}
