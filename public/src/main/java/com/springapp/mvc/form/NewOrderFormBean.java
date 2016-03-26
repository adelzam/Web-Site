package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
public class NewOrderFormBean {
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String name;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Неверный формат email")
    private String email;

    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    private String phone;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String address;

    @AssertTrue(message = "Примите условия договора")
    private Boolean signIn;


    @Size(min = 0, max = 300, message = "Ваше сообщение привышает 300 символов")
    private String message;

    public NewOrderFormBean() {
    }

    public NewOrderFormBean(String name, String email, String phone, String address, Boolean signIn, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.signIn = signIn;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSignIn() {
        return signIn;
    }

    public void setSignIn(Boolean signIn) {
        this.signIn = signIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
