package com.example.sikkah.Service;

import com.example.sikkah.ApiResponse.ApiException;
import com.example.sikkah.Model.Maintenance;
import com.example.sikkah.Repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    public void addMaintenance(Maintenance maintenance) {
        maintenanceRepository.save(maintenance);
    }

    public void updateMaintenance(Integer id, Maintenance maintenance) {
        Maintenance oldMaintenance = maintenanceRepository.findMaintenanceById(id);
        if (oldMaintenance == null)
            throw new ApiException("Maintenance with ID: " + id + " was not found");

        oldMaintenance.setStationId(maintenance.getStationId());
        oldMaintenance.setStartTime(maintenance.getStartTime());
        oldMaintenance.setEndTime(maintenance.getEndTime());
        oldMaintenance.setReason(maintenance.getReason());

        maintenanceRepository.save(oldMaintenance);
    }

    public void deleteMaintenance(Integer id) {
        Maintenance maintenance = maintenanceRepository.findMaintenanceById(id);
        if (maintenance == null)
            throw new ApiException("Maintenance with ID: " + id + " was not found");

        maintenanceRepository.delete(maintenance);
    }

    public List<Maintenance> getMaintenanceByStationAndTime(Integer stationId, LocalDateTime startTime, LocalDateTime endTime) {
        return maintenanceRepository.findByStationIdAndTimeRange(stationId, startTime, endTime);
    }
}