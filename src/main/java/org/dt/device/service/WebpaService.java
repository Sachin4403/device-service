package org.dt.device.service;

import org.dt.device.client.WebpaClient;
import org.dt.device.response.WebpaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

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
