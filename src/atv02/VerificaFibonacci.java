package atv02;

import java.util.Scanner;

public class VerificaFibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um numero para verificar se pertence a sequência de Fibonacci: ");
		int num = scanner.nextInt();
		printFibonacciSequencia(num);

		if (isFibonacci(num)) {
			System.out.println(num + " pertence a sequência de Fibonacci.");
		} else {
			System.out.println(num + " não pertence a sequência de Fibonacci.");
		}

	}

	public static void printFibonacciSequencia(int maxNumber) {
		int atual = 0;
		int antes = 0;
		// exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
		System.out.print("Sequência de Fibonacci: " + atual + " ");

		for (int i = 1; i <= maxNumber; i++) {
			if (i == 1) {
				atual = 1;
				antes = 0;
				System.out.print(atual + " ");
			} else {
				atual += antes;
				antes = atual - antes;
				System.out.print(atual + " ");
			}
		}

		System.out.println();
	}

	public static boolean isFibonacci(int number) {
		if (number < 0) {
			return false;
		}

		int atual = 0;
		int antes = 0;

		if (number == 0) {
			return true;
		}

		for (int i = 1; atual < number; i++) {
			if (i == 1) {
				atual = 1;
				antes = 0;
			} else {
				atual += antes;
				antes = atual - antes;
			}
		}

		return atual == number;
	}
}
