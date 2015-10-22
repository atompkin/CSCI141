package connectmodel;

import javax.swing.JOptionPane;

import connectmodel.View;

/**
 * Check Names
 * Assign PieceTypes
 * Create GameBoard
 * 
 * 
 * @author Andrew Tompkins
 *
 */

public class Controller 
{
	private View myView;
	private Player myPlayer;
	private ComputerPlayer myComputerPlayer;
	private GameBoard myGameBoard;
	private GameEngine myGameEngine;
	private PieceType myTypes[];
	private String myPlayerName;
		
	public Controller()
    {
        myView = new View(this);
		myTypes = new PieceType[2];
		myTypes[0] = PieceType.RED;
		myTypes[1] = PieceType.BLACK;
		myComputerPlayer = new ComputerPlayer("PC", myTypes[1]);
		myPlayer = new Player(JOptionPane.showInputDialog("Enter Your Name"), myTypes[1]);
		this.setPlayerName(myPlayer.getName());
    	myGameBoard = new GameBoard(6, 7, 4, myTypes);
    	myGameEngine = new GameEngine(myPlayer, myGameBoard);
    }
	
	public String setPlayerName(String myName)
	{
		myName = myPlayerName;
		return myName;
	}
	
	private void newGame()
	{
		myGameBoard.resetBoard();
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				myGameBoard.getBoard();
			}
		}
	}
}
