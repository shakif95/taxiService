package dev.freenow.taxi.driver;

import dev.freenow.taxi.exception.BadRequestException;
import dev.freenow.taxi.exception.CarIsOccupiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/drivers")
    public ResponseEntity addDriver(@RequestBody Driver driver){
        return new ResponseEntity(driverService.addDriver(driver), HttpStatus.OK);
    }

    @PutMapping("/drivers")
    public ResponseEntity updateDriver(@RequestBody Driver driver){
        return new ResponseEntity(driverService.updateDriver(driver), HttpStatus.OK);
    }

    @PutMapping("/drivers/{driverId}/takes/{carId}")
    public ResponseEntity driverTakes(@PathVariable("driverId") Long driverId,
                                       @PathVariable("carId") Long carId) throws CarIsOccupiedException, BadRequestException {
        return new ResponseEntity(driverService.selectCar(driverId, carId), HttpStatus.OK);
    }

    @PutMapping("/drivers/{driverId}/returns")
    public ResponseEntity driverReturns(@PathVariable("driverId") Long driverId) throws CarIsOccupiedException, BadRequestException {
        return new ResponseEntity(driverService.deselectCar(driverId), HttpStatus.OK);
    }
}
