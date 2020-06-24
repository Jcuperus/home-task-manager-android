package com.team4.hometaskmanager.common;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

public class GsonRequest<T> extends BaseRequest<T> {

    private final Gson gson = new Gson();
    private final Class<T> parseClass;

    public GsonRequest(int method, String url, Class<T> parseClass, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.parseClass = parseClass;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, parseClass), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException | JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}
