package dev.freenow.taxi.car;

import dev.freenow.taxi.exception.BadRequestException;
import dev.freenow.taxi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public Car getCarById(Long id){
        return carRepository.findById(id).orElseThrow();
    }

    public Car addCar(Car car){ return carRepository.save(car); }

    public List<Car> getCarsByManufacturer(Long manufacturerId){
        return carRepository.findCarByManufacturerId(manufacturerId);
    }

    public Car updateCar(Car car) throws BadRequestException {
        boolean carPresent = carRepository.findById(car.getId()).isPresent();

        if(carPresent){
            Car updatedCar = new Car(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getSeatCount(),
                    car.isConvertible(),
                    car.getRating(),
                    car.getEngineType(),
                    car.getManufacturer(),
                    car.getStatus()
            );

            carRepository.save(updatedCar);
        }

        throw new BadRequestException("invalid request");
    }

    public Car changeCarStatus(Long carId, StatusType statusType){
        Car car = carRepository.findById(carId).orElseThrow();

        car.setStatus(statusType);

        return carRepository.save(car);
    }

    public List<Car> getAvailableCars() { return carRepository.findCarByStatus(StatusType.AVAILABLE); }

    public boolean carAvailable(Long carId){
        Car car = carRepository.findById(carId).orElseThrow();

        return car.getStatus().equals(StatusType.AVAILABLE);
    }
}
