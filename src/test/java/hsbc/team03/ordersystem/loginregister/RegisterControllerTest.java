package hsbc.team03.ordersystem.loginregister;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;
import java.util.HashMap;

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
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)RANDOM_PORT
//@AutoConfigureMockMvc
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterServicesImpl registerServices;

    /**
     * @Description test verify phone code
     * @param : []
     * @return void
     *
     */
    @Test
    public void testVerifyCode() throws Exception {

        Cookie cookie = new Cookie("code", "e10adc3949ba59abbe56e057f20f883e");

        this.mockMvc.perform(post("/user/register/verify-code?verifyCode=123456")
                .accept(MediaType.APPLICATION_JSON).cookie(cookie))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"code confirm\",\"data\":null}"));

        this.mockMvc.perform(post("/user/register/verify-code?verifyCode=15421")
                .accept(MediaType.APPLICATION_JSON).cookie(cookie))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":500,\"msg\":\"fail\",\"data\":null}"));

        this.mockMvc.perform(post("/user/register/verify-code?verifyCode=12006")
                .accept(MediaType.APPLICATION_JSON).cookie(cookie))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":500,\"msg\":\"fail\",\"data\":null}"));
    }

    /**
     * @param : []
     * @return void
     * @Description to test if the username available
     */
    @Test
    public void testUsernameCheck() throws Exception {

        Mockito.when(this.registerServices.findUserByUsername("ljf")).thenReturn(new UserInfo());

        this.mockMvc.perform(get("/user/register/username-check?username=lkk").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"username available\",\"data\":null}"));

        this.mockMvc.perform(get("/user/register/username-check?username=ljf").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":500,\"msg\":\"username non-available\",\"data\":null}"));
    }


    /**
     * @Description test input login message
     * @param : []
     * @return void
     *
     */
    @Test
    public void testInputLoginMessage() throws Exception {

        HashMap<String, String> securityquestion = new HashMap<>(3);
        securityquestion.put("1+1=", "2");
        securityquestion.put("1+3=", "4");
        securityquestion.put("1+2=", "3");
        UserInfo userInfo = new UserInfo("100", "ljf", "123456", "mike",
                1, 20, "manager", "50000", securityquestion);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestbody = objectMapper.writeValueAsString(userInfo);


        Mockito.when(this.registerServices.addUser(Mockito.any(UserInfo.class))).thenReturn(true);

        this.mockMvc.perform(post("/user/register/login-message")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestbody).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"register success\",\"data\":null}"));
    }
}