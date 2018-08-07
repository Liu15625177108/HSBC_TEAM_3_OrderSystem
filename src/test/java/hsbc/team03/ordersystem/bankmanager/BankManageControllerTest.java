package hsbc.team03.ordersystem.bankmanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName BankManageControllerTest
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 10:50
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BankManageController.class)
public class BankManageControllerTest {



//    @Autowired
//    //reject web factory
//    private WebApplicationContext wac;
    //simulate mvc environment;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private  BankManagerService bankManagerService;
//    @Before
//    public void setup(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
    @Test
    /**
    *@Author Jerry.Liu
    *@Description: test for "/manager/login"
    *@Parameter []
    *@Date:10:58 2018/8/3
    *@Package: hsbc_team_3.ordersystem.bankmanager
    */
    public void managerLogin() throws Exception{

        ReturnValue <BankManager> returnValue=new ReturnValue<BankManager>();
        BankManager bankManager=new BankManager("1233231","Jerry","dev");

        given(this.bankManagerService.login("1233231","123456")).willReturn(true);
        given(this.bankManagerService.findByWorkernum("1233231")).willReturn(bankManager);

        given(this.bankManagerService.login("123456","123456")).willReturn(false);


        String result =
                mockMvc.perform(get("/manager/login?workernumber=1233231&password=123456").accept(MediaType.APPLICATION_JSON))       // return json's message
                .andExpect(status().isOk())                             // ensure the http.code is ok;
                .andExpect(jsonPath("$.length()").value(3))     //  ensure the length of json is 3
                .andReturn().getResponse().getContentAsString();                            // return reponse's value
        Logger logger= LoggerFactory.getLogger(BankManageControllerTest.class);
        logger.info(result);                                                                //  output

         result =
                mockMvc.perform(get("/manager/login?workernumber=123456&password=123456").accept(MediaType.APPLICATION_JSON))       // return json's message
                        .andExpect(status().isOk())                             // ensure the http.code is ok;
                        .andExpect(jsonPath("$.length()").value(3))     //  ensure the length of json is 3
                        .andReturn().getResponse().getContentAsString();                            // return reponse's value

        logger.info(result);


    }
}