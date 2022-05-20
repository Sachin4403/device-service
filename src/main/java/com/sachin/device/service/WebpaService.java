package com.sachin.device.service;

import com.sachin.device.client.WebpaClient;
import com.sachin.device.response.WebpaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebpaService {

    private  static Integer counter  = new Integer(0);


    @Autowired
    WebpaClient webpaClient;



    public WebpaResponse getConfig(String deviceId) {
        WebpaResponse webpaResponse = getWebpaConfig(deviceId);
        webpaResponse.setCounter(++counter);
        System.out.println("request no "+ counter+" and payload "+webpaResponse);
        return  webpaResponse;

    }
    private  WebpaResponse getWebpaConfig(String deviceId){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return webpaClient.getConfig(deviceId);
    }
}
