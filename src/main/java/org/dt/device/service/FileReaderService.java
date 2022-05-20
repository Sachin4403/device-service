package org.dt.device.service;


import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class FileReaderService {


    public List<String> readFile(Path path) {
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<String>();
        try {
            bufferedReader = Files.newBufferedReader(path);
            String line = bufferedReader.readLine();
            while (!Objects.isNull(line)) {
                System.out.println("Thread name : "+Thread.currentThread().getName()+ " reading line no " + line);
                list.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(bufferedReader)) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  list;
    }
}


