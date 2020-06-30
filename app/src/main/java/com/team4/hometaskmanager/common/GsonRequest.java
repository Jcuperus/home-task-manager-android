package com.team4.hometaskmanager.common;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GsonRequest<T> extends BaseRequest<T> {

    private final Gson gson = new Gson();
    private final Class<T> klass;

    public GsonRequest(int method, String url, Map<String, String> headers, Class<T> klass, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, headers, listener, errorListener);
        this.klass = klass;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, klass), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException | JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}
