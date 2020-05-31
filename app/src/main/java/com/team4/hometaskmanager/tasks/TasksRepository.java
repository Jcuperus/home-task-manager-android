package com.team4.hometaskmanager.tasks;

import com.android.volley.Request;
import com.android.volley.Response;
import com.team4.hometaskmanager.common.GsonRequest;

public class TasksRepository {
    public Request<Task[]> getTasks(Response.Listener<Task[]> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>("/tasks", Task[].class, null, listener, errorListener);
    }
}
