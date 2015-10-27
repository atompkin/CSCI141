/**
 * 
 * @author Andrew Tompkins, Jason Imeidopf
 * Project 2
 * 10/22/15
 * CSCI142
 * 
 * Sets up GUI and Listeners for the Controller
 */
package controllerandview;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame
{
	private static final long serialVersionUID = 1L;
	/**
	 * Attributes
	 */
	private ButtonListener[] myColumnListener;
	private ButtonListener myResetListener;;
	private JLabel myPlayerScore = new JLabel();
    private JLabel myAiScore = new JLabel();
    private JLabel myTiesScore = new JLabel();
    private JLabel myPlayerLastMove = new JLabel();
    private JLabel myAiLastMove = new JLabel();
    private JLabel myPlayerTurnNotif = new JLabel();
    public JButton[][] myButtons;
    private JButton myResetButton = new JButton("Reset");
    private Controller myController;
    
    /**
     * View, sets up the GUI using JPanels,
     * buttons for the board, and JLabels
     * for the names, ties/wins, and where the pieces
     * are placed.
     *
     * @param controller
     */
    public View(Controller controller)
    {
    	myController = controller;
    	myButtons = new JButton[myController.getNumRows()][myController.getNumColumns()];
    	setSize(1000, 700);
    	setTitle("Connect4 Game");
    	setBackground(Color.WHITE);

    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.associateListeners();
    	
    	JPanel myPanel1 = new JPanel();
    	myPanel1.setBounds(100, 60, 800, 500);
    	JPanel myPanel2 = new JPanel();
    	myPanel2.setBounds(0, 0, 100, 100);
    	
    	
        myPanel1.setLayout(new GridLayout(myController.getNumRows(),myController.getNumColumns()));
        myPanel2.setLayout(null);
      
        myPlayerScore.setText(myController.getPlayerName() + ": " + myController.getPlayerScore() + " pts");        
        myPlayerLastMove.setText("Player Last Move: ");        
        myAiScore.setText(myController.getComputerPlayerName() + ": " + myController.getCompPlayerScore() + " pts");        
        myAiLastMove.setText("AI Last Move: ");       
        myPlayerTurnNotif.setText("Your Turn!");      
        myTiesScore.setText("Tied Games: "+ myController.getTies());
        
        myPanel2.add(myPlayerScore);
        myPanel2.add(myPlayerLastMove);
        myPanel2.add(myAiScore);
        myPanel2.add(myTiesScore);
        myPanel2.add(myAiLastMove);
        myPanel2.add(myPlayerTurnNotif);        
        myPanel2.add(myResetButton);

        myPlayerScore.setBounds(300, 0, 300, 50);
        myPlayerLastMove.setBounds(300, 25, 150, 20);
        myTiesScore.setBounds(450, 0, 100, 50);
        myAiScore.setBounds(600, 0, 150, 50);
        myAiLastMove.setBounds(600,30,300,20);
        myResetButton.setBounds(450, 600, 100, 50);
        myResetButton.addMouseListener(myResetListener);
        myPlayerTurnNotif.setBounds(300, 35, 300, 20);
    
        for(int i =myController.getNumRows()-1; i >=0; i--)
        {
        	for(int j =0; j<myController.getNumColumns(); j++)
        	{
        		myButtons[i][j]=new JButton();
        		myButtons[i][j].setBackground(Color.WHITE);
        		myButtons[i][j].setOpaque(true);
        		myButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        		myButtons[i][j].addMouseListener(myColumnListener[j]);
        		myPanel1.add(myButtons[i][j]);
        	}
        }             
        this.add(myPanel1);
        this.add(myPanel2);
        
        myResetButton.setEnabled(false);
        
    }      
    /**
     * 
     * @param listener
     */
    void addButtonListener(ActionListener listener)
    {
    	for(int i =0; i <myController.getNumRows(); i++)
        {
    		for(int j = 0; j < myController.getNumColumns(); j++ )
    		{
    			myButtons[i][j].addActionListener(listener);
    		}
        }
    }
    /**
     * Associate Listeners for the placePiece buttons
     * and the Play Again button.
     */
   public void associateListeners()
    {
        String error;
        Class<? extends Controller> controllerClass;
        Method placePieceColumnMethod,
        		resetGameMethod;
        
        Class<?>[] classArgs;
        Integer[] args;        
        controllerClass = myController.getClass();       
        error = null;
        placePieceColumnMethod = null;
        resetGameMethod=null;       
        classArgs = new Class[1];
        args = new Integer[1];       
        try
        {
           classArgs[0] = Class.forName("java.lang.Integer");
        }
        catch(ClassNotFoundException exception)
        {
           error = exception.toString();
           System.out.println(error);
        }
        try
        {
           placePieceColumnMethod = controllerClass.getMethod("piecePlacer", classArgs);
           resetGameMethod = controllerClass.getMethod("resetGame", null);
        }
        catch(NoSuchMethodException exception)
        {
           error = exception.toString();
        }
        catch(SecurityException exception)
        {
           error = exception.toString();
        }        
        myColumnListener= new ButtonListener[myController.getNumColumns()];
        myResetListener= new ButtonListener(myController, resetGameMethod, null);
        for(int i =0; i < myController.getNumColumns(); i++)
        {
        	args = new Integer[1];
        	args[0] = new Integer(i);
        	myColumnListener[i]= new ButtonListener(myController, placePieceColumnMethod, args);        	        
        }       
    }
    
    public void setImage(int row, int col, String str)
    {
    	myButtons[row][col].setIcon(new ImageIcon(str));   
    	validate();   	   	
    }
    /**
     * Pulls the coordinates from the win begin and end,
     * then highlights the background button to show the win.
     */
    public void higlightWin()
    {
    	int myX = (int)myController.getBeginPoint().getX(); 
    	int myY = (int)myController.getBeginPoint().getY();
    	int myX1 = (int)myController.getEndPoint().getX();
    	int myY1 = (int)myController.getEndPoint().getY();
    	boolean myVertWin = false;
    	boolean myHorizWin = false;
    	boolean myDiagLeftUpperWin = false;
    	boolean myDiagRightUpperWin = false;
    	
    	if(myX == myX1)
    	{
    		myVertWin = true;
    	}
    	if(myY == myY1)
    	{
    		myHorizWin = true;
    	}
    	
    	if(myX<myX1 && myY<myY1 || myX1<myX && myY1<myY)
    	{
    		myDiagLeftUpperWin = true;
    		if(myX > myX1)
	    	{
	    		int tempx;
	    		tempx=myX;
	    		myX=myX1;
	    		myX1=tempx;
	    	}
	    	if(myY > myY1)
	    	{
	    		int tempy;
	    		tempy=myY;
	    		myY=myY1;
	    		myY1=tempy;
	    		
	    	}
    	}
    	if(myX < myX1 && myY > myY1 || myX1 < myX&& myY1 > myY)
    	{
    		myDiagRightUpperWin =true;
    		if(myX < myX1)
    		{
    			int tempx;
    			int tempy;
    			
    			tempx = myX1;
    			myX1 = myX;
    			myX = tempx;
    			
    			tempy = myY1;
    			myY1 = myY;
    			myY = tempy;
    			
    		}
    		
    	}
    	
    	if(!myDiagLeftUpperWin || !myDiagRightUpperWin) {
	    	if(myX > myX1)
	    	{
	    		int tempx;
	    		tempx=myX;
	    		myX=myX1;
	    		myX1=tempx;
	    	}
	    	if(myY > myY1)
	    	{
	    		int tempy;
	    		tempy=myY;
	    		myY=myY1;
	    		myY1=tempy;
	    		
	    	}
    	}
    	
    	for(int c = 0; c < 4; c++)
    	{
    		if(myHorizWin ==true)
    		{
    			myButtons[myX+c][myY].setBackground(Color.GREEN);
    		}
    		if(myVertWin ==true)
    		{
    			myButtons[myX][myY+c].setBackground(Color.GREEN);
    		}
    		if(myDiagLeftUpperWin ==true)
    		{
    			myButtons[myX+c][myY+c].setBackground(Color.GREEN);
    		}
    		if(myDiagRightUpperWin ==true)
    		{
    			myButtons[(myX+c)][(myY-c)+3].setBackground(Color.GREEN);
    		}
    	}
    }
    
    /**
     * Updates Names and Scores
     */
    public void updateScore()
    {
    	myResetButton.setEnabled(true);
    	myPlayerScore.setText(myController.getPlayerName() + ": " + myController.getPlayerScore()); 
        myAiScore.setText(myController.getComputerPlayerName() + ": "+myController.getCompPlayerScore());
        myTiesScore.setText("Tied Games: "+ myController.getTies());
    }
    
    public void resetLabel()
    {
    	myPlayerLastMove.setText("Player Last Move: ");
    	myAiLastMove.setText(myController.getComputerPlayerName()+" player placed a piece in column: ");
    }
    
    public void updateColumnPlayer()
    {
    	myPlayerLastMove.setText("Player Last Move: " + ((int)myController.getLastPoint().getY()+1));
    }
    
    public void updateColumnAi()
    {
    	myAiLastMove.setText("Ai Last Move: " + ((int)myController.getLastPoint().getY()+1));
    }
    
    public JButton getResetButton()
    {
    	return myResetButton;
    }
}
