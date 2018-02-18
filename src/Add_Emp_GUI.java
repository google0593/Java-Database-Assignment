/*Created by Team Rocket for Semester 2, Programming 2015, Unitec, New Zealand
Team Rocket is:
Nikko Jucutan
Francis Faminial
KG Udanga*/

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import net.proteanit.sql.DbUtils;

public class Add_Emp_GUI extends JFrame{

	private JPanel contentPane;
	private JTextField EmpField;
	private JTextField NamField;
	private JTextField SurField;
	private JTextField AgeField;
	private JTextField ConField;
	private JTextField AddField;
	private JTextField SalField;
	private JTextField GraField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Emp_GUI frame = new Add_Emp_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public Add_Emp_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		connection = sqlConnection.dbConnector();
		//Creating the Frame
		setTitle("Add Employee Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Start of JLabels*/
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(20, 30, 100, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 60, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(20, 90, 100, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(20, 120, 100, 14);
		contentPane.add(lblAge);
		
		JLabel lblContactNumber = new JLabel("Contact #:");
		lblContactNumber.setBounds(20, 150, 100, 14);
		contentPane.add(lblContactNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(20, 180, 100, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(20, 210, 100, 14);
		contentPane.add(lblSalary);
		
		JLabel lblGrade = new JLabel("Grade (0-100):");
		lblGrade.setBounds(20, 240, 100, 14);
		contentPane.add(lblGrade);
		
		ToolTip tp = new ToolTip();
		EmpField = new JTextField();
		EmpField.setToolTipText(tp.empID());
		/*Restricting Input to Numbers Only*/
		EmpField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		EmpField.setBounds(110, 27, 140, 20);
		contentPane.add(EmpField);
		EmpField.setColumns(10);
		
		NamField = new JTextField();
		NamField.setToolTipText(tp.name());
		/*Restricting Input to Letters Only*/
		NamField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		NamField.setColumns(10);
		NamField.setBounds(110, 57, 140, 20);
		contentPane.add(NamField);
		
		SurField = new JTextField();
		SurField.setToolTipText(tp.surname());
		/*Restricting Input to Letters Only*/
		SurField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		SurField.setColumns(10);
		SurField.setBounds(110, 87, 140, 20);
		contentPane.add(SurField);
		
		AgeField = new JTextField();
		AgeField.setToolTipText(tp.age());
		/*Restricting Input to Numbers Only*/
		AgeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		AgeField.setColumns(10);
		AgeField.setBounds(110, 117, 140, 20);
		contentPane.add(AgeField);
		
		ConField = new JTextField();
		ConField.setToolTipText(tp.contact());
		/*Restricting Input to Numbers Only*/
		ConField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		ConField.setColumns(10);
		ConField.setBounds(110, 147, 140, 20);
		contentPane.add(ConField);
		
		AddField = new JTextField();
		AddField.setToolTipText(tp.address());
		AddField.setColumns(10);
		AddField.setBounds(110, 177, 140, 20);
		contentPane.add(AddField);
		
		SalField = new JTextField();
		SalField.setToolTipText(tp.salary());
		/*Restricting Input to Numbers Only*/
		SalField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		SalField.setColumns(10);
		SalField.setBounds(110, 207, 140, 20);
		contentPane.add(SalField);
		
		GraField = new JTextField();
		GraField.setToolTipText(tp.grade());
		/*Restricting Input to Numbers Only*/
		GraField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		GraField.setColumns(10);
		GraField.setBounds(110, 237, 140, 20);
		contentPane.add(GraField);
			
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("Resources/save.png"));
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				save();
			}
		});
		btnSave.setBounds(65, 308, 89, 23);
		contentPane.add(btnSave);
		
	    JButton btnCancel = new JButton("Back");
	    btnCancel.setIcon(new ImageIcon("Resources/back.png"));
	    btnCancel.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    		Main_Admin_GUI cancel = new Main_Admin_GUI();
	    		cancel.cancel();
	    	}
	    });
		btnCancel.setBounds(164, 308, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("*Mouseover the text field for more info");
		label.setEnabled(false);
		label.setBounds(20, 265, 235, 14);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 27, 459, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{EmpField, NamField, SurField, AgeField, ConField, AddField, SalField, GraField, btnSave, btnCancel}));
		table();
	}
	public void save() {
		/*Start of invoke*/
		fields();
		//When input parameters are not met, the relevant text field background turns red
		int count = 0;
		try
		{
			String query = "insert into Employee (EmployeeID,Name,Surname,Age,'Contact#',Address,Salary,Grade) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			
			if(EmpField.getText().isEmpty() || EmpField.getText().length() >= 6)
			{
				EmpField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(1,"E"+EmpField.getText().toUpperCase());
			}
			
			if(NamField.getText().isEmpty())
			{
				NamField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(2, NamField.getText());
			}
			
			if(SurField.getText().isEmpty())
			{
				SurField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(3, SurField.getText());
			}
			
			if(AgeField.getText().isEmpty())
			{
				AgeField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(4, AgeField.getText());
			}
			
			if(ConField.getText().isEmpty() || ConField.getText().length() >= 12)
			{
				ConField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(5, ConField.getText());
			}
			
			if(AddField.getText().isEmpty())
			{
				AddField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(6, AddField.getText());
			}
			
			if(SalField.getText().isEmpty())
			{
				SalField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(7, SalField.getText());
			}
			
			if(GraField.getText().isEmpty())
			{
				GraField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				int grade = Integer.parseInt(GraField.getText());
				if (grade>100)
				{
					GraField.setBackground(new Color(240,50,20));
					count += 1;
				}
				else
				{
					pst.setString(8, GraField.getText());
				}
			}
			
			if (count > 0)
			{
				JOptionPane.showMessageDialog(null, "Conditions not met, check tooltip.");
			}
			
			else if(count == 0)
			{
				try
				{
					pst.execute();
					pst.close();
					clearField();
					JOptionPane.showMessageDialog(null, "Data has been added");
					
					table();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Employee ID already exists, try a new one.");
				}
			}
		}
		catch (Exception e)
		{
		}
		count = 0;
	}
	public void fields() 
	//turns all the text fields to a white background
	{
		JTextField[] fields = new JTextField[8];
		fields[0] = EmpField;
		fields[1] = NamField;
		fields[2] = SurField;
		fields[3] = AgeField;
		fields[4] = ConField;
		fields[5] = AddField;
		fields[6] = SalField;
		fields[7] = GraField;
		
		
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setBackground(Color.white);
		}
	}
	public void table()
	//Brings up the table for viewing
	{
		try
		{
			String query = "select * from Employee";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			pst.close();
			rs.close();
			
		}
		catch(Exception e)
		{
			
		}
	
	}
	public void clearField()
	//Clears all fields for input
	{
		JTextField[] fields = new JTextField[8];
		fields[0] = EmpField;
		fields[1] = NamField;
		fields[2] = SurField;
		fields[3] = AgeField;
		fields[4] = ConField;
		fields[5] = AddField;
		fields[6] = SalField;
		fields[7] = GraField;
		
		
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setText("");
		}
	}
}
