package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Car> data;

    public Database() {
        data = new ArrayList<>();
    }

    /**
     * Loads data from a CSV file into the database.
     *
     * @param filename the name of the CSV file
     */
    public void loadData(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Car car = new Car(fields[0], fields[1], fields[2], fields[3], fields[4]);
                data.add(car);
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    /**
     * Inserts a new car at a specific position in the database, shifting existing records as needed.
     *
     * @param position the position to insert the car
     * @param car the car to insert
     */
    public void insertCar(int position, Car car) {
        data.add(position, car);
    }

    /**
     * Sorts the database by matrícula.
     */
    public void sortDatabase() {
        data.sort((c1, c2) -> c1.getMatrícula().compareTo(c2.getMatrícula()));
    }

    /**
     * Deletes a car with a specific matrícula.
     *
     * @param matrícula the matrícula of the car to delete
     */
    public void deleteCar(String matrícula) {
        data.removeIf(car -> car.getMatrícula().equals(matrícula));
    }

    /**
     * Deletes a car at a specific position.
     *
     * @param position the position of the car to delete
     */
    public void deleteCar(int position) {
        data.remove(position);
    }

    /**
     * Updates a car at a specific position.
     *
     * @param position the position of the car to update
     * @param car the updated car
     */
    public void updateCar(int position, Car car) {
        data.set(position, car);
    }
}