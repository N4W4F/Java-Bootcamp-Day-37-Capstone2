package com.example.sikkah.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Maintenance {
    public Maintenance() {
    }

    public Maintenance(Integer id, Integer stationId, LocalDateTime startTime, LocalDateTime endTime, String reason) {
        this.id = id;
        this.stationId = stationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Maintenance Station ID cannot be empty")
    private Integer stationId;

    @Column(columnDefinition = "datetime not null")
    @NotNull(message = "Maintenance Start Time cannot be empty")
    private LocalDateTime startTime;

    @Column(columnDefinition = "datetime not null")
    @NotNull(message = "Maintenance End Time cannot be empty")
    private LocalDateTime endTime;

    @Column(columnDefinition = "varchar(100)")
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "Maintenance Station ID cannot be empty") Integer getStationId() {
        return stationId;
    }

    public void setStationId(@NotNull(message = "Maintenance Station ID cannot be empty") Integer stationId) {
        this.stationId = stationId;
    }

    public @NotNull(message = "Maintenance Start Time cannot be empty") LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull(message = "Maintenance Start Time cannot be empty") LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public @NotNull(message = "Maintenance End Time cannot be empty") LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(@NotNull(message = "Maintenance End Time cannot be empty") LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

