package calculator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
	
/** 
 * @author Aria Gomes
 * @version 1
 * @see Controller, ActionListener
 * @since 1.8.0_144
 */

public class CalculatorViewController extends JPanel 
{
	private static final long serialVersionUID = -1358422722986703478L;
	private JTextField display1; // the calculator display1 field reference
    private JTextField display2; // the calculator display2 field reference
    private JLabel error; // the mode/error display label reference
    private JButton dotButton; // the decimal point (dot) button reference
    private JButton[] hexButtons ; // reference to container for alphabetical hex buttons
    
    /*{@value} Holds the text to be displayed in each key on the keypad */
    private static final String[] KEY_NUMS = {"A", "B", "C", "D", "E", "F", "7", "8", "9", "4", "5", "6", "1", "2", "3", ".", "0", "\u00B1"}; // Array to be used in creating keypad

    public CalculatorViewController() {  
    	// Sets sizing and border for overall calculator
    	this.setLayout(new BorderLayout());
    	this.setSize(380, 540);
    	this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
    	
    	// Sets the action listener 
    	Controller handler = new Controller();
    	
    	//Sets the midPanel to be used for keypad and operator buttons
    	JPanel midPanel = new JPanel(new BorderLayout());
    	
	    // Creates the main panel to be used
	    JPanel main = new JPanel(new BorderLayout());
	    
	    // Creates the foundation elements of the top row
	    JPanel topRow = new JPanel(new BorderLayout());
	    
	    // Creates a panel to hold the two display elements
	    JPanel text = new JPanel(new BorderLayout());
	    
	    // Creates a panel to hold the backspace button
	    JPanel backspace = new JPanel(new BorderLayout());
	    
	    // Creates the foundation elements of the mode panel
	    JPanel mode = new JPanel(new BorderLayout());
	    
	    // Creates a box to hold the check box and radio buttons
	    Box box = Box.createHorizontalBox();
	    
	    // Creates a group to ensure only one of hex or radio buttons are toggled
	    ButtonGroup buttonGroup = new ButtonGroup();
	    
	    // Creates the hex check box
	    JCheckBox hex = new JCheckBox("Hex");
	    
	    // Creates the single precision decimal radio button
	    JRadioButton decimal1 = new JRadioButton(".0");
	    
	    // Creates the double precision decimal radio button
	    JRadioButton decimal2 = new JRadioButton(".00");
	    
	    // Creates the scientific notation decimal radio button
	    JRadioButton scientific = new JRadioButton("Sci");
	    
	    // Creates the foundation elements of the keypad
	    JPanel keypad = new JPanel(new BorderLayout());
	    
	    // Creates the addition button
	    JButton plus = createButton("+", "+", Color.BLACK, Color.CYAN, handler);
	    
	    // Creates the subtraction button
	    JButton minus = createButton("-", "-", Color.BLACK, Color.CYAN, handler);
	    
	    // North keypad operator buttons panel
	    JPanel northKeypad = new JPanel( new GridLayout(1 , 4, 10, 0));
	    
	    // North keypad operator buttons panel
	    JPanel southKeypad = new JPanel( new GridLayout(1 , 4, 10, 0));
	    
	    // Creates multiplication button
	    JButton multiply = createButton("*", "*", Color.BLACK, Color.CYAN, handler);
	    
	    // Creates division button
	    JButton divide = createButton("/", "/", Color.BLACK, Color.CYAN, handler);
	    
	    // Creates a panel that holds the arithmetic buttons
	    JPanel arithmetic = new JPanel(new GridLayout(0, 3, 3, 3));
	    
	    // Create key button
	    JButton key;
	    
	    // Creates clear button
	    JButton clear = createButton("C", "C", Color.BLACK, Color.RED, handler);
	    
	    // Creates equal button
	    JButton equal = createButton("=", "=", Color.BLACK, Color.YELLOW, handler);
	    
	    // Creates the addition button
	    JButton plus1 = createButton("+", "+", Color.BLACK, Color.CYAN, handler);
	    
	    // Creates the subtraction button
	    JButton minus1 = createButton("-", "-", Color.BLACK, Color.CYAN, handler);
	    
	    // Creates multiplication button
	    JButton multiply1 = createButton("*", "*", Color.BLACK, Color.CYAN, handler);
	    
	    // Creates division button
	    JButton divide1 = createButton("/", "/", Color.BLACK, Color.CYAN, handler);
	    
	    // Begin top panel
	    // Mode/Error label
	    error = new JLabel("F");
	    error.setPreferredSize(new Dimension(52, 55));
        error.setFont(new Font(null, Font.BOLD, 20));
	    error.setHorizontalAlignment(SwingConstants.CENTER);
	    error.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));
	    topRow.add(error, BorderLayout.LINE_START);
	    
	    // Display Text boxes
	    display1 = new JTextField(null, 14);
	    display1.setPreferredSize(new Dimension(0, 30));
	    display1.setBorder(BorderFactory.createEmptyBorder());
	    display1.setEditable(false);
	    text.add(display1, BorderLayout.PAGE_START);
	    //Display 2
	    display2 = new JTextField("0.0", 14);
	    display2.setPreferredSize(new Dimension(0, 30));
	    display2.setHorizontalAlignment(SwingConstants.RIGHT);
	    display2.setBorder(BorderFactory.createEmptyBorder());
	    display2.setEditable(false);
	    text.add(display2, BorderLayout.PAGE_END);
	    topRow.add(text);
	    
	    // Creates the backspace button
	    JButton backspaceButton = createButton("\u21DA", "\u21DA", null, null, handler);
	    backspaceButton.setPreferredSize(new Dimension(52, 55));
	    backspaceButton.setOpaque(true);
	    backspaceButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
	    backspaceButton.setToolTipText("Backspace (Alt-B)");
	    backspaceButton.setMnemonic('b');
	    
	    // Adds the backspace button to the backspace panel
	    backspace.add(backspaceButton);
	    backspace.setBackground(Color.YELLOW);
	    
	    // Adds the backspace panel to the top row
	    topRow.add(backspace, BorderLayout.LINE_END);
	    topRow.setBackground(Color.YELLOW);
	    
	    // Begin mode panel
	    hex.setBackground(Color.GREEN);
	    buttonGroup.add(hex);
	    box.setBackground(Color.BLACK);
	    box.setBorder(BorderFactory.createMatteBorder(10, 2, 10, 2, Color.BLACK));
	    box.add(hex, BorderLayout.LINE_START);
	    hex.addActionListener(handler);

	    // Radio button group
	    // Adds spacing element to the box
	    box.add(Box.createHorizontalGlue());
	    
	    // Adds decimal 1 to the button group and sets visual elements
	    buttonGroup.add(decimal1);
	    decimal1.setBackground(Color.YELLOW);
	    decimal1.addActionListener(handler);
	    box.add(decimal1);
	    
	    // Adds decimal 2 to the button group and sets visual elements
	    buttonGroup.add(decimal2);
	    decimal2.setBackground(Color.YELLOW);
	    decimal2.addActionListener(handler);
	    // Sets decimal 2 as default selection on launch
	    decimal2.setSelected(true);
	    box.add(decimal2);

	    // Adds scientific to the button group and sets visual elements
	    buttonGroup.add(scientific);
	    scientific.setBackground(Color.YELLOW);
	    scientific.addActionListener(handler);
	    box.add(scientific);
	    
	    // Adds mode panel to top row
	    mode.add(box, BorderLayout.PAGE_START);
	    mode.setBorder(BorderFactory.createEmptyBorder());
	    mode.setBackground(Color.BLACK);
	    topRow.add(mode, BorderLayout.PAGE_END);
	    
	    //Creates the midpanel
	    midPanel.add(keypad, BorderLayout.CENTER);
	    midPanel.add(northKeypad, BorderLayout.NORTH);
	    midPanel.add(southKeypad, BorderLayout.SOUTH);
	    
	    // Adds top row to main panel
	    main.add(topRow, BorderLayout.PAGE_START);
	    
	    // Begin arithmetic panel
	    // Array to hold hex buttons
	    hexButtons = new JButton[6];
	    // Creates arithmetic buttons (digits and hex) within keypad
	    for(int i = 0; i < KEY_NUMS.length; i++) 
	    {
	    	if(KEY_NUMS[i].matches("[A-Z]")) 
	    	{
	    		// Creates hex buttons
	    		hexButtons[i] = createButton(KEY_NUMS[i], KEY_NUMS[i], Color.BLACK, Color.BLUE, handler);
	    		hexButtons[i].setEnabled(false);
	    		arithmetic.add(hexButtons[i]);
	    	}
	    	else if(KEY_NUMS[i].matches("\\d+")) 
	    	{
	    		// Creates digit buttons
	    		key = createButton(KEY_NUMS[i], KEY_NUMS[i], Color.BLACK, Color.BLUE, handler);
	    		arithmetic.add(key);
	    	}
	    	else if(KEY_NUMS[i].matches("[.]")) 
	    	{ 
	    		// Creates the dot button
	    		dotButton = createButton(KEY_NUMS[i], KEY_NUMS[i], Color.BLACK, Color.MAGENTA, handler);
	    		arithmetic.add(dotButton);
	    	}
	    	else 
	    	{
	    		// Creates the +- button
	    		key = createButton(KEY_NUMS[i], KEY_NUMS[i], Color.BLACK, Color.MAGENTA, handler);
	    		arithmetic.add(key);
	    	}
	    }
	    arithmetic.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
	    
	    // Adds addition, subtraction, multiplication and division buttons to the north side of keypad
	    northKeypad.add(plus, BorderLayout.PAGE_START);
	    northKeypad.add(minus, BorderLayout.PAGE_START);
	    northKeypad.add(multiply, BorderLayout.PAGE_START);
	    northKeypad.add(divide, BorderLayout.PAGE_START);
	    northKeypad.setBackground(Color.BLACK);
	    
	    // Adds addition, subtraction, multiplication and division buttons to the south side of keypad
	    southKeypad.add(plus1, BorderLayout.PAGE_START);
	    southKeypad.add(minus1, BorderLayout.PAGE_START);
	    southKeypad.add(multiply1, BorderLayout.PAGE_START);
	    southKeypad.add(divide1, BorderLayout.PAGE_START);
	    southKeypad.setBackground(Color.BLACK);
	    
	    // Sets the clear and equal dimension borders and background
	    clear.setPreferredSize(new Dimension(44, 44));
	    clear.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
	    equal.setPreferredSize(new Dimension(44, 44));
	    equal.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK));
	    
	    // Adds clear and equal to keypad
	    main.add(clear, BorderLayout.WEST);
	    main.add(equal, BorderLayout.EAST);
 
	    // Adds the components of the keypad to the main panel
	    keypad.add(southKeypad, BorderLayout.SOUTH);
	    keypad.add(arithmetic, BorderLayout.CENTER);
	    keypad.add(northKeypad, BorderLayout.NORTH);
	    main.add(midPanel);
	    
	    // Adds main panel to calculator frame
	    this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); // Gives the whole panel a 5 pixel border
	    this.add(main);
	    setVisible(true);// makes the panel visible 
    }
    
    /*
     * Creates the controller for the actions of the keys
     * @author 	Aria Gomes
     * @version 1.0
     * @see 	Calculator
     * @since 	1.8.0_232
     */
    private class Controller implements ActionListener
    {
    	@Override
        /*
         * Performs an action based on the command received
         * 
         * @param	text : String - the text to be displayed in the key
         */
    	public void actionPerformed(ActionEvent e) 
    	{
    		// Displays any button press to the 2nd display
    		display2.setText(e.getActionCommand());
    	}
    }

    /*
     * Provides a way to quickly define and create buttons of similar action
     * 
     * @param	text : String - the text to be displayed in the key
     * 			ac : String	- the action command to be returned by the button
     * 			fg : Color - the color of the foreground of the button
     * 			bg : Color - the color of the background of the button
     * 			handler : ActionListener - the listener of the action returned by the button
     * 
     * @return	JButton - returns the button created by this method
     */
    private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler)
    {
    	// Creates the button with the passed text argument
        JButton button = new JButton(text);
        
        if(ac != null) 
        	button.setActionCommand(ac);
        
        // Sets colors and fonts of button
        button.setBackground(bg);
        button.setForeground(fg);
        
        if(text.equalsIgnoreCase("C")) //Special casses for C and Equal buttons because the font is too large
        	button.setFont(new Font(null, 0, 15));
        else if(text.equalsIgnoreCase("="))
        	button.setFont(new Font(null, 0, 12));
        else
        	button.setFont(new Font(null, 0, 20));
        
        button.addActionListener(handler);
        return button;
    }
}