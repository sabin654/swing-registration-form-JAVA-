
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class myFrame extends JFrame implements ActionListener {
	
	
	//from ma chaine kura haru 
	
	JLabel label1,label2,label3,label4,label5;
	JTextField t1,t2;
	JRadioButton male, female;
	JComboBox day,month,year;
	JTextArea text;
	JCheckBox terms;
	JButton sumbit;
	JButton cancel;
	JLabel meg;
	JTextArea screen;
	Connection con;
	
	
	myFrame(){
		
		  try {
	            con = d.getDbConnection();
	            System.out.println(con);
	            System.out.println("Connection Successful");
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
		
		//for label name
		label1=new JLabel("Name");  // label 1 ko first ma name xa
		label1.setBounds(20,50,100,20); // space 20, top bata 50,width 100,height 50
		
		//for textfield of label 1
		
		t1=new JTextField();
		t1.setBounds(120,50,100,20); 
		
		//for label mobile
		label2=new JLabel("Mobile");  // label 1 ko first ma name xa
		label2.setBounds(20,100,100,20); // space 20, top bata 50,width 100,height 50
		
		//for textfield of label 2
		
		t2=new JTextField();
		t2.setBounds(120,100,100,20); 
		
		//for label gender
		label3=new JLabel("Gender");  // label 1 ko first ma name xa
		label3.setBounds(20,150,100,20); // space 20, top bata 50,width 100,height 50
				
		//for radio button of label 3 which is gender
		
		male= new JRadioButton("male");
		male.setBounds(120,150,80,20);
		
		female= new JRadioButton("female");
		female.setBounds(200,150,80,20);
		
		ButtonGroup b= new ButtonGroup(); //yesle ki male ki female matra thichne dekhauxa duiatai dekhaudaina automatically change hunxa
		b.add(male);
		b.add(female);
		
		
		//for label DOB
		label4= new JLabel("DOB");
		label4.setBounds(20,200,100,20);
		this.add(label4);
		
		
		String[]Days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25",
				"26","27","28","29","30","31"};
		
		String[]Months= {"jan","feb","mar","Apr","may","june","july","aug","sep","oct","nov","dec"};
		String[]Years= {"2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"};
	
		
		// for combo box of label 4 which is dob
		day = new JComboBox(Days);
		month = new JComboBox(Months);
		year = new JComboBox(Years);
		
		day.setBounds(120,200,50,20);
		month.setBounds(180,200,50,20);
		year.setBounds(240,200,60,20);
		
		//for label address in label 5
		label5= new JLabel("Address");
		label5.setBounds(20,250,100,20);
		
		text= new JTextArea();
		text.setBounds(120,245,200,40);
		
		terms= new JCheckBox("Please Accept Terms and Condition");
		terms.setBounds(60,300,250,20);
		
		
		
		//for sumbit and canceal
		
		sumbit = new JButton("Submit");
		sumbit.setBounds(120,350,80,20);
		sumbit.addActionListener(this);
		
	
		
		cancel = new JButton("Cancel");
		cancel.setBounds(220,350,80,20);
		cancel.addActionListener(this);
		
		//for text box Screen
		
		screen=new JTextArea();
		screen.setBounds(350,50,300,237);
		
		//for last message
		
		meg=new JLabel();
		meg.setBounds(20,400,250,20);
		
	
	
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setTitle("Registration Form");	
	this.setLayout(null); //layout mathi gayer basxa 
	 
	 this. setBackground(Color. RED);
     

	this.add(label1);
	this.add(t1);
	

	this.add(label2);
	this.add(t2);
	
	this.add(label3);
	this.add(male);
	this.add(female);
	
	this.add(label4);
	this.add(day);
	this.add(month);
	this.add(year);
	
	this.add(label5);
	this.add(text);
	this.add(terms);
	
	
	this.add(sumbit);
	this.add(cancel);
	
	this.add(screen);
	
	this.add(meg);
	
	this.setVisible(true);
	
	 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(terms.isSelected()) {
			 meg.setText("Registration Sucessfull !");
			String name = t1.getText();
   
            
			String mobile = t2.getText();
			
			String gender="male";
			
			
			if(female.isSelected()) {
				gender="female";
			}
			
		
			String DOB=day.getSelectedItem()+ "/"+month.getSelectedItem()+ "/"+year.getSelectedItem();
			String address = text.getText();
			
			
			if(e.getSource()==sumbit) {
				
				
			 screen.setText("name : " + name+"\n"+"mobile :"+mobile+"\n"+"Gender :"+ gender+"\n"+"DOB :" +DOB+"\n"+"Address :" + address);

             try {
                 PreparedStatement statement = con.prepareStatement(address);
                 statement.setString(1, name);
                 statement.setString(2, address);
                 statement.setString(3, gender);
                 statement.setString(4, DOB);
                 statement.setString(5, address);

                 statement.executeUpdate();
               
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
			}
		
			else if(e.getSource()==cancel) {
				

				t1.setText(null);
				t2.setText(null);
				text.setText(null);
				
				meg.setText(null);
				
				terms.setSelected(false);
				screen.setText("");	
			
				
			}	
		}
			
			else if(e.getSource()==sumbit) {
		
		    meg.setText("Please select term and condition !");
		    
	
		}
			else {
				meg.setText(null);
			}
	}
	
	
		
		
		
			
	

		}
		
		
	
		 
	
		
	
	
	
	
			
		
	
	

		
		
		
	
