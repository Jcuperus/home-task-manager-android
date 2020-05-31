package com.team4.hometaskmanager.tasks;

import com.android.volley.Response;
import com.team4.hometaskmanager.common.GsonRequest;

public class TasksRepository {
    public void getTasks(Response.Listener<Task[]> listener, Response.ErrorListener errorListener) {
        GsonRequest<Task[]> request = new GsonRequest<>("/tasks", Task[].class, null, listener, errorListener);
    }
}
