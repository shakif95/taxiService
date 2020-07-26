package dev.freenow.taxi.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer){
        return manufacturerRepository.save(manufacturer);
    }
}
