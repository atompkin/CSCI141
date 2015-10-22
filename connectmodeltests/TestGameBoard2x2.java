package connectmodeltests;
/**
 * Test Case for GameBoard2x2 Class
 * 
 */
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import connectmodel.GameBoard;
import connectmodel.PieceType;

public class TestGameBoard2x2 
{

	private GameBoard myGameBoard; 
	private PieceType myTypes[];
	
	/**
	 * Set up an initial 2X2 board with two players (i.e. PieceTypes)
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		 myTypes = new PieceType[2];
		 myTypes[0] = PieceType.BLACK;
		 myTypes[1] = PieceType.RED;
		 
		 myGameBoard = new GameBoard(2, 2, 2, myTypes);
	}
	
	/*
	 * Test vertical, horizontal, and diagonal wins
	 */
	/**
	 * Test vertical win on left boarder of board
	 */
	@Test
	public void twoBoardVerticleWinLeft()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == true);
		
		boolean check = this.checkEndPoints(new Point(0, 0), new Point(1, 0));
		assertTrue(check);
	}
	
	/**
	 * Test vertical win on right boarder of board
	 */
	@Test
	public void twoBoardVerticleWinRight()
	{
		myGameBoard.placePiece(1, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(1, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == true);
		
		boolean check = this.checkEndPoints(new Point(0, 1), new Point(1, 1));
		assertTrue(check);
	}
	
	/**
	 * Test horizontal win on bottom boarder of board
	 */	
	@Test
	public void twoBoardHorizontalWinBottom()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(0, myTypes[1]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(1, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == true);
		
		boolean check = this.checkEndPoints(new Point(0, 0), new Point(0, 1));
		assertTrue(check);
	}
		
	/**
	 * Test diagonal win sloping down from upper left
	 * corner to lower bottom corner of board.
	 */	
	@Test
	public void twoBoardDiagonalWinDown()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(0, myTypes[1]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(1, myTypes[1]);
		assertTrue(myGameBoard.checkIfWin() == true);
		
		boolean check = this.checkEndPoints(new Point(0, 1), new Point(1, 0));
		assertTrue(check);
	}
	
	/**
	 * Test diagonal win sloping up from lower left
	 * corner to upper right corner of board.
	 */
	@Test
	public void twoBoardDiagonalWinUp()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(1, myTypes[1]);
		assertTrue(myGameBoard.checkIfWin() == false);
		myGameBoard.placePiece(1, myTypes[0]);
		assertTrue(myGameBoard.checkIfWin() == true);
		
		boolean check = this.checkEndPoints(new Point(0, 0), new Point(1, 1));
		assertTrue(check);
	}
	
	/**
	 * Test that placing a piece to the left of the left
	 * boarder of board will fail.
	 */
	@Test
	public void twoBoardNegative()
	{
		assertTrue(myGameBoard.placePiece(-1, myTypes[0]) == false);
	}
	
	/**
	 * Test that placing a piece to the right of the right 
	 * boarder of the board will fail.
	 */
	@Test
	public void twoBoardHorizontal()
	{
		assertTrue(myGameBoard.placePiece(2, myTypes[0]) == false);
	}
	
	/**
	 * Test if a board is full with no winner.  Note that for this
	 * to happen on a 2X2 board, need either three pieces or the
	 * requirement of three in a row to win.  Therefore, create 
	 * board with requirement of three in row.
	 */
	@Test
	public void boardFull()
	{
		myGameBoard = new GameBoard(2, 2, 3, myTypes);
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.isBoardFull() == false);
		myGameBoard.placePiece(1, myTypes[1]);
		assertTrue(myGameBoard.isBoardFull() == false);
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.isBoardFull() == false);
		myGameBoard.placePiece(1, myTypes[0]);
		assertTrue(myGameBoard.isBoardFull() == true);
	}
	
	/**
	 * Test if left column full and that pieces can no 
	 * longer be placed there.
	 */
	@Test
	public void columnFullLeft()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		assertTrue(myGameBoard.isColumnFull(0) == false);
		myGameBoard.placePiece(0, myTypes[1]);
		assertTrue(myGameBoard.isColumnFull(0));
		assertFalse(myGameBoard.placePiece(0, myTypes[0]));
	}
	
	/**
	 * Test if right column full and that pieces can no
	 * longer be placed there.
	 */
	@Test
	public void columnFullRight()
	{
		myGameBoard.placePiece(1, myTypes[0]);
		assertTrue(myGameBoard.isColumnFull(1) == false);
		myGameBoard.placePiece(1, myTypes[1]);
		assertTrue(myGameBoard.isColumnFull(1));
		assertFalse(myGameBoard.placePiece(1, myTypes[0]));
	}
	
	/**
	 * Test that one can get the PieceType on a board
	 */
	@Test
	public void getPiece()
	{
		myGameBoard.placePiece(0, myTypes[0]);
		myGameBoard.placePiece(0, myTypes[1]);
		myGameBoard.placePiece(1, myTypes[0]);
		assertTrue(myGameBoard.getPieceOnBoard(new Point(0, 0)) == myTypes[0]);
		assertTrue(myGameBoard.getPieceOnBoard(new Point(1, 0)) == myTypes[1]);
	    assertTrue(myGameBoard.getPieceOnBoard(new Point(0, 1)) == myTypes[0]);
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