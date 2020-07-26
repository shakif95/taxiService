package dev.freenow.taxi.rental;

import dev.freenow.taxi.car.CarService;
import dev.freenow.taxi.car.StatusType;
import dev.freenow.taxi.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CarService carService;

    public List<Rental> getAll(){
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long rentalId){
        return rentalRepository.findById(rentalId).orElseThrow();
    }

    public Rental updateRental(ApiRental apiRental) throws BadRequestException {
        boolean rentalFound = rentalRepository.findById(apiRental.getId()).isPresent();

        if(rentalFound){
            Rental updatedRental = new Rental();

            updatedRental.setId(apiRental.getId());
            updatedRental.setCarId(apiRental.getCarId());
            updatedRental.setDriverId(apiRental.getDriverId());

            return rentalRepository.save(updatedRental);
        }

        throw new BadRequestException("Invalid rental");
    }

    public Rental addRental(ApiRental apiRental){
        Rental newRental = new Rental();

        carService.changeCarStatus(apiRental.getCarId(), StatusType.LOANED);
        newRental.setCarId(apiRental.getCarId());
        newRental.setDriverId(apiRental.getDriverId());
        newRental.setLoanedAt(LocalDateTime.now());

        return rentalRepository.save(newRental);
    }

    public Rental completeRental(Long id){

        Rental rentalFound = rentalRepository.findById(id).orElseThrow();

        carService.changeCarStatus(rentalFound.getCarId(), StatusType.AVAILABLE);

        rentalFound.setReturnedAt(LocalDateTime.now());

        return rentalRepository.save(rentalFound);
    }
}
