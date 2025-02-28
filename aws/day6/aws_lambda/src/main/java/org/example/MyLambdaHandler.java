package org.example;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.naming.Context;

public class MyLambdaHandler implements RequestHandler<String, String> {


    @Override
    public String handleRequest(String s, com.amazonaws.services.lambda.runtime.Context context) {
        return "Hello, " + s + " from AWS Lambda!";
    }
}
