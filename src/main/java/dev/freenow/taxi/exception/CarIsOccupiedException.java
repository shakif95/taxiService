package dev.freenow.taxi.exception;

public class CarIsOccupiedException extends Exception {

    public CarIsOccupiedException(){
        super("Car is already occupied by another driver");
    }
}
