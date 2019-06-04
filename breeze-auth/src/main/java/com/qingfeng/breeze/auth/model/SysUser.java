package com.qingfeng.breeze.auth.model;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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

    private List<String> resources;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 这里我们没有用到权限，所以返回一个默认的admin权限
        String[] strings = new String[resources.size()];
        strings = resources.toArray(strings);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.join(strings,","));
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