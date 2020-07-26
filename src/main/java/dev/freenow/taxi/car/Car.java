package dev.freenow.taxi.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.freenow.taxi.manufacturer.Manufacturer;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    private String licensePlate;
    private int seatCount;
    private boolean convertible;
    private double rating;

    private EngineType engineType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    private StatusType status;
}
