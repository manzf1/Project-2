/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parkinglotsimulation;

import java.util.*;

// Custom generic class for Parking Lot
class ParkingLot<T> {
    private List<T> vehicles;

    public ParkingLot() {
        this.vehicles = new ArrayList<>();
    }

    public void park(T vehicle) {
        vehicles.add(vehicle);
    }

    public List<T> getVehicles() {
        return vehicles;
    }
}

// Example Vehicle class
class Car {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                '}';
    }
}

public class ParkingLotSimulation {

    public static void main(String[] args) {
        // Create a parking lot for cars
        ParkingLot<Car> carParkingLot = new ParkingLot<>();

        // Park some cars
        carParkingLot.park(new Car("ABD897"));
        carParkingLot.park(new Car("XRZ709"));
        carParkingLot.park(new Car("456PLL"));

        // Get the list of parked cars
        List<Car> parkedCars = carParkingLot.getVehicles();

        // Sort cars by license plate using custom sorting method
        sortCarsByLicensePlate(parkedCars);

        // Display sorted cars
        System.out.println("Sorted Cars:");
        parkedCars.forEach(System.out::println);

        // Use lambdas and streams for analysis
        analyzeCars(parkedCars);
    }

    // Custom sorting method using Comparator
    private static void sortCarsByLicensePlate(List<Car> cars) {
        cars.sort(Comparator.comparing(Car::getLicensePlate));
    }

    // Analysis using lambdas and streams
    private static void analyzeCars(List<Car> cars) {
        long count = cars.stream()
                .filter(car -> car.getLicensePlate().startsWith("A"))
                .count();

        System.out.println("Number of cars with license plates starting with 'A': " + count);
    }
}