package com.springapp.mvc.services;

import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param userInfo add new user into dv
     */
    @Transactional
    public void add(UserInfo userInfo) {
        userRepository.save(userInfo);
    }

    /**
     *
     * @param login
     * @return get user by unique login
     */

    public UserInfo getUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
