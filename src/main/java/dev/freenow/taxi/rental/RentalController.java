package dev.freenow.taxi.rental;

import dev.freenow.taxi.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @GetMapping("/rentals")
    public ResponseEntity getRentals(){
        return new ResponseEntity(rentalService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rentals/{id}")
    public ResponseEntity getRentalById(@PathVariable("id") Long id){
        return new ResponseEntity(rentalService.getRentalById(id), HttpStatus.OK);
    }

    @PostMapping("/rentals")
    public ResponseEntity addRental(@RequestBody ApiRental apiRental){
        return new ResponseEntity(rentalService.addRental(apiRental), HttpStatus.OK);
    }

    @PutMapping("/rentals")
    public ResponseEntity updateRental(@RequestBody ApiRental apiRental) throws BadRequestException {
        return new ResponseEntity(rentalService.updateRental(apiRental), HttpStatus.OK);
    }

    @PutMapping("/rentals/{id}")
    public ResponseEntity completeRental(@PathVariable("id") Long id) {
        return new ResponseEntity(rentalService.completeRental(id), HttpStatus.OK);
    }
}
