package org.restRequests;

import io.restassured.response.Response;

import java.util.Map;

public interface RestApis {

    Response GetApi(String url);

    Response GetApi(String url, Map<String, String> headers);
}
