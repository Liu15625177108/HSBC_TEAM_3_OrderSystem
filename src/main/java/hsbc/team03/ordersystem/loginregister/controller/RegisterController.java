package hsbc.team03.ordersystem.loginregister.controller;

import hsbc.team03.ordersystem.loginregister.pojo.UserInfo;
import hsbc.team03.ordersystem.loginregister.resultview.ResultView;
import hsbc.team03.ordersystem.loginregister.services.RegisterServicesImpl;
import hsbc.team03.ordersystem.loginregister.utils.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: register api entrance
 * @Author: Jeff.Li
 * @Created: 2018年08月02日 16:15:45
 **/
@RestController
@RequestMapping("/user/register")
public class RegisterController {

    private RegisterServicesImpl registerServices;

    @Autowired
    public RegisterController(RegisterServicesImpl registerServices) {
        this.registerServices = registerServices;
    }

    /**
     * @param : phoneNumber, response
     * @return void
     * @Description send message to phone
     */
    @PostMapping("/phone-number")
    public ResultView sendVerifyMessage(@RequestParam("phone-number") String phoneNumber, HttpServletResponse response) {
        String rand = SendSmsUtil.createRandNum();
        SendSmsUtil.sendMsgTo(phoneNumber, rand);
        Cookie cookie = new Cookie("code", SendSmsUtil.sigMD5(rand));
        response.addCookie(cookie);
        ResultView resultView = new ResultView();
        resultView.setCode(200);
        resultView.setMsg("message sent");

        response.setHeader("Access-Control-Allow-Origin", "*");

        return resultView;
    }

    /**
     * @param :code, request
     * @return java.util.HashMap<java.lang.String       ,       java.lang.Boolean>
     * @Description verify the code from user
     */
    @PostMapping("/verify-code")
    public ResultView verifyCode(@RequestParam("verifyCode") String code, HttpServletRequest request) {
        ResultView<String> resultView = new ResultView<>();
        String aName = "code";
        String codes = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(aName)) {
                codes = c.getValue();
            }
        }
        if (codes != null && SendSmsUtil.sigMD5(code).equals(codes)) {
            resultView.setCode(200);
            resultView.setMsg("code confirm");
            return resultView;
        } else {
            resultView.setCode(500);
            resultView.setMsg("fail");
        }
        return resultView;
    }

    /**
     * @param :username
     * @return java.util.HashMap<java.lang.String       ,       java.lang.Boolean>
     * @Description check if the username available
     */
    @GetMapping("/username-check")
    public ResultView usernameCheck(@RequestParam("username") String username) {
        ResultView resultView = new ResultView();
        UserInfo list = registerServices.findUserByUsername(username);
        if (list == null) {
            resultView.setCode(200);
            resultView.setMsg("username available");
        } else {
            resultView.setCode(500);
            resultView.setMsg("username non-available");
        }
        return resultView;
    }


    /**
     * @param :userInfo, request
     * @return ResultView
     * @Description input register message of user
     */
    @PostMapping("/login-message")
    public ResultView loginMessage(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult) {
        ResultView resultView = new ResultView();
        if (bindingResult.hasErrors()) {
            resultView.setCode(500);
            resultView.setMsg("information failed");
        } else if (registerServices.addUser(userInfo)) {
            resultView.setCode(200);
            resultView.setMsg("register success");
        } else {
            resultView.setCode(500);
            resultView.setMsg("register fail");
        }
        return resultView;
    }

}


