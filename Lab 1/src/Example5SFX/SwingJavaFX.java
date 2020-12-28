package Example5SFX;

/* CST8221-JAP: LAB 01, Example 5SFX
   File name: SwingJavaFX.java
*/
import javafx.application.Application;

// JavaFX imports
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.embed.swing.SwingNode;
import javafx.scene.layout.StackPane; 

//Swing imports
//import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This class create a JavaFX application with embedded Swing GUI.
 * This example illustrates how to embed a Swing content into a JavaFX application. 
 * It uses a specialized class SwingNode introduced in JavaFX 8.
 * The content to be displayed is specified with the setContent(javax.swing.JComponent) 
 * method that accepts an instance of Swing JComponent. The hierarchy of components
 * contained in the JComponent instance should not contain
 * any heavyweight components, otherwise SwingNode may fail to paint it. 
 * The content gets repainted automatically. 
 * All the input and focus events are forwarded to the JComponent instance transparently 
 * to the developer.
 * It is also possible to embed JavaFX in Swing using javafx.embed.swing.JFXPanel
 * see link: https://docs.oracle.com/javase/8/javafx/interoperability-tutorial/swing-fx-interoperability.htm
 
 * @author Svillen Ranev
 * @version 1.19.1
 * @since JavaFX 8
 */
public class SwingJavaFX extends Application {

         @Override
         public void start(Stage stage) {
             final SwingNode swingNode = new SwingNode();
             createAndSetSwingContent(swingNode);

             StackPane pane = new StackPane();
             pane.getChildren().add(swingNode);
             stage.setTitle("Swing and JavaFX GUI - E5");
             stage.setScene(new Scene(pane, 500, 200));
             stage.show();
         }

         /**
          * This method creates a Swing GUI and embeds it in a JavaFX SwingNode component.
          * @param swingNode the JavaFX node embedding the Swing GUI 
          */
         private void createAndSetSwingContent(final SwingNode swingNode) {
             SwingUtilities.invokeLater(new Runnable() {
                 @Override
                 public void run() {
                     JPanel p = new SwingGUI();
                     //embed the Swing GUI into JavaFX
                     swingNode.setContent(p);
                 }
             });
         }
 
         /**
          * The JavaFX application main method.
          * @param args - not used.
          */
         public static void main(String[] args) {
             launch(args);
         }
 
    /**
     * This class is used to create a Swing GUI.
     * It is the same class used in Lab 1 Example 3.
     */
    private class SwingGUI extends JPanel {
    //default serial version ID - Swing components implement the Serializable interface 
    private static final long serialVersionUID = 1L;
    private final JButton button_01;
    private final JPanel pane;
    private final JLabel label_01;
    private final JLabel label_02;  
    private int clickCounter;
    private final UIManager.LookAndFeelInfo []installedLF;
    private int lfCounter;
    private final int  lfMaxNumber;
    
    // private final static String FRAME_TITLE = "Simple Swing GUI - E3";
    private final String LABEL_TEXT = "Number of happy button clicks: ";
/**
  Default constructor. Sets the GUI.
*/    
   public SwingGUI(){
          //get available Look and Feels 
	  installedLF = UIManager.getInstalledLookAndFeels();
	  lfMaxNumber = installedLF.length-1;
	  // Create and set up containers and components.
	  button_01 = createButton("A Happy New Semester Swing Button");
          label_01 = new JLabel("Current Look and Feel: "+installedLF[0].getName());
          label_02 = new JLabel(LABEL_TEXT + "0");
	  pane = new JPanel();
	  
         // set a border around the JPanel
	  pane.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));
	  // change the default Layout Manager
	  // use GridLayout with 3 rows and 1 column
	  pane.setLayout(new GridLayout(3, 1));
          // Add components to JPanel container.
	  pane.add(label_01);
	  pane.add(button_01);
	  pane.add(label_02);
	  // Install JPanel as the content pane
          add(pane);   
	}
/**
   Creates a button and registers (adds) an ActionListener to process the events generated by the button.
   @param buttonName the button label.
   @return returns a created button.
*/   
   private JButton createButton(String buttonName){
     // Create a button 
	JButton  button = new JButton(buttonName);
     // Change the font size of the default font
        button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));//resize the font to size 20
     // Set a specific font
     //  button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
     //set the initial size of the component
     //in most cases it is better to leave to the UI Manager to determine the preferred size
        button.setPreferredSize(new Dimension(button.getText().length()*15,40));
   // Create a keyboard shortcut: Pressing ALT-B will act as a mouse click on the button	
	button.setMnemonic('B');
	// Create a Tool Tip. Will show up when the mouse hovers over the button
	button.setToolTipText("Please Click Me");
   
   // Handle the button clicks. Anonymous class is used to handle the events.
   // No need to check for the event source anymore.
   // Now each individual button will be responsible to handle its own events.
   button.addActionListener (new ActionListener(){
   @Override public void actionPerformed(ActionEvent ae) {
	   //button action: increase the number of clicks
	   ++clickCounter;
	   label_01.setText("Current Look and Feel: "+installedLF[++lfCounter].getName());
	   label_02.setText(LABEL_TEXT + clickCounter); 
	   //now perform another button action: switch to the new look and feel
       try {
         // set new look and feel
         UIManager.setLookAndFeel(installedLF[lfCounter].getClassName());
         // force all components to update their look and feel
         SwingUtilities.updateComponentTreeUI(SwingGUI.this);
       }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
         //printStackTrace() is used only for debugging purposes. 
         //Normally an error dialog should be displayed here or the error must be logged.
          e.printStackTrace();
       }
       if(lfCounter == lfMaxNumber) lfCounter= -1;     
      }
    });  
    return button;
   } 
  }//end Swing class 
}//end application
 