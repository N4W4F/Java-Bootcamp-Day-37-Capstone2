package com.example.sikkah.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class User {

    public User() {
    }

    public User(Integer id, String name, String email, String password, String preference, Double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preference = preference;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "User Name cannot be empty") @Size(min = 3, message = "User Name must be 3-12 characters") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "User Name cannot be empty") @Size(min = 3, message = "User Name must be 3-12 characters") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "User Email cannot be empty") @Email(message = "User Email must be in valid email format") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "User Email cannot be empty") @Email(message = "User Email must be in valid email format") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "User Password cannot be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "User Password cannot be empty") String password) {
        this.password = password;
    }

    public @NotEmpty(message = "User Preference cannot empty") @Pattern(regexp = "^(shortest|cheapest)$", message = "User Preference must be either 'Shortest' or 'Cheapest'") String getPreference() {
        return preference;
    }

    public void setPreference(@NotEmpty(message = "User Preference cannot empty") @Pattern(regexp = "^(shortest|cheapest)$", message = "User Preference must be either 'Shortest' or 'Cheapest'") String preference) {
        this.preference = preference;
    }

    public @NotNull(message = "User Balance cannot be empty") Double getBalance() {
        return balance;
    }

    public void setBalance(@NotNull(message = "User Balance cannot be empty") Double balance) {
        this.balance = balance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(12) not null")
    @NotEmpty(message = "User Name cannot be empty")
    @Size(min = 3, message = "User Name must be 3-12 characters")
    private String name;

    @Column(columnDefinition = "varchar(32) not null unique")
    @NotEmpty(message = "User Email cannot be empty")
    @Email(message = "User Email must be in valid email format")
    private String email;

    @Column(columnDefinition = "varchar(21) not null")
    @NotEmpty(message = "User Password cannot be empty")
    private String password;

    @Column(columnDefinition = "varchar(8) not null")
    @NotEmpty(message = "User Preference cannot empty")
    @Pattern(regexp = "^(shortest|cheapest)$", message = "User Preference must be either 'Shortest' or 'Cheapest'")
    private String preference;

    @NotNull(message = "User Balance cannot be empty")
    @Column(columnDefinition = "decimal not null")
    private Double balance;
}