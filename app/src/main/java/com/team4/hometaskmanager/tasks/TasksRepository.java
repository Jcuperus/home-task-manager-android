package com.team4.hometaskmanager.tasks;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.team4.hometaskmanager.common.CustomJsonObjectRequest;
import com.team4.hometaskmanager.common.GsonRequest;
import com.team4.hometaskmanager.users.LoginRepository;

import org.json.JSONObject;

import java.util.Map;

public class TasksRepository {
    private Context context;
    private final LoginRepository loginRepository = new LoginRepository();

    public TasksRepository() {}

    public TasksRepository(Context context) {
        this.context = context;
    }

    public Request<Task> getTask(Integer taskId, Response.Listener<Task> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "tasks/" + taskId, loginRepository.getAuthHeaders(context), Task.class, listener, errorListener);
    }

    public Request<Task[]> getTasks(Response.Listener<Task[]> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(Request.Method.GET, "tasks", loginRepository.getAuthHeaders(context), Task[].class, listener, errorListener);
    }

    public JsonObjectRequest saveTask(Task task, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        JsonObjectRequest request;
        Map<String, String> headers = loginRepository.getAuthHeaders(context);

        if (task.id != null && task.id > 0) {
            request = new CustomJsonObjectRequest(Request.Method.PUT, "tasks", headers, task.toJson(), listener, errorListener);
        } else {
            request = new CustomJsonObjectRequest(Request.Method.POST, "tasks", headers, task.toJson(), listener, errorListener);
        }

        return request;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
