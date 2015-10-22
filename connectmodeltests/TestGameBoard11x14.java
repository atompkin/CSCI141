package connectmodeltests;
/**
 * Test 11X14 board
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import connectmodel.GameBoard;
import connectmodel.PieceType;

public class TestGameBoard11x14 
{
	private PieceType[] myTypes;
	private GameBoard myGameboard;
	
	@Before
	public void setUp() throws Exception
	{
		myTypes = new PieceType[4];
		myTypes[0] = PieceType.BLACK;
		myTypes[1] = PieceType.RED;
		myTypes[2] = PieceType.YELLOW;
		myTypes[3] = PieceType.GREEN;
		myGameboard = new GameBoard(11, 14, 7, myTypes);		
	}
	
	/**
	 * Test Vertical win
	 * bottom left corner
	 */
	@Test
	public void testVerticalWinBotLeft()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(0, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test vertical win
	 * bottom right corner
	 */
	@Test
	public void testVerticalWinBotRight()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(13, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test Vertical win
	 * top left corner
	 */
	@Test
	public void testVerticalWinTopLeft()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(0, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test Vertical win
	 * top right corner
	 */
	@Test
	public void testVerticalWinTopRight()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(13, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * test vertical win
	 * middle of board
	 */
	@Test
	public void testVerticalWinMiddle()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(5, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test Horizontal win
	 * bottom left corner
	 */
	@Test
	public void testHorizontalWinBotLeft()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(6, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test horizontal wins 
	 * bottom right corner
	 */
	@Test 
	public void testHorizontalWinBotRight()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(12, myTypes[0]);
		myGameboard.placePiece(11, myTypes[0]);
		myGameboard.placePiece(10, myTypes[0]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(8, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(7, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * test horizontal win
	 * top left corner
	 */
	@Test
	public void testHorizontalWinTopLeft()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[0]);
		
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[0]);
		
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[0]);
		
		assertFalse(myGameboard.getIsAWin());
		myGameboard.placePiece(6, myTypes[0]);
		
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test horizontal win 
	 * top right corner
	 */
	@Test
	public void testHorizontalWinTopRight()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[0]);
		
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[0]);
		
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[0]);
		
		myGameboard.placePiece(10, myTypes[0]);
		myGameboard.placePiece(10, myTypes[0]);
		myGameboard.placePiece(10, myTypes[0]);
		myGameboard.placePiece(10, myTypes[0]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[0]);
		
		myGameboard.placePiece(11, myTypes[0]);
		myGameboard.placePiece(11, myTypes[0]);
		myGameboard.placePiece(11, myTypes[0]);
		myGameboard.placePiece(11, myTypes[0]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[0]);
		
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[0]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[0]);
		myGameboard.placePiece(12, myTypes[0]);
		myGameboard.placePiece(12, myTypes[0]);
		myGameboard.placePiece(12, myTypes[0]);
		myGameboard.placePiece(12, myTypes[0]);
		
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(13, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test horizontal win
	 * middle of board
	 */
	@Test
	public void testHorizontalWinMiddle()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(8, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test Diagonal Win
	 * bottom left corner
	 */
	@Test
	public void testDiagonalWinBotLeft()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[0]);
		
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		assertFalse(myGameboard.getIsAWin());

		myGameboard.placePiece(6, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test diagonal win 
	 * bottom right corner
	 */
	@Test
	public void testDiagonalWinBotRight()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(13, myTypes[0]);
		
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[0]);
		
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[0]);
		
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[0]);
		myGameboard.placePiece(10, myTypes[0]);
		
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[0]);
		
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[0]);
		
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		assertFalse(myGameboard.getIsAWin());
		
		myGameboard.placePiece(7, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test diagonal win
	 * top left corner
	 */
	@Test 
	public void testDiagonalWinTopLeft()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[0]);
		
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[0]);
		
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		assertFalse(myGameboard.getIsAWin());
		
		myGameboard.placePiece(6, myTypes[0]);
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test diagonal win
	 * top right corner
	 */
	@Test 
	public void testDiagonalWinTopRight()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[0]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[1]);
		myGameboard.placePiece(13, myTypes[0]);
		
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[0]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[1]);
		myGameboard.placePiece(12, myTypes[0]);
		
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[0]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[1]);
		myGameboard.placePiece(11, myTypes[0]);
		
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[0]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[1]);
		myGameboard.placePiece(10, myTypes[0]);
		
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[0]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[1]);
		myGameboard.placePiece(9, myTypes[0]);
		
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[1]);
		myGameboard.placePiece(8, myTypes[0]);
		
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test diagonal win
	 * middle of board
	 */
	@Test
	public void testDiagonalWinMiddle()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[0]);
		
		myGameboard.placePiece(8, myTypes[0]);
		myGameboard.placePiece(8, myTypes[0]);
		
		assertTrue(myGameboard.getIsAWin() == true);
	}
	
	/**
	 * Test if column is full
	 * empty
	 */
	@Test
	public void testIsColFullEmpty()
	{
		myGameboard.resetBoard();
		assertTrue(myGameboard.isColumnFull(0) == false);
	}
	
	/**
	 * Test if column is full
	 * half full
	 */
	@Test 
	public void testIsColFullHalf()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		assertTrue(myGameboard.isColumnFull(0) == false);
	}
	
	/**
	 * Test if column is full
	 * full
	 */
	@Test 
	public void testIsColFullFull()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[0]);
		assertTrue(myGameboard.isColumnFull(0) == true);
	}
	
	/**
	 * Test if board is full
	 * empty
	 */
	@Test
	public void testIsBoardFullEmpty()
	{
		myGameboard.resetBoard();
		assertTrue(myGameboard.isBoardFull() == false);
	}
	
	/**
	 * Find best move column
	 * win horizontal
	 */
	@Test
	public void testFindBestMoveColumnWinHorizontal()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(6, myTypes[0]);
		int move = myGameboard.findBestMoveColumn(myTypes[0]);
		assertTrue(move == 3);
	}
	
	/**
	 * find best move column
	 * win vertical
	 */
	@Test
	public void testFindBestMovecolumnWinVertical()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		int move = myGameboard.findBestMoveColumn(myTypes[0]);
		assertTrue(move == 0);
	}
	
	/**
	 * Find best move column
	 * win Diagonal
	 */
	@Test
	public void testFindBestMoveColumnWinDiagonal()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[0]);
		
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		
		//myGameboard.placePiece(6, myTypes[0]);
		
		int move = myGameboard.findBestMoveColumn(myTypes[0]);
		assertTrue(move == 6);
	}
	
	/**
	 * Find best move column
	 * block horizontal 
	 */
	@Test 
	public void testFindBestMoveColumnBlockHorizontal()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(1, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(6, myTypes[0]);
		int move = myGameboard.findBestMoveColumn(myTypes[1]);
		assertTrue(move == 3);
	}
	
	/**
	 * Find best move column
	 * block Vertical
	 */
	@Test
	public void testFindBestMoveColumnBlockVertical()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		myGameboard.placePiece(0, myTypes[0]);
		int move = myGameboard.findBestMoveColumn(myTypes[1]);
		
		assertTrue(move == 0);
	}
	
	/**
	 * Find best move column
	 * block diagonal
	 */
	@Test
	public void testFindBestMoveColumnBlockDiagonal()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[0]);
		
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[0]);
		
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[0]);
		
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		
		int move = myGameboard.findBestMoveColumn(myTypes[1]);
		assertTrue(move == 4);
	}
	
	/**
	 * Find best move column when no win or block
	 */
	@Test
	public void testFindBestMoveNoWinOrBlock()
	{
		myGameboard.resetBoard();
		myGameboard.placePiece(0, myTypes[1]);
		myGameboard.placePiece(0, myTypes[0]);
		
		myGameboard.placePiece(1, myTypes[1]);
		myGameboard.placePiece(1, myTypes[1]);
		
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[1]);
		myGameboard.placePiece(2, myTypes[0]);
		myGameboard.placePiece(2, myTypes[0]);
		
		myGameboard.placePiece(3, myTypes[0]);
		myGameboard.placePiece(3, myTypes[1]);
		myGameboard.placePiece(3, myTypes[0]);
		
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		myGameboard.placePiece(4, myTypes[1]);
		myGameboard.placePiece(4, myTypes[0]);
		
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[0]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[1]);
		myGameboard.placePiece(5, myTypes[0]);
		
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[1]);
		myGameboard.placePiece(6, myTypes[0]);
		
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[1]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		myGameboard.placePiece(7, myTypes[0]);
		
		myGameboard.placePiece(8, myTypes[0]);

		int move = myGameboard.findBestMoveColumn(myTypes[0]);
		assertTrue(move == 3);
	}
}
