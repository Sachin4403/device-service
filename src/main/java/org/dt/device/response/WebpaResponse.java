package org.dt.device.response;
import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebpaResponse {


    private Date date = new Date();
    int errorCode;
    String errorMessages;
    long timestamp;
    long counter;
}
