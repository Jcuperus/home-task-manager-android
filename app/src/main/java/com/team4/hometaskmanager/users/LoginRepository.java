package com.team4.hometaskmanager.users;

import com.android.volley.Request;
import com.android.volley.Response;
import com.team4.hometaskmanager.common.CustomTokenRequest;
import com.team4.hometaskmanager.common.Serializable;

public class LoginRepository {

    public CustomTokenRequest loginUser(Serializable user, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        return new CustomTokenRequest(Request.Method.POST, "login", user.toJson(), listener, errorListener);
    }

}
