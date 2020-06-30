package com.team4.hometaskmanager.tasks;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.team4.hometaskmanager.common.CustomJsonObjectRequest;
import com.team4.hometaskmanager.common.GsonRequest;

import org.json.JSONObject;

public class TasksRepository {
    public Request<Task> getTask(Integer taskId, Response.Listener<Task> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "tasks/" + taskId, Task.class, listener, errorListener);
    }

    public Request<Task[]> getTasks(Response.Listener<Task[]> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "tasks", Task[].class, listener, errorListener);
    }

    public JsonObjectRequest saveTask(Task task, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        JsonObjectRequest request;

        if (task.id != null && task.id > 0) {
            request = new CustomJsonObjectRequest(Request.Method.PUT, "tasks", task.toJson(), listener, errorListener);
        } else {
            request = new CustomJsonObjectRequest(Request.Method.POST, "tasks", task.toJson(), listener, errorListener);
        }

        return request;
    }
}
