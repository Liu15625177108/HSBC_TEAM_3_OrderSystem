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

        final String bearer = "Bearer ";
        String authheader = httpServletRequest.getHeader("Authorization");
        if (authheader != null && authheader.startsWith(bearer)) {
            final String authToken = authheader.replace("Bearer ", "");
            String userId = jwtTool.getUserIdFromToken(authToken);
            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = jwtUserInfoDetailServices.loadUserByUsername(userId);
                if (jwtTool.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    httpServletRequest.setAttribute("userId", userId);
                }
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
