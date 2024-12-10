package com.example.sikkah.Controller;

import com.example.sikkah.ApiResponse.ApiResponse;
import com.example.sikkah.Model.Route;
import com.example.sikkah.Service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllRoutes() {
        return ResponseEntity.status(200).body(routeService.getAllRoutes());
    }

    @PostMapping("/add")
    public ResponseEntity addRoute(@RequestBody @Valid Route route, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        routeService.addRoute(route);
        return ResponseEntity.status(200).body(new ApiResponse("Route has been added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRoute(@PathVariable Integer id, @RequestBody @Valid Route route, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        routeService.updateRoute(id, route);
        return ResponseEntity.status(200).body(new ApiResponse("Route has been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRoute(@PathVariable Integer id) {
        routeService.deleteRoute(id);
        return ResponseEntity.status(200).body(new ApiResponse("Route has been deleted successfully"));
    }
    // CRUD - End

    // Getters
    @GetMapping("/get/by-id/{id}")
    public ResponseEntity getRouteById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(routeService.getRouteById(id));
    }

    @GetMapping("/get/by-start-station/{id}")
    public ResponseEntity getRouteByStationId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(routeService.getRouteByStartStationId(id));
    }
}
