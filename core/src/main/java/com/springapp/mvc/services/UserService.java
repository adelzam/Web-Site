package com.springapp.mvc.services;

import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param userInfo add new user into db
     */
    @Transactional
    public void add(UserInfo userInfo) {
        int key = 32455 + (userInfo.getLogin().hashCode() * userInfo.getFio().hashCode()) / 145
                + userInfo.getRole().hashCode();
        userInfo.setKey(String.valueOf(key).replace("-",""));
        userRepository.save(userInfo);
    }

    /**
     *
     * @param login
     * @return get user by unique login
     */

    @Transactional
    public UserInfo getUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
