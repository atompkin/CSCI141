/**
 * Kathryn Sarullo
 * Project 2
 * 10/5/15
 * CSCI142 02
 * 
 * Description: This class creates what piece types can be used by the
 * players. It gets the name(color) of the piece type.
 * 
 */

package connectmodel;

public enum PieceType 
{
	/**
	 * The possible colors a player can play with and the name 
	 * of that color
	 */
	RED ("Red"),
	BLACK ("Black"),
	GREEN ("Green"),
	YELLOW ("Yellow");
	private final String myType;
    
	/**
	 * The constructor that initializes the name of the piece type
	 * @param type : The name of the piece type
	 */
    private PieceType(String type) 
    {
    	myType = type;
    }

    /**
     * Gets the name of the piece type
     * @return : Name of the piece type
     */
	private String getName()
	{
		return myType;
	}
}