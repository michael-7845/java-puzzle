package kemin.coding;

import static t.A.*;
import static d.M.*;

import java.util.Scanner;

public class BuildArrrayAsRequired {
	
	public static Integer[][] multipleTable(int row, int column) {
		Integer[][] result = new Integer[row][column];
		for(int i=0; i<row; i++) {
			result[i] = new Integer[column];
			result[i][0] = i;
		}
		for(int i=0; i<column; i++) {
			result[0][i] = i;
		}
		
		for(int i=1; i<row; i++) {
			for(int j=1; j<column; j++) {
				result[i][j] = result[0][j] * result[i][0];
			}
		}

		return result;
	}
	
	public static void demo() {
		Scanner s = new Scanner(System.in);
		p("input integer x:");
		int x = s.nextInt(); //column
		p("input integer y:"); //row
		int y = s.nextInt();
		Integer[][] result = multipleTable(y, x);
		print2dArray(result);
	}

	public static void main(String[] args) {
		demo();
	}

}
