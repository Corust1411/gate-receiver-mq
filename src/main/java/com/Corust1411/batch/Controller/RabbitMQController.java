package com.Corust1411.batch.Controller;

import com.Corust1411.batch.Model.RabbitRequest;
import com.Corust1411.batch.Model.RabbitResponse;
import com.Corust1411.batch.Service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/device")
public class RabbitMQController {
    @Autowired
    RabbitMQService rabbitMQService;

    @PostMapping(value = "/rabbitmq",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RabbitResponse> consumer(RabbitRequest request){
        RabbitResponse response = new RabbitResponse();
        try{
            rabbitMQService.receiver(request);
            response.setRespCode("1000");
            response.setRespDesc("successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(Exception e){
            System.out.println("RabbitMQController_consumer > error > "+e.getMessage());
            response.setRespDesc("fail");
            response.setRespCode("0001");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
        }
    }
}
