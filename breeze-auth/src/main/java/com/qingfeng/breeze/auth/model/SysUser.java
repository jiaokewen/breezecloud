package com.qingfeng.breeze.auth.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
public class SysUser implements UserDetails {
    private Integer userId;

    private String nickName;

    private String loginName;

    private String password;

    private String email;

    private String phoneNumber;

    private String wechatNumber;

    private Date lastLoginDate;

    private Integer sex;

    private Integer age;

    private Integer state;

    private String avatarUrl;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 这里我们没有用到权限，所以返回一个默认的admin权限
        return AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    @Override
    public String getPassword() {
        return password;
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