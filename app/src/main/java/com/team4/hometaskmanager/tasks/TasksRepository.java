package com.team4.hometaskmanager.tasks;

import com.android.volley.Request;
import com.android.volley.Response;
import com.team4.hometaskmanager.common.GsonRequest;

public class TasksRepository {
    public Request<Task> getTask(Integer taskId, Response.Listener<Task> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "tasks/" + taskId, Task.class, listener, errorListener);
    }

    public Request<Task[]> getTasks(Response.Listener<Task[]> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "tasks", Task[].class, listener, errorListener);
    }
}
