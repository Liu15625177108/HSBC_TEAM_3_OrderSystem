package hsbc.team03.ordersystem.productsshow;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 15:30
 * Description://
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductDetailShowController.class)
@Slf4j
public class ProductDetailShowControllerTest {

    @MockBean
    private ProductShowService productShowService;

    @Autowired
    private MockMvc mvc;


    private static final String TEST = "{\"status\":200,\"msg\":\"已经登录\",\"data\":{\"products\":[" +
            "{\"id\":\"1111\",\"name\":\"朝朝盈\",\"price\":4.44,\"description\":\"赚得更多\",\"icon\":\"ZhaoZhaoYing.jpg\"}," +
            "{\"id\":\"2222\",\"name\":\"余额宝\",\"price\":3.33,\"description\":\"稳赚不亏\",\"icon\":\"YuEBao.jpg\"}]}}";


    private static final String TEST2 = "{\"id\":\"1111\",\"name\":\"朝朝盈\",\"price\":4.44,\"description\":\"赚得更多\",\"icon\":\"ZhaoZhaoYing.jpg\"}";

    /**
     * @Method getList
     * @Description //Test
     * @Author Alan Ruan
     * @Date 2018/08/07 09:43:05
     * @Param []
     * @Return void
     */
    @Test
    public void getList() throws Exception{

        ProductInfoView productInfoView1 = new ProductInfoView();
        ProductInfoView productInfoView2 = new ProductInfoView();

        List<ProductInfoView> list = new ArrayList<ProductInfoView>();

        productInfoView1.setProductId("1111");
        productInfoView1.setProductName("朝朝盈");
        productInfoView1.setProductPrice(4.44);
        productInfoView1.setProductDescription("赚得更多");
        productInfoView1.setProductIcon("ZhaoZhaoYing.jpg");

        productInfoView2.setProductId("2222");
        productInfoView2.setProductName("余额宝");
        productInfoView2.setProductPrice(3.33);
        productInfoView2.setProductDescription("稳赚不亏");
        productInfoView2.setProductIcon("YuEBao.jpg");

        list.add(productInfoView1);
        list.add(productInfoView2);

        System.out.println(" ");
        System.out.println(list.toString());
        System.out.println(" ");
       // Logger logger = LoggerFactory.getLogger(list.toString());
        given(this.productShowService.listAll()).willReturn(list);


        String result = this.mvc.perform(get("/user/product/list")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(TEST))
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }

    /**
     * @Method showProductDetailsById
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/08/16 11:55:08
     * @Param []
     * @Return void
     */
    @Test
    public void showProductDetailsById() throws Exception{

        ProductInfoView productInfoView1 = new ProductInfoView();

        productInfoView1.setProductId("1111");
        productInfoView1.setProductName("朝朝盈");
        productInfoView1.setProductPrice(4.44);
        productInfoView1.setProductDescription("赚得更多");
        productInfoView1.setProductIcon("ZhaoZhaoYing.jpg");

        given(this.productShowService.getProductById("1111")).willReturn(productInfoView1);

        System.out.println(productInfoView1.toString());
        String result = this.mvc.perform(get("/user/product/show?productId=1111").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(TEST2))
                .andReturn().getResponse().getContentAsString();

        log.info(result);

    }
}