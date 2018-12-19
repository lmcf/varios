import java.util.Scanner;

public class Exercici8_p1a {
	public static void main(String[] args) {
	System.out.println("Introduzca texto -> ");
	Scanner sc = new Scanner(System.in);
	String texto = sc.nextLine();
	String[] parts = texto.split("\\*");
	System.out.println(parts[0]);
	}
}
