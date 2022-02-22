package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDeleteFrame extends JFrame{
String[] options1 = {"Patient ID", "Sex", "First Name", "Last Name", "Insurance", "DOB", "Address", "SSN", "Blood Type"};
	
	JLabel title = new JLabel("Delete Nurse(s)");
	
	JLabel optionLabel = new JLabel("Column");
	
	JLabel desc = new JLabel("Delete all instances of Nurse with the conditions above");
	
	JTextField input = new JTextField();
	
	JComboBox<String> columnDrop = new JComboBox<>(options1);
	
	JButton deleteButton = new JButton("Delete");
	JButton exitButton = new JButton("Exit");

	  public PatientDeleteFrame(){
		    setTitle("UMD Med System");
		    setSize(500,300);
		    setLocation(new Point(300,200));
		    setLayout(null);    
		    setResizable(false);
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		    initComponent();    
		    initEvent();
	  }
	  
	  private void initComponent() {
		  
		  title.setBounds(200,1,200,100);
		  
		  optionLabel.setBounds(100, 80, 80, 25);
		  columnDrop.setBounds(150, 80, 140, 25);
		  
		  input.setBounds(295, 80, 80, 25);
		  
		  desc.setBounds(60, 100, 400, 100);
		  
		  deleteButton.setBounds(200, 180, 80, 25);
		  exitButton.setBounds(200, 210, 80, 25);
		  
		  add(title);
		  add(optionLabel);
		  add(input);
		  add(columnDrop);
		  add(desc);
		  
		  add(deleteButton);
		  
		  add(exitButton);
		    
	  }
	  
	  private void initEvent() {
		  exitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  exit(e);
			  }  
		  }); 
		  
		  deleteButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  String selected = columnDrop.getSelectedItem().toString();
				  if(selected.equals("Patient ID")) {
					  deleteById(e);
				  }
				  if(selected.equals("Sex")) {
					  deleteBySex(e);
				  }
				  if(selected.equals("First Name")) {
					  deleteByFname(e);
				  }
				  if(selected.equals("Last Name")) {
					  deleteByLname(e);
				  }
				  if(selected.equals("Insurance")) {
					  deleteByInsurance(e);
				  }
				  if(selected.equals("DOB")) {
					  deleteByDob(e);
				  }
				  if(selected.equals("Address")) {
					  deleteByAddress(e);
				  }
				  if(selected.equals("SSN")) {
					  deleteBySsn(e);
				  }
				  if(selected.equals("Blood Type")) {
					  deleteByBloodtype(e);
				  }
			  }
		  });
	  }
	  
	  private void deleteByBloodtype(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String bloodtypeInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(bloodtypeInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE BloodType='" + bloodtypeInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> Blood Type = " + bloodtypeInput + "</br></html>";
	            	
			        dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteBySsn(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String ssnInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(ssnInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE PSSN='" + ssnInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> SSN = " + ssnInput + "</br></html>";
	            	
			        dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteByAddress(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String addressInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(addressInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE Address='" + addressInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> Address = " + addressInput + "</br></html>";
	            	
			        dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteByDob(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String dobInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(dobInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE PDOB='" + dobInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> DOB = " + dobInput + "</br></html>";
	            	
			        dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteByInsurance(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String insuranceInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(insuranceInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE Insurance='" + insuranceInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> Insurance = " + insuranceInput + "</br></html>";
	            	
			        dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteByLname(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String lnameInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(lnameInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE LastName='" + lnameInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> Last Name = " + lnameInput + "</br></html>";
	            	
			        dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteByFname(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String fnameInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(fnameInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE FirstName='" + fnameInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> FirstName = " + fnameInput + "</br></html>";
	            	
			        dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteBySex(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String sexInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(sexInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE Sex='" + sexInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> Sex = " + sexInput + "</br></html>";
	            	
            		dialog(resultText);
	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void deleteById(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
          String idInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(idInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Patient WHERE PatientID='" + idInput+ "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Patient(s) with: <br> Patient ID = " + idInput + "</br></html>";
	            	dialog(resultText);

	            }

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  public void dialog(String resultText) {
      	JDialog idFrame = new JDialog(this);
    	
    	
      	JScrollPane scroll = new JScrollPane();
      	JLabel result = new JLabel(resultText);
      	
      	idFrame.add(result);
      	idFrame.add(scroll, BorderLayout.CENTER);
      	scroll.setViewportView(result);
      	
      	idFrame.setSize (300, 300);
      	
      	idFrame.setVisible(true);
		  
	  }
	  
	  private void exit(ActionEvent evt) {
		  dispose();
	  }
}
