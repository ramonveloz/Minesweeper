//https://youtu.be/YsfeTSUt1MI
import java.util.*;
import java.util.Random;

public class Grid {
	
	private boolean[][] bombGrid;
	private int[][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	
	
	public Grid() {
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		
		createBombGrid();
		createCountGrid();
		
	}
	public Grid(int rows, int columns) {
		numRows = rows;
		numColumns = columns;
		this.numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		
		createBombGrid();
		createCountGrid();
	}
	public Grid(int rows, int columns, int numBombs) {
		numRows = rows;
		numColumns = columns;
		this.numBombs = numBombs;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		
		createBombGrid();
		createCountGrid();
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	public int getNumBombs() {
		return numBombs;
	}
	
	public boolean[][] getBombGrid(){
		boolean[][] c = new boolean[numRows][numColumns];
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < bombGrid[i].length; j++) {
				c[i][j] = bombGrid[i][j];
			}
		}
		
		return c;
	}
	
	public int[][] getCountGrid(){
		int[][] c = new int[numRows][numColumns];
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < countGrid[i].length; j++) {
				c[i][j] = countGrid[i][j];
			}
		}
		
		return c;
		
		
		//return countGrid;
	}
	
	public int getCountAtLocation(int row, int column) {
		return countGrid[row][column];
	}
	
	public boolean isBombAtLocation(int row, int column) {
		return bombGrid[row][column];
	}
	
	public void createBombGrid() {
		Random rand = new Random();
		
		int rows;
		int cols;
		
		for(int i = 0; i < numBombs; i++) {
			rows = rand.nextInt(numRows);
			cols = rand.nextInt(numColumns);
			
			if(bombGrid[rows][cols] == false) {
				bombGrid[rows][cols] = true;
			}
			else {
				i--;
			}
		}
		
		
	}
	
	public void createCountGrid() {
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < countGrid[i].length; j++) {
				int bombsNear = 0;
				if(i == 0 && j == 0) {
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j + 1] == true) {
						bombsNear++;
					}//right
					if(bombGrid[i + 1][j] == true) {
						bombsNear++;
					}//down
					if(bombGrid[i + 1][j + 1] == true) {
						bombsNear++;
					}//diagnal
				}//First
				
				else if(i == numRows-1 && j == 0) {
					
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j + 1] == true) {
						bombsNear++;
					}//right
					if(bombGrid[i -1][j] == true) {
						bombsNear++;
					}//up
					if(bombGrid[i - 1][j + 1] == true) {
						bombsNear++;
					}//diagnal
					
				}//End of the Second
				
				else if(i > 0 && i < numRows && j == 0) {
					
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j + 1] == true) {
						bombsNear++;
					}//right
					if(bombGrid[i -1][j] == true) {
						bombsNear++;
					}//up
					if(bombGrid[i + 1][j] == true) {
						bombsNear++;
					}//down
					if(bombGrid[i + 1][j + 1] == true) {
						bombsNear++;
					}//diagnal down
					
					if(bombGrid[i - 1][j + 1] == true) {
						bombsNear++;
					}//diagnal up
					
				}//End of the third
				
				else if(i == 0 && j == numColumns -1) {
					
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j - 1] == true) {
						bombsNear++;
					}//left
					if(bombGrid[i + 1][j] == true) {
						bombsNear++;
					}//down
					if(bombGrid[i + 1][j -1] == true) {
						bombsNear++;
					}//diagnal down
					
					
				}//End of the Forth
				
				else if(i == numRows - 1 && j == numColumns -1) {
					
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j - 1] == true) {
						bombsNear++;
					}//left
					if(bombGrid[i - 1][j] == true) {
						bombsNear++;
					}//up
					if(bombGrid[i - 1][j -1] == true) {
						bombsNear++;
					}//diagnal down
					
					
				}//End of the Fith
				
				else if(i > 0 && i < numRows && j == numColumns -1) {
					
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j - 1] == true) {
						bombsNear++;
					}//right
					if(bombGrid[i -1][j] == true) {
						bombsNear++;
					}//up
					if(bombGrid[i + 1][j] == true) {
						bombsNear++;
					}//down
					if(bombGrid[i + 1][j - 1] == true) {
						bombsNear++;
					}//diagnal down
					
					if(bombGrid[i - 1][j - 1] == true) {
						bombsNear++;
					}//diagnal up
					
					
				}//End of the sixth
				
				
				else if(i == 0 && j > 0 &&j < numColumns ) {
					
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j - 1] == true) {
						bombsNear++;
					}//right
					if(bombGrid[i][j+ 1] == true) {
						bombsNear++;
					}//left
					if(bombGrid[i + 1][j] == true) {
						bombsNear++;
					}//down
					if(bombGrid[i + 1][j - 1] == true) {
						bombsNear++;
					}//diagnal down left
					
					if(bombGrid[i + 1][j + 1] == true) {
						bombsNear++;
					}//Diagonal down right
					
					
				}//End of the Seventh
				
				else if(i == numRows-1 && j > 0 &&j < numColumns ) {
					
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j - 1] == true) {
						bombsNear++;
					}//right
					if(bombGrid[i][j+ 1] == true) {
						bombsNear++;
					}//left
					if(bombGrid[i - 1][j] == true) {
						bombsNear++;
					}//down
					if(bombGrid[i - 1][j - 1] == true) {
						bombsNear++;
					}//diagnal up left
					
					if(bombGrid[i - 1][j + 1] == true) {
						bombsNear++;
					}//Diagonal down right
					
					
				}//End of the Eith
				
				else {
					if(bombGrid[i][j] == true) {
						bombsNear++;
					}//point
					if(bombGrid[i][j - 1] == true) {
						bombsNear++;
					}//right
					if(bombGrid[i][j+ 1] == true) {
						bombsNear++;
					}//left
					if(bombGrid[i + 1][j] == true) {
						bombsNear++;
					}//down
					if(bombGrid[i - 1][j] == true) {
						bombsNear++;
					}//up
					if(bombGrid[i - 1][j - 1] == true) {
						bombsNear++;
					}//diagnal up left
					
					if(bombGrid[i - 1][j + 1] == true) {
						bombsNear++;
					}//Diagonal up right
					
					if(bombGrid[i + 1][j - 1] == true) {
						bombsNear++;
					}//diagnal down left
					
					if(bombGrid[i + 1][j + 1] == true) {
						bombsNear++;
					}//Diagonal down right
					
				}//End of the Nineth
				countGrid[i][j] = bombsNear;
			}//inside forLoop
			
			
		}
		
	}
	

}
