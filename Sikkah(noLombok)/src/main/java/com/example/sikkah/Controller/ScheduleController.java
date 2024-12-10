package com.example.sikkah.Controller;

import com.example.sikkah.ApiResponse.ApiResponse;
import com.example.sikkah.Model.Schedule;
import com.example.sikkah.Service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllSchedules() {
        return ResponseEntity.status(200).body(scheduleService.getAllSchedules());
    }

    @PostMapping("/add")
    public ResponseEntity addSchedule(@RequestBody @Valid Schedule schedule, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        scheduleService.addSchedule(schedule);
        return ResponseEntity.status(200).body(new ApiResponse("Schedule has been added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSchedule(@PathVariable Integer id, @RequestBody @Valid Schedule schedule, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        scheduleService.updateSchedule(id, schedule);
        return ResponseEntity.status(200).body(new ApiResponse("Schedule has been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSchedule(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.status(200).body(new ApiResponse("Schedule has been deleted successfully"));
    }
    // CRUD - End

    // Getters
    @GetMapping("/get/by-id/{id}")
    public ResponseEntity getScheduleById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(scheduleService.getScheduleById(id));
    }

    @GetMapping("/get/by-route/{id}")
    public ResponseEntity getScheduleByRouteId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(scheduleService.getScheduleByRouteId(id));
    }

    @GetMapping("/get/by-status/{status}")
    public ResponseEntity getScheduleByStatus(@PathVariable String status) {
        return ResponseEntity.status(200).body(scheduleService.getScheduleByStatus(status));
    }

    @GetMapping("/get/by-departure-time")
    public ResponseEntity getScheduleByDepartureTime(@RequestBody LocalDateTime date) {
        return ResponseEntity.status(200).body(scheduleService.getScheduleByDepartureTime(date));
    }
}
