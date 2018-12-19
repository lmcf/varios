public class Exercici7_p1 {
	public static void main(String[] args) {
		try 
		{
			Process p = Runtime.getRuntime().exec (args[0]); 
		} 
		catch(Exception e)

		{
			System.out.println("El ejecutable introducido no existe ");
		} 
	}

}

