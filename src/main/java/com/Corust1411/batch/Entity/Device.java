package com.Corust1411.batch.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Device_List")
public class Device implements Serializable {
    @Id
    @Column(name = "deviceID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deviceID;
    @Column(name = "merchantid")
    private String merchantID;
    @Column(name = "terminalid")
    private String terminalID;
    @Column(name = "location")
    private String location;
    @Column(name = "effective")
    private String effective;
    @Column(name = "status")
    private String status;
    @Column(name = "flag")
    private String flag;
    @Column(name = "result")
    private String result;
    @CreationTimestamp
    @Column(name="time_stamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.SSS",timezone = "Asia/Bangkok")
    private Date timestamp;
}
