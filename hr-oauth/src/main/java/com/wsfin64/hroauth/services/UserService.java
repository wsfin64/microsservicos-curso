package com.wsfin64.hroauth.services;

import com.wsfin64.hroauth.entities.User;
import com.wsfin64.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    UserFeignClient userClient;

    public User findByEmail(String email){
        User user = userClient.findByEmail(email).getBody();
        if (user == null){
            logger.error("Email Not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email Found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userClient.findByEmail(s).getBody();
        if (user == null){
            logger.error("Email Not found: " + s);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email Found: " + s);
        return user;
    }
}
