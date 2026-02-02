package GridWalkerProject;


import java.util.Random;
import java.util.Scanner;

public class GridWalker {

	public static void main(String[] args) {
		
		Scanner input= new Scanner(System.in); // user input
		
		System.out.println("How many rows?");
		int numRows= input.nextInt();// next user input entered in numRows
		
		System.out.println("How many columns?");
		int numColumns = input.nextInt();// next user input entered in numColumns
		
		char[] direction= {'U', 'D', 'L', 'R'}; 
		
		Random random = new Random(); // required for random method below
		
		char[][] grid = new char[numRows][numColumns];
		
		
		for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) { // loop iterates and fills array 
			for(int columnIndex = 0; columnIndex < grid[0].length; columnIndex++ ) { // nested loop required for 2d array 
				grid[rowIndex][columnIndex]=direction[random.nextInt(direction.length)];// puts 1d array elements randomly in 2d array		
			}
		}
		
		// placed out of loop above since only needed only one time randomly in grid
		grid[random.nextInt(numRows)][random.nextInt(numColumns)] = 'T'; 
		
		// prints grid after filled 
		for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) {  
			for(int columnIndex = 0; columnIndex < grid[0].length; columnIndex++ ) {
				System.out.print(grid[rowIndex][columnIndex] + "  "); 
			}
			System.out.println();
		}
		
		System.out.println("What is the starting row?"); 
		int startRow = input.nextInt(); // puts next user input in startRow
		
		System.out.println("What is the starting column?"); 
		int startColumn = input.nextInt(); // puts next user input in startColumn
		
		
		int totalStepCount=0;
		boolean gamecontinued= true; 
		while (gamecontinued) /* Game was put in try catch to address outofboundsexception 
								The boolean in while loop parameter allows code to continue until it hits stoppint conditons:
								1) reach the spot marked T, 
								2) path intersects itself (meaning my step hits a * which previously entered after I made a step), or 
								3) go off the grid(This last one was put as my out of bound exception) */
		{  
			try
			{
				
				if(grid[startRow][startColumn]== 'U') {
					grid[startRow][startColumn]= '*';  
					startRow = startRow - 1; 
					totalStepCount++;	// increments step count	
				}
					
				else if(grid[startRow][startColumn]== 'D') {
					grid[startRow][startColumn]='*';
					startRow = startRow + 1; 
					totalStepCount++;
				}
					
				else if(grid[startRow][startColumn]== 'L') {
					grid[startRow][startColumn]='*';
					startColumn = startColumn - 1; 
					totalStepCount++;
				}
						
				else if(grid[startRow][startColumn]== 'R') {
					grid[startRow][startColumn]='*';
					startColumn = startColumn + 1; 
					totalStepCount++;
				}
						
				if (grid[startRow][startColumn]== 'T') {
					System.out.println("You finished in " + totalStepCount + " steps.");
					gamecontinued=false; // flag/off switch
					break; // required after off switch
				}
					
				if(grid[startRow][startColumn] == '*') {
					System.out.println("Your path intersected itself!");
					gamecontinued=false;
					break;
				}
				
			}
				
				catch(IndexOutOfBoundsException e) {
					System.out.println("You left the grid!");
					gamecontinued=false;
					break;
			}
		}
		
		// prints 2nd grid with the changes indicated in while loop above
		for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
			for(int columnIndex = 0; columnIndex < grid[0].length; columnIndex++ ) {
				System.out.print(grid[rowIndex][columnIndex] + "  "); 
			}
			System.out.println();
		}
		
		input.close();	// closes scanner 
	}

}













