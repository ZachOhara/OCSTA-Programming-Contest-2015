package problem09;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem09Main {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Photo size? ");
		int photoWidth = console.nextInt();
		int photoHeight = console.nextInt();

		System.out.print("Features? ");
		String photoFeatureString = console.next().trim();

		System.out.print("\nPattern size? ");
		int patternWidth = console.nextInt();
		int patternHeight = console.nextInt();

		System.out.print("Features? ");
		String patternFeatureString = console.next().trim();

		console.close();

		int[][] patternFeatures = new int[patternHeight][patternWidth];
		int[][] photoFeatures = new int[photoHeight][photoWidth];

		Problem09Main.populateFromString(patternFeatures, patternFeatureString);
		Problem09Main.populateFromString(photoFeatures, photoFeatureString);

		ArrayList<int[]> matchesList = new ArrayList<int[]>();
		for (int i = 0; i < photoHeight - patternHeight + 1; i++) {
			for (int j = 0; j < photoWidth - patternWidth + 1; j++) {
				boolean isMatch = true;
				for (int k = 0; k < patternHeight; k++) {
					for (int l = 0; l < patternWidth; l++) {
						int photoAtPos = photoFeatures[i + k][j + l];
						int patternAtPos = patternFeatures[k][l];
						if (photoAtPos != 0 && patternAtPos != 0) {
							if (photoAtPos != patternAtPos) {
								isMatch = false;
							}
						}
					}
				}
				if (isMatch) {
					int[] matchCoords = {j, i};
					matchesList.add(matchCoords);
				}
			}
		}
		System.out.println("\nMatches at: ");
		for (int[] coordPair : matchesList) {
			System.out.println("   position " + (coordPair[0] + 1) + " " + (coordPair[1] + 1));
		}

	}

	// take the features from a String form, and wrap them into an int array
	private static void populateFromString(int[][] arr, String s) {
		int charIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int intRep = -1; // the integer representation of the feature
				String feature = s.substring(charIndex, charIndex + 1); // a single feature
				if (feature.equals("*")) {
					intRep = 0;
				}
				if (feature.equalsIgnoreCase("F")) {
					intRep = 1;
				}
				if (feature.equalsIgnoreCase("S")) {
					intRep = 2;
				}
				if (feature.equalsIgnoreCase("R")) {
					intRep = 3;
				}
				arr[i][j] = intRep;
				charIndex++;
			}
		}
	}

}
