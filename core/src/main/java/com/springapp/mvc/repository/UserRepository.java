package com.springapp.mvc.repository;

import com.springapp.mvc.common.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gataullin Kamil
 * 28.03.2016 21:21
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findUserByLogin(String login);
}
