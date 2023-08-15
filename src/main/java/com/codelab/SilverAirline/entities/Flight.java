package com.codelab.SilverAirline.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private String destination;
    private String origin;
    private String departureT;
    private String arrivalT;
    private Integer passengers;

}
