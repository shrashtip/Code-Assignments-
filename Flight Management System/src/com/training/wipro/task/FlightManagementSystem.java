package com.training.wipro.task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.training.wipro.task.dao.FlightDAO;
import com.training.wipro.task.entities.Flight;

public class FlightManagementSystem {
    private static FlightDAO flightDAO = new FlightDAO();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Flight Management System =====");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flight");
            System.out.println("3. Update Flight");
            System.out.println("4. Delete Flight");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    viewFlight();
                    break;
                case 3:
                    updateFlight();
                    break;
                case 4:
                    deleteFlight();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    private static void addFlight() {
        System.out.println("\n===== Add Flight =====");
        System.out.print("Enter Flight Name: ");
        String flightName = scanner.nextLine();
        System.out.print("Enter Arrival Time (YYYY-MM-DD HH:MM:SS): ");
        String arrivalTimeStr = scanner.nextLine();
        Date arrivalTime = parseDate(arrivalTimeStr);
        System.out.print("Enter Departure Time (YYYY-MM-DD HH:MM:SS): ");
        String departureTimeStr = scanner.nextLine();
        Date departureTime = parseDate(departureTimeStr);
        System.out.print("Enter Start Location: ");
        String startLocation = scanner.nextLine();
        System.out.print("Enter End Location: ");
        String endLocation = scanner.nextLine();
        System.out.print("Enter Flight Fare: ");
        double flightFare = scanner.nextDouble();

        flightDAO.addFlight(new Flight(flightName, arrivalTime, departureTime, startLocation, endLocation, flightFare));
        System.out.println("Flight added successfully!");
    }

    private static void viewFlight() {
        System.out.println("\n===== View Flight =====");
        System.out.print("Enter Flight ID: ");
        int flightId = scanner.nextInt();
        Flight flight = flightDAO.getFlightById(flightId);
        if (flight != null) {
            System.out.println("Flight Details:");
            System.out.println("Flight ID: " + flightId);
            System.out.println("Flight Name: " + flight.getFlightName());
            System.out.println("Arrival Time: " + dateFormat.format(flight.getArrivalTime()));
            System.out.println("Departure Time: " + dateFormat.format(flight.getDepartureTime()));
            System.out.println("Start Location: " + flight.getStartLocation());
            System.out.println("End Location: " + flight.getEndLocation());
            System.out.println("Flight Fare: " + flight.getFlightFare());
        } else {
            System.out.println("Flight not found!");
        }
    }
   
    
    private static void updateFlight() {
        System.out.println("\n===== Update Flight =====");
        System.out.print("Enter Flight ID: ");
        int flightId = scanner.nextInt();
        scanner.nextLine();
        Flight existingFlight = flightDAO.getFlightById(flightId);
        if (existingFlight != null) {
            System.out.print("Enter New Flight Name (leave blank to keep current): ");
            String newFlightName = scanner.nextLine();
            System.out.print("Enter New Arrival Time (YYYY-MM-DD HH:MM:SS) (leave blank to keep current): ");
            String newArrivalTimeStr = scanner.nextLine();
            Date newArrivalTime = null;
            if (!newArrivalTimeStr.isBlank()) {
                newArrivalTime = parseDate(newArrivalTimeStr);
                if (newArrivalTime == null) {
                    return; 
                }
            }
            System.out.print("Enter New Departure Time (YYYY-MM-DD HH:MM:SS) (leave blank to keep current): ");
            String newDepartureTimeStr = scanner.nextLine();
            Date newDepartureTime = null;
            if (!newDepartureTimeStr.isBlank()) {
                newDepartureTime = parseDate(newDepartureTimeStr);
                if (newDepartureTime == null) {
                    return; 
                }
            }
            System.out.print("Enter New Start Location (leave blank to keep current): ");
            String newStartLocation = scanner.nextLine();
            System.out.print("Enter New End Location (leave blank to keep current): ");
            String newEndLocation = scanner.nextLine();
            System.out.print("Enter New Flight Fare (leave blank to keep current): ");
            String newFlightFareStr = scanner.nextLine();

           
            if (!newFlightName.isBlank()) {
                existingFlight.setFlightName(newFlightName);
            }
            if (newArrivalTime != null) {
                existingFlight.setArrivalTime(newArrivalTime);
            }
            if (newDepartureTime != null) {
                existingFlight.setDepartureTime(newDepartureTime);
            }
            if (!newStartLocation.isBlank()) {
                existingFlight.setStartLocation(newStartLocation);
            }
            if (!newEndLocation.isBlank()) {
                existingFlight.setEndLocation(newEndLocation);
            }
            if (!newFlightFareStr.isBlank()) {
                existingFlight.setFlightFare(Double.parseDouble(newFlightFareStr));
            }

          
            flightDAO.updateFlight(existingFlight);
            System.out.println("Flight updated successfully!");
        } else {
            System.out.println("Flight not found!");
        }
    }

    
    
    
    private static void deleteFlight() {
        System.out.println("\n===== Delete Flight =====");
        System.out.print("Enter Flight ID: ");
        int flightId = scanner.nextInt();
        if (flightDAO.deleteFlight(flightId)) {
            System.out.println("Flight deleted successfully!");
        } else {
            System.out.println("Failed to delete flight. Flight ID may be invalid.");
        }
    }


    private static Date parseDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD HH:MM:SS format.");
            return null;
        }
    }
}
