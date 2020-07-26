package dev.freenow.taxi.rental;

import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRental {
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    private Long carId;
    private Long driverId;

    private @Nullable
    LocalDateTime loanedAt;
    private @Nullable
    LocalDateTime returnedAt;
}
