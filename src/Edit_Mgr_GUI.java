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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Edit_Mgr_GUI extends JFrame {
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
	private JTextField nameField1;
	private JTextField surField1;
	private JTextField ageField1;
	private JTextField contField1;
	private JTextField addField1;
	private JTextField salField1;
	private JTextField parField1;
	private JTextField makeField1;
	private JTextField modField1;
	private JTextField regField1;
	private JTable table;
	private JScrollPane scrollPane;
	

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
					Edit_Mgr_GUI frame = new Edit_Mgr_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	Connection connection=null;
	private JComboBox carTypes1;
	private JComboBox carTypes;
	private JTextField searchField;
	private JLabel lblSearch;
	private JLabel label;
	public Edit_Mgr_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		connection = sqlConnection.dbConnector();
		setTitle("Edit Manager Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 500);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*start of labels*/
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(20, 47, 84, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 77, 84, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(20, 107, 84, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(20, 137, 84, 14);
		contentPane.add(lblAge);
		
		JLabel lblContactNumber = new JLabel("Contact #:");
		lblContactNumber.setBounds(20, 167, 84, 14);
		contentPane.add(lblContactNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(20, 197, 84, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(20, 227, 84, 14);
		contentPane.add(lblSalary);
		
		JLabel lblMake = new JLabel("Make");
		lblMake.setBounds(20, 317, 46, 14);
		contentPane.add(lblMake);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(20, 347, 46, 14);
		contentPane.add(lblModel);
		
		JLabel lblReg = new JLabel("Regisration");
		lblReg.setBounds(20, 377, 70, 14);
		contentPane.add(lblReg);
		
		JLabel lblCar = new JLabel("Car:");
		lblCar.setBounds(20, 257, 84, 14);
		contentPane.add(lblCar);
		
		JLabel lblParkingArea = new JLabel("Parking Area (1-50)");
		lblParkingArea.setBounds(20, 287, 99, 14);
		contentPane.add(lblParkingArea);
		/*end of labels*/
		
		/*start of field/types*/
		
		empField = new JTextField();
		empField.setEditable(false);
		empField.setBounds(128, 41, 140, 20);
		contentPane.add(empField);
		empField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(128, 71, 140, 20);
		contentPane.add(nameField);
		nameField.setEditable(false);
		
		surField = new JTextField();
		surField.setColumns(10);
		surField.setBounds(128, 101, 140, 20);
		contentPane.add(surField);
		surField.setEditable(false);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(128, 131, 140, 20);
		contentPane.add(ageField);
		ageField.setEditable(false);
		
		contField = new JTextField();
		contField.setColumns(10);
		contField.setBounds(128, 161, 140, 20);
		contentPane.add(contField);
		contField.setEditable(false);
		
		addField = new JTextField();
		addField.setColumns(10);
		addField.setBounds(128, 191, 140, 20);
		contentPane.add(addField);
		addField.setEditable(false);
		
		carTypes = new JComboBox();
		carTypes.setEnabled(false);
		carTypes.setModel(new DefaultComboBoxModel(new String[] {"--------Select Car--------", "Toyota", "Honda", "Jeep"}));
		carTypes.setToolTipText("Select a car");
		carTypes.setBounds(128, 254, 140, 20);
		contentPane.add(carTypes);
		
		salField = new JTextField();
		salField.setColumns(10);
		salField.setBounds(128, 221, 140, 20);
		contentPane.add(salField);
		salField.setEditable(false);
		
		parField = new JTextField();
		parField.setBounds(128, 281, 140, 20);
		contentPane.add(parField);
		parField.setColumns(10);
		parField.setEditable(false);
		
		makeField = new JTextField();
		makeField.setBounds(128, 311, 140, 20);
		contentPane.add(makeField);
		makeField.setColumns(10);
		makeField.setEditable(false);
		
		modField = new JTextField();
		modField.setBounds(128, 341, 140, 20);
		contentPane.add(modField);
		modField.setColumns(10);
		modField.setEditable(false);
		
		regField = new JTextField();
		regField.setBounds(128, 371, 140, 20);
		contentPane.add(regField);
		regField.setColumns(10);
		regField.setEditable(false);
		
		nameField1 = new JTextField();
		nameField1.addKeyListener(new KeyAdapter() {
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
		nameField1.setBounds(300, 71, 140, 20);
		contentPane.add(nameField1);
		nameField1.setColumns(10);
		
		surField1 = new JTextField();
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
		surField1.setBounds(300, 101, 140, 20);
		contentPane.add(surField1);
		surField1.setColumns(10);
		
		ageField1 = new JTextField();
		ageField1.addKeyListener(new KeyAdapter() {
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
		ageField1.setBounds(300, 131, 140, 20);
		contentPane.add(ageField1);
		ageField1.setColumns(10);
		
		contField1 = new JTextField();
		contField1.addKeyListener(new KeyAdapter() {
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
		contField1.setBounds(300, 161, 140, 20);
		contentPane.add(contField1);
		contField1.setColumns(10);
		
		addField1 = new JTextField();
		addField1.setBounds(300, 191, 140, 20);
		contentPane.add(addField1);
		addField1.setColumns(10);
		
		salField1 = new JTextField();
		salField1.addKeyListener(new KeyAdapter() {
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
		salField1.setBounds(300, 221, 140, 20);
		contentPane.add(salField1);
		salField1.setColumns(10);
		
		parField1 = new JTextField();
		parField1.addKeyListener(new KeyAdapter() {
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
		
		carTypes1 = new JComboBox();
		carTypes1.setToolTipText("Select a car");
		carTypes1.setModel(new DefaultComboBoxModel(new String[] {"--------Select Car--------", "Toyota", "Honda", "Jeep"}));
		carTypes1.setBounds(300, 251, 140, 20);
		
		contentPane.add(carTypes1);
		parField1.setBounds(300, 281, 140, 20);
		contentPane.add(parField1);
		parField1.setColumns(10);
		
		makeField1 = new JTextField();
		makeField1.setBounds(300, 311, 140, 20);
		contentPane.add(makeField1);
		makeField1.setColumns(10);
		
		modField1 = new JTextField();
		modField1.setBounds(300, 341, 140, 20);
		contentPane.add(modField1);
		modField1.setColumns(10);
		
		regField1 = new JTextField();
		regField1.setBounds(300, 371, 140, 20);
		contentPane.add(regField1);
		regField1.setColumns(10);
		
		
		/*end of field/types*/
		
		/*start of button*/
		JButton btnSave = new JButton("Update");
		btnSave.setIcon(new ImageIcon("Resources/update.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(153, 414, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main_Admin_GUI cancel = new Main_Admin_GUI();
				cancel.cancel();
			}
		});
		btnCancel.setIcon(new ImageIcon("Resources/back.png"));
		btnCancel.setBounds(351, 414, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnDel = new JButton("Delete");
		btnDel.setIcon(new ImageIcon("Resources/delete.png"));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete();
			}
		});
		btnDel.setBounds(252, 414, 89, 23);
		contentPane.add(btnDel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 41, 600, 396);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				update();
			}
		});
		scrollPane.setViewportView(table);
		
		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				search();
			}
		});
		searchField.setForeground(Color.LIGHT_GRAY);
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
		searchField.setText("Enter name/EmployeeID...");
		searchField.setBounds(894, 11, 156, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		lblSearch = new JLabel("Search:");
		lblSearch.setBounds(838, 14, 46, 14);
		contentPane.add(lblSearch);
		
		label = new JLabel("*Mouseover the text field for more info");
		label.setEnabled(false);
		label.setBounds(20, 395, 235, 14);
		contentPane.add(label);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblEmployeeId, lblName, lblSurname, lblAge, lblContactNumber, lblAddress, lblSalary, lblMake, lblModel, lblReg, lblCar, lblParkingArea, empField, nameField, surField, ageField, contField, addField, carTypes, salField, parField, makeField, modField, regField, nameField1, surField1, ageField1, contField1, addField1, salField1, carTypes1, parField1, makeField1, modField1, regField1, btnSave, btnCancel, btnDel, scrollPane, table, lblSearch, label}));
		ToolTip tp = new ToolTip();
		nameField1.setToolTipText(tp.name());
		surField1.setToolTipText(tp.surname());
		ageField1.setToolTipText(tp.age());
		contField1.setToolTipText(tp.contact());
		addField1.setToolTipText(tp.address());
		salField1.setToolTipText(tp.salary());
		carTypes1.setToolTipText(tp.car());
		parField1.setToolTipText(tp.park());
		makeField1.setToolTipText(tp.make());
		modField1.setToolTipText(tp.model());
		regField1.setToolTipText(tp.rego());
		
		
		
		table();
		
		
		/*end of buttons*/
		
	}
	public void save()
	{
		/*Start of invoke*/
		int count = 0;
		if(empField.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Please select a data.");
		}
		else
		{
			try
			{
				
				if(nameField1.getText().isEmpty())
				{
					nameField1.setText(nameField.getText());
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
				
				if(contField1.getText().isEmpty())
				{
					contField1.setText(contField.getText());
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
				
				if(carTypes1.getSelectedIndex() == 0)
				{
					carTypes1.setSelectedItem(carTypes.getSelectedItem());

				}
				else
				{
					
				}
				
				
				
				if(parField1.getText().isEmpty())
				{
					parField1.setText(parField.getText());
				}
				else
				{
					int par = Integer.parseInt(parField1.getText());
					if(par >= 1 && par <= 50)
					{
						parField1.setBackground(Color.white);
					}
					else
					{
						parField1.setBackground(new Color(240,50,20));
						count += 1;
						
					}
				}
				
				
				if(makeField1.getText().isEmpty())
				{
					makeField1.setText(makeField.getText());
				}
				else
				{

				}
				
				if(modField1.getText().isEmpty())
				{
					modField1.setText(modField.getText());
				}
				else
				{
				}
				 
				if(regField1.getText().isEmpty())
				{
					regField1.setText(regField.getText());
				}
				else
				{
				}
				
				
				if(count==0)
				{
					String query ="update Manager set Name='"+nameField1.getText()+"' , Surname='"+surField1.getText()+"' , Age='"+ageField1.getText()+"' , 'Contact#'='"+contField1.getText()+"' , Address='"+addField1.getText()+"' , Salary='"+salField1.getText()+"' , Car='"+carTypes1.getSelectedItem().toString()+"' , ParkingArea='"+parField1.getText()+"' , Make='"+makeField1.getText()+"' , Model='"+modField1.getText()+"' , Registration='"+regField1.getText()+"' where EmployeeID = '"+empField.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null, "Table has been updated");
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
		
		
		
		
		/*end of invoke*/
	}	
	public void update()
	{
		clearFields();
		try
		{
			int row = table.getSelectedRow();
			System.out.println(row);
			String Emp =(table.getModel().getValueAt(row, 0).toString());
			String query = "select * from Manager where EmployeeID = '"+Emp+"' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				empField.setText(rs.getString("EmployeeID").toUpperCase());
				nameField.setText(rs.getString("Name"));
				surField.setText(rs.getString("Surname"));
				ageField.setText(rs.getString("Age"));
				contField.setText(rs.getString("Contact#"));
				addField.setText(rs.getString("Address"));
				salField.setText(rs.getString("Salary"));
				carTypes.setSelectedItem(rs.getString("Car"));
				parField.setText(rs.getString("ParkingArea"));
				makeField.setText(rs.getString("Make"));
				modField.setText(rs.getString("Model"));
				regField.setText(rs.getString("Registration"));
			}
			pst.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
	}
	public void delete()
	{
		try
		{
			String empID = JOptionPane.showInputDialog(null, "Please enter the managers ID you wish to delete", "Delete manager data", JOptionPane.PLAIN_MESSAGE).toUpperCase();
			String query0 = "select * from Manager where EmployeeID=?";
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
					String query = "delete from Manager where EmployeeID = '"+empID+"' ";
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.execute();
					pst1.close();
					JOptionPane.showMessageDialog(null, "Employee ID " + empID + " has been deleted from the managers record");
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
	public void table()
	{	
		try
		{
			String query1 = "select * from Manager";
			PreparedStatement pst = connection.prepareStatement(query1);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			
		}
	}
	public void search()
	{
		try
		{
			String query = "SELECT * from Manager where Name LIKE '"+searchField.getText()+"%' OR  EmployeeID LIKE '"+searchField.getText()+"%' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			pst.close();
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void clearFields()
	{
		JTextField[] fields = new JTextField[10];
		fields[0] = nameField1;
		fields[1] = surField1;
		fields[2] = ageField1;
		fields[3] = contField1;
		fields[4] = addField1;
		fields[5] = salField1;
		fields[6] = parField1;
		fields[7] = makeField1;
		fields[8] = modField1;
		fields[9] = regField1;
		carTypes1.setSelectedIndex(0);
		
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setText("");
		}
	}
}
