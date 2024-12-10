package com.example.sikkah.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(32) not null unique")
    @NotEmpty(message = "Station Name cannot be empty")
    private String name;

    @Column(columnDefinition = "varchar(16) not null")
    @NotEmpty(message = "Station Type cannot be empty")
    @Pattern(regexp = "^(bus|metro)$", message = "Station Type must be either 'Bus' or 'Metro'")
    private String type;

    @Column(columnDefinition = "varchar(50) not null")
    @NotEmpty(message = "Station Location cannot be empty")
    private String location;

    @Column(columnDefinition = "varchar(12) not null")
    @NotEmpty(message = "Station Status cannot be empty")
    @Pattern(regexp = "^(open|closed)", message = "Station Status must be either 'Open' or 'Closed'")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "Station Name cannot be empty") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Station Name cannot be empty") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Station Type cannot be empty") @Pattern(regexp = "^(bus|metro)$", message = "Station Type must be either 'Bus' or 'Metro'") String getType() {
        return type;
    }

    public void setType(@NotEmpty(message = "Station Type cannot be empty") @Pattern(regexp = "^(bus|metro)$", message = "Station Type must be either 'Bus' or 'Metro'") String type) {
        this.type = type;
    }

    public @NotEmpty(message = "Station Location cannot be empty") String getLocation() {
        return location;
    }

    public void setLocation(@NotEmpty(message = "Station Location cannot be empty") String location) {
        this.location = location;
    }

    public @NotEmpty(message = "Station Status cannot be empty") @Pattern(regexp = "^(open|closed)", message = "Station Status must be either 'Open' or 'Closed'") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "Station Status cannot be empty") @Pattern(regexp = "^(open|closed)", message = "Station Status must be either 'Open' or 'Closed'") String status) {
        this.status = status;
    }

    public Station(Integer id, String name, String type, String location, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.status = status;
    }

    public Station() {
    }
}
