package hsbc.team03.ordersystem.bankmanager;



import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName ManagerInterceptor
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc.team03.ordersystem.bankmanager
 * @Date 2018/8/8 11:44
 */

public class ManagerInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String checker = "workerNumber";
        if (request.getSession().getAttribute(checker) != null) {
            return true;
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.append("please login");
            response.setStatus(200);
            return false;
        }
    }

}
