package com.yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Yangbin
 * @date 2019/12/19 -0:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    private int uid;
    private String uname;
    private String upwd;
    private Authority role;

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getAst()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.upwd;
    }

    @Override
    public String getUsername() {
        return this.uname;
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
}
