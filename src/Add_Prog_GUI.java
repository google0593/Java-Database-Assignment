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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.sql.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Add_Prog_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField EmpField;
	private JTextField NamField;
	private JTextField SurField;
	private JTextField AgeField;
	private JTextField ConField;
	private JTextField AddField;
	private JTextField SalField;
	private JTextField GraField;
	private JTable table;
	private JCheckBox checkbox1,checkbox2,checkbox3;


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
					Add_Prog_GUI frame = new Add_Prog_GUI();
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
	public Add_Prog_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		connection = sqlConnection.dbConnector();
		setTitle("Add Programmer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		//Needs drop box
		
		JLabel lblSoftware = new JLabel("Software");
		lblSoftware.setBounds(20, 270, 100, 14);
		contentPane.add(lblSoftware);
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
		
		SalField = new JTextField();
		SalField.setToolTipText(tp.salary());
		/*Restricting Input to Numbers Only*/
		SalField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE|| c == KeyEvent.VK_PERIOD))
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(62, 338, 89, 23);
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
		btnCancel.setBounds(161, 338, 89, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 27, 511, 334);
		contentPane.add(scrollPane);

		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		checkbox1 = new JCheckBox("Dr. Java");
		checkbox2 = new JCheckBox("Eclipse");
		checkbox3 = new JCheckBox("Netbeans");
		
		
		JButton btnNewButton = new JButton("Select Software");
		btnNewButton.setToolTipText(tp.software());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Select sotfware(s)";
				//Object[] params = {message, checkbox1, checkbox2, checkbox3, "Other:"};
				Object[] params = {message, checkbox1, checkbox2, checkbox3};
				int a = JOptionPane.showConfirmDialog(null, params, "List of sofwares", JOptionPane.YES_NO_OPTION);
				//String a = JOptionPane.showInputDialog(null, params, "List of softwares",JOptionPane.INFORMATION_MESSAGE);
				//JOptionPane.showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue)
				//String a = JOptionPane.showInputDialog(null, params, "Hello", JOptionPane.OK_CANCEL_OPTION);
				//Backup in case of adding more
				if(a == JOptionPane.OK_OPTION)
				//if(a.equals(JOptionPane.OK_OPTION))
				{
					checkbox1.setSelected(false);
					checkbox2.setSelected(false);
					checkbox3.setSelected(false);
				}
		
			}
		});
		btnNewButton.setBounds(110, 266, 140, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("*Mouseover the text field for more info");
		label.setEnabled(false);
		label.setBounds(20, 295, 235, 14);
		contentPane.add(label);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{EmpField, NamField, SurField, AgeField, ConField, AddField, SalField, GraField, btnNewButton, btnSave, btnCancel}));
		
		

		table();
		//Needs drop box
	}
	public void save() 
	{
		/*Start of invoke*/
		fields();
		int count = 0;
		int checkbox = 0;
		try
		{
			String query = "insert into Programmer (EmployeeID,Name,Surname,Age,'Contact#',Address,Salary,Grade,DrJava,Eclipse,Netbeans) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			
			if(EmpField.getText().isEmpty() || EmpField.getText().length() >= 6)
			{
				EmpField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(1,"P"+EmpField.getText().toUpperCase());
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
					/*JOptionPane.showMessageDialog(null, "Highest Possible Grade is 100!");	*/
				}
				else
				{
					pst.setString(8, GraField.getText());
				}
				
			}
			
			
			if(checkbox1.isSelected())
			{
				pst.setString(9, "Yes");
			}
			else
			{
				checkbox += 1;
			}
			
			if(checkbox2.isSelected())
			{
				pst.setString(10, "Yes");
			}
			else
			{
				checkbox += 1;
			}
			
			if(checkbox3.isSelected())
			{
				pst.setString(11, "Yes");
			}
			else
			{
				checkbox += 1;
			}
			
			if(checkbox1.isSelected() || checkbox2.isSelected() || checkbox3.isSelected())
			{
				checkbox = 0;
			}
			else
			{
			}
			
			if (count > 0 || checkbox > 0)
			{
				JOptionPane.showMessageDialog(null, "Conditions not met, check tooltip.");
			}
			else if(count == 0 && checkbox == 0)
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
					JOptionPane.showMessageDialog(null, "Programmer ID already exists, try a new one.");
				}
			}
		}
		catch (Exception e)
		{
		}
		checkbox = 0;
		count = 0;
	}
	public void fields() 
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
	{
		try
		{
			String query = "select * from Programmer";
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
		checkbox1.setSelected(false);
		checkbox2.setSelected(false);
		checkbox3.setSelected(false);
	}
}
