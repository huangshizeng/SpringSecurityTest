package com.huang.security.service;

import com.huang.security.domain.User;
import com.huang.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        System.out.println(user);
        System.out.println(user.getRoles());
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
