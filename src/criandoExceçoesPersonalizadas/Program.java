package criandoExceçoesPersonalizadas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

		try {

			// Leitura do Numero do quarto
			System.out.print("Room Number: ");
			int number = scan.nextInt();
			// Leitura da data de check-in
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = formatDate.parse(scan.next());
			// Leitura da data de check-out
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = formatDate.parse(scan.next());
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update reservation: ");
			// Leitura da data de check-in
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = formatDate.parse(scan.next());
			// Leitura da data de check-out
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = formatDate.parse(scan.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

		} 
		catch (ParseException e) {
			System.out.println("Invalid date Format");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		scan.close();
	}
}