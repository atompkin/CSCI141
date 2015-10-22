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

import connectmodel.ButtonListener;
import connectmodel.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;

public class View extends JFrame {
	private JPanel myView = new JPanel();
	private JPanel myNameGet = new JPanel();
	// private Button myButtons[] = new Button[42];
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
	private ImageIcon myXImage;
	private ImageIcon myBlankImage;
	private JTextField myOutput = new JTextField(10);

	public View(Controller controller) {
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBackground(Color.gray);
		this.setLocationRelativeTo(null);

		File imageCheck = new File("src/Images/pX.jpg");

		// try{
		// Image img = ImageIO.read(getClass().getResource("Images/pX.jpg"));
		myXImage = new ImageIcon("src/Images/pX.jpg");
		myBlankImage = new ImageIcon("src/Images/blank.jpg");
		// }

		myNames = new Panel(new GridLayout());
		myNames.add(myName1);
		myNames.add(myTies);
		myNames.add(myName2);

		myBottom = new Panel();
		myBottom.add(myReset);
		myBottom.add(myLabel);
		mySquareListener = new ButtonListener[6][7];
		mySquare = new JButton[6][7];
		mySquaresPanel = new Panel(new GridLayout(6, 7));
		mySquaresPanel.setMinimumSize(new Dimension(300, 300));
		mySquaresPanel.setLocation(0, 0);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				mySquare[i][j] = new JButton(myBlankImage);
				mySquare[i][j].setIcon(myBlankImage);
				mySquare[i][j].setPreferredSize(new Dimension(50, 50));
				mySquare[i][j].setBackground(Color.DARK_GRAY);
				// System.out.println(mySquare[i][j].getBackground().toString());
				mySquaresPanel.add(mySquare[i][j]);
			}
		}

		getContentPane().add(myNames);
		getContentPane().add(mySquaresPanel);
		getContentPane().add(myBottom);
		setVisible(true);
	}

	public String setNames(String n) {
		return n;
	}

	public void addViewListener(ActionListener listenForInput) {

	}
}
