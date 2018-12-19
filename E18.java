/*
 * Exercicis Programació Multifil - Ejercicio 8
 * Modifica l'exercici E1.7 per tal de que s'imprimeixi el següent:
 * OLE OLE TU OLE OLE TU ...
 */

public class E18 {
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
		E18 programa = new E18();
		
		Thread productor = programa.new Productor();
		Thread consumidor = programa.new Consumidor();
		
		productor.start();
		Thread.sleep(750);
		consumidor.start();

	}
}

