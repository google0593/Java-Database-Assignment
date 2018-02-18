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

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Edit_Prog_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField EmpField;
	private JTextField NameField;
	private JTextField SurField;
	private JTextField AgeField;
	private JTextField ConField;
	private JTextField AddField;
	private JTextField SalField;
	private JTextField GraField;
	private JTextField GraField1;
	private JTextField NameField1;
	private JTextField SurField1;
	private JTextField AgeField1;
	private JTextField ConField1;
	private JTextField AddField1;
	private JTextField SalField1;
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
					Edit_Prog_GUI frame = new Edit_Prog_GUI();
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
	private JTable table;
	private JButton btnDel;
	private JTextField searchField;
	private JLabel lblSearch;
	private JLabel label;
	public Edit_Prog_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		connection = sqlConnection.dbConnector();
		setTitle("Edit Programmer Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JLabels begin*/
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(10, 49, 100, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 79, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(10, 109, 100, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 139, 100, 14);
		contentPane.add(lblAge);
		
		JLabel lblContactNumber = new JLabel("Contact #:");
		lblContactNumber.setBounds(10, 169, 100, 14);
		contentPane.add(lblContactNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 199, 100, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(10, 229, 100, 14);
		contentPane.add(lblSalary);
		
		JLabel lblGrade = new JLabel("Grade (0-100):");
		lblGrade.setBounds(10, 259, 100, 14);
		contentPane.add(lblGrade);
		
		/*JLabels End*/
		/*JTextFields Begin*/
		
		EmpField = new JTextField();
		EmpField.setEditable(false);
		EmpField.setBounds(100, 46, 140, 20);
		contentPane.add(EmpField);
		EmpField.setColumns(10);
		
		NameField = new JTextField();
		NameField.setEditable(false);
		NameField.setColumns(10);
		NameField.setBounds(100, 76, 140, 20);
		contentPane.add(NameField);
		
		SurField = new JTextField();
		SurField.setEditable(false);
		SurField.setColumns(10);
		SurField.setBounds(100, 106, 140, 20);
		contentPane.add(SurField);
		
		AgeField = new JTextField();
		AgeField.setEditable(false);
		AgeField.setColumns(10);
		AgeField.setBounds(100, 136, 140, 20);
		contentPane.add(AgeField);
		
		ConField = new JTextField();
		ConField.setEditable(false);
		ConField.setColumns(10);
		ConField.setBounds(100, 166, 140, 20);
		contentPane.add(ConField);
		
		AddField = new JTextField();
		AddField.setEditable(false);
		AddField.setColumns(10);
		AddField.setBounds(100, 196, 140, 20);
		contentPane.add(AddField);
		
		SalField = new JTextField();
		SalField.setEditable(false);
		SalField.setColumns(10);
		SalField.setBounds(100, 226, 140, 20);
		contentPane.add(SalField);
		
		GraField = new JTextField();
		GraField.setEditable(false);
		GraField.setColumns(10);
		GraField.setBounds(100, 256, 140, 20);
		contentPane.add(GraField);
		
		GraField1 = new JTextField();
		GraField1.addKeyListener(new KeyAdapter() {
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
		GraField1.setColumns(10);
		GraField1.setBounds(260, 256, 140, 20);
		contentPane.add(GraField1);
		
		NameField1 = new JTextField();
		NameField1.addKeyListener(new KeyAdapter() {
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
		NameField1.setColumns(10);
		NameField1.setBounds(260, 76, 140, 20);
		contentPane.add(NameField1);
		
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
		SurField1.setBounds(260, 106, 140, 20);
		contentPane.add(SurField1);
		
		AgeField1 = new JTextField();
		AgeField1.addKeyListener(new KeyAdapter() {
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
		AgeField1.setColumns(10);
		AgeField1.setBounds(260, 136, 140, 20);
		contentPane.add(AgeField1);
		
		ConField1 = new JTextField();
		ConField1.addKeyListener(new KeyAdapter() {
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
		ConField1.setColumns(10);
		ConField1.setBounds(260, 166, 140, 20);
		contentPane.add(ConField1);
		
		AddField1 = new JTextField();
		AddField1.setColumns(10);
		AddField1.setBounds(260, 196, 140, 20);
		contentPane.add(AddField1);
		
		SalField1 = new JTextField();
		SalField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD))
				{
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		SalField1.setColumns(10);
		SalField1.setBounds(260, 226, 140, 20);
		contentPane.add(SalField1);
		
		/*Buttons Begin*/
		
		JButton btnSave = new JButton("Update");
		btnSave.setIcon(new ImageIcon("Resources/update.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(111, 357, 89, 23);
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
		btnCancel.setBounds(311, 357, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblSoftware = new JLabel("Software:");
		lblSoftware.setBounds(10, 289, 100, 14);
		contentPane.add(lblSoftware);
		
		JButton softBtn = new JButton("Select Software");
		softBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Select sotfware(s)";
				Object[] params = {message, checkbox1, checkbox2, checkbox3,};
				JOptionPane.showConfirmDialog(null, params, "List of sofwares", JOptionPane.YES_NO_OPTION);
		
			}
		});
		softBtn.setBounds(100, 285, 300, 23);
		contentPane.add(softBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 46, 544, 334);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				update();
			}
		});
		scrollPane.setViewportView(table);
		
		btnDel = new JButton("Delete");
		btnDel.setIcon(new ImageIcon("Resources/delete.png"));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDel.setBounds(212, 357, 89, 23);
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
		searchField.setBounds(799, 15, 156, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		lblSearch = new JLabel("Search:");
		lblSearch.setBounds(743, 18, 46, 14);
		contentPane.add(lblSearch);
		
		label = new JLabel("*Mouseover the text field for more info");
		label.setEnabled(false);
		label.setBounds(10, 316, 235, 14);
		contentPane.add(label);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{NameField1, SurField1, AgeField1, ConField1, AddField1, SalField1, GraField1, softBtn, btnSave, btnDel, btnCancel}));
		
		checkbox1 = new JCheckBox("Dr. Java");
		checkbox2 = new JCheckBox("Eclipse");
		checkbox3 = new JCheckBox("Netbeans");
		ToolTip tp = new ToolTip();
		NameField1.setToolTipText(tp.name());
		SurField1.setToolTipText(tp.surname());
		AgeField1.setToolTipText(tp.age());
		ConField1.setToolTipText(tp.contact());
		AddField1.setToolTipText(tp.address());
		SalField1.setToolTipText(tp.salary());
		GraField1.setToolTipText(tp.grade());
		softBtn.setToolTipText(tp.software());
		
		table();
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
	public void update()
	{
		clearFields();
		try
		{
			int row = table.getSelectedRow();
			System.out.println(row);
			String Emp =(table.getModel().getValueAt(row, 0).toString());
			String query = "select * from Programmer where EmployeeID = '"+Emp+"' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				EmpField.setText(rs.getString("EmployeeID").toUpperCase());
				NameField.setText(rs.getString("Name"));
				SurField.setText(rs.getString("Surname"));
				AgeField.setText(rs.getString("Age"));
				ConField.setText(rs.getString("Contact#"));
				AddField.setText(rs.getString("Address"));
				SalField.setText(rs.getString("Salary"));
				GraField.setText(rs.getString("Grade"));
				
				if("Yes".equalsIgnoreCase(rs.getString("DrJava")))
				{
					checkbox1.setSelected(true);
				}
				else
				{
					checkbox1.setSelected(false);
				}
				if("Yes".equalsIgnoreCase(rs.getString("Eclipse")))
				{
					checkbox2.setSelected(true);
				}
				else
				{
					checkbox2.setSelected(false);
				}
				if("Yes".equalsIgnoreCase(rs.getString("NetBeans")))
				{
					checkbox3.setSelected(true);
				}
				else
				{
					checkbox3.setSelected(false);
				}
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
			String empID = JOptionPane.showInputDialog(null, "Please enter the programmer ID you wish to delete", "Delete programmer data", JOptionPane.PLAIN_MESSAGE).toUpperCase();
			String query0 = "select * from Programmer where EmployeeID=?";
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
					String query = "delete from Programmer where EmployeeID = '"+empID+"' ";
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.execute();
					pst1.close();
					JOptionPane.showMessageDialog(null, "Employee ID " + empID + " has been deleted from the programmers record");
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
		if(EmpField.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Please select data.");
		}
		else
		{
			try
			{
				
				if(NameField1.getText().isEmpty())
				{
					NameField1.setText(NameField.getText());
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
				
				if(SalField1.getText().isEmpty())
				{
					SalField1.setText(SalField.getText());
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
				
				if(checkbox1.isSelected())
				{
					String cb1 = "update Programmer set DrJava='"+"Yes"+"' where EmployeeID = '"+EmpField.getText()+"' ";
					PreparedStatement cb1pst = connection.prepareStatement(cb1);
					cb1pst.execute();
					cb1pst.close();
				}
				else
				{
					String cb1 = "update Programmer set DrJava='"+""+"' where EmployeeID = '"+EmpField.getText()+"' ";
					PreparedStatement cb1pst = connection.prepareStatement(cb1);
					cb1pst.execute();
					cb1pst.close();
				}
				if(checkbox2.isSelected())
				{
					String cb2 = "update Programmer set Eclipse='"+"Yes"+"' where EmployeeID = '"+EmpField.getText()+"' ";
					PreparedStatement cb2pst = connection.prepareStatement(cb2);
					cb2pst.execute();
					cb2pst.close();
				}
				else
				{
					String cb2 = "update Programmer set Eclipse='"+""+"' where EmployeeID = '"+EmpField.getText()+"' ";
					PreparedStatement cb2pst = connection.prepareStatement(cb2);
					cb2pst.execute();
					cb2pst.close();
				}
				if(checkbox3.isSelected())
				{
					String cb3 = "update Programmer set NetBeans='"+"Yes"+"' where EmployeeID = '"+EmpField.getText()+"' ";
					PreparedStatement cb3pst = connection.prepareStatement(cb3);
					cb3pst.execute();
					cb3pst.close();
				}
				else
				{
					String cb3 = "update Programmer set NetBeans='"+""+"' where EmployeeID = '"+EmpField.getText()+"' ";
					PreparedStatement cb3pst = connection.prepareStatement(cb3);
					cb3pst.execute();
					cb3pst.close();
				}

				
				if(count==0)
				{
					String query ="update Programmer set Name='"+NameField1.getText()+"' , Surname='"+SurField1.getText()+"' , Age='"+AgeField1.getText()+"' , 'Contact#'='"+ConField1.getText()+"' , Address='"+AddField1.getText()+"' , Salary='"+SalField1.getText()+"' , Grade='"+GraField1.getText()+"' where EmployeeID = '"+EmpField.getText()+"' ";
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
	public void search()
	{
		try
		{
			String query = "SELECT * from Programmer where Name LIKE '"+searchField.getText()+"%' OR  EmployeeID LIKE '"+searchField.getText()+"%' ";
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
	public void clearFields()
	{
		JTextField[] fields = new JTextField[7];
		fields[0] = NameField1;
		fields[1] = SurField1;
		fields[2] = AgeField1;
		fields[3] = ConField1;
		fields[4] = AddField1;
		fields[5] = SalField1;
		fields[6] = GraField1;
		for(int i=0; i < fields.length ; i++)
		{

				fields[i].setText("");
		}
	}

}

