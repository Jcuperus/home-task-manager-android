package com.team4.hometaskmanager.users;

import com.team4.hometaskmanager.common.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public class User implements Serializable {

    public Integer id;
    public String username;
    public String password;

    public JSONObject toJson() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", username);
            jsonObject.put("password", password);
            return jsonObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
