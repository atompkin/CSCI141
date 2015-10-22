package connectmodel;

import javax.swing.JOptionPane;

import connectmodel.View;

/**
 * 
 * 
 * @author Andrew Tompkins
 *
 */

public class Controller 
{
	private GameBoard myGameBoard;
	private GameEngine myGameEngine;
	private Player myPlayer;
	private ComputerPlayer myComputerPlayer;
	private PieceType[] myPieceType;
	
    public View myView;
	
	public Controller()
    {
        String firstName = null;

		firstName = JOptionPane.showInputDialog("Enter Your Name");

        myView = new View(this);
    	
    	myGameBoard = new GameBoard(6, 7, 4, myPieceType);
		myPlayer = new Player(firstName, PieceType.RED);
    }
	
	public void computerPlayer()
	{
		
	}
}
