package connectmodeltests;
/**
 * Test Case for GameBoard6x7 Class
 * 
 */
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import connectmodel.GameBoard;
import connectmodel.PieceType;

public class TestGameBoard6x7 
{
	private GameBoard myGameBoard; 
	private PieceType myTypes[];
	
	/**
	 * Set GameBoard and PieceType objects for all test scripts.
	 * Also, assume that board row and column indices begin at 0.
	 * (e.g. for 7 columns, index 0 thru 6, not 1 thru 7)
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		myTypes = new PieceType[2];
		myTypes[0] = PieceType.BLACK;
		myTypes[1] = PieceType.RED;

		 myGameBoard = new GameBoard(6, 7, 4, myTypes);
	}
	/*
	 * Checks if Columns are full
	 */
	@Test
	public void columnLeftFull() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myTypes[1]);
		assertTrue(myGameBoard.isColumnFull(0));
		assertFalse(myGameBoard.placePiece(0, myTypes[0]));
	}

	@Test
	public void columnRightFull() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myTypes[1]);
		assertTrue(myGameBoard.isColumnFull(6));
		assertFalse(myGameBoard.placePiece(6, myTypes[0]));
	}
	
	@Test
	public void columnMiddleFull() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myTypes[1]);
		assertTrue(myGameBoard.isColumnFull(3));
		assertFalse(myGameBoard.placePiece(3, myTypes[0]));
	}
	/*
	 * Tests vertical, horizontal, and diagonal wins from
	 * both corners, bottom, top, and in the middle of
	 * the board.  Test case names describe each.
	 */
	
	/*
	 * Vertical tests
	 */
	@Test
	public void testVerticalLeftBottomWin() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(0, 0), new Point(3, 0));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalRightBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(0, 6), new Point(3, 6));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalMiddleBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(0, 3), new Point(3, 3));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalLeftTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(2, 0), new Point(5, 0));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalRightTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(2, 6), new Point(5, 6));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalMiddleTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(2, 3), new Point(5, 3));
		assertTrue(check);
	}

	@Test
	public void testVerticalLeftNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(1, 0), new Point(4, 0));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalMiddleNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		boolean check = this.checkEndPoints(new Point(1, 4), new Point(4, 4));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalRightNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(1, 6), new Point(4, 6));
		assertTrue(check);
	}
	
	/*
	 * Horizontal tests
	 */
	@Test
	public void testHorizontalLeftBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		boolean check = this.checkEndPoints(new Point(0, 0), new Point(0, 3));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalRightBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		boolean check = this.checkEndPoints(new Point(0, 3), new Point(0, 6));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalMiddleBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(0, 2), new Point(0, 5));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalLeftNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(2, 0), new Point(2, 3));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalRightNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(2, 3), new Point(2, 6));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalMiddleNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(2, 1), new Point(2, 4));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalLeftTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(5, 0), new Point(5, 3));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalRightTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(5, 3), new Point(5, 6));
		assertTrue(check);
	}
	
	@Test
	public void testHorizontalMiddleTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(5, 1), new Point(5, 4));
		assertTrue(check);
	}
	
	/*
	 * Diagonal wins
	 */
	@Test
	public void testDiagonalBottomLeftWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(0, 0), new Point(3, 3));
		assertTrue(check);
	}
	
	@Test
	public void testDiagonalBottomRightWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(0, 6), new Point(3, 3));
		assertTrue(check);
	}
	
	@Test
	public void testDiagonalBottomMiddleWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(0, 5), new Point(3, 2));
		assertTrue(check);
	}
	
	@Test
	public void testDiagonalUpperRightWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(5, 6), new Point(2, 3));
		assertTrue(check);
	}
	
	@Test
	public void testDiagonalUpperLeftWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check = this.checkEndPoints(new Point(5, 0), new Point(2, 3));
		assertTrue(check);
	}
	
	@Test
	public void testDiagonalUpperMiddleWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		boolean check = this.checkEndPoints(new Point(5, 1), new Point(2, 4));
		assertTrue(check);
	}
	
	/*
	 * No preference will be given to which win a piece provides.
	 * Test if a piece will yield both a horizontal and diagonal
	 * win, that a win is recorded.  Either win is acceptable.
	 */
	@Test
	public void testDoubleWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean checkDiag = this.checkEndPoints(new Point(0, 1), new Point(3, 4));
		boolean checkHoriz = this.checkEndPoints(new Point(3, 1), new Point(3, 4));
		assertTrue(checkDiag || checkHoriz);
	}
	
	/**
	 * Test tie
	 */
	@Test
	public void testTie()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		myGameBoard.placePiece(0, myTypes[0]);
		myGameBoard.placePiece(0, myTypes[1]);
		myGameBoard.placePiece(0, myTypes[0]);
		myGameBoard.placePiece(0, myTypes[1]);
		myGameBoard.placePiece(0, myTypes[0]);
		
		myGameBoard.placePiece(1, myTypes[0]);
		myGameBoard.placePiece(1, myTypes[0]);
		myGameBoard.placePiece(1, myTypes[1]);
		myGameBoard.placePiece(1, myTypes[0]);
		myGameBoard.placePiece(1, myTypes[1]);
		myGameBoard.placePiece(1, myTypes[0]);

		myGameBoard.placePiece(2, myTypes[1]);
		myGameBoard.placePiece(2, myTypes[1]);
		myGameBoard.placePiece(2, myTypes[0]);
		myGameBoard.placePiece(2, myTypes[1]);
		myGameBoard.placePiece(2, myTypes[0]);
		myGameBoard.placePiece(2, myTypes[1]);

		myGameBoard.placePiece(3, myTypes[1]);
		myGameBoard.placePiece(3, myTypes[1]);
		myGameBoard.placePiece(3, myTypes[0]);
		myGameBoard.placePiece(3, myTypes[1]);
		myGameBoard.placePiece(3, myTypes[0]);
		myGameBoard.placePiece(3, myTypes[1]);

		myGameBoard.placePiece(4, myTypes[0]);
		myGameBoard.placePiece(4, myTypes[0]);
		myGameBoard.placePiece(4, myTypes[1]);
		myGameBoard.placePiece(4, myTypes[0]);
		myGameBoard.placePiece(4, myTypes[1]);
		myGameBoard.placePiece(4, myTypes[0]);
		
		myGameBoard.placePiece(5, myTypes[0]);
		myGameBoard.placePiece(5, myTypes[0]);
		myGameBoard.placePiece(5, myTypes[1]);
		myGameBoard.placePiece(5, myTypes[0]);
		myGameBoard.placePiece(5, myTypes[1]);
		myGameBoard.placePiece(5, myTypes[0]);

		myGameBoard.placePiece(6, myTypes[1]);
		myGameBoard.placePiece(6, myTypes[1]);
		myGameBoard.placePiece(6, myTypes[0]);
		myGameBoard.placePiece(6, myTypes[1]);
		myGameBoard.placePiece(6, myTypes[0]);
		myGameBoard.placePiece(6, myTypes[1]);
		
		assertTrue(myGameBoard.isBoardFull());
		assertFalse(myGameBoard.getIsAWin());
		assertFalse(myGameBoard.checkAllNull());
	}
	
	/**
	 * Test that placing a piece to the left of the left
	 * boarder of board will fail.
	 */
	@Test
	public void twoBoardNegative()
	{
		assertFalse(myGameBoard.placePiece(-1, myTypes[0]));
	}
	
	/**
	 * Test that placing a piece to the right of the right 
	 * boarder of the board will fail.
	 */
	@Test
	public void twoBoardHorizontal()
	{
		assertFalse(myGameBoard.placePiece(7, myTypes[0]));
	}
	
	
	/*
	 * Do not show preference for how end points of a win
	 * are selected, as long as both are correct.
	 * 
	 * @param p1 one end point
	 * @param p2 the other end point
	 */
	private boolean checkEndPoints(Point p1, Point p2)
	{
		boolean option1 = myGameBoard.getWinBegin().equals(p1)
				&& myGameBoard.getWinEnd().equals(p2);
		boolean option2 = myGameBoard.getWinBegin().equals(p2)
				&& myGameBoard.getWinEnd().equals(p1);
		return option1 || option2;
	}
}