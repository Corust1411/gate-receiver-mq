package com.Corust1411.batch.Repository;

import com.Corust1411.batch.Entity.Device;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RabbitMQRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void Insert(Device device){
        try{
            entityManager.persist(device);
        }catch(Exception e){
            System.out.println("RabbitMQRepository_Insert > error > " + e.getMessage());
        }
    }
}
