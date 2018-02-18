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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import net.proteanit.sql.DbUtils;

public class View_All_GUI extends JFrame {

	private JPanel contentPane;
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
					View_All_GUI frame = new View_All_GUI();
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
	private JRadioButton ascBtn;
	private JRadioButton descBtn;
	private JTextField searchField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblSortByName;
	private JRadioButton idnameBtn;
	private JLabel lblSortBySalary;
	private JRadioButton ascBtn1;
	private JRadioButton descBtn1;
	private JSeparator separator;
	private JRadioButton empBtn;
	private JRadioButton mgrBtn;
	private JRadioButton prgBtn;
	private JRadioButton salBtn;
	public View_All_GUI() {
		setResizable(false);
		setTitle("View All");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		http://icons.iconarchive.com/icons/elegantthemes/beautiful-flat/128/rocket-icon.png
		setTitle("View All");
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ascBtn = new JRadioButton("Ascending");
		ascBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				table();
			}
		});
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(647, 88, 46, 14);
		contentPane.add(lblSearch);
		
		lblSortByName = new JLabel("Sort by Name");
		lblSortByName.setBounds(10, 117, 82, 14);
		contentPane.add(lblSortByName);
		
		lblSortBySalary = new JLabel("Sort by Salary");
		lblSortBySalary.setBounds(10, 226, 82, 14);
		contentPane.add(lblSortBySalary);
		ascBtn.setSelected(true);
		buttonGroup.add(ascBtn);
		ascBtn.setBounds(10, 134, 82, 23);
		contentPane.add(ascBtn);
		
		descBtn = new JRadioButton("Descending");
		descBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(descBtn);
		descBtn.setBounds(10, 160, 82, 23);
		contentPane.add(descBtn);
		
		searchField = new JTextField();
		searchField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(searchField.getText().equals("Enter name/EmployeeID.."))
				{
					searchField.setText("");
					searchField.setForeground(Color.BLACK);
				}
			}
		});
		searchField.setForeground(Color.LIGHT_GRAY);
		searchField.setText("Enter name/EmployeeID..");
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				search();
			}
		});
		
		idnameBtn = new JRadioButton("Sort by ID and Name");
		idnameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(idnameBtn);
		idnameBtn.setBounds(10, 186, 126, 23);
		contentPane.add(idnameBtn);
		
		ascBtn1 = new JRadioButton("Ascending");
		ascBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(ascBtn1);
		ascBtn1.setBounds(10, 247, 109, 23);
		contentPane.add(ascBtn1);
		
		descBtn1 = new JRadioButton("Descending");
		descBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(descBtn1);
		descBtn1.setBounds(10, 273, 109, 23);
		contentPane.add(descBtn1);
		searchField.setBounds(693, 85, 156, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JButton backBtn = new JButton("Back");
		backBtn.setIcon(new ImageIcon("Resources/back.png"));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Main_Admin_GUI cancel = new Main_Admin_GUI();
				cancel.cancel();
			}
		});
		backBtn.setBounds(760, 545, 89, 23);
		contentPane.add(backBtn);
		
		separator = new JSeparator();
		separator.setBounds(10, 216, 146, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 303, 146, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 116, 679, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblShow = new JLabel("Show");
		lblShow.setBounds(10, 312, 46, 14);
		contentPane.add(lblShow);
		
		empBtn = new JRadioButton("Employee");
		empBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(empBtn);
		empBtn.setBounds(10, 333, 109, 23);
		contentPane.add(empBtn);
		
		mgrBtn = new JRadioButton("Manager");
		mgrBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(mgrBtn);
		mgrBtn.setBounds(10, 359, 109, 23);
		contentPane.add(mgrBtn);
		
		salBtn = new JRadioButton("Salesperson");
		salBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(salBtn);
		salBtn.setBounds(10, 411, 109, 23);
		contentPane.add(salBtn);
		
		prgBtn = new JRadioButton("Programmer");
		prgBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
		buttonGroup.add(prgBtn);
		prgBtn.setBounds(10, 385, 109, 23);
		contentPane.add(prgBtn);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{backBtn}));
		table();
	}
	public void table()
	{
		if(ascBtn.isSelected())
		{
			try
			{
				String query = "select * from viewAll order by Name COLLATE NOCASE";
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
		else if(descBtn.isSelected())
		{
			try
			{
				String query = "select * from viewAll order by Name COLLATE NOCASE desc";
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
		else if(idnameBtn.isSelected())
		{
			try
			{
				String query = "select * from viewAll order by EmployeeID asc, Name asc";
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
		else if(ascBtn1.isSelected())
		{
			try
			{
				String query = "select * from viewAll order by Salary asc";
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
		else if(descBtn1.isSelected())
		{
			try
			{
				String query = "select * from viewAll order by Salary desc";
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
		else if(empBtn.isSelected())
		{
			try
			{
				String query = "select * from viewAll where EmployeeID like 'E%'";
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
		else if(mgrBtn.isSelected())
		{
			try
			{
				String query = "select * from viewAll where EmployeeID like 'M%'";
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
		else if(prgBtn.isSelected())
		{
			try
			{
				String query = "select * from viewAll where EmployeeID like 'P%'";
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
		else
		{
			try
			{
				String query = "select * from viewAll where EmployeeID like 'S%'";
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
	}
	public void search()
	{
		try
		{
			String query = "SELECT * from viewAll where Name LIKE '"+searchField.getText()+"%' OR  EmployeeID LIKE '"+searchField.getText()+"%' ";
			System.out.println(query);
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
	public void easterEgg()
	{
		System.out.println("This program was designed, developed and sponsored by Francis Faminial, KG Udanga and  Nikko Jucutan. LOL.");
	}
}
