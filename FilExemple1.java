public class FilExemple1  extends Thread{
	
	private int filCount; //Contador de cada Hilo
	private int fil; 
	
	public FilExemple1 (int fil) {
		this.fil = fil;
		System.out.println("Creando el Hilo: "+fil);
	}
	
	public void run(){
		filCount = 0 ;
		while (filCount <= 5){
			System.out.println("Fil: "+fil+" filCount = " + filCount);
			filCount++;
		}
	}
	
	public static void main (String[] args) {
		FilExemple1 f = null;
		for (int i = 0; i < 3;i++){
			f = new FilExemple1(i+1);// Crear Hilo
			f.start();
		}
		System.out.println("3 Hilos creados...");
	}
}

