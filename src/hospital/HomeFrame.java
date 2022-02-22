package hospital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeFrame extends JFrame{
	
	String[] optionsToChoose = {"Doctor", "Nurse", "Patient"};
	
	JLabel label = new JLabel("Home Page");
	JButton searchButton = new JButton("Search");
	JButton insertButton = new JButton("Add");
	JButton deleteButton = new JButton("Delete");
	JButton updateButton = new JButton("Update");
	JButton exitButton = new JButton("Exit");
	
	JComboBox<String> searchDrop = new JComboBox<>(optionsToChoose);
	JComboBox<String> insertDrop = new JComboBox<>(optionsToChoose);
	JComboBox<String> updateDrop = new JComboBox<>(optionsToChoose);
	JComboBox<String> deleteDrop = new JComboBox<>(optionsToChoose);
	
	public HomeFrame() {
	    setTitle("UMD Med System");
	    setSize(400,500);
	    setLocation(new Point(200,200));
	    setLayout(null);    
	    setResizable(false);
	    
	    initComponent();    
	    initEvent();
	}
	
	private void initComponent(){
		
		
		
		label.setBounds(158, 1, 100, 100);
		searchDrop.setBounds(70, 82, 140, 20);
		searchButton.setBounds(220, 80, 80, 25);
		deleteButton.setBounds(220, 320, 80, 25);
		deleteDrop.setBounds(70, 322, 140, 20);
		updateButton.setBounds(220, 240, 80, 25);
		updateDrop.setBounds(70, 242, 140, 20);
		insertButton.setBounds(220, 160, 80, 25);
		insertDrop.setBounds(70, 162, 140, 20);

		exitButton.setBounds(158, 400, 80, 25);
		
		add(searchDrop);
		add(searchButton);
		add(label);
		add(insertButton);
		add(deleteButton);
		add(updateButton);
		add(exitButton);
		add(searchDrop);
		add(deleteDrop);
		add(insertDrop);
		add(updateDrop);
		
	}
	
	private void initEvent(){

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String option = deleteDrop.getSelectedItem().toString();
				if(option.equals("Doctor")) {
					openDrDelete(e);
				}
				if(option.equals("Nurse")) {
					openNurseDelete(e);
				}
				if(option.equals("Patient")) {
					openPatientDelete(e);
				}
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String option = searchDrop.getSelectedItem().toString();
				if(option.equals("Doctor")) {
					openDrSearch(e);
				}
				if(option.equals("Nurse")) {
					openNurseSearch(e);
				}
				if(option.equals("Patient")) {
					openPatientSearch(e);
				}

		    }
		});
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String option = insertDrop.getSelectedItem().toString();
				if(option.equals("Doctor")) {
					openDrInsert(e);
				}
				if(option.equals("Nurse")) {
					openNurseInsert(e);
				}
				if(option.equals("Patient")) {
					openPatientInsert(e);
				}
			}
		});
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String option = updateDrop.getSelectedItem().toString();
				if(option.equals("Doctor")) {
					openDrUpdate(e);
				}
				if(option.equals("Nurse")) {
					openNurseUpdate(e);
				}
				if(option.equals("Patient")) {
					openPatientUpdate(e);
				}
			}
		});
		
	}
	
	private void openPatientUpdate(ActionEvent evt) {
		PatientUpdateFrame pupd = new PatientUpdateFrame();
		pupd.setVisible(true);
	}
	
	private void openNurseUpdate(ActionEvent evt) {
		NurseUpdateFrame nupd = new NurseUpdateFrame();
		nupd.setVisible(true);
	}
	
	private void openDrUpdate(ActionEvent evt) {
		DoctorUpdateFrame dupd = new DoctorUpdateFrame();
		dupd.setVisible(true);
	}
	
	private void openDrSearch(ActionEvent evt) {
		DoctorSearchFrame f = new DoctorSearchFrame();
		f.setVisible(true);
	}
	
	private void openNurseSearch(ActionEvent evt) {
		NurseSearchFrame n = new NurseSearchFrame();
		n.setVisible(true);
	}
	
	private void openPatientSearch(ActionEvent evt) {
		PatientSearchFrame p = new PatientSearchFrame();
		p.setVisible(true);
	}
	
	private void openDrInsert(ActionEvent evt) {
		DoctorInsertFrame drins = new DoctorInsertFrame();
		drins.setVisible(true);
	}
	
	private void openNurseInsert(ActionEvent evt) {
		NurseInsertFrame nins = new NurseInsertFrame();
		nins.setVisible(true);
	}
	
	private void openPatientInsert(ActionEvent evt) {
		PatientInsertFrame pins = new PatientInsertFrame();
		pins.setVisible(true);
	}
	
	private void openDrDelete(ActionEvent evt) {
		DoctorDeleteFrame ddel = new DoctorDeleteFrame();
		ddel.setVisible(true);
	}
	
	private void openNurseDelete(ActionEvent evt) {
		NurseDeleteFrame ndel = new NurseDeleteFrame();
		ndel.setVisible(true);
	}
	
	private void openPatientDelete(ActionEvent evt) {
		PatientDeleteFrame pdel = new PatientDeleteFrame();
		pdel.setVisible(true);
	}
	
}
