package org.dt.device.controller;

import org.dt.device.response.WebpaResponse;
import org.dt.device.service.WebpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("device")
public class WebpaController {

    @Autowired
    WebpaService webpaService;

    @GetMapping("/{deviceId}/config")
    public  ResponseEntity<WebpaResponse> getConfig(@PathVariable String deviceId){
        System.out.println("request received");
       WebpaResponse webpaResponse  = webpaService.getConfig(deviceId);
       ResponseEntity response = ResponseEntity.status(webpaResponse.getErrorCode()).body(webpaResponse);
       return  response;
    }
}
