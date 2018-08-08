package hsbc.team03.ordersystem.displayproduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
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
}
