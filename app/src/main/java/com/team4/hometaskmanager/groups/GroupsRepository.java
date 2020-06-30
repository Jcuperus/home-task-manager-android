package com.team4.hometaskmanager.groups;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.team4.hometaskmanager.common.GsonRequest;
import com.team4.hometaskmanager.users.LoginRepository;

public class GroupsRepository {

    private Context context;
    private LoginRepository loginRepository = new LoginRepository();

    public GroupsRepository() {}

    public GroupsRepository(Context context) {
        this.context = context;
    }

    public Request<Group[]> getGroups(Response.Listener<Group[]> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "groups", loginRepository.getAuthHeaders(context), Group[].class, listener, errorListener);
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
