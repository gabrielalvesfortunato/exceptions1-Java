package criandoExceçoesPersonalizadas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		//Leitura do Numero do quarto
		System.out.print("Room Number: ");
		int number = scan.nextInt();
		//Leitura da data de check-in
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = formatDate.parse(scan.next());
		//Leitura da data de check-out
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = formatDate.parse(scan.next());
		
		//testa se a data de check-in nao é posterior à data de check-out
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to update reservation: ");
		
			//Leitura da data de check-in
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = formatDate.parse(scan.next());
			//Leitura da data de check-out
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = formatDate.parse(scan.next());
		
			Date now = new Date();
			
			//testa se a data de check-in ou check-out nao sao posteriores a data atual
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			//testa se a data de check-in nao é posterior à data de check-out
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");	
			}
			else {
				reservation.updateDates(checkIn,checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
		}	
	    scan.close();	
	}
}