import java.nio.IntBuffer;

/*
 * Exercicis Programació Multifil - Ejercicio 4
 * Crea un programa format per dos fils d’execució. 
 * Un d'ells establirà el valor d'una variable d'un objecte Buffer (mitjançant un mètode anomenat setValue). 
 * Després mostrarà per pantalla el missatge: "Escriptor: valor".
 * L'altre fil llegirà aquest valor (funció getValue) i ho mostrarà per pantalla amb el format: "Lector: valor".
 * Cada fil s'executarà 10 vegades. A cada iteració posa a dormir 1 segon a cadascun dels fils d’execució.
 */
public class E14 {
	public class Lector extends Thread {
		Escritor escritor;
		
		Lector(Escritor escritor){
			this.escritor = escritor;
		}
    }
	
    public class Escritor extends Thread {
    	IntBuffer buffer = new IntBuffer();
    	int[] valores = {88,96,83,31,62,46,41,19,58,71};
    	
    	public void run() {
	    	for (int num:valores) {
	    		buffer.clear();
	    		System.out.println("Escriptor: " + num);
	    		buffer.put(0, num);
	    		try {
	    			sleep(1000);
	    		}catch(Exception e) {
	    			System.out.print("Ha ocurrio un error :D");
	    		}
	    		
	    	}
    	}
    	
    	public int getValue() {
    		return buffer.get(0);
    	}
    }

    public static void main(String[] args) throws Exception {
    	E14 programa = new E14();
    	Thread escritor = programa.new Escritor();
    	Thread lector = programa.new Lector((Escritor) escritor);
    	escritor.start();
    	Thread.sleep(1000);
    	lector.start();
    	
    }
}