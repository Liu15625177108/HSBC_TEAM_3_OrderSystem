package hsbc.team03.ordersystem.loginregister;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: test the register function
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 14:51:39
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterServicesImpl registerServices;

    /**
     * @param : []
     * @return void
     * @Description to test register proccess
     */
    @Test
    public void testRegister() throws Exception {

        HashMap<String, String> securityquestion = new HashMap<>(3);
        securityquestion.put("1+1=", "2");
        securityquestion.put("1+3=", "4");
        securityquestion.put("1+2=", "3");
        UserInfo userInfo = new UserInfo(100, "ljf", "123456", "mike", 1, 20,
                "manager", "50000", securityquestion);

        given(registerServices.verifyCode("123456", "[\\s\\S]*")).willReturn(true);
        given(registerServices.findUserByUsername("ljf")).willReturn(null);
        given(registerServices.addUser(userInfo)).willReturn(true);

        this.mockMvc.perform(post("/user/register/phone-number?phone-number=15521301710").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"message sent\",\"data\":null}"));
        this.mockMvc.perform(post("/user/register/verify-code?verifyCode=123456").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"code confirm\",\"data\":null}"));
        this.mockMvc.perform(get("/user/register/username-check?username=ljf").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"username available\",\"data\":null}"));
        this.mockMvc.perform(post("/user/register/login-message").accept(MediaType.APPLICATION_JSON).requestAttr("userInfo", userInfo))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"register success\",\"data\":null}"));

    }
}
