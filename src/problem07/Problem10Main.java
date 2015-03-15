package problem07;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem10Main {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("How big is the grid? ");
		int gs = console.nextInt();
		System.out.println("How many dominoes are there? ");
		int numDominoes = console.nextInt();
		ArrayList<Domino> dominoList = new ArrayList<Domino>();
		for (int i = 0; i < numDominoes; i++) {
			dominoList.add(new Domino(console.nextDouble()));
		}
		ArrayList<int[][]> playGrid = new ArrayList<int[][]>();
	}

	public static boolean tryPlacement(ArrayList<Domino> domlist,
			ArrayList<int[][]> playgrid, int level, int gs) {
		int l = domlist.get(0).l;
		int r = domlist.get(0).r;
		int[][] thisgrid = playgrid.get(level);
		int[][] lastgrid = null;
		if (level != 0) {
			lastgrid = playgrid.get(level - 1);
		}
		level++;
		boolean success = false;
		for (int i = 0; i < gs; i++) {
			for (int j = 0; j < gs - 1; j++) {
				if (isPlaceValidHoriz(l, r, i, j, thisgrid, lastgrid, gs))
			}
			if (success)
				break;
		}


		for (int i = 0; i < gs - 1; i++) {
			for (int j = 0; j < gs; j++) {

			}
			if (success)
				break;
		}
		return success;
	}

	public static boolean isPlaceValidVert(int t, int b, int i, int j, int[][] thisgrid,
			int[]][] lastgrid, int gs) {
		if (i != 0 && isMismatch(thisgrid[i-1][j], top))
			return false;
		if (i + 1 != gs && isMismatch(thisgrid[i+2][j], bot))
			return false;
		if (j != 0 && (isMismatch(thisgrid[i][j-1], top) || isMismatch(thisgrid[i+1][j-1], bot)))
	}

	public static boolean isMismatch(int a, int b) {
		boolean aEven = a % 2 == 0;
		boolean bEven = b % 2 == 0;
		return ((aEven || bEven) && !(aEven && bEven));
	}

}

class Domino {
	int r;
	int l;

	public Domino(double d) {
		l = (int) d;
		r = (int)((d * 10) % 10);
	}
}