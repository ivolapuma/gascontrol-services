package br.com.ivolapuma.gascontrolservices.repository;

import br.com.ivolapuma.gascontrolservices.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    List<Vehicle> findByLicensePlate(String s);
}
