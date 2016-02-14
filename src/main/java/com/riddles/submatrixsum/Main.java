package com.riddles.submatrixsum;

/**
 * Create the example matrix at{@link https://github.com/yaronma/riddles-submatrixsum} and
 * calculate the given sub-matrixes
 *  
 * @author yaron
 *
 */
public class Main {

	public static final int width = 8;
	public static final int height = 7;
	
	
	public static final int data[][] = new int[][] {
		{45,0,14,3,4,30,6,12},
		{34,14,22,9,34,56,17,34},
		{6,12,15,3,49,49,8,72},
		{16,78,5,42,63,1,48,18},
		{2,24,12,20,56,11,29,13},
		{32,9,33,2,33,6,19,21},
		{58,37,10,21,20,15,98,19},
		{17,55,19,1,13,20,17,43}
	};

	public final Rect rectRed =  new Rect(1,1,1,4);
	public final Rect rectBlue = new Rect(1,4,2,6);
	public final Rect rectPurple = new Rect(3,4,7,6);
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {

		System.out.println("Started...");
		
		System.out.println("Building and processing matrix.");
		
		Matrix matrix = new Matrix(data);
		
		// Make all the rows and columns sums
		matrix.process();
		
		System.out.println(matrix);
		
		System.out.print("Red rectangle " + rectRed + " sum is ");
		System.out.println(matrix.getSum(rectRed.x1, rectRed.y1, rectRed.x2, rectRed.y2));
		System.out.print("Blue rectangle " + rectBlue + " sum is ");
		System.out.println(matrix.getSum(rectBlue.x1, rectBlue.y1, rectBlue.x2, rectBlue.y2));
		System.out.print("Purple rectangle " + rectPurple + " sum is ");
		System.out.println(matrix.getSum(rectPurple.x1, rectPurple.y1, rectPurple.x2, rectPurple.y2));
		
		System.out.println("Completed.");
	}
}
