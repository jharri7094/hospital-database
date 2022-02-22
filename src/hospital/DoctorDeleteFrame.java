package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorDeleteFrame extends JFrame{
	String[] options1 = {"Doctor ID", "Specialization"};
	
	JLabel title = new JLabel("Delete Doctor(s)");
	
	JLabel optionLabel = new JLabel("Column");
	
	JLabel desc = new JLabel("Delete all instances of Doctor with the conditions above");
	
	JTextField input = new JTextField();
	
	JComboBox<String> columnDrop = new JComboBox<>(options1);
	
	JButton deleteButton = new JButton("Delete");
	JButton exitButton = new JButton("Exit");

	  public DoctorDeleteFrame(){
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
				  if(selected.equals("Doctor ID")) {
					  deleteById(e);
				  }
				  if(selected.equals("Specialization")) {
					  deleteBySpec(e);
				  }
			  }
		  });
	  }
	  
	  private void deleteBySpec(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String specInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(specInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Doctor WHERE DSpecilization='" + specInput + "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Doctor(s) with: <br> Specialization = " + specInput + "</br></html>";
	            	
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
	  
	  private void deleteById(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String idInput = input.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            
	            if(idInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must enter a value", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "DELETE FROM Projectdb.Doctor WHERE DoctorID='" + idInput+ "'";
	            	stmt.executeUpdate(query);
	            	
            		
            		String resultText = "<html>You have deleted Doctor(s) with: <br> Doctor ID = " + idInput + "</br></html>";
	            	
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
