package com.cloud.hroauth.service;

import com.cloud.hroauth.client.UserClient;
import com.cloud.hroauth.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserClient client;

    public User findByEmail(String email){
        User user = client.findByEmail(email).getBody();

        if(user == null){
            logger.error("Email not found: {}", email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: {}", email);
        return user;
    }

}
