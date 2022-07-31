package com.dimple.service;

import com.dimple.dao.UserRepository;
import com.dimple.entity.User;
import com.dimple.utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static com.dimple.constant.Constants.*;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException(USER_NOT_FOUND);
        }
        return new CustomUserDetails(user);
    }
}
