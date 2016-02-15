package com.riddles.submatrixsum;

/**
 * A very simple implementation of two dimensional matrix (backed by two
 * dimensional integers array)
 * 
 * @author yaron
 *
 */
public class Matrix {

	public static final String description = "Given an NxM matrix of numbers, calculate in O(1) the sum of a given sub-matrix";

	int m;

	int n;

	// Holds the matrix data
	int data[][];

	// Holds the sum of the sub matrixes
	int sumData[][];

	public Matrix(int[][] data) {
		
		this.n = data.length;
		this.m = data[0].length;
		
		if (n < 1 || m < 1) {
			throw new IllegalArgumentException();
		}

		this.data = data;
		sumData = new int[m][n];
	}

	/**
	 * Sets the content of a specific matrix cell
	 * 
	 * @param y
	 *            The y coordinate of the cell
	 * @param x
	 *            The x coordinate of the cell
	 * @param num
	 *            The number to store in the cell
	 */
	public void set(int x, int y, int num) {
		data[y][x] = num;
	}

	/**
	 * Returns the integer value stored in a specific matrix cell
	 * 
	 * @param y
	 *            The y coordinate of the cell
	 * @param x
	 *            The x coordinate of the cell
	 * @return
	 */
	public int get(int x, int y) {

		if (x < 0 || x > n || y < 0 || y > m) {
			throw new IllegalArgumentException();
		}

		return data[y][x];
	}

	/**
	 * Returns the sum of the sub-matrix ends with the cell at (x,y)
	 * 
	 * @param y
	 *            The y coordinate of the cell
	 * @param x
	 *            The x coordinate of the cell
	 * @return the sum of the sub-matrix ends with the cell at (x,y)
	 */
	public int getSum(int x, int y) {
		return sumData[y][x];
	}

	/**
	 * Returns {@code true} if the cell (x,y) is inside the matrix;
	 * {@code false} otherwise
	 * 
	 * @param y
	 *            The y coordinate of the cell
	 * @param x
	 *            The x coordinate of the cell
	 * @return {@code true} if the cell (x,y) is inside the matrix;
	 *         {@code false} otherwise
	 */
	public boolean inside(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}

		return true;
	}

	/**
	 * Returns {@code true} if the cell (x,y) is outside the matrix;
	 * {@code false} otherwise
	 * 
	 * @param y
	 *            The y coordinate of the cell
	 * @param x
	 *            The x coordinate of the cell
	 * @return {@code true} if the cell (x,y) is outside the matrix;
	 *         {@code false} otherwise
	 */
	public boolean outside(int x, int y) {
		return !inside(x, y);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Matrix\n");
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++)	{
				sb.append(" ");
				sb.append(String.format("%5d", data[y][x]));

			}
			sb.append("\n");
		}

		sb.append("Sum Matrix\n");
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				sb.append(" ");
				sb.append(String.format("%5d", sumData[y][x]));

			}
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * Builds the sums matrix
	 */
	public void process() {

		// Set the (0,0) cell
		sumData[0][0] = data[0][0];

		// Calculate the sub matrixes of the first row
		for (int x = 1; x < n; x++) {
			sumData[0][x] = sumData[0][x - 1] + data[0][x];
		}

		// Calculate the sub matrixes of the first colomn
		for (int y = 1; y < m; y++) {
			sumData[y][0] = sumData[y - 1][0] + data[y][0];
		}

		// Calculate sub matrixes of all other cells based on oriviously calculated vales
		for (int y = 1; y < m; y++) {
			for (int x = 1; x < n; x++) {
				sumData[y][x] = sumData[y][x - 1] + sumData[y - 1][x] + data[y][x] - sumData[y - 1][x - 1];
			}
		}
	}

	/**
	 * Returns the sum of the sub matrix that starts with (x1,y1) and ends with
	 * (x2,y2)
	 * 
	 * @param x1
	 *            The x coordinate of the upper-left corner of the sub matrix
	 * @param y1
	 *            The y coordinate of the upper-left corner of the sub matrix
	 * @param x2
	 *            The x coordinate of the lower-right corner of the sub matrix
	 * @param y2
	 *            The y coordinate of the lower-right corner of the sub matrix
	 * @return the sum of the sub matrix that starts with (x1,y1) and ends with
	 *         (x2,y2)
	 */
	public int getSum(int x1, int y1, int x2, int y2) {

		if (outside(x1, y1) || outside(x2, y2)) {
			throw new IllegalArgumentException();
		}

		int result = sumData[y2][x2];

		if (y1 > 0) {
			result -= sumData[y1 - 1][x2];
		}

		if (x1 > 0) {
			result -= sumData[y2][x1 - 1];
		}

		if (y1 > 0 && x1 > 0) {
			result += sumData[y1 - 1][x1 - 1];
		}

		return result;
	}
}
