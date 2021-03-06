package hsbc.team03.ordersystem.productsshow;

import hsbc.team03.ordersystem.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 13:19
 * Description://
 */
@RestController
@RequestMapping("/user/product")
public class ProductDetailShowController {

    @Autowired
    private ProductShowService productShowService;

    /**
     * @Method getList
     * @Description //get all the product detail information
     * @Author Alan Ruan
     * @Date 2018/08/07 09:38:17
     * @Param []
     * @Return hsbc.team03.ordersystem.result.ResultView
     */
    @GetMapping("/list")
    public ResultView getList(){

        ResultView<ProductView> resultView = new ResultView<ProductView>();
        ProductView productView = new ProductView();

        productView.setProductInfoViewList(productShowService.listAll());

        resultView.setStatus(200);
        resultView.setMsg("已经登录");
        resultView.setData(productView);

        return resultView;
    }

    /**
     * @Method showProductDetailsById
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/08/16 11:44:17
     * @Param [productId]
     * @Return hsbc.team03.ordersystem.productsshow.ProductInfoView
     */
    @GetMapping("/show")
    public ProductInfoView showProductDetailsById(@RequestParam(value = "productId",
            required = true) String productId){

        //ProductInfoView productInfoView = new ProductInfoView();
        return productShowService.getProductById(productId);

    }

}
