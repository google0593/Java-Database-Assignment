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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import net.proteanit.sql.DbUtils;


public class Edit_Sales_GUI extends JFrame {

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
	private JTextField NamField1;
	private JTextField SurField1;
	private JTextField AgeField1;
	private JTextField ConField1;
	private JTextField AddField1;
	private JTextField BasField1;
	private JTextField GraField1;
	private JTextField SalField1;
	private JTextField ActField1;
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
					Edit_Sales_GUI frame = new Edit_Sales_GUI();
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
	Connection connection = null;
	private JTextField searchField;
	private JLabel lblSearch;
	private JLabel label_1;
	
	public Edit_Sales_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		connection = sqlConnection.dbConnector();
		
		setTitle("Edit Salesperson Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Labels Start*/
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(20, 51, 100, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 81, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(20, 111, 100, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(20, 141, 100, 14);
		contentPane.add(lblAge);
		
		JLabel lblContactNumber = new JLabel("Contact #:");
		lblContactNumber.setBounds(20, 171, 100, 14);
		contentPane.add(lblContactNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(20, 201, 100, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("Base Salary:");
		lblSalary.setBounds(20, 231, 100, 14);
		contentPane.add(lblSalary);
		
		JLabel lblGrade = new JLabel("Grade (0-100):");
		lblGrade.setBounds(20, 261, 80, 14);
		contentPane.add(lblGrade);
		
		JLabel lblNewLabel = new JLabel("Sales Volume:");
		lblNewLabel.setBounds(20, 291, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Commission Rate:");
		lblNewLabel_1.setBounds(20, 321, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Actual Salary:");
		lblNewLabel_2.setBounds(20, 351, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("5%");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(136, 321, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		/*Labels End*/
		
		/*TextFields Begin*/
		
		EmpField = new JTextField();
		EmpField.setEditable(false);
		/*Restricting Input to Numbers Only*/
		
		JLabel label = new JLabel("5%");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(299, 321, 100, 14);
		contentPane.add(label);
		EmpField.setBounds(110, 48, 140, 20);
		contentPane.add(EmpField);
		EmpField.setColumns(10);
		
		NamField = new JTextField();
		NamField.setEditable(false);
		/*Restricting Input to Letters Only*/
		NamField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		NamField.setColumns(10);
		NamField.setBounds(110, 78, 140, 20);
		contentPane.add(NamField);
		
		SurField = new JTextField();
		SurField.setEditable(false);
		/*Restricting Input to Letters Only*/
		SurField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
						{
						getToolkit().beep();
						evt.consume();
						}
			}
		});
		SurField.setColumns(10);
		SurField.setBounds(110, 108, 140, 20);
		contentPane.add(SurField);
		
		AgeField = new JTextField();
		AgeField.setEditable(false);
		/*Restricting Input to Numbers Only*/
		AgeField.setColumns(10);
		AgeField.setBounds(110, 138, 140, 20);
		contentPane.add(AgeField);
		
		ConField = new JTextField();
		ConField.setEditable(false);
		/*Restricting Input to Numbers Only*/
		ConField.setColumns(10);
		ConField.setBounds(110, 168, 140, 20);
		contentPane.add(ConField);
		
		AddField = new JTextField();
		AddField.setEditable(false);
		AddField.setColumns(10);
		AddField.setBounds(110, 198, 140, 20);
		contentPane.add(AddField);
		
		BasField = new JTextField();
		BasField.setEditable(false);
		/*Restricting Input to Numbers Only*/
		BasField.setColumns(10);
		BasField.setBounds(110, 228, 140, 20);
		contentPane.add(BasField);
		
		GraField = new JTextField();
		GraField.setEditable(false);
		GraField.setColumns(10);
		GraField.setBounds(110, 258, 140, 20);
		contentPane.add(GraField);
		
		SalField = new JTextField();
		SalField.setEditable(false);
		SalField.setColumns(10);
		SalField.setBounds(110, 288, 140, 20);
		contentPane.add(SalField);
		
		ActField = new JTextField();
		ActField.setEditable(false);
		ActField.setColumns(10);
		ActField.setBounds(110, 349, 140, 20);
		contentPane.add(ActField);
		
		//for Updating 
		
		/*	EmpField1 = new JTextField();
		EmpField1.setColumns(10);
		EmpField1.setBounds(273, 27, 140, 20);
		contentPane.add(EmpField1);*/
		
		NamField1 = new JTextField();
		NamField1.addKeyListener(new KeyAdapter() {
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
		NamField1.setColumns(10);
		NamField1.setBounds(273, 78, 140, 20);
		contentPane.add(NamField1);
		
		SurField1 = new JTextField();
		SurField1.addKeyListener(new KeyAdapter() {
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
		SurField1.setColumns(10);
		SurField1.setBounds(273, 108, 140, 20);
		contentPane.add(SurField1);
		
		AgeField1 = new JTextField();
		AgeField1.addKeyListener(new KeyAdapter() {
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
		AgeField1.setColumns(10);
		AgeField1.setBounds(273, 138, 140, 20);
		contentPane.add(AgeField1);
		
		ConField1 = new JTextField();
		ConField1.addKeyListener(new KeyAdapter() {
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
		ConField1.setColumns(10);
		ConField1.setBounds(273, 168, 140, 20);
		contentPane.add(ConField1);
		
		AddField1 = new JTextField();
		AddField1.setColumns(10);
		AddField1.setBounds(273, 198, 140, 20);
		contentPane.add(AddField1);
		
		BasField1 = new JTextField();
		BasField1.addKeyListener(new KeyAdapter() {
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
						actual();
					}
					catch(Exception e)
					{
							
					}
						
						
				}
			}
		});
		BasField1.setColumns(10);
		BasField1.setBounds(273, 228, 140, 20);
		contentPane.add(BasField1);
		
		GraField1 = new JTextField();
		GraField1.addKeyListener(new KeyAdapter() {
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
		GraField1.setColumns(10);
		GraField1.setBounds(273, 258, 140, 20);
		contentPane.add(GraField1);
		
		SalField1 = new JTextField();
		SalField1.addKeyListener(new KeyAdapter() {
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
						actual();
					}
					catch(Exception e)
					{
							
					}
						
						
				}
			}
		});
		SalField1.setColumns(10);
		SalField1.setBounds(273, 288, 140, 20);
		contentPane.add(SalField1);
		
		ActField1 = new JTextField();
		ActField1.setEditable(false);
		ActField1.setColumns(10);
		ActField1.setBounds(273, 349, 140, 20);
		contentPane.add(ActField1);

		
		/*Text Fields End*/
		
		/*Buttons Begin*/
		
		JButton btnSave = new JButton("Update");
		btnSave.setIcon(new ImageIcon("Resources/update.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
/*				Calculate for Actual Salary
				double salary = Double.parseDouble(BasField.getText());
				double sales_volume = Double.parseDouble(SalField.getText());
				double Actual_Salary = salary + (sales_volume *.05);
				
				Display Actual Salary
				ActField.setText(""+Actual_Salary);
												*/
				save();			
			}
		});
		btnSave.setBounds(110, 398, 89, 23);
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
		btnCancel.setBounds(310, 398, 89, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(421, 48, 514, 373);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				update();
			}
		});
		scrollPane.setViewportView(table);

		
		JButton btnDel = new JButton("Delete");
		btnDel.setIcon(new ImageIcon("Resources/delete.png"));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDel.setBounds(211, 398, 89, 23);
		contentPane.add(btnDel);
		
		searchField = new JTextField();
		searchField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(searchField.getText().equals("Enter name/EmployeeID..."))
				{
					searchField.setText("");
					searchField.setForeground(Color.BLACK);
				}
			}
		});
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		searchField.setForeground(Color.LIGHT_GRAY);
		searchField.setText("Enter name/EmployeeID...");
		searchField.setBounds(779, 17, 156, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		lblSearch = new JLabel("Search:");
		lblSearch.setBounds(723, 20, 46, 14);
		contentPane.add(lblSearch);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(779, 20, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		label_1 = new JLabel("*Mouseover the text field for more info");
		label_1.setEnabled(false);
		label_1.setBounds(20, 376, 235, 14);
		contentPane.add(label_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{NamField1, SurField1, AgeField1, ConField1, AddField1, BasField1, GraField1, SalField1, btnSave, btnDel, btnCancel}));
		ToolTip tp = new ToolTip();
		NamField1.setToolTipText(tp.name());
		SurField1.setToolTipText(tp.surname());
		AgeField1.setToolTipText(tp.age());
		ConField1.setToolTipText(tp.contact());
		AddField1.setToolTipText(tp.address());
		BasField1.setToolTipText(tp.baseSalary());
		GraField1.setToolTipText(tp.grade());
		SalField1.setToolTipText(tp.salesV());
		ActField1.setToolTipText(tp.actSalary());
		
		table();
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
	public void update()
	{
		clearField();
		try
		{
			int row = table.getSelectedRow();
			System.out.println(row);
			String Emp =(table.getModel().getValueAt(row, 0).toString());
			String query = "select * from SalesPerson where EmployeeID = '"+Emp+"' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				EmpField.setText(rs.getString("EmployeeID").toUpperCase());
				NamField.setText(rs.getString("Name"));
				SurField.setText(rs.getString("Surname"));
				AgeField.setText(rs.getString("Age"));
				ConField.setText(rs.getString("Contact#"));
				AddField.setText(rs.getString("Address"));
				BasField.setText(rs.getString("BaseSalary"));
				GraField.setText(rs.getString("Grade"));
				SalField.setText(rs.getString("SalesVolume"));
				ActField.setText(rs.getString("ActualSalary"));
				
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
			String empID = JOptionPane.showInputDialog(null, "Please enter the salespersons ID you wish to delete", "Delete salesperson data", JOptionPane.PLAIN_MESSAGE).toUpperCase();
			String query0 = "select * from Salesperson where EmployeeID=?";
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
					String query = "delete from Salesperson where EmployeeID = '"+empID+"' ";
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.execute();
					pst1.close();
					JOptionPane.showMessageDialog(null, "Employee ID " + empID + " has been deleted from the salespersons record");
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
		String gra = null;
		if(EmpField.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Please select a data.");
		}
		else
		{
			try
			{
				
				if(NamField1.getText().isEmpty())
				{
					NamField1.setText(NamField.getText());
				}
				else
				{

				}
				
				if(SurField1.getText().isEmpty())
				{
					SurField1.setText(SurField.getText());
				}
				else
				{
				}
				
				if(AgeField1.getText().isEmpty())
				{
					AgeField1.setText(AgeField.getText());
				}
				else
				{
				}
				
				if(ConField1.getText().isEmpty())
				{
					ConField1.setText(ConField.getText());
				}
				else
				{
				}
				
				if(AddField1.getText().isEmpty())
				{
					AddField1.setText(AddField.getText());
				}
				else
				{
				}
				
				if(BasField1.getText().isEmpty())
				{
					BasField1.setText(BasField.getText());
				}
				else
				{
		
				}
		
				
				if(GraField1.getText().isEmpty())
				{
					GraField1.setText(GraField.getText());
				}
				else
				{
					int grade = Integer.parseInt(GraField1.getText());
					if (grade>100)
					{
						JOptionPane.showMessageDialog(null, "Highest Possible Grade is 100!");
						count += 1;
					}
					else
					{
					}
				}
				
				
				
				
				
				if(SalField1.getText().isEmpty())
				{
					SalField1.setText(SalField.getText());
				}
				else
				{
				}
				
				if(ActField1.getText().isEmpty())
				{
					ActField1.setText(ActField.getText());
				}
				else
				{
				}
				
				actual();
				
				if(count==0)
				{
					String query ="update SalesPerson set Name='"+NamField1.getText()+"' , Surname='"+SurField1.getText()+"' , Age='"+AgeField1.getText()+"' , 'Contact#'='"+ConField1.getText()+"' , Address='"+AddField1.getText()+"' , BaseSalary='"+BasField1.getText()+"' , Grade='"+GraField1.getText()+"', SalesVolume='"+SalField1.getText()+"' , ActualSalary='"+ActField1.getText()+"' where EmployeeID = '"+EmpField.getText()+"' ";
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
				e.printStackTrace();
			}
		}
		
	}
	public void actual()
	{
		double salary = Double.parseDouble(BasField1.getText());
		double sales_volume = Double.parseDouble(SalField1.getText());
		double Actual_Salary = salary + (sales_volume *.05);
		ActField1.setText(""+Actual_Salary);
		
	}
	public void search()
	{
		try
		{
			String query = "SELECT * from Salesperson where Name LIKE '"+searchField.getText()+"%' OR  EmployeeID LIKE '"+searchField.getText()+"%' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			pst.close();
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void clearField()
	{
		JTextField[] fields = new JTextField[9];
		fields[0] = NamField1;
		fields[1] = SurField1;
		fields[2] = AgeField1;
		fields[3] = ConField1;
		fields[4] = AddField1;
		fields[5] = BasField1;
		fields[6] = GraField1;
		fields[7] = SalField1;
		fields[8] = ActField1;
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setText("");
		}
	}
}
