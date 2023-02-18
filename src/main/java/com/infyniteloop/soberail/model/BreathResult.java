package com.infyniteloop.soberail.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * BreathAnalyzer
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BreathResult implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    @JsonProperty("id")
    private UUID id = null;


    @JsonProperty("testerId")
    private UUID testerId = null;


    @JsonProperty("result")
    private Float result = null;


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


    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonProperty("calibrationDate")
    private Timestamp calibrationDate = null;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @JsonProperty("testDateTime")
    private Timestamp testDateTime = null;

    @JsonProperty("LAT")
    private String lattitude = null;

    @JsonProperty("LONG")
    private String longitude = null;


    @JsonProperty("image")
    private String image = null;


}

