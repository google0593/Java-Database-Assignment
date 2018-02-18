 /*Created by Team Rocket for Semester 2, Programming 2015, Unitec, New Zealand
Team Rocket is:
Nikko Jucutan
Francis Faminial
KG Udanga*/

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Edit_Emp_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField empField;
	private JTextField namField;
	private JTextField surField;
	private JTextField ageField;
	private JTextField conField;
	private JTextField addField;
	private JTextField salField;
	private JTextField graField;
	private JTextField namField1;
	private JTextField surField1;
	private JTextField ageField1;
	private JTextField conField1;
	private JTextField addField1;
	private JTextField salField1;
	private JTextField graField1;
	private JTable table;

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
					Edit_Emp_GUI frame = new Edit_Emp_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField searchField;
	private JLabel label;
	/**
	 * Create the frame.
	 */
	public Edit_Emp_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		connection = sqlConnection.dbConnector();
		setTitle("Edit Employee Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(10, 73, 100, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 103, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(10, 133, 100, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 163, 100, 14);
		contentPane.add(lblAge);
		
		JLabel lblContactNumber = new JLabel("Contact #:");
		lblContactNumber.setBounds(10, 193, 100, 14);
		contentPane.add(lblContactNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 223, 100, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(10, 253, 100, 14);
		contentPane.add(lblSalary);
		
		JLabel lblGrade = new JLabel("Grade (0-100):");
		lblGrade.setBounds(10, 283, 100, 14);
		contentPane.add(lblGrade);
		
		empField = new JTextField();
		empField.setEditable(false);
		empField.setBounds(100, 70, 140, 20);
		contentPane.add(empField);
		empField.setColumns(10);
		
		namField = new JTextField();
		namField.setEditable(false);
		namField.setColumns(10);
		namField.setBounds(100, 100, 140, 20);
		contentPane.add(namField);
		
		surField = new JTextField();
		surField.setEditable(false);
		surField.setColumns(10);
		surField.setBounds(100, 130, 140, 20);
		contentPane.add(surField);
		
		ageField = new JTextField();
		ageField.setEditable(false);
		ageField.setColumns(10);
		ageField.setBounds(100, 160, 140, 20);
		contentPane.add(ageField);
		
		conField = new JTextField();
		conField.setEditable(false);
		conField.setColumns(10);
		conField.setBounds(100, 190, 140, 20);
		contentPane.add(conField);
		
		addField = new JTextField();
		addField.setEditable(false);
		addField.setColumns(10);
		addField.setBounds(100, 220, 140, 20);
		contentPane.add(addField);
		
		salField = new JTextField();
		salField.setEditable(false);
		salField.setColumns(10);
		salField.setBounds(100, 250, 140, 20);
		contentPane.add(salField);
		
		graField = new JTextField();
		graField.setEditable(false);
		graField.setColumns(10);
		graField.setBounds(100, 280, 140, 20);
		contentPane.add(graField);
		
		namField1 = new JTextField();
		/*Restricting Input to Letters Only*/
		namField1.addKeyListener(new KeyAdapter() {
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
		namField1.setColumns(10);
		namField1.setBounds(260, 100, 140, 20);
		contentPane.add(namField1);
		
		
		surField1 = new JTextField();
		/*Restricting Input to Letters Only*/
		surField1.addKeyListener(new KeyAdapter() {
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
		surField1.setColumns(10);
		surField1.setBounds(260, 130, 140, 20);
		contentPane.add(surField1);
		
		ageField1 = new JTextField();
		/*Restricting Input to Numbers Only*/
		ageField1.addKeyListener(new KeyAdapter() {
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
		ageField1.setColumns(10);
		ageField1.setBounds(260, 160, 140, 20);
		contentPane.add(ageField1);
		
		conField1 = new JTextField();
		/*Restricting Input to Numbers Only*/
		conField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		conField1.setColumns(10);
		conField1.setBounds(260, 190, 140, 20);
		contentPane.add(conField1);
		
		addField1 = new JTextField();
		addField1.setColumns(10);
		addField1.setBounds(260, 220, 140, 20);
		contentPane.add(addField1);
		
		salField1 = new JTextField();
		/*Restricting Input to Numbers Only*/
		salField1.addKeyListener(new KeyAdapter() {
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
		salField1.setColumns(10);
		salField1.setBounds(260, 250, 140, 20);
		contentPane.add(salField1);
		
		graField1 = new JTextField();
		/*Restricting Input to Numbers Only*/
		graField1.addKeyListener(new KeyAdapter() {
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
		graField1.setColumns(10);
		graField1.setBounds(260, 280, 140, 20);
		contentPane.add(graField1);
		
		JButton btnSave = new JButton("Update");
		btnSave.setIcon(new ImageIcon("Resources/update.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		label = new JLabel("*Mouseover the text field for more info.");
		label.setEnabled(false);
		label.setBounds(10, 303, 235, 14);
		contentPane.add(label);
		btnSave.setBounds(100, 328, 89, 23);
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
		btnCancel.setBounds(302, 328, 89, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 47, 459, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		//Displays the non-editable column of fields with data from database
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnDel = new JButton("Delete");
		btnDel.setIcon(new ImageIcon("Resources/delete.png"));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete();
			}
		});
		btnDel.setBounds(199, 328, 89, 23);
		contentPane.add(btnDel);
		
		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				search();
			}
		});
		searchField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(searchField.getText().equals("Enter name/EmployeeID..."))
				{
					searchField.setText("");
					searchField.setForeground(Color.BLACK);
				}
					
			}
		});
		searchField.setForeground(Color.LIGHT_GRAY);
		searchField.setText("Enter name/EmployeeID...");
		searchField.setBounds(719, 16, 156, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(663, 19, 46, 14);
		contentPane.add(lblSearch);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{namField1, surField1, ageField1, conField1, addField1, salField1, graField1, btnSave, btnDel, btnCancel}));
		ToolTip tp = new ToolTip();
		namField1.setToolTipText(tp.name());
		surField1.setToolTipText(tp.surname());
		ageField1.setToolTipText(tp.age());
		conField1.setToolTipText(tp.contact());
		addField1.setToolTipText(tp.address());
		salField1.setToolTipText(tp.salary());
		graField1.setToolTipText(tp.grade());
		table();
	}
	public void table()
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
	public void update()
	{
		clearFields();
		try
		{
			int row = table.getSelectedRow();
			System.out.println(row);
			String Emp =(table.getModel().getValueAt(row, 0).toString());
			String query = "select * from Employee where EmployeeID = '"+Emp+"' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				empField.setText(rs.getString("EmployeeID").toUpperCase());
				namField.setText(rs.getString("Name"));
				surField.setText(rs.getString("Surname"));
				ageField.setText(rs.getString("Age"));
				conField.setText(rs.getString("Contact#"));
				addField.setText(rs.getString("Address"));
				salField.setText(rs.getString("Salary"));
				graField.setText(rs.getString("Grade"));
			}
			pst.close();
		}
		catch(Exception e)
		{
			
		}
	}
	public void delete()
	{
		try
		{
			String empID = JOptionPane.showInputDialog(null, "Please enter the employee ID you wish to delete.", "Delete employee data", JOptionPane.PLAIN_MESSAGE).toUpperCase();
			String query0 = "select * from Employee where EmployeeID=?";
			PreparedStatement pst = connection.prepareStatement(query0);
			pst.setString(1, empID);
			ResultSet rs=pst.executeQuery();
			int count = 0;
			while(rs.next())
			{
				count+=1;
			}
			if(count == 1)
			{
				try
				{
					String query = "delete from Employee where EmployeeID = '"+empID+"' ";
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.execute();
					pst1.close();
					JOptionPane.showMessageDialog(null, "Employee ID " + empID + " has been deleted from the employee record.");
					count = 0;
				}
				catch(Exception e)
				{
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Employee ID " + empID + " does not exist.");
			}
			pst.close();
			rs.close();
		}
		catch(Exception e)
		{
		}
		

		table();
	}
	public void save()
	{
		int count = 0;
		if(empField.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Please select data.");
		}
		else
		{
			try
			{
				if(namField1.getText().isEmpty())
				{
					namField1.setText(namField.getText());
				}
				else
				{
	
				}
				
				if(surField1.getText().isEmpty())
				{
					surField1.setText(surField.getText());
				}
				else
				{
				}
				
				if(ageField1.getText().isEmpty())
				{
					ageField1.setText(ageField.getText());
				}
				else
				{
				}
				
				if(conField1.getText().isEmpty())
				{
					conField1.setText(conField.getText());
				}
				else
				{
				}
				
				if(addField1.getText().isEmpty())
				{
					addField1.setText(addField.getText());
				}
				else
				{
				}
				
				if(salField1.getText().isEmpty())
				{
					salField1.setText(salField.getText());
				}
				else
				{
		
				}
				
				if(graField1.getText().isEmpty())
				{
					graField1.setText(graField.getText());
				}
				else
				{
					int grade = Integer.parseInt(graField1.getText());
					if (grade>100)
					{
						JOptionPane.showMessageDialog(null, "Highest Possible Grade is 100!");
						count += 1;
					}
					else
					{	
					}
				}
				
				if(count==0)
				{
					String query ="update Employee set Name='"+namField1.getText()+"' , Surname='"+surField1.getText()+"' , Age='"+ageField1.getText()+"' , 'Contact#'='"+conField1.getText()+"' , Address='"+addField1.getText()+"' , Salary='"+salField1.getText()+"' , Grade='"+graField1.getText()+"' where EmployeeID = '"+empField.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null, "Table has been updated.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Conditions not met, check tooltip.");
				}
				
				table();
				count = 0;
		
			}
			catch (Exception e)
			{
			}
		}
			
	}
	public void search()
	//searches as the user types
	{
		try
		{
			String query = "SELECT * from Employee where Name LIKE '"+searchField.getText()+"%' OR  EmployeeID LIKE '"+searchField.getText()+"%' ";
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
	public void clearFields()
	{
		JTextField[] fields = new JTextField[7];
		fields[0] = namField1;
		fields[1] = surField1;
		fields[2] = ageField1;
		fields[3] = conField1;
		fields[4] = addField1;
		fields[5] = salField1;
		fields[6] = graField1;

		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setText("");
		}
	}
}
