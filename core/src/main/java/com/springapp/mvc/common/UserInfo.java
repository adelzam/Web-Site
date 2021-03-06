package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.List;

/**
 * Gataullin Kamil
 * 28.03.2016 20:58
 */
@Entity
@Table(name = "h_users")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name and Last name of client
     */
    private String fio;

    /**
     * Login (email)
     */
    private String login;

    /**
     * hash password
     */
    private String hashPassword;

    /**
     * user's role
     */
    private String role;

    /**
     * unique key for registration with we send to email
     */
    private String key;

    /**
     * iser is enable or not
     */
    private Boolean enabled;

    @OneToMany(mappedBy = "userInfo")
    private List<OrderInfo> orders ;

    public UserInfo() {
    }

    public UserInfo(String fio, String login, String hashPassword, String role, String key, Boolean enabled, List<OrderInfo> orders) {
        this.fio = fio;
        this.login = login;
        this.hashPassword = hashPassword;
        this.role = role;
        this.key = key;
        this.enabled = enabled;
        this.orders = orders;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<OrderInfo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderInfo> orders) {
        this.orders = orders;
    }
}
