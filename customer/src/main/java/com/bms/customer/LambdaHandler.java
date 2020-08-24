package com.bms.customer;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaHandler implements RequestStreamHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(LambdaHandler.class);
	
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    static {
        try {
        	logger.info("insideLambdaHandler");
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(CustomerApplication.class);
        } catch (ContainerInitializationException e) {
            logger.debug("handleRequest :", e);
        }
    }
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
    	 logger.info("handleRequest");
        handler.proxyStream(inputStream, outputStream, context);
        outputStream.close();
    }
}