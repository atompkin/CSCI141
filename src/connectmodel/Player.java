/**
 * Kathryn Sarullo
 * Project 2
 * 10/5/15
 * CSCI142 02
 * 
 * Description: This class creates a player by them typing in their name and
 * what color piece type they want to play with. Their name can only contain
 * capital letters, lowercase letters, and number so everything else is 
 * replaced with the default name. This is also where each player score gets 
 * incremented and where you can find out what each player's score is. Lastly,
 * you can also get what color piece type that player is playing with.
 * 
 */

package connectmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player 
{
	/**
	 * Creating member variables to create a default name if the name is 
	 * not valid, the name variable, the number of wins, and the piece color.
	 * Lastly, there is a username pattern that should be followed that only
	 * includes lowercase letters, uppercase letters, and numbers.
	 */
	public static final String DEFAULT_NAME = "JohnCena";
	private String myName;
	private int myNumWins;
	private PieceType myPieceType;
	private static final String USERNAME_PATTERN = "^[a-z0-9A-Z]{1,50}$";

	/**
	 * The Constructor, initializing all member variables
	 * @param name : The name of the player
	 * @param type : The color of the piece type
	 */
	public Player(String name, PieceType type)
	{
		myName = name;
		myPieceType = type;
		myNumWins = 0;
	}

	/**
	 * Making sure a valid name is entered
	 * @param name : The name the player would like to use
	 * @return Either return the valid name the player entered or
	 * the default name if the name was invalid
	 */
	private boolean validateName(String name) 
	{
		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Matcher matcher = pattern.matcher(name);
		if(matcher.matches())
		{
			return true;
		}
		return false;
	}

	/**
	 * Increases the number of wins by one
	 */
	public void incrementScore() 
	{
		myNumWins = myNumWins + 1;
	}
	
	/**
	 * Gets the color of the piece type
	 * @return The color of the piece type
	 */
	public PieceType getPieceType()
	{
		return myPieceType;
	}

	/**
	 * Gets the name of the player
	 * @return The name of the player
	 */
	public String getName() 
	{
		if(validateName(myName))
		{
			return myName;
		}
		return DEFAULT_NAME;
	}

	/**
	 * Gets the number of wins for a player
	 * @return Number of wins
	 */
	public int getNumWins()
	{
		return myNumWins;
	}
	
	/**
	 * Gets the current score of a player
	 * @return The score
	 */
	public int getScore()
	{
		return myNumWins;
	}
}