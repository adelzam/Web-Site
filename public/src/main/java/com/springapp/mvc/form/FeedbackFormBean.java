package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by adelzamalutdinov on 23.03.16.
 */
public class FeedbackFormBean {
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String name;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Неверный формат email")
    private String email;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 1, max = 13, message = "Введите тему вашего обращения")
    private String sub;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 1, max = 1000, message = "Ваше сообщение привышает 1000 символов")
    private String message;

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

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FeedbackFormBean{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sub='" + sub + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
