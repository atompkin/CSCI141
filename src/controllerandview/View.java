package controllerandview;

import javax.swing.*;


import connectmodel.PieceType;

import java.awt.*;
import java.lang.reflect.Method;

/** 
 * View is the Gui. The Gui Includes Player 1 and 2 wins as well as the total number of ties. 
 * Board is contructed of a 2D array of JLabels.
 * The bottom of the board has a Reset button which is only active if the game has ended aswell
 * as a text box to display feed back to the user.
 * 
 * 
 * @author Andrew Tompkins
 * @Due 10/22/15
 * @version 1.0.3
 */
public class View extends JFrame
{
	private int rows = 6;
	private int cols = 7;
    private Panel myNames;
    private Panel myBottom;
	private JLabel myName1 = new JLabel("Player1: 0");
	private JLabel myTies = new JLabel("Ties: 0");
	private JLabel myName2 = new JLabel("Player2: 0");
	private JLabel myLabel = new JLabel("The Game has started");
	private JButton myReset = new JButton("Reset");
	private ImageIcon my1Image;
	private ImageIcon my2Image;
	private ImageIcon myBlankImage;
	private JPanel mySquarePanel;
	private JLabel[][] mySquare;
	private ButtonListener mySquareListener[][];
	private ButtonListener myResetListener;
	
	/** Constructor For the view creates all the panels and buttons
	 * 
	 * @param controller
	 */
	public View(Controller controller)
	{
		this.setSize(600,600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.associateListeners(controller);
		getContentPane().setBackground(Color.white);
		
		my1Image = new ImageIcon("src/Images/pX.jpg");
		my2Image = new ImageIcon("src/Images/pO.jpg");
	    myBlankImage = new ImageIcon("src/Images/blank.jpg");
		
		myNames = new Panel(new GridLayout(0,3));
		myNames.setSize(600,100);
		myNames.setLocation(new Point(0,0));
		myNames.add(myName1);
		myNames.add(myTies);
		myNames.add(myName2);
	     
		myBottom = new Panel();
		myBottom.setSize(500,100);
		myBottom.setLocation(new Point(0,500));
		myReset.setSize(100,100);
		myReset.addMouseListener(myResetListener);
		myBottom.add(myReset);
		myBottom.add(myLabel);
		
		mySquarePanel = new JPanel(new GridLayout(6,7));
	    mySquarePanel.setSize(300,300);
	    mySquarePanel.setLocation(100,100);
		
		mySquare = new JLabel[rows][cols];
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				mySquare[i][j] = new JLabel();
				mySquare[i][j].addMouseListener(mySquareListener[i][j]);
				mySquare[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				mySquare[i][j].setIcon(myBlankImage);
				mySquarePanel.add(mySquare[i][j]);
			}
		}
		
		
		getContentPane().add(myNames);
		getContentPane().add(mySquarePanel);
		getContentPane().add(myBottom);
		
		this.setVisible(true);
	}
	/**
	 *  Associated listener Listens for mouse input and sends the selected 
	 *  column to the controllers method tester. 
	 * 
	 * @param controller
	 */

	private void associateListeners(Controller controller) 
	{
		Class<? extends Controller> controllerClass;
        Method tester, reset;
        Class<?>[] classArgs;

        controllerClass = controller.getClass();
        
        tester = null;
        reset = null;
        classArgs = new Class[1];
        
        try
        {
           classArgs[0] = Class.forName("java.lang.Integer");
        }
        catch(ClassNotFoundException e)
        {
           String error;
           error = e.toString();
           System.out.println(error);
        }
        
        
        try
        {
           reset= controllerClass.getMethod("reset",(Class<?>[])null);   
           tester = controllerClass.getMethod("tester",classArgs);      
        }
        catch(NoSuchMethodException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }
        catch(SecurityException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }
        
        int i,j;
        Integer[] args;
        mySquareListener = new ButtonListener[rows][cols];

        for (i=0; i < rows; i++)
        {
        	for(j=0;j<cols;j++)
        	{
        		args = new Integer[1];
                args[0] = new Integer(j);
                mySquareListener[i][j] = new ButtonListener(controller, tester, args);
        	}
        }
        myResetListener = new ButtonListener(controller, reset);
	}
	
	/**
	 *  sets the name of the 1st player and the players number of wins at the top of screen
	 * 
	 * @param n
	 * @param score
	 */
	
	public void setPlayer1Name(String n, int score)
	{
		myName1.setText(n+ ": " + score);
	}
	/**
	 * sets the name of the 2nd player and the players number of wins at the top of screen
	 * 
	 * @param n
	 * @param score
	 */
	
	public void setPlayer2Name(String n,int score)
	{
		myName2.setText(n+ ": " + score);
	}
	
	/**
	 * updates the number of ties
	 * 
	 * @param ties
	 */
	
	public void setTie(int ties)
	{
		myTies.setText("Ties: "+ ties);
	}
	/**
	 * Set Message puts up to 3 strings in the JLabel at the bottom right
	 *  each line corresponds to the correct line
	 * 
	 * @param line1
	 * @param line2
	 * @param line3
	 */
	
	public void setMessage(String line)
	{
		myLabel.setText(line);
	}
	
	/** 
	 * changes the image to the corresponding image
	 * 
	 * @param col
	 * @param row
	 * @param type
	 */
	public void changeImage(int col, int row, PieceType type)
    {
        if(type == null)
        {
        	mySquare[col][row].setIcon(myBlankImage);
        }
        else if(type == PieceType.RED)
        {
        	mySquare[col][row].setIcon(my1Image);
        }
        else if(type == PieceType.BLACK)
        {
        	mySquare[col][row].setIcon(my2Image);
        }  
    }
}

