package controllerandview;

import javax.swing.*;


import connectmodel.PieceType;

import java.awt.*;
import java.lang.reflect.Method;

/**
 * 
 * @author Andrew Tompkins
 *
 */
public class View extends JFrame
{
	private int rows = 6;
	private int cols = 7;
    private Panel myNames;
    private Panel myBottom;
	private JLabel myName1 = new JLabel("Player1: ");
	private JLabel myTies = new JLabel("Ties: ");
	private JLabel myName2 = new JLabel("Player2: ");
	private JLabel myLabel = new JLabel("Test");
	private JButton myReset = new JButton("Reset");
	private ImageIcon my1Image;
	private ImageIcon my2Image;
	private ImageIcon myBlankImage;
	private JPanel mySquarePanel;
	private JLabel[][] mySquare;
	private ButtonListener mySquareListener[][];
	
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
				mySquarePanel.add(mySquare[i][j]);
			}
		}
		
		
		getContentPane().add(myNames);
		getContentPane().add(mySquarePanel);
		getContentPane().add(myBottom);
		
		this.setVisible(true);
	}

	private void associateListeners(Controller controller) 
	{
		Class<? extends Controller> controllerClass;
        Method tester;
        Class<?>[] classArgs;

        controllerClass = controller.getClass();
        
        tester = null;
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
	}
	
	public void setPlayer1Name(String n, int score)
	{
		myName1.setText(n+ ": " + score);
	}
	
	public void setPlayer2Name(String n,int score)
	{
		myName2.setText(n+ ": " + score);
	}
	
	public void setTie(int ties)
	{
		myTies.setText("Ties: "+ ties);
	}
	
	public void setMessage(String line1,String line2,String line3)
	{
		myLabel.setText(line1+ "\n"+line2+"\n"+line3);
	}
	
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

