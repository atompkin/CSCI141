package connectmodel;

/**The View Class creates the board and arranges everything.
 * 
 * 
 * @author Andrew Tompkins
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import connectmodel.ButtonListener;
import connectmodel.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;

public class View extends JFrame 
{
	private JPanel myView = new JPanel();
	private JPanel myNameGet = new JPanel();
	//private Button myButtons[] = new Button[42];
    private ButtonListener[][] mySquareListener;
    private Controller myController;
    private JButton[][] mySquare;
    private Panel mySquaresPanel;
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
	private JTextField myOutput = new JTextField(10);
	
	
	public View(Controller controller)
	{
		this.setSize(600,600);
		this.setResizable(false);
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBackground(Color.gray);
		this.setLocationRelativeTo(null);
		
		
		File imageCheck = new File("src/Images/px.jpg");
		
		
//		try{
//			Image img = ImageIO.read(getClass().getResource("Images/pX.jpg"));
		 my1Image = new ImageIcon("src/Images/pX.jpg");
		 my2Image = new ImageIcon("src/Images/pO.jpg");
	     myBlankImage = new ImageIcon("src/Images/blank.jpg");
//		}
		
		myNames = new Panel(new GridLayout());
		 myNames.add(myName1);
		 myNames.add(myTies);
		 myNames.add(myName2);
	     
		 myBottom = new Panel();
		 myBottom.add(myReset);
		 myBottom.add(myLabel);
	     mySquareListener = new ButtonListener[6][7];
	     mySquare = new JButton[6][7];
	     mySquaresPanel = new Panel(new GridLayout(6,7));
	     mySquaresPanel.setMinimumSize(new Dimension(300, 300));
	     mySquaresPanel.setLocation(0,0);
		
		
	     for(int i=0; i < 6; i++)
	        {
	    	 for(int j=0; j < 7;j++)
	    	 {
	    		 mySquare[i][j] = new JButton(myBlankImage);
	    		 mySquare[i][j].setIcon(myBlankImage);
	    		 mySquare[i][j].setPreferredSize(new Dimension(50, 50));
	    		 mySquare[i][j].setBackground(Color.DARK_GRAY);
	    		 //System.out.println(mySquare[i][j].getBackground().toString());
		         mySquaresPanel.add(mySquare[i][j]);
	    	 }
	        } 
		 
	     getContentPane().add(myNames);
	     getContentPane().add(mySquaresPanel);
	     getContentPane().add(myBottom);
		setVisible(true);
	}
	
	public void setPlayer1Name(String n)
	{
		myName1 = new JLabel(n+ ": ");
	}
	
	public void setPlayer2Name(String n)
	{
		myName2 = new JLabel(n+":");
	}
	
	public void addViewListener(ActionListener listenForInput)
	{
		{
	        Class<? extends Controller> controllerClass;
	        Class<?>[] classArgs;

	        controllerClass = myController.getClass();
	        
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
	        
	        
//	        try
//	        {
//	           //incrementMethod = controllerClass.getMethod("increment",classArgs);      
//	        }
//	       // catch(NoSuchMethodException exception)
//	        {
//	           String error;
//
//	           error = exception.toString();
//	           System.out.println(error);
//	        }
	        catch(SecurityException exception)
	        {
	           String error;

	           error = exception.toString();
	           System.out.println(error);
	        }
	        
	        int i;
	        Integer[] args;

	        for (i=0; i < 7; i++)
	        {
	           args = new Integer[1];
	           args[0] = new Integer(i);
	           //mySquare[i].addMouseListener(mySquareListener[i]);

	        }
	    }
	}
	
    public void changeImage(int col, int row, int type)
    {
        if(type == 0)
        {
        	mySquare[col][row].setIcon(myBlankImage);
        }
        else if(type == 1)
        {
        	mySquare[col][row].setIcon(my1Image);
        }
        else if(type == 2)
        {
        	mySquare[col][row].setIcon(my2Image);
        }  
    }
}
