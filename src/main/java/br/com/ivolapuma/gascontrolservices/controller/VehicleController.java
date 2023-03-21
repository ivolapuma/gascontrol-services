package br.com.ivolapuma.gascontrolservices.controller;

import br.com.ivolapuma.gascontrolservices.dto.ResponseDTO;
import br.com.ivolapuma.gascontrolservices.model.Vehicle;
import br.com.ivolapuma.gascontrolservices.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping(path = "/vehicles",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<Vehicle>> createVehicle(@RequestBody Vehicle newVehicle) {
        System.out.println(String.format("<<vehicles|POST>> newVehicle: %s", newVehicle.toString()));
        try {
            Vehicle vehicle = service.create(newVehicle);
            return ResponseEntity.ok().body(new ResponseDTO<>("Vehicle got successfully created", vehicle));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseDTO<>(e.getMessage(), null));
        }
    }

    @GetMapping(path="/vehicles/{licensePlate}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<List<Vehicle>>> findVehiclesByLicensePlate(@PathVariable String licensePlate) {
        System.out.println(String.format("<<vehicles|GET>> licensePlate: %s", licensePlate));
        try {
            List<Vehicle> vehicles = service.findVehiclesByLicensePlate(licensePlate.toUpperCase());
            if (vehicles == null || vehicles.isEmpty()) {
                return ResponseEntity.ok().body(new ResponseDTO<>(String.format("There is no vehicles with license plate %s", licensePlate), null));
            }
            return ResponseEntity.ok().body(new ResponseDTO<>("Vehicle(s) got successfully found", vehicles));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseDTO<>(e.getMessage(), null));
        }
    }
}
