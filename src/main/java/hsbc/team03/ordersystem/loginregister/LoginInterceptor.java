package hsbc.team03.ordersystem.loginregister;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Package: hsbc.team03.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: check if login
 * @Author: Jeff.Li
 * @Created: 2018年08月07日 16:36:48
 **/
@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String checker = "userId";
        if (request.getSession().getAttribute(checker) != null) {
            return true;
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.append("please login");
            printWriter.append(request.getRequestURL().toString());
            response.setStatus(200);
            return false;
        }
    }
}
