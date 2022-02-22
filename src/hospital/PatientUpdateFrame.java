package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientUpdateFrame extends JFrame{
	String[] options = {"Patient ID", "Sex", "First Name", "Last Name", "Insurance", "DOB", "Address", "SSN", "BloodType"};
	JComboBox<String> updateDrop = new JComboBox<>(options);
	JLabel title = new JLabel("Update: Patient");
	JLabel setLabel = new JLabel("Set Patient(s) with:");
	JComboBox<String> setDrop = new JComboBox<>(options);
	
	JButton updateButton = new JButton("Update");
	JButton exitButton = new JButton("Exit");
	JTextField update = new JTextField();
	JLabel toLabel = new JLabel("To:");
	JTextField toUpdate = new JTextField();
	
	  public PatientUpdateFrame(){
		  
		    setTitle("UMD Med System");
		    setSize(400,300);
		    setLocation(new Point(300,200));
		    setLayout(null);    
		    setResizable(false);
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		    initComponent();    
		    initEvent();
	  }
	  
	  private void initComponent() {
		  
		  title.setBounds(158,-10,200,100);
		  
		  setLabel.setBounds(150, 20, 300, 100);
		  
		  toLabel.setBounds(190, 102, 140, 20);
		  
		  update.setBounds(220, 78, 80, 25);
		  
		  updateButton.setBounds(158, 160, 80, 25);
		  
		  updateDrop.setBounds(70, 82, 140, 20);
		  setDrop.setBounds(70, 125, 140, 20);
		  toUpdate.setBounds(220, 123, 80, 25);
		  exitButton.setBounds(158, 200, 80, 25);
		  
		  add(title);
		  add(setLabel);
		  add(update);
		  add(toUpdate);
		  add(updateButton);
		  add(toLabel);
		  add(setDrop);
		  
		  add(updateDrop);
		  
		  add(exitButton);
		    
	  }
	  
	  private void initEvent() {
		  
		  updateButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  update(e);
			  }
		  });
		  
		  exitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  exit(e);
			  }
		  });
				 
	  }
	  
	  private void update(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String setDropInput = updateDrop.getSelectedItem().toString();
          String setInput = update.getText().toString();
          String toDropInput = setDrop.getSelectedItem().toString();
          String toInput = toUpdate.getText().toString();
          
          String setQueryPart = "";
          if(setDropInput.equals("Patient ID")) {
        	  setQueryPart = "PatientID";
          }else if(setDropInput.equals("Sex")){
        	  setQueryPart = "Sex";
          }else if(setDropInput.equals("First Name")) {
        	  setQueryPart = "FirstName";
          }else if(setDropInput.equals("Last Name")) {
        	  setQueryPart = "LastName";
          }else if(setDropInput.equals("Insurance")) {
        	  setQueryPart = "Insurance";
          }else if(setDropInput.equals("DOB")) {
        	  setQueryPart = "PDOB";
          }else if(setDropInput.equals("Address")) {
        	  setQueryPart = "Address";
          }else if(setDropInput.equals("SSN")) {
        	  setQueryPart = "PSSN";
          }else if(setDropInput.equals("Blood Type")) {
        	  setQueryPart = "BloodType";
          }
          
          String toQueryPart = "";
          if(toDropInput.equals("Patient ID")) {
        	  toQueryPart = "PatientID";
          }else if(toDropInput.equals("Sex")){
        	  toQueryPart = "Sex";
          }else if(toDropInput.equals("First Name")) {
        	  toQueryPart = "FirstName";
          }else if(toDropInput.equals("Last Name")) {
        	  toQueryPart = "LastName";
          }else if(toDropInput.equals("Insurance")) {
        	  toQueryPart = "Insurance";
          }else if(toDropInput.equals("DOB")) {
        	  toQueryPart = "PDOB";
          }else if(toDropInput.equals("Address")) {
        	  toQueryPart = "Address";
          }else if(toDropInput.equals("SSN")) {
        	  toQueryPart = "PSSN";
          }else if(toDropInput.equals("Blood Type")) {
        	  toQueryPart = "BloodType";
          }
          
          
        		  
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(setInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a SET value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else if(toInput.equals("")){
	            	
	            	JOptionPane.showMessageDialog(null, "You must enter a WHERE value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            	
	            }else {
	            	query = "UPDATE Projectdb.Patient SET " + toQueryPart + "= '" + toInput + "' WHERE " + setQueryPart + "= '" 
	            + setInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		String resultText = "<html>You have updated Patient(s) with: <br>" + setDropInput + " = "  + setInput 
            				+ "</br><br>To " + toDropInput + " = " + toInput + "</br></html>";
	            	
			        	JDialog idFrame = new JDialog(this);
			        	
			        	
			        	JScrollPane scroll = new JScrollPane();
			        	JLabel result = new JLabel(resultText);
			        	
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
	  
	  private void exit(ActionEvent evt) {
		  dispose();
	  }
	
}
