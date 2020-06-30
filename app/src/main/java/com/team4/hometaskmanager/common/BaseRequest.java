package com.team4.hometaskmanager.common;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.Map;

abstract public class BaseRequest<T> extends Request<T> {

    private Map<String, String> headers;
    private final Response.Listener<T> listener;

    public BaseRequest(int method, String url, Map<String, String> headers, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, BackendVars.BASE_URL + url, errorListener);
        this.listener = listener;
        this.headers = headers;
        this.headers.put("Content-Type", "application/json");
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers: super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
