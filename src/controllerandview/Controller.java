/**
 * @author Jason Imeidopf, Andrew Tompkins
 * Project 2
 * 10/22/15
 * CSCI142
 * 
 * Allows the Model and View to interact. 
 */
package controllerandview;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JOptionPane;

import connectmodel.ComputerPlayer;
import connectmodel.GameBoard;
import connectmodel.GameEngine;
import connectmodel.PieceType;
import connectmodel.Player;

public class Controller 
{
	/**
	 * Attributes
	 */
	private View myView;
    private ComputerPlayer myComputerPlayer;
    private GameBoard myGameBoard;
    private GameEngine myGameEngine;
    private PieceType myTypes[];
    private Player myPlayer;
    private String myPlayerName;
    private int myties=0;
    private int mySwitchPlay=1;
    private Point myBeginPoint;
    private Point myEndPoint;
    
    /**
     * Sets up game from model.
     */
	public Controller()
	{
		myTypes = new PieceType[2];
		myTypes[0] = PieceType.RED;
		myTypes[1] = PieceType.BLACK;
        myComputerPlayer = new ComputerPlayer("Kat", myTypes[0]);
        myGameBoard = new GameBoard(6, 7, 4, myTypes);
        myPlayer = new Player(JOptionPane.showInputDialog("Enter Name"), myTypes[1]);
        this.setPlayerName(myPlayer.getName());     	
        
        myView = new View(this);    
        myGameEngine = new GameEngine(myPlayer, myGameBoard);
        this.newGame();
        myView.setVisible(true);
	}
	

	/**
	 * Sets all buttons to blank image to simulate being empty
	 */
	private void newGame()
	{
		myGameBoard.resetBoard();
		for(int i = 0; i < 6; i++)
        {
    		for(int j = 0; j < 7; j++ )
    		{
    			myView.setImage(i, j, "blank.jpg");	
    		}
        }		
	}

	/**
	 * Resets the background to blank image to simulate being empty.
	 * Changes starting player at the end of each game.
	 */
	public void resetGame()
	{
		if(myGameBoard.checkIfWin() == true || myGameBoard.isBoardFull() == true)
		{
			myGameBoard.resetBoard();
			for(int i = 0; i < 6; i++)
			{
	    		for(int j = 0; j < 7; j++ )
	    		{
	    			myView.setImage(i, j, "blank.jpg");
	    			myView.myButtons[i][j].setBackground(Color.WHITE);	    			
	    		}
	        }
			myView.resetLabel();
			myView.update(myView.getGraphics());
			mySwitchPlay++;
			if(mySwitchPlay % 2 == 0)
			{
				myGameEngine.switchPlayerUp();
				this.aiTurn();
			}			
			myView.getResetButton().setEnabled(false);
		}
	}
	
	
		/**
		 * Places pieces in clicked column.
		 */
	public void piecePlacer(Integer x)
	{
		int column = x;		
		if(myGameBoard.isColumnFull(column) != true && myGameBoard.checkIfWin() == false && myGameBoard.isBoardFull() == false)
		{
			myGameBoard.placePiece(column, myGameEngine.getPlayerUp().getPieceType());
			myView.setImage(myGameBoard.getLastPoint().x, myGameBoard.getLastPoint().y, "BLACK.jpg");
			myView.updateColumnPlayer();
			if (myGameBoard.checkIfWin() == true)
			{
				myPlayer.incrementScore();
				myView.updateScore();
				myView.higlightWin();
			}
			if(myGameBoard.checkIfWin() != true)
			{
				myGameEngine.switchPlayerUp();							
				this.aiTurn();
			}
		}
		if(myGameBoard.isBoardFull() == true)
		{
			setTieCount(getTies() + 1);
			myView.updateScore();
		}
	}
	
	
	public void aiTurn()
	{
		int aiColumn;
		aiColumn = myGameBoard.findBestMoveColumn(myGameEngine.getPlayerUp().getPieceType());
		if(myGameBoard.isColumnFull(aiColumn) == true)
		{
			for(int i = 0; i< myGameBoard.getNumColumns() - 1; i++)
			{
				aiColumn = i;
				if(myGameBoard.isColumnFull(aiColumn) == false)
				{
					break;
				}
			}
		}
		if(myGameBoard.isColumnFull(aiColumn) != true)
		{
			myGameBoard.placePiece(aiColumn, myGameEngine.getPlayerUp().getPieceType());
			myView.setImage(myGameBoard.getLastPoint().x, myGameBoard.getLastPoint().y, "RED.jpg");

			if(myGameBoard.checkIfWin() == true)
			{
				myComputerPlayer.incrementScore();
				myView.updateScore();
				myView.higlightWin();
			}
			myGameEngine.switchPlayerUp();			
		}
		myView.updateColumnAi();
	}
	
	
	/**
	 * Accessors
	 */
	public void setPlayerName(String name)
    {
    	myPlayerName = name;
    }
	
	public void setTieCount(int ties)
	{
		myties = ties;			
	}
	
	public void setBeginPoint()
	{	
		myBeginPoint = myGameBoard.getWinBegin();
	}
	
	public void setEndPoint()
	{
		myEndPoint = myGameBoard.getWinEnd();	
	}
	
	
	/**
	 * Mutators
	 */
	public Point getBeginPoint()
	{
		setBeginPoint();
		return myBeginPoint;
	}
	
	public Point getEndPoint()
	{
		setEndPoint();
		return myEndPoint;
	}
	
	public Point getLastPoint()
	{
		return myGameBoard.getLastPoint();
	}
	
	public boolean getIfWin()
	{
		return myGameBoard.checkIfWin();
	}
	
	public String getPlayerName() 
	{		
		return myPlayerName;
	}
	
	public int getCompPlayerScore()
	{
		return myComputerPlayer.getScore();
	}
	
	public int getPlayerScore()
	{
		return myPlayer.getScore();
	}
	
	public int getTies()
	{
		return myties;
	}
	
	public int getNumRows()
	{
		return myGameBoard.getNumRows();
	}
	
	public int getNumColumns()
	{
		return myGameBoard.getNumColumns();
	}
	
	public String getComputerPlayerName()
	{
		return myComputerPlayer.getName();
	}
}
