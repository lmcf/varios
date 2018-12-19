public class Exercici8_p1b {
	public static void main(String[] args) {
		try
		{
			Process process =  Runtime.getRuntime().exec("java Exercici8_p1");
		}
			catch(Exception e)
		{
			System.err.println("Error on exec() method");
		}
	}
}
