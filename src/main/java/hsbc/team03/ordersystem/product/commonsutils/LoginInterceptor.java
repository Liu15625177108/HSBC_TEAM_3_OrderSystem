/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: LginInterceptor
 * Author:   ca
 * Date:     2018/8/2 21:49
 * Description: the Interceptor for login
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 21:49     1.0              the Interceptor for login
 */
package hsbc.team03.ordersystem.product.commonsutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description〈the Interceptor for login〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */

public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //  Auto-generated method stub
        logger.info("------LginInterceptor------");
        // get session
        HttpSession session = request.getSession(true);
        //if userId is not exist
        if(session.getAttribute("userId") == null){
            logger.info("----对不起您还没登录,请先登录----");
            return false;
        }else{
            session.setAttribute("userId", session.getAttribute("userId"));
            return true;
        }
    }
}