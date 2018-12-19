/*
 * Exercicis Programació Multifil - Ejercicio 7
 * Utilitzant com a base l'exemple del model productor-consumidor, 
 * realitza un programa que mitjançant dos fils d’execució (un productor i un consumidor) 
 * es mostri per pantalla de manera sincronitzada la cadena OLE TU indefinidament.
 * OLE TU OLE TU OLE TU ...
 */
public class E17 {
	public class Productor extends Thread{
		public void run() {
			for (; ;) {
				System.out.print(" OLE ");
				try {
					sleep(1000);
				}catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}
	
	public class Consumidor extends Thread{
		public void run() {
			for (; ;) {
				System.out.print(" TU ");
				try {
					sleep(1000);
				}catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}
	
	public static void main (String[] args) throws InterruptedException{
		E17 programa = new E17();
		
		Thread productor = programa.new Productor();
		Thread consumidor = programa.new Consumidor();
		
		productor.start();
		Thread.sleep(500);
		consumidor.start();
		
	}
}
