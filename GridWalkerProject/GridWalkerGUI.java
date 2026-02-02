package GridWalkerProject;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class GridWalkerGUI extends JFrame implements ActionListener{
	
	private static JButton [][] gridOfButtons;
	private boolean gameContinued = true;
    private int numRows;
	private int numColumns;
	
	//actionPerformed occurs automatically when action such as button click occurs
	//action command is split by split method with semicolon. the result array is 2 strings-- the first for row index and second for columns index of button
	//doClick method called on corresponding row and column index values obtained by array
	@Override
	public void actionPerformed(ActionEvent e) {
		String [] array= e.getActionCommand().split(";"); 
		doClick(Integer.parseInt( array[0]), Integer.parseInt( array[1]));
		
	}
	
    
	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		new GridWalkerGUI();
	}
	
	
	public GridWalkerGUI(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits out of application when hit x button
		this.setSize(600,600);// this passes in size width (x dimension) and height (y dimension)
		
        String input =JOptionPane.showInputDialog("How many rows?");  // showInputDialog box--allows user to enter info
        numRows= Integer.valueOf(input); // turns string number into integer and stores in numRows
		input = JOptionPane.showInputDialog("How many columns?");// showInputDialog box-- allows user to enter info
		numColumns = Integer.valueOf(input); // turns string number into integer and stores in numColumns
		
		this.setLayout(new GridLayout(numRows, numColumns, 1, 1)); // Gives grid layout first two parameters are rows, column, last two parameter are spacing between boxes
		
        gridOfButtons = new JButton[numRows][numColumns];
		String [] direction= { "\u2191","\u2193","\u2190", "\u2192"}; // Unicode for my Up,Down, Left, Right arrows
		
		// 2D array iterates and fills array randomly with arrow buttons
		for(int rowIndex = 0; rowIndex < gridOfButtons.length; rowIndex++) { 
			for(int columnIndex = 0; columnIndex < gridOfButtons[0].length; columnIndex++ ) { // loop required for 2d array. 
				JButton button = new JButton(direction[(int)(Math.random()*4)]);// puts 1d array elements randomly in 2d array		 
				button.setOpaque(true);
                button.setContentAreaFilled(true);
                button.setActionCommand(rowIndex + ";" + columnIndex); // Sets a string to represent button action command, combines rowIndex and columnIndex values separated by ; 
				button.addActionListener(this);
                gridOfButtons[rowIndex][columnIndex] = button;
                this.add(button);
			}
		}
		
		// Target only needed one time randomly in grid
		gridOfButtons[(int)(Math.random()*numRows)][(int)(Math.random()*numColumns)].setText("\u25CE"); 
		this.setVisible(true);
	}

	
	private void doClick(int startRow, int startColumn) { // Start row and start column
		boolean[][] visited = new boolean[numRows][numColumns]; // 2D array keeps track of buttons already visited
		int totalStepCount=0;
		
		while (gameContinued){  //The boolean in while loop parameter allows the code to continue until stop conditions encountered:
								//1) reach the target button 
								//2) path intersects itself (I step on a yellow button which was marked as already stepped on), or 
								//3) go off the grid (addresses any out of bound exception) 
				JButton gameButton = gridOfButtons[startRow][startColumn];
				gameButton.setFont(new Font("Monaco", Font.PLAIN, 35));  // To change font
				// custom color created-adjusted range in each color to create new(RGB values-Red (0-255), Green (0-255), Blue (0-255))
				gameButton.setForeground(new Color (96, 96, 96)); // Dark gray RGB color code
				// gameButton.setForeground(Color.white); //another way to set text font color
				
				if(gameButton.getText().equals("\u2191")) //Up arrow
				{ 
					gameButton.setBackground(Color.yellow); 
					// Kept track of which button is visited by switching the values on/off for the corresponding button in this boolean array
					visited[startRow][startColumn]= true; 
					startRow = startRow - 1; 
					totalStepCount++;	// Increments my step count	
				}	
				else if (gameButton.getText().equals("\u2193")) // Down arrow
				{ 
					gameButton.setBackground(Color.yellow);  
					visited[startRow][startColumn] = true;
					startRow = startRow + 1; 
					totalStepCount++;
				}
				else if(gameButton.getText().equals("\u2190")) // Left arrow
				{ 
					gameButton.setBackground(Color.yellow); 
					visited[startRow][startColumn] = true;
					startColumn = startColumn - 1; 
					totalStepCount++;
				}		
				else if(gameButton.getText().equals("\u2192")) // Right arrow
				{ 
					gameButton.setBackground(Color.yellow); 
					visited[startRow][startColumn] = true;
					startColumn = startColumn + 1;   
					totalStepCount++;
				}		
				else if (gameButton.getText().equals("\u25CE")) // Target 
				{ 
					gameButton.setBackground(Color.green);
					JOptionPane.showMessageDialog(null, "You finished in " + totalStepCount + " steps.");
					gameContinued=false; // Flag/off switch
				}
                if (startRow < 0 || startRow >= numRows || startColumn < 0 || startColumn >= numColumns)
                {
                    gameButton.setBackground(new Color(255, 51, 51)); // Lighter red RGB color code
                    JOptionPane.showMessageDialog(null, "You left the grid!");
                    gameContinued = false;
                    break;
                }
                if (visited[startRow][startColumn])
                {
                    gameButton.setBackground(new Color(255, 51, 51)); // Lighter red RGB color code
                    JOptionPane.showMessageDialog(null, "Your path intersected itself!");
                    gameContinued = false;
                    break;
                }
				this.setVisible(true);
		}
		System.exit(0); // terminates program--closes screen 
	}
}





