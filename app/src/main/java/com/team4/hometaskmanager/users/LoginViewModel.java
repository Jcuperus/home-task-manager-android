package com.team4.hometaskmanager.users;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LoginViewModel extends BaseObservable {

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Bindable
    public String getUsername() {
        return user.username;
    }

    public void setUsername(String username) {
        user.username = username;
    }

    @Bindable
    public String getPassword() {
        return user.password;
    }

    public void setPassword(String password) {
        user.password = password;
    }
}
