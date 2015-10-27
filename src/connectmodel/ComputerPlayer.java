/**
 * Kathryn Sarullo
 * Project 2
 * 10/5/15
 * CSCI142 02
 * 
 * Description: This Computer Player extends player so it does everything
 * the player class does except, this is the AI. It's moves are created
 * for them so the only thing this type of player needs is a name and a 
 * piece type.
 * 
 */

package connectmodel;

public class ComputerPlayer extends Player
{
	/**
	 * The Constructor for a computer player, initializing all member 
	 * variables need for a computer player in the player class
	 * @param name : Name of computer player
	 * @param type : Color of piece type
	 */
	public ComputerPlayer(String name, PieceType type)
	{
		super(name, type);
	}
}