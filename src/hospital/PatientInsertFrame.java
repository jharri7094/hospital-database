package hospital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientInsertFrame extends JFrame{
	
	JLabel title = new JLabel("Insert New Patient");
	JLabel idLabel = new JLabel("Patient ID");
	JLabel sexLabel = new JLabel("Sex");
	JLabel fnameLabel = new JLabel("First Name");
	JLabel lnameLabel = new JLabel("Last Name");
	JLabel insuranceLabel = new JLabel("Insurance");
	JLabel dobLabel = new JLabel("DOB");
	JLabel addressLabel = new JLabel("Address");
	JLabel ssnLabel = new JLabel("SSN");
	JLabel bloodtypeLabel = new JLabel("Blood Type");
	JTextField idEntry = new JTextField();
	JTextField sexEntry = new JTextField();
	JTextField fnameEntry = new JTextField();
	JTextField lnameEntry = new JTextField();
	JTextField insuranceEntry = new JTextField();
	JTextField dobEntry = new JTextField();
	JTextField addressEntry = new JTextField();
	JTextField ssnEntry =  new JTextField();
	JTextField bloodtypeEntry = new JTextField();
	JButton insertButton = new JButton("Insert");
	JButton exitButton = new JButton("Exit");
	
	  public PatientInsertFrame(){
		    setTitle("UMD Med System");
		    setSize(400,500);
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
		  
		  sexLabel.setBounds(120, 110, 100, 25);
		  sexEntry.setBounds(220, 110, 120, 25);
		  
		  fnameLabel.setBounds(120, 140, 100, 25);
		  fnameEntry.setBounds(220, 140, 120, 25);
		  
		  lnameLabel.setBounds(120, 170, 100, 25);
		  lnameEntry.setBounds(220, 170, 120, 25);
		  
		  insuranceLabel.setBounds(120, 200, 100, 25);
		  insuranceEntry.setBounds(220, 200, 120, 25);
		  
		  dobLabel.setBounds(120, 230, 100, 25);
		  dobEntry.setBounds(220, 230, 120, 25);
		  
		  addressLabel.setBounds(120, 260, 100, 25);
		  addressEntry.setBounds(220, 260, 120, 25);
		  
		  ssnLabel.setBounds(120, 290, 100, 25);
		  ssnEntry.setBounds(220, 290, 120, 25);
		  
		  bloodtypeLabel.setBounds(120, 320, 100, 25);
		  bloodtypeEntry.setBounds(220, 320, 120, 25);
		  
		  insertButton.setBounds(158, 350,80,25);
		  exitButton.setBounds(158, 380, 80, 25);
		  
		  add(title);
		  add(idLabel);
		  add(idEntry);
		  add(sexLabel);
		  add(sexEntry);
		  add(fnameLabel);
		  add(fnameEntry);
		  add(lnameLabel);
		  add(lnameEntry);
		  add(insuranceLabel);
		  add(insuranceEntry);
		  add(dobLabel);
		  add(dobEntry);
		  add(addressLabel);
		  add(addressEntry);
		  add(ssnLabel);
		  add(ssnEntry);
		  add(bloodtypeLabel);
		  add(bloodtypeEntry);
		  
		  add(insertButton);
		  add(exitButton);
	  }
	  
	  private void initEvent() {
		  exitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  exit(e);
			  }
		  });
		  
		  insertButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  addPatient(e);
			  }
		  });
	  }
	  
	  public void addPatient(ActionEvent evt) {
		  final String ID = "root";
		  final String PW = "fart2676QUEEN1400";
		  final String SERVER = "jdbc:mysql://localhost:3306/?serverTimezone=EST#/Projectdb";
		  String querys;
          String idInput = idEntry.getText().toString();
          String sexInput = sexEntry.getText().toString();
          String fnameInput = fnameEntry.getText().toString();
          String lnameInput = lnameEntry.getText().toString();
          String insuranceInput = insuranceEntry.getText().toString();
          String dobInput = dobEntry.getText().toString();
          String addressInput = addressEntry.getText().toString();
          String ssnInput = ssnEntry.getText().toString();
          String bloodtypeInput = bloodtypeEntry.getText().toString();
          String query = "";
	        try {
	            Connection con = DriverManager.getConnection(SERVER, ID, PW);
	            Statement stmt = con.createStatement();
	            Boolean rs;
	            
	            if(idInput.equals("")) {
		            JOptionPane.showMessageDialog(null, "You must insert a Patient ID", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else if(ssnInput.equals("")){
	            	JOptionPane.showMessageDialog(null, "You must insert a Patient SSN", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }else {
	            	query = "INSERT INTO Projectdb.Patient (PatientID, Sex, FirstName, LastName, Insurance, PDOB, Address, PSSN, BloodType) VALUES ('" + idInput 
	            			+ "', '" + sexInput + "', '" + fnameInput + "', '" + lnameInput + "', '" 
	            			+ insuranceInput + "', '" + dobInput + "', '" + addressInput + "', '" + ssnInput + "', '" 
	            			+ bloodtypeInput + "')";
		            rs = stmt.execute(query);
			        String resultText = "<html><br>You have successfully inserted a Patient:</br><br></br><br>" 
			        		+ "Patient ID: " + idInput + "<blockquote>Sex: " + sexInput + "<br>FirstName: " + fnameInput 
			        		+ "</br><br>Last Name: " + lnameInput + "</br><br>Insurance: " + insuranceInput
			        		+ "</br><br>DOB: " + dobInput + "</br><br>Address: " +addressInput+ "</br><br>SSN: " + ssnInput
			        		+ "</br><br>BloodType: "+ bloodtypeInput + "</br></blockquote></br>";
			        
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
	  
	  public void exit(ActionEvent evt) {
		  dispose();
	  }
}
