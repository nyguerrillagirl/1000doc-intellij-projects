package com.example.demo.soaprestdemo.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.soaprestdemo.soap.schema.GetGreetingRequest;
import com.example.demo.soaprestdemo.soap.schema.GetGreetingResponse;

@Endpoint
public class GreetingEndpoint {

    private static final String NAMESPACE = "http://example.com/greeting";

    @PayloadRoot(namespace = NAMESPACE, localPart = "GetGreetingRequest")
    @ResponsePayload
    public GetGreetingResponse getGreeting(@RequestPayload GetGreetingRequest request) {
        GetGreetingResponse response = new GetGreetingResponse();
        response.setMessage("Hello " + request.getName() + " from SOAP!");
        return response;
    }
}
