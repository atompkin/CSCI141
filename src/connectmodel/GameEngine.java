/**
 * Kathryn Sarullo
 * Project 2
 * 10/5/15
 * CSCI142 02
 * 
 * Description: The game engine is everything that happens behind the scenes 
 * such as getting all the players, getting the starting player, switching 
 * the players, setting up the game board, etc. This class also is the one to
 * start the game and make sure pieces can be placed too.
 * 
 */

package connectmodel;

import java.util.Vector;

public class GameEngine 
{
	/**
	 * Creating member variables that creates the Players, player up, 
	 * starting player, the game board and the computer player
	 */
	private Vector<Player> myPlayers;
	private Player myPlayerUp;
	private Player myStartingPlayer;
	private GameBoard myGameBoard;
	private ComputerPlayer myCompPlayer;
  
	/**
	 * The Constructor, initializing all member variables
	 * @param player : A new player to this game
	 * @param gameboard : The size of the game board
	 */
	public GameEngine(Player player, GameBoard gameboard) 
	{
		myPlayers = new Vector<Player>();
		myGameBoard = gameboard;
		myStartingPlayer = player;
		myPlayerUp = player;
		myPlayers.add(player);
		myCompPlayer = new ComputerPlayer("Kat", PieceType.BLACK);
		if(myPlayers.firstElement() != null)
		{
			if(myPlayers.firstElement().getPieceType() == PieceType.BLACK)
			{
				myCompPlayer = new ComputerPlayer("Kat", PieceType.RED);
			}
			else
			{
				myCompPlayer = new ComputerPlayer("Kat", PieceType.BLACK);
			}
			myPlayers.add(myCompPlayer);
		}
	}

	/**
	 * Selecting the starting player
	 * @param player : A player in the game
	 * @return Whether the player being passed in is the starting player
	 * already or not.
	 */
	public boolean selectStartingPlayer(Player player)
	{
		if(getStartingPlayer() == player)
		{
			return true;
		}
		return false;
	}

	/**
	 * Starting the game if the game board is initialized and there are
	 * player elements as well as making sure the board is empty before 
	 * the game starts
	 * @return Whether all of this is true or not.
	 */
	public boolean startGame() 
	{
		if(myGameBoard == null || myPlayers.firstElement() == null)
		{
			return false;
		}
		myGameBoard.resetBoard();
		if(myGameBoard.checkAllNull() == true)
		{
			if(getStartingPlayer() == myPlayers.firstElement())
			{
				myStartingPlayer = myPlayers.lastElement();
				myPlayerUp = myPlayers.lastElement();
			}
			else
			{
				myStartingPlayer = myPlayers.firstElement();
				myPlayerUp = myPlayers.firstElement();
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Switching the player up in the game
	 * @return The opposite player that was just up
	 */
	public Player switchPlayerUp() 
	{
		if(getStartingPlayer() == myPlayers.firstElement())
		{
			myStartingPlayer = myPlayers.lastElement();
			myPlayerUp = myPlayers.lastElement();
		}
		else
		{
			myStartingPlayer = myPlayers.firstElement();
			myPlayerUp = myPlayers.firstElement();
		}
		return getStartingPlayer();
	}

	/**
	 * Checking to see if a piece can be placed or not
	 * @param column : The column that a piece is trying to get placed in
	 * @return Whether the column is full or not, if not place the piece.
	 */
	public boolean placePiece(int column)
	{
		if(myGameBoard.isColumnFull(column))
		{
			return false;
		}
		else if(myGameBoard.placePiece(column, getPlayerUp().getPieceType()))
		{
			return true;
		}
		return false;
	}

	/**
	 * Getting whichever players turn it is
	 * @return The player up
	 */
	public Player getPlayerUp() 
	{
		return myPlayerUp;
	}
	
	/**
	 * Getting the starting player
	 * @return The player who starts the game
	 */
	public Player getStartingPlayer()
	{
		return myStartingPlayer;
	}

	/**
	 * Getting the vector of players that are currently playing the game
	 * @return The vector of players
	 */
	public Vector<Player> getPlayers()
	{
		return myPlayers;
	}
  
	/**
	 * Creating the game board
	 * @param gameboard : The game board currently being used
	 */
	public void setGameBoard(GameBoard gameboard)
	{
		myGameBoard = gameboard;
	}

	/**
	 * Getting the size of the game board and the number of players
	 * @return The game board
	 */
	public GameBoard getGameBoard()
	{
		return myGameBoard;
	}
}