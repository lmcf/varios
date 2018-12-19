import java.util.Random;

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
		
		System.out.println(num1);
		
		
		Thread dado2 = programa.new Dado();
		dado2.start();
		
		
		Thread dado3 = programa.new Dado();
		dado3.start();
	
	}
}
