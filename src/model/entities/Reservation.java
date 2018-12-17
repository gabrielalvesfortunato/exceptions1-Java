package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	//criaçao do Objeto 
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	//Construtor padrao
	public Reservation() {
		
	}
	//Construtor com argumentos
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
    //metodo para se pegar o valor do roomNumber("Numero do quarto")
	public Integer getRoomNumber() {
		return roomNumber;
	}
	//metodo para se definir o valor do roomNumber
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	//Metodo para se obter o dado do check-in
	public Date getCheckIn() {
		return checkIn;
	}
	//metodo para se obter o dado do check-out
	public Date getCheckOut() {
		return checkOut;
	}
	//Definiçao da duraçao da estadia do cliente
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	//Atualizaçao de datas ("remarcaçao de hospedagem)
	public void updateDates(Date checkIn, Date CheckOut) {
		this.checkIn = checkIn;
		this.checkOut = CheckOut;		
	}
	//Sobrescrita do metodo toString para se escrever todos os dados que se quer obter no codigo
	@Override
	public String toString() {
		
		return "Room " + roomNumber + ", check-in: " + format.format(checkIn) + ", check-out: " + format.format(checkOut)
		       + ", " + duration() + " nights";
	}
}