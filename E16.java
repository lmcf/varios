/*
 * Exercicis Programació Multifil - Ejercicio 6
 * Amb motiu del seu 111è aniversari en Bilbo celebra una cursa entre 3 hobbits: 
 * en Frodo (F), en Sam (S) i en Pippin (P). 
 * En Gàndalf fa de les seves i realitza un encanteri per tal d’intentar que el resultat final de la cursa sigui el següent (l’encanteri no és infal·lible):
 * 1. Sam
 * 2. Frodo
 * 3. Pippin
 * Realitza un programa en Java que simuli la cursa. 
 * Per tal de simular la cursa, cada hobbit serà un thread que realitzarà un total de 30 mostres de missatges per la consola de la seva inicial. 
 * S’anirà informant de l’estat de la cursa per consola de la manera següent:
 */
public class E16 {

		public class Hobbit extends Thread{
			private String nombreHobbit;
			private int realentizarHobbit;
			
			public Hobbit(String nombreHobbit, int realentizarHobbit) {
				this.nombreHobbit = nombreHobbit;
				this.realentizarHobbit = realentizarHobbit;
			}
			
			public void run() {
				for (int i = 0 ; i < 30 ; i++ ) {
					try {
						sleep(100 + realentizarHobbit);
					}catch(InterruptedException ie){
						ie.printStackTrace();					
					}
					System.out.print(nombreHobbit);
				}
				System.out.println();
				System.out.println("Arriba " + nombreHobbit);
			}
			
			
		}
		
		public static void main (String[] args) throws InterruptedException{
			E16 programa = new E16();
			
			Hobbit sam = programa.new Hobbit("S",10); //Cuanto mas alto sea el numero mas tardara en llegar
			Hobbit frodo = programa.new Hobbit("F",50);
			Hobbit pippin = programa.new Hobbit("P",100);
		
			sam.start();
			frodo.start();
			pippin.start();
		}
}
