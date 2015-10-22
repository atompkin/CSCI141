package connectmodeltests;
/**
 * Test Cases for Player Class
 */
import static org.junit.Assert.*;

import org.junit.Test;

import connectmodel.PieceType;
import connectmodel.Player;

public class TestPlayer 
{
	/*
	 * These methods check if the name entered meets criteria
	 * If not, sets to null and becomes JohnCena
	 */
	
	/*
	 * Test valid names
	 */
	@Test
	public void testValidNameUpperAndLowerCase() 
	{
		
		Player player = new Player("Bob",PieceType.YELLOW );
		assertTrue(player.getName() == "Bob");
	}
	
	@Test
	public void testValidNameAllUpperCase() 
	{
		
		Player player = new Player("BOB",PieceType.YELLOW );
		assertTrue(player.getName() == "BOB");
	}
	
	@Test
	public void testValidNameAllLowerCase() 
	{
		
		Player player = new Player("bob",PieceType.YELLOW );
		assertTrue(player.getName() == "bob");
	}
	
	@Test
	public void testLowerAndNumberName()
	{
		PieceType[] types = new PieceType[2];
		Player p = new Player("amplissimus2496", types[0]);
		assertTrue(p.getName()== "amplissimus2496");
	}
	
	@Test
	public void testUpperAndNumberName()
	{
		PieceType[] types = new PieceType[2];
		Player p = new Player("AMP2496", types[0]);
		assertTrue(p.getName()== "AMP2496");
	}
	
	@Test
	public void testNumberName()
	{
		PieceType[] types = new PieceType[2];
		Player p = new Player("2496", types[0]);
		assertTrue(p.getName()== "2496");
	}
	
	/*
	 * Test invalid names
	 */
	
	@Test
	public void testInvalidSymbolName()
	{
		PieceType[] types = new PieceType[2];
		Player p = new Player("@#$", types[0]);
		assertTrue(p.getName()== "JohnCena");
	}
	
	@Test
	public void testInvalidSpaceInName()
	{
		PieceType[] types = new PieceType[2];
		Player p = new Player("amp 2496", types[0]);
		assertTrue(p.getName()== "JohnCena");
	}
	
	@Test
	public void testNoName()
	{
		PieceType[] types = new PieceType[2];
		Player p = new Player("" , types[0]);
		assertTrue(p.getName()== "JohnCena");
	}

	/*
	 * Test scores
	 */
	@Test
	public void testInitialScore()
	{
		Player player = new Player("Joe",PieceType.YELLOW );
		assertTrue(player.getScore()==0);	
	}

	@Test
	public void testIncrementScore()
	{
		Player player = new Player("Joe",PieceType.YELLOW );
		player.incrementScore();
		assertTrue(player.getScore()==1);	
	}
	
	@Test
	public void testIncrementScoreTwice() 
	{
		
		Player player = new Player("Joe",PieceType.YELLOW );
		player.incrementScore();
		player.incrementScore();
		assertTrue(player.getScore()==2);
	}
}
