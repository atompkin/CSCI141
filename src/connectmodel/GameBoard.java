/**
 * Kathryn Sarullo
 * Project 2
 * 10/5/15
 * CSCI142 02
 * 
 * Description: This class makes the game board which includes getting the
 * number of rows, columns, win length, etc. This class is what makes it 
 * possible to place a piece as well. It also checks to see if the player
 * has won the game or not by checking in every direction as well as if 
 * the column or board is full. If it is a win, the win beginning and end
 * are saved. This class also controls the AI's moves such as where the
 * best move will be. Lastly, this can reset the board so many games can
 * be played.
 * 
 */

package connectmodel;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

public class GameBoard
{
	/**
	 * Creating member variables needed for the number of rows, columns,
	 * win length as well as the types being used in the game. Also, the 
	 * size of the board in a double array for the piece types to be placed.
	 * Lastly there are three points used to save the last point placed and
	 * where the win beginning and end are.
	 */
    private int myNumRows;
    private int myNumColumns;
    private PieceType[][] myBoard;
    private int myWinLength;
    private Point myLastPoint;
    private Vector<PieceType> myTypes;
    private Point myWinBegin;
    private Point myWinEnd;
    private boolean myIsAWin;
	
    /**
     * The Constructor, initializing all member variables
     * @param rows : Number of rows
     * @param cols : Number of columns
     * @param winLength : Number of pieces in a row to win
     * @param types : Piece type being used
     */
    public GameBoard(int rows, int cols, int winLength, PieceType[] types) 
    {
    	myNumRows = rows;
    	myNumColumns = cols;
    	myWinLength = winLength;
    	myIsAWin = false;
    	myBoard = new PieceType[rows][cols];
    	myLastPoint = new Point(0,0);
    	myWinBegin = new Point(0,0);
    	myWinEnd = new Point(0,0);
    }
	
    /**
     * Checking to see if a piece can be placed
     * @param col : Column the piece wants to be placed in
     * @param type : Color of the piece type being placed
     * @return Whether it is possible to place a piece in that column
     */
    public boolean placePiece(int col, PieceType type)
    {
    	if(col < 0 || col >= myNumColumns || isColumnFull(col))
		{
			return false;
		}
    	for(int i = 0; i < myNumRows; i++)
		{
			if(myBoard[i][col] == null)
			{
				myBoard[i][col] = type;
				myLastPoint = new Point(i,col);
				return true;
			}
		}
    	return false;
    }
	
    /**
     * Resetting the board so that every space is empty
     */
    public void resetBoard()
    {
    	for(int i = 0; i < myNumColumns; i++)
		{
    		for(int j = 0; j < myNumRows; j++)
    		{
    			myBoard[j][i] = null;
    		}
		}
    }
	
    /**
     * Checking to see if a player has won
     * @return True if a player has won, false otherwise
     */
    public boolean checkIfWin() 
    {
    	if(checkVerticalWin() || checkHorizontalWin() || checkDiagonalWin())
		{
			return true;
		}
		return false;
    }
	
    /**
     * Finding the best move the AI can make
     * @param type : The color of the computer player
     * @return The column of the best move
     */
    public int findBestMoveColumn(PieceType type)
    {
    	for(int i = 0; i < myNumColumns; i++)
    	{
    		if(countVerticalLengthIfPiecePlacedWin(i,type) == i ||
    				countHorizontalLengthIfPiecePlacedWin(i,type) == i ||
    				countDiagonalLengthIfPiecePlacedWin(i,type) == i)
    		{
    			return i;
    		}
    	}
    	for(int i = 0; i < myNumColumns; i++)
    	{
    		if(countVerticalLengthIfPiecePlacedBlock(i,type) == i ||
    				countHorizontalLengthIfPiecePlacedBlock(i,type) == i ||
    				countDiagonalLengthIfPiecePlacedBlock(i,type) == i)
    		{
    			return i;
    		}
    	}
    	for(int i = 0; i < myNumColumns; i++)
    	{
    		if(countVerticalLengthIfPiecePlacedOther(i,type) == i ||
    				countHorizontalLengthIfPiecePlacedOther(i,type) == i ||
    				countDiagonalLengthIfPiecePlacedOther(i,type) == i)
    		{
    			return i;
    		}
    	}
    	return 0;
    }
	
    /**
     * Checking if there is a win in the vertical directions
     * @return True if there is a win, false otherwise
     */
    private boolean checkVerticalWin() 
    {
    	int counterBlack = 0;
    	int counterRed = 0;
    	int y = (int)myLastPoint.getY();
    	for(int i = 0; i < myNumRows; i++)
    	{
    		if(myBoard[i][y] == PieceType.BLACK)
    		{
    			counterBlack++;
    			counterRed = 0;
    			if(counterBlack == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterBlack == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    		else if(myBoard[i][y] == PieceType.RED)
    		{
    			counterRed++;
    			counterBlack = 0;
    			if(counterRed == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterRed == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    	}
    	return false;
    }
	/**
	 * Checking if there is a win in the horizontal direction
	 * @return True if there is a win, false otherwise
	 */
    private boolean checkHorizontalWin() 
    {
    	int counterBlack = 0;
    	int counterRed = 0;
    	int x = (int)myLastPoint.getX();
    	for(int i = 0; i < myNumColumns; i++)
    	{
    		if(myBoard[x][i] == PieceType.BLACK)
    		{
    			counterBlack++;
    			counterRed = 0;
    			if(counterBlack == myWinLength)
    			{
    				myWinEnd = new Point(x,i);
    				return true;
    			}
    			else if(counterBlack == 1)
    			{
    				myWinBegin = new Point(x,i);
    			}
    		}
    		else if(myBoard[x][i] == PieceType.RED)
    		{
    			counterRed++;
    			counterBlack = 0;
    			if(counterRed == myWinLength)
    			{
    				myWinEnd = new Point(x,i);
    				return true;
    			}
    			else if(counterRed == 1)
    			{
    				myWinBegin = new Point(x,i);
    			}
    		}
    	}
    	return false;
    }
	
    /**
     * Checking to see if there is a win in the diagonal directions
     * @return True if there is a win, false otherwise
     */
    private boolean checkDiagonalWin() 
    {
    	//Checking in the up, right direction from the last point
    	int counterBlack = 0;
    	int counterRed = 0;
    	int x = (int)myLastPoint.getX();
    	int y = (int)myLastPoint.getY();
    	for(int i = x; i < myNumRows && y < myNumColumns; i++, y++)
    	{
    		if(myBoard[i][y] == PieceType.BLACK)
    		{
    			counterBlack++;
    			counterRed = 0;
    			if(counterBlack == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterBlack == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    		else if(myBoard[i][y] == PieceType.RED)
    		{
    			counterRed++;
    			counterBlack = 0;
    			if(counterRed == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterRed == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    	}
    	//Checking in the down, left direction from the last point
    	counterBlack = 0;
    	counterRed = 0;
    	x = (int)myLastPoint.getX();
    	y = (int)myLastPoint.getY();
    	for(int i = x; i >= 0 && y >= 0; i--, y--)
    	{
    		if(myBoard[i][y] == PieceType.BLACK)
    		{
    			counterBlack++;
    			counterRed = 0;
    			if(counterBlack == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterBlack == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    		else if(myBoard[i][y] == PieceType.RED)
    		{
    			counterRed++;
    			counterBlack = 0;
    			if(counterRed == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterRed == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    	}
    	//Checking in the up, left direction from the last point
    	counterBlack = 0;
    	counterRed = 0;
    	x = (int)myLastPoint.getX();
    	y = (int)myLastPoint.getY();
    	for(int i = x; i < myNumRows && y >= 0; i++, y--)
    	{
    		if(myBoard[i][y] == PieceType.BLACK)
    		{
    			counterBlack++;
    			counterRed = 0;
    			if(counterBlack == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterBlack == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    		else if(myBoard[i][y] == PieceType.RED)
    		{
    			counterRed++;
    			counterBlack = 0;
    			if(counterRed == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterRed == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    	}
    	//Checking in the down, right direction from the last point
    	counterBlack = 0;
    	counterRed = 0;
    	x = (int)myLastPoint.getX();
    	y = (int)myLastPoint.getY();
    	for(int i = x; i >= 0 && y < myNumColumns; i--, y++)
    	{
    		if(myBoard[i][y] == PieceType.BLACK)
    		{
    			counterBlack++;
    			counterRed = 0;
    			if(counterBlack == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterBlack == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    		else if(myBoard[i][y] == PieceType.RED)
    		{
    			counterRed++;
    			counterBlack = 0;
    			if(counterRed == myWinLength)
    			{
    				myWinEnd = new Point(i,y);
    				return true;
    			}
    			else if(counterRed == 1)
    			{
    				myWinBegin = new Point(i,y);
    			}
    		}
    	}
    	return false;
    }
	
    /**
     * Checking where the best column to place a piece for the AI is
     * in the horizontal direction to block
     * @param col : The column the piece could be placed in
     * @param type : The piece type of the AI
     * @return The column where the piece should be placed
     */
    private int countHorizontalLengthIfPiecePlacedBlock(int col, PieceType type) 
    {
    	int count = 0; 
		for(int c = 0; c < myNumRows; c++) 
		{
			if(myBoard[c][col] != null) 
			{
				count++;
			}
		}
		if(count >= myNumRows)
		{
			return -1;
		}
		int counterBlack = 0;
		int counterRed = 0;
		for(int i = 0; i < myNumColumns; i++)
		{
			if(myBoard[count][i] == PieceType.BLACK)
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - 1)
				{
					return col;
				}
			}
			else if(myBoard[count][i] == PieceType.RED)
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - 1)
				{
					return col;
				}
			}
		}
    	return -1;
    }
	
    /**
     * Checking where the best column to place a piece for the AI is in 
     * the vertical direction to block
     * @param col : The column the piece could be placed in
     * @param type : The piece type of the AI
     * @return The column where the piece should be placed
     */
    private int countVerticalLengthIfPiecePlacedBlock(int col, PieceType type) 
    {
    	int counterBlack = 0;
    	int counterRed = 0;
		for(int i = 0; i < myNumRows; i++)
		{
			if(myBoard[i][col] == PieceType.BLACK)
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - 1)
				{
					return col;
				}
			}
			if(myBoard[i][col] == PieceType.RED)
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - 1)
				{
					return col;
				}
			}
		}
    	return -1;
    }
	
    /**
     * Checking which column a piece should be placed for the AI in the
     * diagonal direction to block
     * @param col : Column where piece could be placed
     * @param type : The piece type of the AI
     * @return The column where a piece should be placed
     */
    private int countDiagonalLengthIfPiecePlacedBlock(int col, PieceType type) 
    {
    	int count = 0; 
		for(int c = 0; c < myNumRows; c++) 
		{
			if(myBoard[c][col] != null) 
			{
				
				count++;
			}
		}
		if(count >= myNumRows)
		{
			return -1;
		}
		//The up diagonal check
		int diff = Math.min(count, col);
		int counterBlack = 0;
		int counterRed = 0;
		int tempCol = col - diff;
		for(int i = count - diff; i < myNumRows; i++, tempCol++)
		{
			if(tempCol >= myNumColumns) 
			{
				break;
			}			
			if(myBoard[i][tempCol] == PieceType.BLACK) 
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - 1) 
				{
					return col;
				}
			}
			else if(myBoard[i][tempCol] == PieceType.RED) 
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - 1) 
				{
					return col;
				}
			}
		}
		//The down diagonal check
		diff = Math.min(myNumRows - count, col);
		counterBlack = 0;
		counterRed = 0;
		tempCol = col - diff;
		for(int i = count + diff; i >= 0 && i < myNumRows; i--, tempCol++)
		{
			if(tempCol >= myNumColumns) 
			{
				break;
			}			
			if(myBoard[i][tempCol] == PieceType.BLACK) 
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - 1) 
				{
					return col;
				}
			}
			else if(myBoard[i][tempCol] == PieceType.RED) 
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - 1) 
				{
					return col;
				}
			}
		}
	    return -1;
    }
    
    /**
     * Checking where the best column to place a piece for the AI is
     * in the horizontal direction to win
     * @param col : The column the piece could be placed in
     * @param type : The piece type of the AI
     * @return The column where the piece should be placed to win
     */
    private int countHorizontalLengthIfPiecePlacedWin(int col, PieceType type)
    {
    	int count = 0; 
		for(int c = 0; c < myNumRows; c++) 
		{
			if(myBoard[c][col] != null) 
			{
				count++;
			}
		}
		if(count >= myNumRows)
		{
			return -1;
		}
		int counter = 0;
		if(type == PieceType.BLACK)
		{
			for(int i = 0; i < myNumColumns; i++)
			{
				if(myBoard[count][i] == PieceType.BLACK)
				{
					counter++;
					if(counter == myWinLength - 1)
					{
						return col;
					}
				}
				else
				{
					counter = 0;
				}
			}
		}
		else if(type == PieceType.RED)
		{
			for(int i = 0; i < myNumColumns; i++)
			{
				if(myBoard[count][i] == PieceType.RED)
				{
					counter++;
					if(counter == myWinLength - 1)
					{
						return col;
					}
				}
				else
				{
					counter = 0;
				}
			}
		}
    	return -1;
    }
    /**
     * Checking where the best column to place a piece for the AI is
     * in the vertical direction to win
     * @param col : The column the piece could be placed in
     * @param type : The piece type of the AI
     * @return The column where the piece should be placed to win
     */
    private int countVerticalLengthIfPiecePlacedWin(int col, PieceType type)
    {
    	int counter = 0;
    	if(type == PieceType.BLACK)
    	{
    		for(int i = 0; i < myNumRows; i++)
    		{
    			if(myBoard[i][col] == PieceType.BLACK)
    			{
    				counter++;
    				if(counter == myWinLength - 1)
    				{
    					return col;
    				}
    			}
    			else
    			{
    				counter = 0 ;
    			}
    		}
    	}
    	else if(type == PieceType.RED)
    	{
    		for(int i = 0; i < myNumRows; i++)
    		{
    			if(myBoard[i][col] == PieceType.RED)
    			{
    				counter++;
    				if(counter == myWinLength - 1)
    				{
    					return col;
    				}
    			}
    			else
    			{
    				counter = 0 ;
    			}
    		}
    	}
    	
    	return -1;
    }
    
    /**
     * Checking which column a piece should be placed for the AI in the
     * diagonal direction to win
     * @param col : Column where piece could be placed
     * @param type : The piece type of the AI
     * @return The column where a piece should be placed to win
     */
    private int countDiagonalLengthIfPiecePlacedWin(int col, PieceType type)
    {
    	int count = 0; 
		for(int c = 0; c < myNumRows; c++) 
		{
			if(myBoard[c][col] != null) 
			{
				
				count++;
			}
		}
		if(count >= myNumRows)
		{
			return -1;
		}
		int diff = Math.min(count, col);
		int counter = 0;
		int tempCol = col - diff;
		if(type == PieceType.BLACK)
		{
			for(int i = count - diff; i < myNumRows; i++, tempCol++)
			{
				if(tempCol >= myNumColumns) 
				{
					break;
				}			
				if(myBoard[i][tempCol] == PieceType.BLACK) 
				{
					counter++;
					if(counter == myWinLength - 1) 
					{
						return col;
					}
				}
				else
				{
					counter = 0;
				}
			}
		}
		else if(type == PieceType.RED)
		{
			for(int i = count - diff; i < myNumRows; i++, tempCol++)
			{
				if(tempCol >= myNumColumns) 
				{
					break;
				}			
				if(myBoard[i][tempCol] == PieceType.RED) 
				{
					counter++;
					if(counter == myWinLength - 1) 
					{
						return col;
					}
				}
				else
				{
					counter = 0;
				}
			}
		}
		diff = Math.min(myNumRows - count, col);
		counter = 0;
		tempCol = col - diff;
		if(type == PieceType.BLACK)
		{
			for(int i = count + diff; i >= 0 && i < myNumRows; i--, tempCol++)
			{
				if(tempCol >= myNumColumns) 
				{
					break;
				}			
				if(myBoard[i][tempCol] == PieceType.BLACK) 
				{
					counter++;
					if(counter == myWinLength - 1) 
					{
						return col;
					}
				}
				else
				{
					counter = 0;
				}
			}
		}
		else if(type == PieceType.RED)
		{
			for(int i = count + diff; i >= 0 && i < myNumRows; i--, tempCol++)
			{
				if(tempCol >= myNumColumns) 
				{
					break;
				}			
				if(myBoard[i][tempCol] == PieceType.RED) 
				{
					counter++;
					if(counter == myWinLength - 1) 
					{
						return col;
					}
				}
				else
				{
					counter = 0;
				}
			}
		}
    	return -1;
    }
    
    /**
     * Checking where the best column to place a piece for the AI is
     * in the horizontal direction for other than a block or win
     * @param col : The column the piece could be placed in
     * @param type : The piece type of the AI
     * @return The column where the piece should be placed
     */
    private int countHorizontalLengthIfPiecePlacedOther(int col, PieceType type)
    {
    	int count = 0; 
		for(int c = 0; c < myNumRows; c++) 
		{
			if(myBoard[c][col] != null) 
			{
				count++;
			}
		}
		if(count >= myNumRows)
		{
			return -1;
		}
		int counterBlack = 0;
		int counterRed = 0;
		for(int i = 0; i < myNumColumns; i++)
		{
			if(myBoard[count][i] == PieceType.BLACK)
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - col)
				{
					return col;
				}
			}
			else if(myBoard[count][i] == PieceType.RED)
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - col)
				{
					return col;
				}
			}
		}
    	return -1;
    }
    
    /**
     * Checking where the best column to place a piece for the AI is
     * in the vertical direction for other than a block or win
     * @param col : The column the piece could be placed in
     * @param type : The piece type of the AI
     * @return The column where the piece should be placed
     */
    private int countVerticalLengthIfPiecePlacedOther(int col, PieceType type)
    {
    	int counterBlack = 0;
    	int counterRed = 0;
		for(int i = 0; i < myNumRows; i++)
		{
			if(myBoard[i][col] == PieceType.BLACK)
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - col)
				{
					return col;
				}
			}
			if(myBoard[i][col] == PieceType.RED)
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - col)
				{
					return col;
				}
			}
		}
    	return -1;
    }
    
    /**
     * Checking where the best column to place a piece for the AI is
     * in the diagonal direction for other than a block or win
     * @param col : The column the piece could be placed in
     * @param type : The piece type of the AI
     * @return The column where the piece should be placed
     */
    private int countDiagonalLengthIfPiecePlacedOther(int col, PieceType type)
    {
    	int count = 0; 
		for(int c = 0; c < myNumRows; c++) 
		{
			if(myBoard[c][col] != null) 
			{
				
				count++;
			}
		}
		if(count >= myNumRows)
		{
			return -1;
		}
		//The up diagonal check
		int diff = Math.min(count, col);
		int counterBlack = 0;
		int counterRed = 0;
		int tempCol = col - diff;
		for(int i = count - diff; i < myNumRows; i++, tempCol++)
		{
			if(tempCol >= myNumColumns) 
			{
				break;
			}			
			if(myBoard[i][tempCol] == PieceType.BLACK) 
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - col) 
				{
					return col;
				}
			}
			else if(myBoard[i][tempCol] == PieceType.RED) 
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - col) 
				{
					return col;
				}
			}
		}
		//The down diagonal check
		diff = Math.min(myNumRows - count, col);
		counterBlack = 0;
		counterRed = 0;
		tempCol = col - diff;
		for(int i = count + diff; i >= 0 && i < myNumRows; i--, tempCol++)
		{
			if(tempCol >= myNumColumns) 
			{
				break;
			}			
			if(myBoard[i][tempCol] == PieceType.BLACK) 
			{
				counterBlack++;
				counterRed = 0;
				if(counterBlack == myWinLength - col) 
				{
					return col;
				}
			}
			else if(myBoard[i][tempCol] == PieceType.RED) 
			{
				counterRed++;
				counterBlack = 0;
				if(counterRed == myWinLength - col) 
				{
					return col;
				}
			}
		}
    	return -1;
    }
	
    /**
     * Getting the vector of the piece types being used in the game
     * @return The vector of piece types
     */
    public Vector<PieceType> getTypes() 
    {
	    return myTypes;
    }
	
    /**
     * Getting the beginning position of the win
     * @return The beginning position of the win
     */
    public Point getWinBegin() 
    {
	    return myWinBegin;
    }
	
    /**
     * Getting the end position of the win
     * @return The end position of the win
     */
    public Point getWinEnd()
    {
		return myWinEnd;
    }
	
    /**
     * Getting the position of the last piece placed
     * @return The position of the last piece placed
     */
    public Point getLastPoint() 
    {
	    return myLastPoint;
    }
	
    /**
     * Getting the piece type in a specific spot on the board
     * @param point : Point on the board to return the piece type
     * @return The piece type in that point
     */
    public PieceType getPieceOnBoard(Point point) 
    {
    	return myBoard[(int)point.getX()][(int)point.getY()];
    }
	
    /**
     * Getting the size of the board
     * @return Size of the board
     */
    public PieceType[][] getBoard() 
    {
	    return myBoard;
    }
	
    /**
     * Checking if the board is completely full
     * @return True if it is, false otherwise
     */
    public boolean isBoardFull() 
    {
    	for(int i = 0; i < myNumColumns; i++)
		{
			if(isColumnFull(i) && i == myNumColumns-1)
			{
				return true;
			}
		}
		return false;
    }
	/**
	 * Checking if the column is full
	 * @param col : Column needed to check if full
	 * @return True if it is, false otherwise
	 */
    public boolean isColumnFull(int col) 
    {
    	for(int i = 0; i < myNumRows; i++)
		{
			if(myBoard[i][col] == null)
			{
				return false;
			}
		}
    	return true;
    }
	
    /**
     * Checking to see if there is a win
     * @return True if there is, false otherwise
     */
    public boolean getIsAWin() 
    {
    	if(checkIfWin())
		{
    		myIsAWin = true;
		}
		return myIsAWin;
    }
    
    /**
     * Checking to see if the board is empty
     * @return True if it is, false otherwise
     */
    public boolean checkAllNull()
    {
    	for(int i = 0; i < myNumColumns; i++)
		{
    		for(int j = 0; j < myNumRows; j++)
    		{
    			if(myBoard[j][i] == null && i >= myNumColumns - 1 && j >= myNumRows - 1)
    			{
    				return true;
    			}
    			else if(myBoard[j][i] != null)
    			{
    				return false;
    			}
    		}
		}
    	return false;
    }
}