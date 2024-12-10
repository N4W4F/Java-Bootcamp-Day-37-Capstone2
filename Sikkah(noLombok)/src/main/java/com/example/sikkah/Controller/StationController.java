package com.example.sikkah.Controller;

import com.example.sikkah.ApiResponse.ApiResponse;
import com.example.sikkah.Model.Station;
import com.example.sikkah.Service.StationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stations")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    // CRUD
    @GetMapping("/get")
    public ResponseEntity getAllStations() {
        return ResponseEntity.status(200).body(stationService.getAllStations());
    }

    @PostMapping("/add")
    public ResponseEntity addStation(@RequestBody @Valid Station station, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        stationService.addStation(station);
        return ResponseEntity.status(200).body(new ApiResponse("Station has been added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStation(@PathVariable Integer id, @RequestBody @Valid Station station, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        stationService.updateStation(id, station);
        return ResponseEntity.status(200).body(new ApiResponse("Station has been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStation(@PathVariable Integer id) {
        stationService.deleteStation(id);
        return ResponseEntity.status(200).body(new ApiResponse("Station has been deleted successfully"));
    }
    // CRUD - End

    // Getters
    @GetMapping("/get/by-id/{id}")
    public ResponseEntity getStationById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(stationService.getStationById(id));
    }

    @GetMapping("/get/by-name/{name}")
    public ResponseEntity getStationByName(@PathVariable String name) {
        return ResponseEntity.status(200).body(stationService.getStationByName(name));
    }

    @GetMapping("/get/by-type/{type}")
    public ResponseEntity getStationByType(@PathVariable String type) {
        return ResponseEntity.status(200).body(stationService.getStationByType(type));
    }

    @GetMapping("/get/by-location/{location}")
    public ResponseEntity getStationByLocation(@PathVariable String location) {
        return ResponseEntity.status(200).body(stationService.getStationByLocation(location));
    }

    @GetMapping("/get/by-status/{status}")
    public ResponseEntity getStationByStatus(@PathVariable String status) {
        return ResponseEntity.status(200).body(stationService.getStationByStatus(status));
    }
}
