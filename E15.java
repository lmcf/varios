import java.util.Random;
/*
 * Exercicis Programació Multifil - Ejercicio 5
 * Crea un programa amb tres fils d'execució on cadascun llença un dau. 
 * El programa principal ha de mostrar el resultat de la suma de les tres tirades.
 */
public class E15 {
	public class Dado extends Thread{
		private int n = 0;
		public void run() {
			Random rand = new Random();
			n = rand.nextInt(6) + 1;
			//System.out.println(n);
		}
		public int getNum() {
			return n;
		}
	}
	
	public static void main(String[] args) {
		E15 programa = new E15();
		
		Dado dado1 = programa.new Dado();
		dado1.start();
		try {
			dado1.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num1 = dado1.getNum(); // Todos los dados iguales que el primero el sleep entre el strat y el entero que creo
		
		Dado dado2 = programa.new Dado();
		dado2.start();
		try {
			dado2.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		int num2 = dado2.getNum();
		
		Dado dado3 = programa.new Dado();
		dado3.start();
		try {
			dado3.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		int num3 = dado3.getNum();
		
		System.out.println("D1: " + num1);
		System.out.println("D2: " + num2);
		System.out.println("D3: " + num3);
		
		int D = num1 + num2 + num3;
		
		System.out.println("D1 + D2 + D3: " + D);
	}
}
