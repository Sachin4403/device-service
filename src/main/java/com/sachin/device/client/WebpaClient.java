package com.sachin.device.client;

import com.sachin.device.response.WebpaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
public class WebpaClient {


    private  final RestTemplate restTemplate;

    public WebpaClient(@Value("${webpa.service.url}") String url) {
        this.restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
    }


    public WebpaResponse getConfig(String deviceId){
        return  this.restTemplate.getForObject("/device/{deviceId}/config",WebpaResponse.class,deviceId);
    }
}