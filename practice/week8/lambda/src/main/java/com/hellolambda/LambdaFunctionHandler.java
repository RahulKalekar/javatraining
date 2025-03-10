package com.hellolambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class LambdaFunctionHandler implements RequestHandler<Map<String, Object>, String> {

    // The default main method to run Spring Boot locally
    public static void main(String[] args) {
        SpringApplication.run(LambdaFunctionHandler.class, args);
    }

    // This method will be used by AWS Lambda to handle the request
    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        return "Hello, World from AWS Lambda!";
    }
}
