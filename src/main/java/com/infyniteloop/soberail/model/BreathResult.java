package com.infyniteloop.soberail.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.UUID;

/**
 * BreathAnalyzer
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BreathResult implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("recordId")
    private UUID id = null;


    @JsonProperty("testerId")
    private UUID testerId = null;


    @JsonProperty("result")
    private Integer result = null;


    @JsonProperty("location")
    private String location = null;


    @JsonProperty("deviceSno")
    private String deviceSno = null;


    @JsonProperty("recordNo")
    private String recordNo = null;


    @JsonProperty("exhaleVol")
    private String exhaleVol = null;


    @JsonProperty("exhaleTime")
    private String exhaleTime = null;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @JsonProperty("calibrationDate")
    private String calibrationDate = null;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @JsonProperty("testDateTime")
    private String testDateTime = null;

    @JsonProperty("LAT")
    private String lattitude = null;

    @JsonProperty("LONG")
    private String longitude = null;


    @JsonProperty("image")
    private String image = null;


}

