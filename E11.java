import java.io.*;
import java.util.*;
/* 
 * Exercicis Programació Multifil - Ejercicio 1
 * Crea un programa amb un fil d’execució que mostri per consola els nombres primers entre els 100 primers enters.
 */

public class E11 extends Thread {
	public void run() {
		ArrayList<Integer> primos = new ArrayList<Integer>();
		boolean primo = true;
		for (int i = 1; i <= 100; i++) {
			for (Integer numero: primos) {
				if (numero != 1 && i % numero == 0) {
					primo = false;
					break;
				}else {
					primo = true;
				}				
			}
			if (primo) {
				primos.add(i);
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args){
		Thread primo = new E11();
		primo.start();
	}

}
