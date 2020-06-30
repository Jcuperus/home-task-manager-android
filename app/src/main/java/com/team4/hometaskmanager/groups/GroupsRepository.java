package com.team4.hometaskmanager.groups;

import com.android.volley.Request;
import com.android.volley.Response;
import com.team4.hometaskmanager.common.GsonRequest;

public class GroupsRepository {
    public Request<Group[]> getGroups(Response.Listener<Group[]> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "groups", Group[].class, listener, errorListener);
    }
}
