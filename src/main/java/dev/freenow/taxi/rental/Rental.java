package dev.freenow.taxi.rental;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental implements Serializable {

    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long carId;
    private Long driverId;
    private LocalDateTime loanedAt;
    private @Nullable LocalDateTime returnedAt;

//    public Rental(Long id, Long carId, Long driverId){
//        this.id = id;
//        this.carId = carId;
//        this.driverId = driverId;
//    }
}
