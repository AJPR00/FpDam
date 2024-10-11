package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Load data from CSV file");
            System.out.println("2. Insert car at specific position");
            System.out.println("3. Sort database by matrícula");
            System.out.println("4. Delete car by matrícula");
            System.out.println("5. Delete car at specific position");
            System.out.println("6. Update car at specific position");
            System.out.println("7. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter CSV file name: ");
                    String filename = scanner.next();
                    database.loadData(filename);
                    break;
                case 2:
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter car details (matrícula, marca, modelo, año, color): ");
                    String[] fields = scanner.next().split(",");
                    Car car = new Car(fields[0], fields[1], fields[2], fields[3], fields[4]);
                    database.insertCar(position, car);
                    break;
                case 3:
                    database.sortDatabase();
                    break;
                case 4:
                    System.out.print("Enter matrícula to delete: ");
                    String matrícula = scanner.next();
                    database.deleteCar(matrícula);
                    break;
                case 5:
                    System.out.print("Enter position to delete: ");
                    position = scanner.nextInt();
                    database.deleteCar(position);
                    break;
                case 6:
                    System.out.print("Enter position to update: ");
                    position = scanner.nextInt();
                    System.out.print("Enter updated car details (matrícula, marca, modelo, año, color): ");
                    fields = scanner.next().split(",");
                    car = new Car(fields[0], fields[1], fields[2], fields[3], fields[4]);
                    database.updateCar(position, car);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}