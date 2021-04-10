
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class represents the front end of the server side application.
 * It display the status of the server and status for each request 
 * made to the server.
 * 
 * @author emalianakasmuri
 *
 */



public class ServerDataFrame extends JFrame {
	
	String GetInputFromGui=" ";
	 String countNoOfWords=" ";
	
	private static final long serialVersionUID = 1L;
	
	// Private components
	private JLabel lblServerStatus;
	private JTextArea txtRequestStatus;
	
	// Private dimension
	private int width = 900;
	private int height = 500;

	/**
	 * The constructor organize the GUI component for the window.
	 */
	public ServerDataFrame () {
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Server Side");
		this.setSize(new Dimension(width, height));  
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
 
		// Initialize component
		this.lblServerStatus = new JLabel ("-");
		// Row, Column
		this.txtRequestStatus  = new JTextArea(20, 70);
		
		
		
		// Load more component
		loadComponent();
				
	}
	
	/**
	 * This method create and arrange Swing components to display the status of 
	 * the server application
	 * 
	 * @param font - Default font for the application
	 * @return Swing components organized in a panel.
	 */
	private JPanel getServerStatusPanel(Font font) {
		
		// Components to display server's status
		JPanel panel = new JPanel();
		JLabel lblServer = new JLabel ("Server status: ");
		
		// Style the components
		lblServer.setFont(font);
		lblServerStatus.setFont(font);
		lblServer.setBackground(Color.WHITE);
		lblServer.setOpaque(true);
		lblServerStatus.setBackground(Color.WHITE);
		lblServerStatus.setOpaque(true);

		// Organize component into the panel
		panel.add(lblServer);
		panel.add(lblServerStatus);
		
		return panel;
		
	}
	
	/**
	 * This method create and arrange Swing components the status of request 
	 * send to the client.
	 * 
	 * @param font - Default font for the application
	 * @return Swing components organized in a panel.
	 */
	private JPanel getRequestStatusPanel () {
		
		// Component to display request's status
		JPanel panel = new JPanel();

		// Set default message when the frame launch for the first time
		txtRequestStatus.setText("\n > Server is running");
		txtRequestStatus.setEditable(false);
		
		// Styling the request text
		txtRequestStatus.setFont(new Font("Courier", Font.PLAIN, 15));


		// Add component to panel
		panel.add(txtRequestStatus);
		
		return panel;
		
	}
	
	public JPanel getLowerPanel(){
		
		
		ServerDataGenerator ClassObject =new ServerDataGenerator();
		
		JButton btn=new JButton("Send this message to the Client"); 
		JPanel lowerPanel=new JPanel();
		JLabel lblServer = new JLabel ("Enter Any String to compute the number of words in the text: ");
		JTextField t1=new JTextField(30);  
	
		lowerPanel.add(lblServer);
		lowerPanel.add(t1);
		lowerPanel.add(btn);
		
	btn.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			   
				  GetInputFromGui=t1.getText();
				 
				  ClassObject.setCurrentDate(GetInputFromGui);
				 
				 ClassObject.setNoOFWordsInAString(GetInputFromGui);
				 countNoOfWords=ClassObject.getNoOFWordsInAString();
				  System.out.println(ClassObject.getNoOFWordsInAString());
				 
				 
				  
				  
			  } 
			} );

		return lowerPanel;
		
	
		
		
	}
	
	/**
	 * This method arrange the GUI component on the frame
	 */
	public void loadComponent() {
		
		// Get the server status panel and add to frame
		Font font = this.getFontStyle();
		JPanel topPanel = this.getServerStatusPanel(font);
		this.add(topPanel, BorderLayout.NORTH);
		
		
		// Component to display request's status
		JPanel centrePanel = this.getRequestStatusPanel();	
	
		this.add(centrePanel, BorderLayout.CENTER);
		JPanel lowerPanel=this.getLowerPanel();
		this.add(lowerPanel,BorderLayout.SOUTH);
		
		

		
		
	}
	
	/**
	 * This method update the status of the server
	 * 
	 * @param flag: status of the server
	 */
	public void updateServerStatus(boolean b) {
		
	
		String status;
		if(b) 
			
		status = "Waiting for connection.";
		
		
		else 
			status = "Received connection.";
			 
		
		this.lblServerStatus.setText(status);
		
				
	}
	
	/**
	 * This method update the status of the request sent to the client
	 * 
	 * @param status: request status
	 */
	public void updateRequestStatus (String status) {
		
		// Get current status displayed on the window
		String currentText = this.txtRequestStatus.getText();
		txtRequestStatus.setEditable(true);
		
		// Display the latest status on top
		status += "\n > " + currentText;
		this.txtRequestStatus.setText(status);
		txtRequestStatus.setEditable(false);
		
		
		
		
	}
	
	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {
		
		Font font = new Font (Font.SANS_SERIF, Font.PLAIN, 30);
		
		return font;
		
	}
	
	
}
