/*Created by Team Rocket for Semester 2, Programming 2015, Unitec, New Zealand
Team Rocket is:
Nikko Jucutan
Francis Faminial
KG Udanga*/

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class Add_Sales_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField EmpField;
	private JTextField NamField;
	private JTextField SurField;
	private JTextField AgeField;
	private JTextField ConField;
	private JTextField AddField;
	private JTextField BasField;
	private JTextField GraField;
	private JTextField SalField;
	private JTextField ActField;
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
					Add_Sales_GUI frame = new Add_Sales_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;

	/**
	 * Create the frame.
	 */
	public Add_Sales_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		connection = sqlConnection.dbConnector();
		
		setTitle("Add Salesperson");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Labels Start*/
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
		
		JLabel lblSalary = new JLabel("Base Salary:");
		lblSalary.setBounds(20, 210, 100, 14);
		contentPane.add(lblSalary);
		
		JLabel lblGrade = new JLabel("Grade (0-100):");
		lblGrade.setBounds(20, 240, 100, 14);
		contentPane.add(lblGrade);
		
		JLabel lblNewLabel = new JLabel("Sales Volume:");
		lblNewLabel.setBounds(20, 270, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Commission Rate:");
		lblNewLabel_1.setBounds(20, 300, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Actual Salary:");
		lblNewLabel_2.setBounds(20, 330, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("5%");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(136, 300, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		/*Labels End*/
		
		/*TextFields Begin*/
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
		
		BasField = new JTextField();
		BasField.setToolTipText(tp.baseSalary());
		BasField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
				{
						
					getToolkit().beep();
					evt.consume();
				}
				else
				{
					try
					{
						double salary = Double.parseDouble(BasField.getText());
						double sales_volume = Double.parseDouble(SalField.getText());
						double Actual_Salary = salary + (sales_volume *.05);
						ActField.setText(""+Actual_Salary);
					}
					catch(Exception e)
					{
							
					}
						
						
				}
			}
		});
		/*Restricting Input to Numbers Only*/
		BasField.addKeyListener(new KeyAdapter() {
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
		BasField.setColumns(10);
		BasField.setBounds(110, 207, 140, 20);
		contentPane.add(BasField);
		
		GraField = new JTextField();
		GraField.setToolTipText(tp.grade());
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
		
		SalField = new JTextField();
		SalField.setToolTipText(tp.salary());
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
				else
				{
					try
					{
						double salary = Double.parseDouble(BasField.getText());
						double sales_volume = Double.parseDouble(SalField.getText());
						double Actual_Salary = salary + (sales_volume *.05);
						ActField.setText(""+Actual_Salary);
					}
					catch(Exception e)
					{
							
					}
						
						
				}
			}
		});
		SalField.setColumns(10);
		SalField.setBounds(110, 267, 140, 20);
		contentPane.add(SalField);
		
		ActField = new JTextField();
		ActField.setToolTipText(tp.actSalary());
		ActField.setEnabled(false);
		ActField.setEditable(false);
		ActField.setColumns(10);
		ActField.setBounds(110, 328, 140, 20);
		contentPane.add(ActField);
		
		/*Text Fields End*/
		
		/*Buttons Begin*/
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("Resources/save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
												
				save();			
			}
		});
		btnSave.setBounds(62, 377, 89, 23);
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
		btnCancel.setBounds(161, 377, 89, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 27, 531, 373);
		contentPane.add(scrollPane);

		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("*Mouseover the text field for more info");
		label.setEnabled(false);
		label.setBounds(20, 352, 235, 14);
		contentPane.add(label);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{EmpField, NamField, SurField, AgeField, ConField, AddField, BasField, GraField, SalField, btnSave, btnCancel}));
		table ();
	}
	
	
	public void save() {
		/*Start of invoke*/
		fields();
		int count = 0;
		
		try
		{
			String query = "insert into SalesPerson (EmployeeID,Name,Surname,Age,'Contact#',Address,BaseSalary,Grade,SalesVolume,ActualSalary) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			
			if(EmpField.getText().isEmpty() || EmpField.getText().length() >= 6)
			{
				EmpField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(1, "S"+EmpField.getText());
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
			
			if(BasField.getText().isEmpty())
			{
				BasField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(7, BasField.getText());
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
					JOptionPane.showMessageDialog(null, "Highest Possible Grade is 100!");
					GraField.setBackground(new Color(240,50,20));
					count += 1;
				}
				else
				{
					pst.setString(8, GraField.getText());	
				}
			}
			if(SalField.getText().isEmpty())
			{
				SalField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(9, SalField.getText());
			}
			
			
			pst.setString(10, ActField.getText());

			
	
			
			
			if (count > 0)
			{
				JOptionPane.showMessageDialog(null, "Conditions not met, check tooltip.");
				//count = 0;
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
					JOptionPane.showMessageDialog(null, "Salesperson ID already exists, try a new one.");
				}
			}
		}
		catch (Exception e)
		{
			//JOptionPane.showMessageDialog(null, "One of the required field(s) is either empty or too long!");
		}
		count= 0;
	}
	public void fields() 
	{
		JTextField[] fields = new JTextField[11];
		fields[0] = EmpField;
		fields[1] = NamField;
		fields[2] = SurField;
		fields[3] = AgeField;
		fields[4] = ConField;
		fields[5] = AddField;
		fields[6] = SalField;
		fields[7] = GraField;
		fields[8] = SalField;
		fields[9] = ActField;
		fields[10] = BasField;
		
		
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setBackground(Color.white);
		}
	}
	public void table()
	{
		try
		{
			String query = "select * from SalesPerson";
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
	{
		JTextField[] fields = new JTextField[11];
		fields[0] = EmpField;
		fields[1] = NamField;
		fields[2] = SurField;
		fields[3] = AgeField;
		fields[4] = ConField;
		fields[5] = AddField;
		fields[6] = SalField;
		fields[7] = GraField;
		fields[8] = SalField;
		fields[9] = ActField;
		fields[10] = BasField;

		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setText("");
		}

	}
	public void actualSal()
	{
		
	}
}
