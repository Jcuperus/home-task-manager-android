package com.team4.hometaskmanager.common;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

public class CustomJsonObjectRequest extends JsonObjectRequest {

    private Map<String, String> headers;

    public CustomJsonObjectRequest(int method, String url, Map<String, String> headers, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, BackendVars.BASE_URL + url, jsonRequest, listener, errorListener);
        this.headers = headers;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }
}
