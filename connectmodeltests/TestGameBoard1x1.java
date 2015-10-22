package connectmodeltests;
/**
 * Test Case for GameBoard1x1 Class
 * 
 */
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import connectmodel.GameBoard;
import connectmodel.PieceType;

public class TestGameBoard1x1 
{

	private GameBoard myGameBoard; 
	private PieceType myTypes[];
	private Point myOnlyPoint;
	
	/**
	 * 
	 * @throws Exception
	 * Sets GameBoard and PieceType[] objects for test cases
	 */
	
	@Before
	public void setUp() throws Exception 
	{
		 myTypes = new PieceType[1];
		 myTypes[0] = PieceType.BLACK;

		 myGameBoard = new GameBoard(1, 1, 1, myTypes);
		 myOnlyPoint = new Point(0,0);
	}
	
	/*
	 * Check board when placing a piece or not placing a piece
	 * when resetting and not resetting.
	 */
	@Test
	public void testPieceOnBoard()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.getPieceOnBoard(myOnlyPoint) == myTypes[0]);
	}

	@Test
	public void testReset()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		myGameBoard.resetBoard();
		assertTrue(myGameBoard.getPieceOnBoard(myOnlyPoint) == null);
	}
	
	@Test
	public void testCheckAllNull()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		myGameBoard.resetBoard();
		assertTrue(myGameBoard.checkAllNull());
	}
	
	@Test
	public void testIfBoardFull()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.isBoardFull());
	}
	
	@Test
	public void testIfBoardNotFull()
	{
		assertFalse(myGameBoard.isBoardFull());
	}
	
	/*
	 * Check columns filled
	 */
	@Test
	public void testIfColumnFull()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.isColumnFull(0));
	}
	
	@Test
	public void testIfColumnNotFull()
	{
		assertFalse(myGameBoard.isColumnFull(0));
	}
	
	/*
	 * Check wins
	 */
	@Test
	public void testCheckIfWin()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.getIsAWin());
	}
	
	@Test
	public void testCheckIfNotWin()
	{
		assertFalse(myGameBoard.checkIfWin());
		assertFalse(myGameBoard.getIsAWin());
	}
}

