package hsbc.team03.ordersystem.loginregister.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : Jeff.Li
 * @Package: hsbc.team03.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: user info filter
 * @date : 2018年08月10日 15:45:57
 **/
//@WebFilter(urlPatterns = "", filterName = "UserInfoFilter")
public class UserInfoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("Filter Start!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println("Filter Doing!");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
