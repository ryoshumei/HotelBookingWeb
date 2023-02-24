package com.example.hotelbookingweb.services.admin;

import com.example.hotelbookingweb.entities.AdminEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class AdminUserDetails implements UserDetails {

    private final AdminEntity adminEntity;
    private final Collection<? extends GrantedAuthority> authorities;

    public AdminUserDetails(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;

        this.authorities = Arrays.asList(adminEntity.getRole())
                .stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .toList();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {
        return adminEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return adminEntity.getAdminId();
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
