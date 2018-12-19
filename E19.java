/*
 * Exercicis Programació Multifil - Ejercicio 9
 * Modifica l'exercici E1.7 per tal de que s'imprimeixi el següent:
 * OLE TU OLE OLE TU OLE TU OLE OLE TU ...
 */

public class E19 {
	public class Productor extends Thread{
		public void run() {
			for (; ;) {
				System.out.print(" OLE ");
				try {
					sleep(500);
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
		E19 programa = new E19();
		
		Thread productor = programa.new Productor();
		Thread consumidor = programa.new Consumidor();
		
		productor.start();
		Thread.sleep(250);
		consumidor.start();
	}
}

