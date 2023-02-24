package com.example.hotelbookingweb.services.admin;

import com.example.hotelbookingweb.entities.AdminEntity;
import com.example.hotelbookingweb.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminLogInService implements UserDetailsService {

    private final AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println(username);
        Optional<AdminEntity> loginUserOptional = adminRepository.findByUsername(username);
        return loginUserOptional.map(loginUser -> new AdminUserDetails(loginUser))
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
    }
}
