import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represent the window for the client side TCP application.
 * It display the date retrieve from the server.
 * 
 * 
 *
 */
public class ClientSideFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblServerDate;
	private JLabel lblStatusValue;
	private JLabel lblServerText;
	
	// Private attributes for frame size
	private int width = 1000;
	private int height = 200;


	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public ClientSideFrame () {
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
		lblServerDate = new JLabel("-");
		lblStatusValue = new JLabel("-");
		lblServerText=new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
		public void updateServerDate (String serverDate) {
			
			String st = serverDate;
			String st1=st.replaceAll("[^A-Za-z]", " ");
		
			System.out.println("Input String = "+st1);
		
		
		this.lblServerDate.setText(st1);
		
	}
		
		public void updateServerText(String serverText) {
			
			
			
			String st = serverText;
			
			String st2=st.replaceAll("[^0-9]", "");
		
			System.out.println("Nubmer of Words="+st2);
			
			this.lblServerText.setText(st2);
		}
	
	
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	
	/**
	 * This method creates and arrange Swing components to display status of 
	 * client's connection to the server.
	 * 
	 * @param font
	 * @return Swing components organized in a panel.
	 */
	private JPanel getConnectionStatusPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");
		
		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);
		
		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		
		return panel;
		
	}
	
	private JPanel getStringDataFromServer(Font font) {
		
		JPanel panel =new JPanel();
		
		JLabel TextReceivedFromTheServer = new JLabel ("Number of Words in the String(Computed in Server): ");
		TextReceivedFromTheServer.setFont(font);
	    lblServerText.setFont(font);
		TextReceivedFromTheServer.setBackground(Color.WHITE);
		TextReceivedFromTheServer.setOpaque(true);
		lblServerText.setBackground(Color.WHITE);
		lblServerText.setOpaque(true);

		// Organize components into panel
		
	
		
		panel.add(TextReceivedFromTheServer);
		panel.add(lblServerText);
		return panel;
		
		
	}
	
	/**
	 * This method creates and arrange Swing components to date retrieve from 
	 * the server.
 	 *
	 * @param font
	 * @return Swing components organized in panel
	 */
	private JPanel getServerDatePanel(Font font) {
		
		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblDate = new JLabel ("Text Received from the Server is: ");
		
		
		
		// Style the component
		lblDate.setFont(font);
		lblServerDate.setFont(font);
		lblDate.setBackground(Color.WHITE);
		lblDate.setOpaque(true);
		lblServerDate.setBackground(Color.WHITE);
		lblServerDate.setOpaque(true);

		// Organize components into panel
		panel.add(lblDate);
		panel.add(lblServerDate);
	
		
		return panel;
	} 
	
	
	/**
	 * This method arrange the Swing components on the frame.
	 */
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		// Get server date's panel and add to frame
		JPanel center = getServerDatePanel(font);
		this.add(center, BorderLayout.CENTER);
		
		JPanel lowerPanel =getStringDataFromServer(font);
		this.add(lowerPanel,BorderLayout.SOUTH);
		
	}
	
	
	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}
	
	
	
	
	
}
