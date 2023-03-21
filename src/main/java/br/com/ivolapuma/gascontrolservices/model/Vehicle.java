package br.com.ivolapuma.gascontrolservices.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Vehicle {

    @Id
    private String id;

    private Long vehicleIdNumber;
    private String licensePlate;
    private String make;
    private String model;
    private Integer modelYear;
    private Integer manufactureYear;
    private String color;
    private String bodyType;
    private String transmissionType;
    private String fuelType;

}