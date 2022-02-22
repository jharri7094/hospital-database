package hospital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NurseInsertFrame extends JFrame{
	JLabel title = new JLabel("Insert New Nurse");
	JLabel idLabel = new JLabel("Nurse ID");
	JLabel specLabel = new JLabel("Specialization");
	JTextField idEntry = new JTextField();
	JTextField specEntry = new JTextField();
	JButton insertButton = new JButton("Insert");
	JButton exitButton = new JButton("Exit");
	
	  public NurseInsertFrame(){
		    setTitle("UMD Med System");
		    setSize(400,400);
		    setLocation(new Point(300,200));
		    setLayout(null);    
		    setResizable(false);
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		    initComponent();    
		    initEvent();
	 }
	  
	  private void initComponent() {
		  title.setBounds(158,1,200,100);
		  
		  idLabel.setBounds(120, 80, 80, 25);
		  idEntry.setBounds(220, 80, 120, 25);
		  
		  specLabel.setBounds(120, 110, 100, 25);
		  specEntry.setBounds(220, 110, 120, 25);
		  
		  insertButton.setBounds(158, 200,80,25);
		  exitButton.setBounds(158, 250, 80, 25);
		  
		  add(title);
		  add(idLabel);
		  add(idEntry);
		  add(specLabel);
		  add(specEntry);
		  
		  add(insertButton);
		  add(exitButton);
	  }
	  
	  public void initEvent() {
		  insertButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  addNurse(e);
			  }
		  });
		  
		  exitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  exit(e);
			  }
		  });
	  }
	  
	  public void exit(ActionEvent evt) {
		  dispose();
	  }
	  
	  public void addNurse(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String idInput = idEntry.getText().toString();
          String specInput = specEntry.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            Boolean rs;
	            
	            if(idInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must insert a Nurse ID", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "INSERT INTO Projectdb.Nurse (NurseID, NSpecilization) VALUES ('" + idInput + "', '" + specInput + "')";
		            rs = stmt.execute(query);
			        String resultText = "<html><br>You have successfully inserted a Nurse:</br><br></br><br>" 
			        		+ "Nurse ID: " + idInput + "<blockquote>Specialization: " + specInput + "</blockquote></br>";
			        
		        	JDialog idFrame = new JDialog(this);
		        	
		        	JLabel result = new JLabel(resultText);
		        	
		        	JScrollPane scroll = new JScrollPane();
		        	
		        	idFrame.add(result);
		        	idFrame.add(scroll, BorderLayout.CENTER);
		        	scroll.setViewportView(result);
		        	
		        	idFrame.setSize (300, 300);
		        	
		        	idFrame.setVisible(true);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
}
