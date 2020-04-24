package brickBracker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {

	public int[][] matrix;
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator(int row, int col) {
		matrix = new int[row][col];
		for(int i=0 ; i<matrix.length ; i++) {
			for(int j=0 ; j<matrix[0].length ; j++) {
				matrix[i][j] = 1;
				
			}
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
		
	} 
	
	
	public void draw(Graphics2D g) {
		for(int i=0 ; i<matrix.length ; i++) {
			for(int j=0 ; j<matrix[0].length ; j++) {
				if(matrix[i][j] > 0) {
					g.setColor(Color.white);
					g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);

				}
				
			}
		}
		
	}
	
	public void setBrickValue(int value, int row, int col) {
		matrix[row][col] = value;
	}
	
	
	
	
}
