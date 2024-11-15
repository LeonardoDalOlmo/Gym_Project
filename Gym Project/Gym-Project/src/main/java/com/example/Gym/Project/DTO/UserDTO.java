package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.User;

public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String login;

    public UserDTO(Integer id, String name, String email, String phoneNumber, String password, String login) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.login = login;
    }

    public UserDTO(User entity){
        id = entity.getUserid();
        name = entity.getName();
        email = entity.getEmail();
        phoneNumber = entity.getPhoneNumber();
        password = entity.getPassword();
        login = entity.getLogin();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
