

import java.util.Arrays;
import java.util.Scanner;

public class Histogram {

	public static final int MAX_NUMBERS = 20;
	public static final int NUM_BINS = 10;
	public static final int BIN_SIZE = 100 / NUM_BINS;

	public static void main(String[] argv) {
		
		int count = 0;
		double x = 0;
		double[] histogram = new double[NUM_BINS];
		double[] numbers = new double[MAX_NUMBERS];
		
		Scanner userInput = new Scanner(System.in);
		Histogram.printHeading();

		while (userInput.hasNextDouble()) {
			x = userInput.nextDouble();
			numbers[count] = x;
			count++;
			if (x == -1) {
				System.out.println(" ");
				userInput.close();
				break;
			}
		}
		while (Histogram.validInput(x) == false) {
			System.out.println("Error: Please enter a valid number in the range of [0...100");
			x = userInput.nextDouble();

			
			

			if (count == MAX_NUMBERS) {
				System.out.println(" ");
				System.out.println("You've inputted the maximum amount of number: 20");
				System.out.println(" ");
				userInput.close();
				break;
			}
		}

		System.out.println("You input " + count + " numbers: "+Arrays.toString(numbers));

		double[] numbers1 = Arrays.copyOfRange(numbers, 0, count);
		for (int k = 0; k < count; k++) {
			if (k == (count - 1)) 
			{
				System.out.println(numbers1[k]);
			} 
			else {
				System.out.println(numbers1[k] + ", ");
			}
		}

		//for (int i = 0; i < numbers1.length; i++) {
			
		
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < histogram.length; j++) {
				if (numbers1[i] <= (NUM_BINS * j) + NUM_BINS) {
					++histogram[j];
					break;
				}
			}
		}
		Histogram.printHistogram(histogram);
	}

	public static void printHeading() {

		System.out.println("Welcome to the Histogram program");
		System.out.println(" ");
		System.out.println("This program will print out a histogram of the numbers input by the user;");
		System.out.println("enter up to 20 doubles in the range [0..100]); enter -1 to end.");

	}

	public static boolean validInput(double Range) {
		if (Range > 100.0) {
			return false;
		}
		return true;
	}

	public static void printHistogram(double histogram[]) {
		System.out.println("Histogram of values in Decades from 0 to 100: ");

		for (int i = 0; i <= 90; i += NUM_BINS) {
			System.out.println(" ");
			System.out.print("[" + i + ".." + (i + NUM_BINS) + "]:\t");
			for (int j = 0; j < histogram[i / NUM_BINS]; j++) {
				System.out.print("*");
			}
		}
	}
}
