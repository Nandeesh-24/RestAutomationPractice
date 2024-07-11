package org.services;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import org.apache.http.params.CoreConnectionPNames;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.constants.Constants;
import org.restRequests.RestApis;
import org.restRequests.RestApisImpl;
import org.testng.Assert;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class MyServiceRequests {

    public static final Logger log = Logger.getLogger(MyServiceRequests.class.getName());
    RestApis rest = new RestApisImpl();

    public void getBookResponse(){
        Response response = rest.GetApi(Constants.getBook);
        log.info(String.valueOf(response.getStatusCode()));
        log.info(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
        long responseTime = response.time();
        log.info("Response Time: " + responseTime + " ms");
    }

    public void asyncGet(int delay) throws ExecutionException, InterruptedException {
        ListenableFuture<org.asynchttpclient.Response> responseFuture = Dsl.asyncHttpClient().
                prepareGet("https://reqres.in/api/users/delay="+delay+"&unique="+System.currentTimeMillis())
                .execute();
        log.info(responseFuture.get().getResponseBody());
    }

    public void proxyGetRequest(){
        RestAssured.proxy("");
        getBookResponse();
    }

    public void timeoutGetRequest() throws ExecutionException, InterruptedException {
        HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT,5000)
                .setParam(CoreConnectionPNames.SO_TIMEOUT,1000);
        RestAssured.config = RestAssured.config().httpClient(httpClientConfig);
        getBookResponse();
    }
}
