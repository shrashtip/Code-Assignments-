package com.training.wipro.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.training.wipro.task.dbconfig.DatabaseConnection;
import com.training.wipro.task.entities.Flight;

public class FlightDAO {
    private Connection connection;

    public FlightDAO() {
        try {
   
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addFlight(Flight flight) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Flights (Flight_name, Arrival_time, Departure_time, Start_location, End_location, Flight_fare) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, flight.getFlightName());
            statement.setTimestamp(2, new Timestamp(flight.getArrivalTime().getTime()));
            statement.setTimestamp(3, new Timestamp(flight.getDepartureTime().getTime()));
            statement.setString(4, flight.getStartLocation());
            statement.setString(5, flight.getEndLocation());
            statement.setDouble(6, flight.getFlightFare());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Flight getFlightById(int flightId) {
        Flight flight = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Flights WHERE Flight_id = ?");
            statement.setInt(1, flightId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flight = new Flight(
                        resultSet.getString("Flight_name"),
                        resultSet.getTimestamp("Arrival_time"),
                        resultSet.getTimestamp("Departure_time"),
                        resultSet.getString("Start_location"),
                        resultSet.getString("End_location"),
                        resultSet.getDouble("Flight_fare")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }



    public boolean updateFlight(Flight flight) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Flights SET Flight_name = ?, Arrival_time = ?, Departure_time = ?, Start_location = ?, End_location = ?, Flight_fare = ? WHERE Flight_id = ?");
            statement.setString(1, flight.getFlightName());
            statement.setTimestamp(2, new Timestamp(flight.getArrivalTime().getTime()));
            statement.setTimestamp(3, new Timestamp(flight.getDepartureTime().getTime()));
            statement.setString(4, flight.getStartLocation());
            statement.setString(5, flight.getEndLocation());
            statement.setDouble(6, flight.getFlightFare());
            statement.setInt(7, flight.getFlightId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean deleteFlight(int flightId) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Flights WHERE Flight_id = ?");
            statement.setInt(1, flightId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
