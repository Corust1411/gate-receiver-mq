package com.Corust1411.batch.Service;

import com.Corust1411.batch.Entity.Device;
import com.Corust1411.batch.Model.RabbitRequest;
import com.Corust1411.batch.Repository.RabbitMQRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    @Autowired
    RabbitMQRepository rabbitMQRepository;


    @RabbitListener(queues = "${Corust1411.rabbitmq.queue}")
    public void receiver(RabbitRequest request) {
        try {
            System.out.println("receiver msg = " + request);

            Device device = new Device();

            String MerchantID = request.getMerchantID();
            String TerminalID = request.getTerminalID();
            String Location = request.getLocation();
            String Effective = request.getEffective();
            String Status = request.getStatus();
            String Flag = request.getFlag();

            device.setMerchantID(MerchantID);
            device.setTerminalID(TerminalID);
            device.setLocation(Location);
            device.setEffective(Effective);
            device.setStatus(Status);
            device.setFlag(Flag);
            rabbitMQRepository.Insert(device);
        }catch(Exception e){
            System.out.println("RabbitMQService_receiver > error > " + e.getMessage());
        }
    }
}
