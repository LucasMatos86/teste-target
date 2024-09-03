package atv05;

import java.util.Scanner;

public class InverterString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a string a ser invertida:");
		String nome = scanner.nextLine();

		String stringReversa= inverterString(nome);
		System.out.println("String original: " + nome);
		System.out.println("String invertida: " + stringReversa);

	}

	private static String inverterString(String str) {
		char[] caracteresInvertidos = new char[str.length()];

		int index = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			caracteresInvertidos[index++] = str.charAt(i);
		}

		String stringInvertida = "";
		for (char c : caracteresInvertidos) {
			stringInvertida += c;
		}

		return stringInvertida;
	}

}
