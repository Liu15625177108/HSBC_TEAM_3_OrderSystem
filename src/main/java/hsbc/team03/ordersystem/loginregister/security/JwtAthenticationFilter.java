package hsbc.team03.ordersystem.loginregister.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Jeff.Li
 * @Package: hsbc.team03.ordersystem.loginregister.security
 * @Program: ordersystem
 * @Description: todo
 * @date : 2018年08月13日 13:19:39
 **/
public class JwtAthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private JwtUserInfoDetailServicesImpl jwtUserInfoDetailServices;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        /** to get the token*/
        final String bearer = "Bearer ";
        String authheader = httpServletRequest.getHeader("Authorization");
        if (authheader != null && authheader.startsWith(bearer)) {

            /** to get the username in the body of token*/
            final String authToken = authheader.replace("Bearer ", "");
            String username = jwtTool.getUsernameFromToken(authToken);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                /** to get the detail of the user and validate*/
                UserDetails userDetails = jwtUserInfoDetailServices.loadUserByUsername(username);
                if (jwtTool.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    /** to set the spring-security authentication to user*/
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    /** to set userId in request, which will be used in controller*/
                    httpServletRequest.setAttribute("userId", jwtTool.getUserIdFromToken(authToken));
                }
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
