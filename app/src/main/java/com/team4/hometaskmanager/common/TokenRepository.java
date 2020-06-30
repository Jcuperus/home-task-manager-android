package com.team4.hometaskmanager.common;

import java.util.HashMap;
import java.util.Map;

public class TokenRepository {

    public static String AUTHORIZATION_KEY = "Authorization";

    public static String getToken() {
        return "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYWVwIiwiZXhwIjoxNTkzODcxNzkxfQ.JL9avLAtTtzXTMBMChv-lhrttGKUAoAV-A8FrkLzVzroM2-iNG-Lu2va2j_QgRLsO9d6TuncS2qdX-VQBgFYlA";
    }

    public static Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION_KEY, getToken());
        return headers;
    }
}
