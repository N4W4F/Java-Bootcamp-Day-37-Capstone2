package com.example.sikkah.Controller;

import com.example.sikkah.ApiResponse.ApiResponse;
import com.example.sikkah.Model.Maintenance;
import com.example.sikkah.Service.MaintenanceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllMaintenances() {
        return ResponseEntity.status(200).body(maintenanceService.getAllMaintenances());
    }

    @PostMapping("/add")
    public ResponseEntity addMaintenance(@RequestBody @Valid Maintenance maintenance, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        maintenanceService.addMaintenance(maintenance);
        return ResponseEntity.status(200).body(new ApiResponse("Maintenance schedule added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMaintenance(@PathVariable Integer id, @RequestBody @Valid Maintenance maintenance, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        maintenanceService.updateMaintenance(id, maintenance);
        return ResponseEntity.status(200).body(new ApiResponse("Maintenance schedule updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMaintenance(@PathVariable Integer id) {
        maintenanceService.deleteMaintenance(id);
        return ResponseEntity.status(200).body(new ApiResponse("Maintenance schedule deleted successfully"));
    }

    @GetMapping("/get-by-station")
    public ResponseEntity getMaintenanceByStationAndTime(@RequestParam Integer stationId,
                                                         @RequestParam String startTime,
                                                         @RequestParam String endTime) {
        List<Maintenance> maintenances = maintenanceService.getMaintenanceByStationAndTime(
                stationId, LocalDateTime.parse(startTime), LocalDateTime.parse(endTime));
        return ResponseEntity.status(200).body(maintenances);
    }
}
