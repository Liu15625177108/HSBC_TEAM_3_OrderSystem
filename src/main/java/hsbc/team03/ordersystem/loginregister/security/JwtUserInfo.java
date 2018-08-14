package hsbc.team03.ordersystem.loginregister.security;

import hsbc.team03.ordersystem.loginregister.pojo.SysRole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author : Jeff.Li
 * @Package: hsbc.team03.ordersystem.loginregister.security
 * @Program: ordersystem
 * @Description: todo
 * @date : 2018年08月13日 11:18:58
 **/
@Data
public class JwtUserInfo implements UserDetails {

    private final String userId;

    private final String username;

    private final String password;

    private List<SysRole> roles;

    private List<? extends GrantedAuthority> authorities;

    private Date lastPasswordResetDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

}
