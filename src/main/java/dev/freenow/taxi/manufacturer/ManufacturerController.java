package dev.freenow.taxi.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ManufacturerController {

    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> getManufacturers(){
        return new ResponseEntity(manufacturerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> addManufacturer(@RequestBody Manufacturer manufacturer){
        return new ResponseEntity(manufacturerService.addManufacturer(manufacturer), HttpStatus.OK);
    }
}
