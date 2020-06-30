package com.team4.hometaskmanager.users;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.team4.hometaskmanager.common.CustomTokenRequest;
import com.team4.hometaskmanager.common.Serializable;

import java.util.HashMap;
import java.util.Map;

public class LoginRepository {

    public CustomTokenRequest loginUser(Serializable user, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        return new CustomTokenRequest(Request.Method.POST, "login", user.toJson(), listener, errorListener);
    }

    public String getAuthToken(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account[] accounts = accountManager.getAccountsByType(UserAuthenticator.ACCOUNT_TYPE_KEY);

        if (accounts.length > 0) {
            return accountManager.peekAuthToken(accounts[0], UserAuthenticator.AUTHENTICATION_TYPE_KEY);
        }

        return null;
    }

    public Map<String, String> getAuthHeaders(Context context) {
        HashMap<String, String> headers = new HashMap<>();
        String token = getAuthToken(context);

        if (token != null && !token.isEmpty()) {
            headers.put("Authorization", token);
        }

        return headers;
    }

}
