package org.restRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestApisImpl implements RestApis {
    @Override
    public Response GetApi(String url) {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();

        return httpRequest.log().all().get();
    }

    @Override
    public Response GetApi(String url, Map<String, String> headers) {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers(headers);
        return httpRequest.get();
    }
}
