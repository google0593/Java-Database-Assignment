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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class Add_Mgr_GUI extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField empField;
	private JTextField nameField;
	private JTextField surField;
	private JTextField ageField;
	private JTextField contField;
	private JTextField addField;
	private JTextField salField;
	private JTextField parField;
	private JTextField makeField;
	private JTextField modField;
	private JTextField regField;
	private JComboBox<String> carTypes;

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
					Add_Mgr_GUI frame = new Add_Mgr_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public Add_Mgr_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		
		connection = sqlConnection.dbConnector();
	
		setTitle("Add Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*start of labels*/
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(20, 30, 84, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 60, 84, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(20, 90, 84, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(20, 120, 84, 14);
		contentPane.add(lblAge);
		
		JLabel lblContactNumber = new JLabel("Contact #:");
		lblContactNumber.setBounds(20, 150, 84, 14);
		contentPane.add(lblContactNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(20, 180, 84, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(20, 210, 84, 14);
		contentPane.add(lblSalary);
		
		JLabel lblMake = new JLabel("Make");
		lblMake.setBounds(20, 300, 46, 14);
		contentPane.add(lblMake);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(20, 330, 46, 14);
		contentPane.add(lblModel);
		
		JLabel lblReg = new JLabel("Regisration");
		lblReg.setBounds(20, 360, 70, 14);
		contentPane.add(lblReg);
		
		JLabel lblCar = new JLabel("Car:");
		lblCar.setBounds(20, 240, 84, 14);
		contentPane.add(lblCar);
		
		JLabel lblParkingArea = new JLabel("Parking Area (1-50)");
		lblParkingArea.setBounds(20, 270, 99, 14);
		contentPane.add(lblParkingArea);
		/*end of labels*/
		ToolTip tp = new ToolTip();
		/*start of field/types*/
		empField = new JTextField();
		empField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		empField.setToolTipText(tp.empID());
		empField.setBounds(128, 24, 140, 20);
		contentPane.add(empField);
		empField.setColumns(10);
		
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter() {
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
		nameField.setToolTipText(tp.name());
		nameField.setColumns(10);
		nameField.setBounds(128, 54, 140, 20);
		contentPane.add(nameField);
		
		surField = new JTextField();
		surField.addKeyListener(new KeyAdapter() {
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
		surField.setToolTipText(tp.surname());
		surField.setColumns(10);
		surField.setBounds(128, 84, 140, 20);
		contentPane.add(surField);
		
		ageField = new JTextField();
		ageField.setToolTipText(tp.age());
		ageField.addKeyListener(new KeyAdapter() { /*DEL DEL https://www.youtube.com/watch?v=9B5ZgItFxNA*/			
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();
					evt.consume();
				}
				
			}
		});
		ageField.setColumns(10);
		ageField.setBounds(128, 114, 140, 20);
		contentPane.add(ageField);
		
		contField = new JTextField();
		contField.setToolTipText(tp.contact());
		contField.addKeyListener(new KeyAdapter() {
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
		contField.setColumns(10);
		contField.setBounds(128, 144, 140, 20);
		contentPane.add(contField);
		
		addField = new JTextField();
		addField.setToolTipText(tp.address());
		addField.setColumns(10);
		addField.setBounds(128, 174, 140, 20);
		contentPane.add(addField);
		
		salField = new JTextField();
		salField.setToolTipText(tp.salary());
		salField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD))
				{
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		salField.setColumns(10);
		salField.setBounds(128, 204, 140, 20);
		contentPane.add(salField);
		
		carTypes = new JComboBox<String>(new DefaultComboBoxModel(new String[] {"--------Select Car--------", "Toyota", "Honda", "Jeep"}));
		carTypes.setToolTipText(tp.car());
		carTypes.setBounds(128, 237, 140, 20);
		contentPane.add(carTypes);
		
		parField = new JTextField();
		parField.setToolTipText(tp.park());
		parField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		parField.setBounds(128, 264, 140, 20);
		contentPane.add(parField);
		parField.setColumns(10);
		
		makeField = new JTextField();
		makeField.setToolTipText(tp.make());
		makeField.setBounds(128, 294, 140, 20);
		contentPane.add(makeField);
		makeField.setColumns(10);
		
		modField = new JTextField();
		modField.setToolTipText(tp.model());
		modField.setBounds(128, 324, 140, 20);
		contentPane.add(modField);
		modField.setColumns(10);
		
		regField = new JTextField();
		regField.setToolTipText(tp.rego());
		regField.setBounds(128, 354, 140, 20);
		contentPane.add(regField);
		regField.setColumns(10);
		
		
		/*end of field/types*/
		
		/*start of button*/
		JButton btnSave = new JButton("Add");
		btnSave.setIcon(new ImageIcon("Resources/save.png"));

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
		});
		
		btnSave.setBounds(80, 397, 89, 23);
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
		
		btnCancel.setBounds(179, 397, 89, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 24, 600, 396);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblInfo = new JLabel("*Mouseover the text field for more info");
		lblInfo.setEnabled(false);
		lblInfo.setBounds(20, 380, 235, 14);
		contentPane.add(lblInfo);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{empField, nameField, surField, ageField, contField, addField, salField, carTypes, parField, makeField, modField, regField, btnSave, btnCancel}));
		table();
		/*end of buttons*/
		
	}
	public void save()
	{
		/*Start of invoke*/
		fields();
		int count = 0;

		try
		{	
			
			String query = "insert into Manager (EmployeeID,Name,Surname,Age,'Contact#',Address,Salary,Car,ParkingArea,Make,Model,Registration) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			
			
			if(empField.getText().isEmpty() || empField.getText().length() >= 6)
			{
				empField.setBackground(new Color(240,50,20));
				//JOptionPane.showMessageDialog(null, "Employee ID Field is either empty or too long!", "Error", JOptionPane.ERROR_MESSAGE);
				count += 1;
				/*tool tip*/
			}
			else
			{
				pst.setString(1, "M"+empField.getText().toUpperCase());
			}
			
			if(nameField.getText().isEmpty())
			{
				nameField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(2, nameField.getText());
				
			}
			
			if(surField.getText().isEmpty())
			{
				surField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(3, surField.getText());
			}
			
			if(ageField.getText().isEmpty())
			{
				ageField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(4, ageField.getText());
			}
			
			if(contField.getText().isEmpty())
			{
				contField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(5, contField.getText());
			}
			
			if(addField.getText().isEmpty())
			{
				addField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(6, addField.getText());
			}
			
			if(salField.getText().isEmpty())
			{
				salField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(7, salField.getText());
			}
			String car = carTypes.getSelectedItem().toString();
			
			if(car.equals("--------Select Car--------"))
			{

				count += 1;
				//	JOptionPane.showMessageDialog(null, "You must select a car");
			}
			else
			{
				String a = carTypes.getSelectedItem().toString();
				pst.setString(8, a);
			}
			
			if(parField.getText().isEmpty())
			{
				parField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				int par = Integer.parseInt(parField.getText());
				if(par >= 1 && par <= 50)
				{
					pst.setString(9, parField.getText());
				}
				else
				{
					parField.setBackground(new Color(240,50,20));
					count += 1;
					
				}
			}
			
			
			if(makeField.getText().isEmpty())
			{
				makeField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(10, makeField.getText());
			}
			
			if(modField.getText().isEmpty())
			{
				modField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(11, modField.getText());
			}
			
			if(regField.getText().isEmpty())
			{
				regField.setBackground(new Color(240,50,20));
				count += 1;
			}
			else
			{
				pst.setString(12, regField.getText());
			}
			
			
			if(count > 0)
			{
				JOptionPane.showMessageDialog(null, "Conditions not met, check tooltip.");
				/*count = 0;*/
			}
			else if(count == 0)
			{
				try 
				{
					
					
					pst.execute();
					pst.close();
					clearFields();
					JOptionPane.showMessageDialog(null, "Data has been added");
					
					
					
					table();
					
				}
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Manager ID already exists, try a new one/Parking area is already taken.");
				}
			}
			count = 0;	
			
		}
		catch(Exception e)
		{
		}

		
		/*end of invoke*/
	}
	public void fields()
	{
		JTextField[] fields = new JTextField[11];

		fields[0] = empField;
		fields[1] = nameField;
		fields[2] = surField;
		fields[3] = ageField;
		fields[4] = contField;
		fields[5] = addField;
		fields[6] = salField;
		fields[7] = parField;
		fields[8] = makeField;
		fields[9] = modField;
		fields[10] = regField;
		
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setBackground(Color.white);
		}
		
	}
	public void clearFields()
	{
		JTextField[] fields = new JTextField[11];
		fields[0] = empField;
		fields[1] = nameField;
		fields[2] = surField;
		fields[3] = ageField;
		fields[4] = contField;
		fields[5] = addField;
		fields[6] = salField;
		fields[7] = parField;
		fields[8] = makeField;
		fields[9] = modField;
		fields[10] = regField;
		carTypes.setSelectedIndex(0);
		
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setText("");
		}
	}
	public void table()
	{
		try
		{
			String query = "select * from Manager";
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
}
