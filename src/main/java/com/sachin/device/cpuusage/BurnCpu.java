package com.sachin.device.cpuusage;

import com.sachin.device.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Component
public class BurnCpu {


    @Autowired
    FileReaderService fileReaderService;

    @PostConstruct
    private  void  init(){
        int count = Runtime.getRuntime().availableProcessors();
        Runnable runnable = () -> {
//            while (true){
//                int max = 200;
//                for(int i=0;i<max;i++){
//                    System.out.println("factorial of "+i+" is "+factorial(i));
//                }
//                try {
//                    readFile("/opt/app/file03.txt");
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        };
        for (int i = 0; i < count; i++) {
            System.out.println("Scheduling thread "+ (i+1));
            new Thread(runnable).start();
        }
    }

    public static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }


    public void readFile(String p) {
        Path pa = Paths.get(p);
        boolean isDocker = Files.exists(pa);
        if(!isDocker){
            p="/Users/sachinnarang/Desktop/test/prometheus.yml";
        }
        Path path = Paths.get(p);
        List<String> contents = fileReaderService.readFile(path);
        if(!Objects.isNull(contents)){
            contents.forEach(line -> {
                System.out.println("Thread name : "+Thread.currentThread().getName()+ " Received : "+ line);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
