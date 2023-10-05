package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;

	public Reservation() {

	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		if (!checkout.isAfter(checkin)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}

		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public int Duration() {
		return checkout.compareTo(checkin);
	}

	public void UpdateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || (checkOut.isBefore(now))) {
			throw new DomainException("Reservation date for update must be before future date.");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}

		this.checkin = checkIn;
		this.checkout = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + checkin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", check-out: " + checkout.format((DateTimeFormatter.ofPattern("dd/MM/yyyy"))) + ", " + Duration()
				+ " nights.";
	}

}
