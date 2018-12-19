public class E13 {
	
	public class Pares extends Thread{
		public void run() {
			for(int i = 1; i <= 100;i++) {
				if (i % 2 == 0) {
					System.out.println("Pares: " + i);
				}
			}
		}
	}
	
	public class Impares extends Thread{
		public void run() {
			for(int i = 1; i <= 100;i++) {
				if (i % 2 != 0) {
					System.out.println("Impares: " + i);
				}			
			}
		}
	}
	
	public static void main(String[] args) {
		E13 programa = new E13();
		Thread pares = programa.new Pares();
		Thread impares = programa.new Impares();
		pares.start();
		impares.start();
	}
	
}
