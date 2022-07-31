package com.dimple.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "alex.yates2020";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println(encodedPassword);

    }
}
