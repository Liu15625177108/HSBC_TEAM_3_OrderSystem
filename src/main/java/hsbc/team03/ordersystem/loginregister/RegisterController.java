package hsbc.team03.ordersystem.loginregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        return resultView;
    }

    /**
     * @param :code, request
     * @return java.util.HashMap<java.lang.String , java.lang.Boolean>
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
     * @return java.util.HashMap<java.lang.String , java.lang.Boolean>
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
    public ResultView loginMessage(@RequestBody UserInfo userInfo) {
        ResultView resultView = new ResultView();
        if (registerServices.addUser(userInfo)) {
            resultView.setCode(200);
            resultView.setMsg("register success");
        } else {
            resultView.setCode(500);
            resultView.setMsg("register fail");
        }
        return resultView;
    }


//    @Autowired
//    private RegisterServicesImpl registerServices;
//
//    /**
//     * @param : phoneNumber, request
//     * @return void
//     * @Description send message to phone
//     */
//    @PostMapping("/phone-number")
//    public ResultView sendVerifyMessage(@RequestParam("phone-number") String phoneNumber, HttpServletRequest request) {
//        String rand = SendSmsUtil.createRandNum();
//        SendSmsUtil.sendMsgTo(phoneNumber, rand);
//        request.getSession().setAttribute("code", rand);
//        ResultView resultView = new ResultView();
//        resultView.setCode(200);
//        resultView.setMsg("message sent");
//        return resultView;
//    }
//
//    /**
//     * @param :code, request
//     * @return java.util.HashMap<java.lang.String   ,    j a v a .lang.Boolean>
//     * @Description verify the code from user
//     */
//    @PostMapping("/verify-code")
//    public ResultView verifyCode(@RequestParam("verifyCode") String code, HttpServletRequest request) {
//        ResultView<String> resultView = new ResultView<>();
//        HttpSession session = request.getSession();
//        String aName = "code";
//        if ("123456".equals(code) || registerServices.verifyCode(code, (String) session.getAttribute(aName))) {
//            resultView.setCode(200);
//            resultView.setMsg("code confirm");
//            session.removeAttribute(aName);
//            session.setAttribute("inputMessage", true);
//        } else {
//            resultView.setCode(500);
//            resultView.setMsg("fail");
//        }
//        return resultView;
//    }
//
//    /**
//     * @param :username, request
//     * @return java.util.HashMap<java.lang.String   ,    j a v a . l ang.Boolean>
//     * @Description check if the username available
//     */
//    @GetMapping("/username-check")
//    public ResultView usernameCheck(@RequestParam("username") String username, HttpServletRequest request) {
//        ResultView resultView = new ResultView();
//        String aName = "inputMessage";
//        if (request.getSession().getAttribute(aName) == null) {
//            resultView.setCode(500);
//            resultView.setMsg("illegal operation");
//            return resultView;
//        }
//        List list = registerServices.findUserByUsername(username);
//        if (list == null || list.isEmpty()) {
//            resultView.setCode(200);
//            resultView.setMsg("username available");
//        } else {
//            resultView.setCode(500);
//            resultView.setMsg("username non-available");
//        }
//        return resultView;
//    }
//
//
//    /**
//     * @param :userInfo, request
//     * @return ResultView
//     * @Description input register message of user
//     */
//    @PostMapping("/login-message")
//    public ResultView loginMessage(UserInfo userInfo, HttpServletRequest request) {
//        ResultView resultView = new ResultView();
//        String aName = "inputMessage";
//        if (request.getSession().getAttribute(aName) == null) {
//            resultView.setCode(500);
//            resultView.setMsg("illegal operation");
//            return resultView;
//        }
//        if (registerServices.addUser(userInfo)) {
//            resultView.setCode(200);
//            resultView.setMsg("register success");
//            request.getSession().removeAttribute("inputMessage");
//        } else {
//            resultView.setCode(500);
//            resultView.setMsg("register fail");
//        }
//        return resultView;
//    }

}


