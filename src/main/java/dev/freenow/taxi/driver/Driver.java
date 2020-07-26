package dev.freenow.taxi.driver;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "drivers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    private String licenseNumber;
    private int yearOfExperience;
}
