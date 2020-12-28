package calculator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class CalculatorSplashScreen extends JWindow
{
	private static final long serialVersionUID = 1L;
	private int duration = 5000; // Duration in milliseconds
	
	public void showSplash()
	{
		//used for the progress bar
				long referenceTime = System.currentTimeMillis();
				long newTime;
				
				//Create our content pane
				JPanel content = new JPanel(new BorderLayout()); //The content pane that will contain the splash screen
				content.setBackground(Color.BLACK);
				
				int width =  250 + 10;
			    int height = 300 + 10;
			    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			    int x = (screen.width-width)/2;
			    int y = (screen.height-height)/2;
				setBounds(x, y, width, height);
				
				//Set the image and text
				JLabel image = new JLabel(new ImageIcon("src/calculator/SplashScreen.png"));
				JLabel author = new JLabel("Aria Gomes (040878659)");
				author.setHorizontalAlignment(JLabel.CENTER);
				author.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
				author.setForeground(new Color(255, 255, 255));
				
				//Make a progress bar to show how things are coming along
				JProgressBar progress = new JProgressBar(0, duration);
				progress.setString("Loading Calculator. Please wait...");
				progress.setStringPainted(true);
				progress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				progress.setForeground(Color.RED);
				
				//Make a nice little border and add the items to the panel
				content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				content.add(progress, BorderLayout.NORTH);
				content.add(image, BorderLayout.CENTER);
				content.add(author, BorderLayout.SOUTH);
				
				//Show the splash screen
				add(content);
				setVisible(true);
				
				//This replaces Thread.sleep and waits a "duration" amount of time accurately
				while ( (newTime = System.currentTimeMillis() - referenceTime) < duration){
					progress.setValue((int)newTime);
				}
				
				setVisible(false);
				dispose();
			}
	}