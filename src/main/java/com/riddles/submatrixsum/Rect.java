package com.riddles.submatrixsum;

/**
 * Simple rectangle class implementation
 * 
 * @author yaron
 *
 */
public class Rect {

	// X coordinate of the upper-left corner
	int x1;

	// Y coordinate of the upper-left corner
	int x2;

	// X coordinate of the lower-right corner
	int y1;

	// Y coordinate of the lower-right corner
	int y2;

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Rect(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append('[');
		sb.append(x1);
		sb.append(',');
		sb.append(y1);
		sb.append(" => ");
		sb.append(x2);
		sb.append(',');
		sb.append(y2);
		sb.append(']');
		
		return sb.toString();
	}
}
