package com.Corust1411.batch.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RabbitRequest implements Serializable {
    @JsonProperty("merchantID")
    private String MerchantID;
    @JsonProperty("terminalID")
    private String TerminalID;
    @JsonProperty("location")
    private String Location;
    @JsonProperty("effective")
    private String Effective;
    @JsonProperty("status")
    private String Status;
    @JsonProperty("flag")
    private String Flag;
}
