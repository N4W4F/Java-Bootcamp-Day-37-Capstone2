package com.example.sikkah.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Schedule {
    public Schedule() {
    }

    public Schedule(Integer id, Integer routeId, LocalDateTime departureTime, LocalDateTime arrivalTime, String status) {
        this.id = id;
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "Route ID cannot be empty") Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(@NotNull(message = "Route ID cannot be empty") Integer routeId) {
        this.routeId = routeId;
    }

    public @NotNull(message = "Departure Time cannot be empty") LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(@NotNull(message = "Departure Time cannot be empty") LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public @NotNull(message = "Arrival Time cannot be empty") LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(@NotNull(message = "Arrival Time cannot be empty") LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public @NotEmpty(message = "Schedule Status cannot be empty") @Pattern(regexp = "^(on time|delayed)$", message = "Schedule Status must be either 'On Time' or 'Delayed'") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "Schedule Status cannot be empty") @Pattern(regexp = "^(on time|delayed)$", message = "Schedule Status must be either 'On Time' or 'Delayed'") String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Route ID cannot be empty")
    private Integer routeId;

    @Column(columnDefinition = "time not null")
    @NotNull(message = "Departure Time cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime departureTime;

    @Column(columnDefinition = "time not null")
    @NotNull(message = "Arrival Time cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime arrivalTime;

    @Column(columnDefinition = "varchar(7) not null")
    @NotEmpty(message = "Schedule Status cannot be empty")
    @Pattern(regexp = "^(on time|delayed)$", message = "Schedule Status must be either 'On Time' or 'Delayed'")
    private String status;
}
