package calculator;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Calculator
{
	public static void main(String args[])
	{
		Dimension calcSize = new Dimension(340, 500); // Dimension of the main calculator Frame
		CalculatorSplashScreen splash = new CalculatorSplashScreen(); // Declaration of reference objects needed to launch and manipulate the panels/frames
		splash.showSplash(); // launches the splash screen
	EventQueue.invokeLater(new Runnable() 
	{
		public void run() 
		{

			//Show the Calculator
			JFrame calcFrame = new JFrame("Calculator - Aria Gomes"); // Creates the main calculator frame with a custom title
			calcFrame.setMinimumSize(calcSize); // sets the dimension for the frame
			calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gives the frame operation to execute on close
			calcFrame.setLocationByPlatform(true); // sets the location of the frame by the platform launched on
			calcFrame.setLocationRelativeTo(null); // centers the frame on the screen
			CalculatorViewController cvc = new CalculatorViewController();
			calcFrame.setContentPane(cvc);
			calcFrame.setVisible(true); // Finally shows the frame once everything has been executed
			
		}
	});
}
}