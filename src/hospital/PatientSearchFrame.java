package hospital;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientSearchFrame extends JFrame{
	
	String[] options = {"Patient ID", "Sex", "First Name", "Last Name", "Insurance", "DOB", "Address", "SSN", "Blood Type"};
	JComboBox<String> searchDrop = new JComboBox<>(options);
	JLabel title = new JLabel("Search: Patient");
	
	JButton searchButton = new JButton("Search");
	JButton exitButton = new JButton("Exit");
	JTextField search = new JTextField();
	
	  public PatientSearchFrame(){
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
		  
		  title.setBounds(158,1,200,100);
		  
		  search.setBounds(220, 80, 80, 25);
		  
		  searchButton.setBounds(158, 120, 80, 25);
		  
		  searchDrop.setBounds(70, 82, 140, 20);
		  exitButton.setBounds(158, 200, 80, 25);
		  
		  add(title);
		  add(search);
		  add(searchButton);
		  
		  add(searchDrop);
		  
		  add(exitButton);
		    
	  }
	  
	  private void initEvent() {
		  
		  searchButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  String selected = searchDrop.getSelectedItem().toString();
				  if(selected.equals("Patient ID")) {
					  searchPatientByID(e);
				  }
				  if(selected.equals("Sex")) {
					  searchPatientBySex(e);
				  }
				  if(selected.equals("First Name")) {
					  searchPatientByFname(e);
				  }
				  if(selected.equals("Last Name")) {
					  searchPatientByLname(e);
				  }
				  if(selected.equals("Insurance")) {
					  searchPatientByInsurance(e);
				  }
				  if(selected.equals("DOB")) {
					  searchPatientByDOB(e);
				  }
				  if(selected.equals("Address")) {
					  searchPatientByAddress(e);
				  }
				  if(selected.equals("SSN")) {
					  searchPatientBySSN(e);
				  }
				  if(selected.equals("Blood Type")) {
					  searchPatientByBloodType(e);
				  }
			  }
		  });
		  
		  exitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  exit(e);
			  }
		  });
				 
	  }
	  
	  private void exit(ActionEvent evt) {
		  dispose();
	  }
	  
	  private void searchPatientByID(ActionEvent evt) {
		    final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE PatientID='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void searchPatientBySex(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE Sex='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  private void searchPatientByFname(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE FirsName='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  private void searchPatientByLname(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE Last Name='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  
	  private void searchPatientByInsurance(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE Insurance='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  private void searchPatientByDOB(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE PDOB='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            
	            process(rs);
	            
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  
	  private void searchPatientByAddress(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE Address='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  
	  private void searchPatientBySSN(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE PSSN='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  
	  private void searchPatientByBloodType(ActionEvent evt) {
		  
		  final String ID = "root";
		    final String PW = "fart2676QUEEN1400";
		    final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		    String querys;
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            String searchEntry = search.getText().toString();
	            String query = "";
	            
	            if(searchEntry.equals("")) {
	            	query = "SELECT * FROM Projectdb.Patient";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Patient WHERE BloodType='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            process(rs);
	        }catch (SQLException e){
	            System.err.println(e);
	        }	  
	        
	  }
	  
	  private void process(ResultSet rs) {
	        try {
	            
	            String resultText = "<html>";
	            
	            
	            while (rs.next()){
	                String patientID = rs.getString("PatientID");
		            String sex = rs.getString("Sex");
		            String fname = rs.getString("FirstName");
		            String lname = rs.getString("LastName");
		            String insurance = rs.getString("Insurance");
		            String dob = rs.getString("PDOB");
		            String address = rs.getString("Address");
		            String pssn = rs.getString("PSSN");
		            String bloodtype = rs.getString("BloodType");
		            System.out.println("Patient ID: " + patientID + "\n\tSex: " + sex + "\n\tFirst Name: " + fname + "\n\tLast Name: " + lname
		                		+ "\n\tInsurance: " + insurance + "\n\tDOB: " + dob + "\n\tAddress: " + address + "\n\tSSN: " + pssn + 
		                		"\n\tBloodType: " + bloodtype); 
		            
		            resultText += "<br>Patient ID: " + patientID + "<blockquote>Sex: " + sex + "<br>First Name: " + fname + "</br><br>Last Name: " + lname
		                		+ "</br><br>Insurance: " + insurance + "</br><br>DOB: " + dob + "</br><br>Address: " + address + "</br><br>SSN: " + pssn + 
		                		"</br><br>BloodType: " + bloodtype + "</br></blockquote></br>";
		            
		            System.out.println();
	            }
	            if(resultText.equals("<html>")) {
	            	resultText += "No results to show.";
	            }
	            resultText = resultText + "</html>";
	            
	        	JDialog idFrame = new JDialog(this);
	        	
	        	JLabel result = new JLabel(resultText);
	        	
	        	JScrollPane scroll = new JScrollPane();
	        	
	        	idFrame.add(result);
	        	idFrame.add(scroll, BorderLayout.CENTER);
	        	scroll.setViewportView(result);
	        	
	        	idFrame.setSize (300, 300);
	        	
	        	idFrame.setVisible(true);
	            
	            

	        }catch (SQLException e){
	            System.err.println(e);
	        }	
	  }

}
