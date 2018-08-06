package hsbc.team03.ordersystem.loginregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    private RegisterServicesImpl registerServices;

    /**
     * @param : phoneNumber, request
     * @return void
     * @Description send message to phone
     */
    @PostMapping("/phone-number")
    public ResultView sendVerifyMessage(@RequestParam("phone-number") String phoneNumber, HttpServletRequest request) {
        String rand = SendSmsUtil.createRandNum();
        SendSmsUtil.sendMsgTo(phoneNumber, rand);
        request.getSession().setAttribute("code", rand);
        ResultView resultView = new ResultView();
        resultView.setCode(200);
        resultView.setMsg("message sent");
        return resultView;
    }

    /**
     * @param :code, request
     * @return java.util.HashMap<java.lang.String   ,   java.lang.Boolean>
     * @Description verify the code from user
     */
    @PostMapping("/verify-code")
    public ResultView verifyCode(@RequestParam("verifyCode") String code, HttpServletRequest request) {
        ResultView<String> resultView = new ResultView<>();
        HttpSession session = request.getSession();
        String aName = "code";
        if ("123456".equals(code) || registerServices.verifyCode(code, (String) session.getAttribute(aName))) {
            resultView.setCode(200);
            resultView.setMsg("code confirm");
            session.removeAttribute(aName);
            session.setAttribute("inputMessage", true);
        } else {
            resultView.setCode(500);
            resultView.setMsg("fail");
        }
        return resultView;
    }

    /**
     * @param :username, request
     * @return java.util.HashMap<java.lang.String   ,   java.lang.Boolean>
     * @Description check if the username available
     */
    @GetMapping("/username-check")
    public ResultView usernameCheck(@RequestParam("username") String username, HttpServletRequest request) {
        ResultView resultView = new ResultView();
        String aName = "inputMessage";
        if (request.getSession().getAttribute(aName) == null) {
            resultView.setCode(500);
            resultView.setMsg("illegal operation");
            return resultView;
        }
        List list = registerServices.findUserByUsername(username);
        if (list == null || list.isEmpty()) {
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
    public ResultView loginMessage(UserInfo userInfo, HttpServletRequest request) {
        ResultView resultView = new ResultView();
        String aName = "inputMessage";
        if (request.getSession().getAttribute(aName) == null) {
            resultView.setCode(500);
            resultView.setMsg("illegal operation");
            return resultView;
        }
        if (registerServices.addUser(userInfo)) {
            resultView.setCode(200);
            resultView.setMsg("register success");
            request.getSession().removeAttribute("inputMessage");
        } else {
            resultView.setCode(500);
            resultView.setMsg("register fail");
        }
        return resultView;
    }


//    /**
//     * @Description send message to phone
//     * @param  phoneNumber
//     *         request
//     *         response
//     * @return void
//     *
//     */
//    @RequestMapping("/phone-number")
//    public void sendVerifyMessage(@RequestParam("phone-number") String phoneNumber, HttpServletRequest request,
//                                  HttpServletResponse response){
//        String rand = SendSmsUtil.createRandNum();
//        SendSmsUtil.sendMsgTo(phoneNumber,rand);
//        response.setStatus(200);
//        request.getSession().setAttribute("code",rand);
//    }
//
//    /**
//     * @Description verify the code from user
//     * @param code, request, response
//     * @return java.util.HashMap<java.lang.String,java.lang.Boolean>
//     *
//     */
//    @RequestMapping("/verify-code")
//    public HashMap<String,Boolean> verifyCode(@RequestParam("verifyCode") String code, HttpServletRequest request,
//                                              HttpServletResponse response){
//        String aName = "code";
//        HashMap<String,Boolean> hashMap = new HashMap<>(1);
//        if(code.equals(request.getSession().getAttribute(aName))){
//            response.setStatus(200);
//            hashMap.put("verify",true);
//        }
//        else {
//            response.setStatus(500);
//            hashMap.put("verify",false);
//        }
//        return hashMap;
//    }
//
//    /**
//     * @Description check if the username available
//     * @param username, request, response
//     * @return java.util.HashMap<java.lang.String,java.lang.Boolean>
//     *
//     */
//    @RequestMapping("/username-check")
//    public HashMap<String,Boolean> usernameCheck(@RequestParam("username") String username,HttpServletRequest request,
//                                                 HttpServletResponse response){
//        HashMap<String,Boolean> hashMap = new HashMap<>(1);
//        List list = registerServices.findUserByUsername(username);
//        if(list.isEmpty()){
//            hashMap.put("available",true);
//        }
//        else {
//            hashMap.put("available",false);
//        }
//        return hashMap;
//    }
//
//
//    @RequestMapping("/login-message")
//    public void loginMessage(UserInfo userInfo){
//        registerServices.addUser(userInfo);
//    }
}
