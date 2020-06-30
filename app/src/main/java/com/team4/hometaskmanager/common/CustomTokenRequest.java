package com.team4.hometaskmanager.common;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class CustomTokenRequest extends StringRequest {

    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);

    private String requestBody;

    public CustomTokenRequest(int method, String url, JSONObject requestBody, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, BackendVars.BASE_URL + url, listener, errorListener);
        this.requestBody = requestBody.toString();
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return TokenRepository.getHeaders();
    }

    @Override
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        try {
            return requestBody == null ? null : requestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException uee) {
            VolleyLog.wtf(
                    "Unsupported Encoding while trying to get the bytes of %s using %s",
                    requestBody, PROTOCOL_CHARSET);
            return null;
        }
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        if (response.headers.containsKey("Authorization")) {
            return Response.success(response.headers.get("Authorization"), HttpHeaderParser.parseCacheHeaders(response));
        }

        return super.parseNetworkResponse(response);
    }
}
