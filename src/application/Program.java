package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Reservation reserva = new Reservation(roomNumber, checkIn, checkOut);
		System.out.println("Reservation: " + reserva.toString());
		
		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		reserva.UpdateDates(checkIn, checkOut);
		System.out.println("Reservation: " + reserva.toString());
		
		} catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());			
		} catch(RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		
		sc.close();
	}

}
