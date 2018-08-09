package hsbc.team03.ordersystem.displayproduct;
<<<<<<< HEAD
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
=======

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
<<<<<<< HEAD
=======

import java.util.ArrayList;
import java.util.List;

>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author:Evan
 * @Date:2018/8/6 17:53
 * @Describe：
 * @Return:
 * @Param:
 */
<<<<<<< HEAD
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ProductTest {
//    @Autowired
//    private WebApplicationContext context;
//    private MockMvc mvc;
//
//    @Before
//    public void setUp() {
//        mvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void productTest() throws Exception {
//        this.mvc.perform(get("/user/get/products")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
=======
@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(ProductController.class)
public class ProductTest {
   /* @Autowired
    private WebApplicationContext context;*/
   @Autowired
    private MockMvc mvc;

    @MockBean
   ProductService productService;
  /*  @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
*/
    @Test
    public void productTest() throws Exception {
        List<Product> list = new ArrayList<>();

        Mockito.when(productService.getAllProduct()).thenReturn(list);
        this.mvc.perform(get("/user/get/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
}
