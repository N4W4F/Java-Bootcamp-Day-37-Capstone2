package com.example.sikkah.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Ticket {
    public Ticket() {
    }

    public Ticket(Integer id, Integer userId, Integer routeId, LocalDateTime purchaseTime, String status) {
        this.id = id;
        this.userId = userId;
        this.routeId = routeId;
        this.purchaseTime = purchaseTime;
        this.status = status;
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

    public @NotNull(message = "Route ID cannot be empty") Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(@NotNull(message = "Route ID cannot be empty") Integer routeId) {
        this.routeId = routeId;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public @Pattern(regexp = "^(active|used|expired)$", message = "Ticket Status must be either 'Active', 'Used' or 'Expired'") String getStatus() {
        return status;
    }

    public void setStatus(@Pattern(regexp = "^(active|used|expired)$", message = "Ticket Status must be either 'Active', 'Used' or 'Expired'") String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "User ID cannot be empty")
    private Integer userId;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Route ID cannot be empty")
    private Integer routeId;

    @Column(columnDefinition = "datetime default current_timestamp")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime purchaseTime;

    @Column(columnDefinition = "varchar(7) default('active')")
    @Pattern(regexp = "^(active|used|expired)$", message = "Ticket Status must be either 'Active', 'Used' or 'Expired'")
    private String status;

    @PrePersist
    protected void onCreate() {
        this.purchaseTime = LocalDateTime.now();
        this.status = "active";
    }
}
