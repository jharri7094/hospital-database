package hospital;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NurseSearchFrame extends JFrame{
	String[] options = {"Nurse ID", "Specialization"};
	JComboBox<String> searchDrop = new JComboBox<>(options);
	JLabel title = new JLabel("Search: Nurse");
	
	JButton searchButton = new JButton("Search");
	JButton exitButton = new JButton("Exit");
	JTextField search = new JTextField();
	
	  public NurseSearchFrame(){
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
				  if(selected.equals("Nurse ID")) {
					  searchNurseByID(e);
				  }
				  if(selected.equals("Specialization")) {
					  searchNurseBySpec(e);
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
	  
	  private void searchNurseByID(ActionEvent evt) {
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
	            	query = "SELECT * FROM Projectdb.Nurse";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Nurse WHERE NurseID='" + searchEntry + "'";
	            	rs = stmt.executeQuery(query);
	            }
	            
	            process(rs);
	            
	            

	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
	  
	  private void searchNurseBySpec(ActionEvent evt) {
		  
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
	            	query = "SELECT * FROM Projectdb.Nurse";
	            	rs = stmt.executeQuery(query);
	            }else {
	            	query = "SELECT * FROM Projectdb.Nurse WHERE NSpecilization='" + searchEntry + "'";
	            	System.out.println(query);
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
	                String doctorID = rs.getString("NurseID");
		            String special = rs.getString("NSpecilization");
		            System.out.println("Nurse ID: " + doctorID + ", Specialty: "+special +"\n");
		            resultText += "<br>Nurse ID: " + doctorID + "<blockquote> Specialty: "+special + "</blockquote></br>";
	            }
	            
	            if(resultText.equals("<html>")) {
	            	resultText += "No results to show.";
	            }
	            
	            resultText = resultText + "</html>";
	            
	        	JDialog specFrame = new JDialog(this);
	        	
	        	JLabel result = new JLabel(resultText);
	        	
	        	JScrollPane scroll = new JScrollPane();
	        	
	        	specFrame.add(result);
	        	specFrame.add(scroll, BorderLayout.CENTER);
	        	
	        	scroll.setViewportView(result);
	        	
	        	specFrame.setSize (300, 300);
	        	
	        	specFrame.setVisible(true);
	            
	        }catch (SQLException e){
	            System.err.println(e);
	        }
	  }
}
