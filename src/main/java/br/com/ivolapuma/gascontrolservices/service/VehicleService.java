package br.com.ivolapuma.gascontrolservices.service;

import br.com.ivolapuma.gascontrolservices.model.Vehicle;
import br.com.ivolapuma.gascontrolservices.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle create(Vehicle newVehicle) {
        validateVehicle(newVehicle);
        Vehicle vehicle = repository.save(newVehicle);
        return vehicle;
    }

    private void validateVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Instance of Vehicle cannot be null.");
        } else if (vehicle.getVehicleIdNumber() == null || vehicle.getVehicleIdNumber() <= 0L) {
            throw new IllegalArgumentException("VehicleIdNumber attribute is invalid. Must be a positive Long number.");
        } else if (vehicle.getLicensePlate() == null || vehicle.getLicensePlate().isEmpty()) {
            throw new IllegalArgumentException("LicensePlate attribute is invalid. Must be a not empty String.");
        } else if (vehicle.getMake() == null || vehicle.getMake().isEmpty()) {
            throw new IllegalArgumentException("Make attribute is invalid. Must be a not empty String.");
        } else if (vehicle.getModel() == null || vehicle.getModel().isEmpty()) {
            throw new IllegalArgumentException("Model attribute is invalid. Must be a not empty String.");
        } else if (vehicle.getModelYear() == null || vehicle.getModelYear() <= 1899) {
            throw new IllegalArgumentException("ModelYear attribute is invalid. Must be a positive Integer greater than 1899.");
        } else if (vehicle.getManufactureYear() == null || vehicle.getManufactureYear() <= 1899) {
            throw new IllegalArgumentException("ManufactureYear attribute is invalid. Must be a positive Integer greater than 1899.");
        } else if (vehicle.getColor() == null || vehicle.getColor().isEmpty()) {
            throw new IllegalArgumentException("Color attribute is invalid. Must be a not empty String.");
        } else if (vehicle.getBodyType() == null || vehicle.getBodyType().isEmpty()) {
            throw new IllegalArgumentException("BodyType attribute is invalid. Must be a not empty String.");
        } else if (vehicle.getTransmissionType() == null || vehicle.getTransmissionType().isEmpty()) {
            throw new IllegalArgumentException("TransmissionType attribute is invalid. Must be a not empty String.");
        } else if (vehicle.getFuelType() == null || vehicle.getFuelType().isEmpty()) {
            throw new IllegalArgumentException("FuelType attribute is invalid. Must be a not empty String.");
        }
    }

    public List<Vehicle> findVehiclesByLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.isEmpty()) {
            throw new IllegalArgumentException("LicensePlate attribute is invalid. Must be a not empty String.");
        }
        List<Vehicle> vehicles = repository.findByLicensePlate(licensePlate);
        return vehicles;
    }
}
