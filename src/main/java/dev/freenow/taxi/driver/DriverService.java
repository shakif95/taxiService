package dev.freenow.taxi.driver;

import dev.freenow.taxi.car.CarService;
import dev.freenow.taxi.exception.BadRequestException;
import dev.freenow.taxi.exception.CarIsOccupiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CarService carService;

    public Driver addDriver(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Driver driver){
        driverRepository.findById(driver.getId()).orElseThrow();
        Driver updatedDriver = new Driver(
                driver.getId(),
                driver.getLicenseNumber(),
                driver.getYearOfExperience()
        );

        return driverRepository.save(updatedDriver);
    }

    public Driver selectCar(Long driverId, Long carId) throws CarIsOccupiedException, BadRequestException {
        if(carId == null){
            throw new BadRequestException("Car Id cannot be null");
        }

        if(!carService.carAvailable(carId)){
            throw new CarIsOccupiedException();
        }

        Driver driver = driverRepository.findById(driverId).orElseThrow();
        Driver driverWithCar = new Driver(
                driver.getId(),
                driver.getLicenseNumber(),
                driver.getYearOfExperience()
        );

        return driverRepository.save(driverWithCar);
    }

    public Driver deselectCar(Long driverId) throws CarIsOccupiedException {

        Driver driver = driverRepository.findById(driverId).orElseThrow();
        Driver driverWithCar = new Driver(
                driver.getId(),
                driver.getLicenseNumber(),
                driver.getYearOfExperience()
        );

        return driverRepository.save(driverWithCar);
    }

/*    private boolean checkIfCarIsOccupied(Long carId) {
        return driverRepository.findDriverByCarId(carId).isPresent();
    }*/
}
