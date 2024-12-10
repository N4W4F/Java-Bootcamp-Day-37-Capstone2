package com.example.sikkah.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Route {
    public Route() {
    }

    public Route(Integer id, Integer startStationId, Integer endStationId, String transportType, Integer durationMinutes, Double price) {
        this.id = id;
        this.startStationId = startStationId;
        this.endStationId = endStationId;
        this.transportType = transportType;
        this.durationMinutes = durationMinutes;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Route Start Station ID cannot be empty")
    private Integer startStationId;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Route End Stations ID cannot be empty")
    private Integer endStationId;

    @Column(columnDefinition = "varchar(5) not null")
    @NotEmpty(message = "Route Transport Type cannot be empty")
    @Pattern(regexp = "^(bus|metro)$", message = "Route Transport Type must be either 'Bus' or 'Metro'")
    private String transportType;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Route Duration Minutes cannot be empty")
    private Integer durationMinutes;

    @Column(columnDefinition = "decimal(5,2) not null")
    @NotNull(message = "Route Price cannot be empty")
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "Route Start Station ID cannot be empty") Integer getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(@NotNull(message = "Route Start Station ID cannot be empty") Integer startStationId) {
        this.startStationId = startStationId;
    }

    public @NotNull(message = "Route End Stations ID cannot be empty") Integer getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(@NotNull(message = "Route End Stations ID cannot be empty") Integer endStationId) {
        this.endStationId = endStationId;
    }

    public @NotEmpty(message = "Route Transport Type cannot be empty") @Pattern(regexp = "^(bus|metro)$", message = "Route Transport Type must be either 'Bus' or 'Metro'") String getTransportType() {
        return transportType;
    }

    public void setTransportType(@NotEmpty(message = "Route Transport Type cannot be empty") @Pattern(regexp = "^(bus|metro)$", message = "Route Transport Type must be either 'Bus' or 'Metro'") String transportType) {
        this.transportType = transportType;
    }

    public @NotNull(message = "Route Duration Minutes cannot be empty") Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(@NotNull(message = "Route Duration Minutes cannot be empty") Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public @NotNull(message = "Route Price cannot be empty") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Route Price cannot be empty") Double price) {
        this.price = price;
    }
}
