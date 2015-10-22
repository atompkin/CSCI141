package controllerandview;

/**
 * 
 * 
 * @author Andrew Tompkins
 *
 */

public class Controller 
{

    public View myView;
	
	public Controller()
    {
        myView = new View(this);
        String firstName;
    	//firstName = JOptionPane.showInputDialog("First Name");
    }
    
	public void tester(Integer col)
	{
		myView.setMessage("Column "+col+ " has been clicked","","");
		System.out.println("Column "+col+ " has been clicked");
	}
}
