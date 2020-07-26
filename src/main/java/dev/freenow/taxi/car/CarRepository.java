package dev.freenow.taxi.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarByManufacturerId(Long manufacturerId);
    List<Car> findCarByStatus(StatusType status);
}
