package hsbc.team03.ordersystem.loginregister.security;

import hsbc.team03.ordersystem.loginregister.pojo.SysRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author : Jeff.Li
 * @Package: hsbc.team03.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: userinfo in userDetail of spring security
 * @date : 2018年08月10日 11:08:59
 **/
@Component
public class JwtUserInfoDetailServicesImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = new User(s,"123456",
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        return user;
        JwtUserInfo jwtUserInfo = new JwtUserInfo("123", s, "123456");
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        jwtUserInfo.setAuthorities(authorities);

        List<SysRole> roles = new ArrayList<>();
        roles.add(new SysRole("123", "USER"));
        jwtUserInfo.setRoles(roles);

        return jwtUserInfo;
    }
}
