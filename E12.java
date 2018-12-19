import java.util.ArrayList;
/*
 * Exercicis Programació Multifil - Ejercicio 2
 * Crea un programa que faci el mateix que l'anterior però amb dos fils d’execució, cadascun dels quals processarà 50 nombres. 
 * Indica per consola el nom del fil que està fent el càlcul amb el nombre que ha calculat.
 */

public class E12 {
	ArrayList<Integer> primos = new ArrayList<Integer>();
	
	public class Thread0 extends Thread{
		public void run() {
			boolean primo = true;
			for (int i = 1; i <= 50; i++) {
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
					System.out.println("Thread-0: " + i);
				}
			}
		}
	}
	
	public class Thread1 extends Thread{
		public void run() {
			boolean primo = true;
			for (int i = 51; i <= 100; i++) {
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
					System.out.println("Thread-1: " + i);
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		E12 programa = new E12();
		Thread thread0 = programa.new Thread0();
		Thread thread1 = programa.new Thread1();
		thread0.start();
		thread1.start();
	}
}
