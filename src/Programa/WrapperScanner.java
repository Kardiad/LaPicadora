package Programa;

import java.util.Scanner;

public class WrapperScanner {
	private Scanner input;
	/**
	 * @param input
	 */
	public WrapperScanner() {
		this.input = new Scanner(System.in);
	}
	/**
	 * nextInt de mi wrapper
	 * */
	public int metodoQueObtieneIntSeguro() {
		try {
			int numero = input.nextInt();
			limpiezaBuffer();
			return numero;
		}catch(Exception error) {
			limpiezaBuffer();
			return -1;
		}
	}
	/**
	 * next de mi wrapper
	 * */
	public String metodoQueDaCadenaDeTexto() {
		try {
			String cadena = input.next();
			limpiezaBuffer();
			return cadena;
		}catch(Exception error) {
			limpiezaBuffer();
			return "!!";
		}
	}
	/**
	 * nextLine de mi wrapper
	 * */
	public String metodoQueDaCadenaDeTextoConSaltoLinea() {
		try {
			String cadena = input.nextLine();
			return cadena;
		}catch(Exception error) {
			return "!!";
		}
	}
	public void cerrarWrapper() {
		input.close();
	}
	private void limpiezaBuffer() {
		input.nextLine();
	}
}
