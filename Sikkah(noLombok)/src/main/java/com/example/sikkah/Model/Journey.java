package com.example.sikkah.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "User ID cannot be empty")
    private Integer userId;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Start Station ID cannot be empty")
    private Integer startStationId;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "End Station ID cannot be empty")
    private Integer endStationId;

    @Column(columnDefinition = "datetime not null")
    @NotNull(message = "Start Time cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    @Column(columnDefinition = "datetime not null")
    @NotNull(message = "End Time cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    @Column(columnDefinition = "decimal not null")
    @NotNull(message = "Journey Total Cost cannot be empty")
    private Double totalCost;

    public Journey(Integer id, Integer userId, Integer startStationId, Integer endStationId, LocalDateTime startTime, LocalDateTime endTime, Double totalCost) {
        this.id = id;
        this.userId = userId;
        this.startStationId = startStationId;
        this.endStationId = endStationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalCost = totalCost;
    }

    public Journey() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "User ID cannot be empty") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "User ID cannot be empty") Integer userId) {
        this.userId = userId;
    }

    public @NotNull(message = "Start Station ID cannot be empty") Integer getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(@NotNull(message = "Start Station ID cannot be empty") Integer startStationId) {
        this.startStationId = startStationId;
    }

    public @NotNull(message = "End Station ID cannot be empty") Integer getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(@NotNull(message = "End Station ID cannot be empty") Integer endStationId) {
        this.endStationId = endStationId;
    }

    public @NotNull(message = "Start Time cannot be empty") LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull(message = "Start Time cannot be empty") LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public @NotNull(message = "End Time cannot be empty") LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(@NotNull(message = "End Time cannot be empty") LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public @NotNull(message = "Journey Total Cost cannot be empty") Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(@NotNull(message = "Journey Total Cost cannot be empty") Double totalCost) {
        this.totalCost = totalCost;
    }
}
