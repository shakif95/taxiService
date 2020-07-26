package dev.freenow.taxi.car;

import dev.freenow.taxi.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public ResponseEntity getAll(){
        return new ResponseEntity(carService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity getCar(@PathVariable("id") Long id){
        return new ResponseEntity(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity addCar(@RequestBody Car car){
        return new ResponseEntity(carService.addCar(car), HttpStatus.OK);
    }

    @PutMapping("/cars")
    public ResponseEntity updateCar(@RequestBody Car car) throws BadRequestException {
        return new ResponseEntity(carService.updateCar(car), HttpStatus.OK);
    }


    @GetMapping("/cars/manufacturer/{id}")
    public ResponseEntity getCarsByManufacturer(@PathVariable("id") Long id){
        return new ResponseEntity(carService.getCarsByManufacturer(id), HttpStatus.OK);
    }

    @GetMapping("/cars/available")
    public ResponseEntity getAvailableCars(){
        return new ResponseEntity(carService.getAvailableCars(), HttpStatus.OK);
    }
}
