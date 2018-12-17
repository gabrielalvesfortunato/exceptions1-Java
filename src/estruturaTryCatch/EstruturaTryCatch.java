package estruturaTryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EstruturaTryCatch {

	public static void main(String[] args) {
		method2();
		System.out.println("End of Program");
	}
	
	public static void method2() {
		System.out.println("***Method2 Start***");
		method();
		System.out.println("***Method2 End***");
	}
	
	public static void method() {
	System.out.println("***Method Start***");	
	Scanner scan = new Scanner(System.in);
		//O try tentara realizar uma opera�ao caso ocorra alguma exce�ao a execu�ao caira no catch;
		try{			
			String[] vect = scan.nextLine().split(" ");
			int position = scan.nextInt();
			System.out.println(vect[position]);
			}
		//A execu�ao caira no tratamento dessa exce�ao para dai entao dar prosseguimento ao programa; 
		catch (ArrayIndexOutOfBoundsException e ) {	
			System.out.println("Posi�ao Invalida!");
			e.printStackTrace();
			scan.next();
		}
		//Podem ser usados varios catch para 1 try
		catch(InputMismatchException e) {
			System.out.println("Dado de entrada Invalido entre com um numero!");
		}
		
		System.out.println("***Method End***");
		scan.close();
	}
}	