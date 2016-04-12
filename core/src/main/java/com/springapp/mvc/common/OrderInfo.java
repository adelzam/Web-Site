package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Entity
@Table(name = "h_order")
public class OrderInfo {

    /**
     * order id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * name of person who made order
     */
    @Column(name = "name")
    private String name;

    /**
     * address where we will need order
     */
    @Column(name = "address")
    private String address;

    /**
     * contact email info
     */
    @Column(name = "email")
    private String email;

    /**
     * contact phone
     */
    @Column(name = "phone")
    private String phone;

    /**
     * some information about details of order
     */
    @Column(name = "message")
    private  String message;

    /**
     * id of registered user
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    /**
     * is we registered this order
     * (have pay and another)
     */
    @Column(name = "registered")
    private Boolean registered;

    /**
     * creation date
     */
    @Column
    private Date creationDate;

    public OrderInfo() {
    }

    public OrderInfo(String name, String address, String email, String phone, String message, UserInfo userInfo, Date creationDate) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.userInfo = userInfo;
        this.creationDate = creationDate;
        this.registered = true;
    }

    public OrderInfo(String name) {
        this.name = name;
        this.address = null;
        this.email = null;
        this.phone = null;
        this.message = null;
        this.userInfo = null;
        this.creationDate = null;
        this.registered = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
