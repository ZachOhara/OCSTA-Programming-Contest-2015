package problem10;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem10Main {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int xC = console.nextInt();
		int yC = console.nextInt();

		ArrayList<int[]> checkerCoords = new ArrayList<int[]>();

		int xIn;
		int yIn;
		do {
			xIn = console.nextInt();
			yIn = console.nextInt();
			if (xIn != 0 && yIn != 0) {
				int[] coords = {xIn, yIn};
				checkerCoords.add(coords);
			}
		} while (xIn != 0 && yIn != 0);

		console.close();
		System.out.println();

		doMoves(xC, yC, checkerCoords, "");
	}

	public static void doMoves(int xC, int yC, ArrayList<int[]> otherCheckers, String moveString) {
		if (yC < 8) {
			yC++;
			if (xC - 1 >= 1) {
				boolean clearPath = true;
				for (int[] checker : otherCheckers) {
					if (checker[0] == xC - 1 && checker[1] == yC)
						clearPath = false;
				}
				if (clearPath) {
					doMoves(xC - 1, yC, otherCheckers, moveString + "L"); // do one space to the left
				}
			}
			if (xC + 1 <= 8) {
				boolean clearPath = true;
				for (int[] checker : otherCheckers) {
					if (checker[0] == xC + 1 && checker[1] == yC)
						clearPath = false;
				}
				if (clearPath) {
					doMoves(xC + 1, yC, otherCheckers, moveString + "R"); // do one space to the right
				}
			}
		} else {
			System.out.println(moveString);
		}
	}

}
