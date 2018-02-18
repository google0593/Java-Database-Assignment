import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class GenerateReport extends JFrame {

	private JPanel contentPane;
	private JTextArea dataPane;

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
					GenerateReport frame = new GenerateReport();
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
	private JButton backBtn;
	public GenerateReport() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		setTitle("Report");
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 32, 700, 502);
		contentPane.add(scrollPane);
		
		dataPane = new JTextArea();
		dataPane.setEditable(false);
		scrollPane.setViewportView(dataPane);
		
		backBtn = new JButton("Back");
		backBtn.setIcon(new ImageIcon("Resources/back.png"));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Main_Admin_GUI cancel = new Main_Admin_GUI();
				cancel.cancel();
			}
		});
		backBtn.setBounds(397, 552, 89, 23);
		contentPane.add(backBtn);
		data();
	}
	public void data()
	{
		try
		{
			dataPane.append("------------------------------------------------------------------------------------\n\n");
			dataPane.append("\t\t\t\t\tSalary\n\n");
			//query for total salary of all employee
			String query = "select sum(Salary) [TotalSalary] from viewAll";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			String ts = rs.getString("TotalSalary");
			System.out.println("Total Salary of all employees: $"+ts);
			dataPane.append("Total Salary of all employees: $"+ts);
			pst.close();
			rs.close();
			
			//query for total salary for regular employee
			String query1 = "select sum(Salary) [TotalSalary] from viewAll where employeeID like 'e%'";
			PreparedStatement pst1 = connection.prepareStatement(query1);
			ResultSet rs1 = pst1.executeQuery();
			String tse = rs1.getString("TotalSalary");
			System.out.println("Total Salary of regular employees: $"+tse);
			dataPane.append("\nTotal Salary of regular employees: $"+tse);
			pst1.close();
			rs1.close();
			
			//query for total salary for manager
			String query2 = "select sum(Salary) [TotalSalary] from viewAll where employeeID like 'm%'";
			PreparedStatement pst2 = connection.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			String tsm = rs2.getString("TotalSalary");
			System.out.println("Total Salary of managers: "+tsm);
			dataPane.append("\nTotal Salary of managers: $"+tsm);
			pst2.close();
			rs2.close();
			
			//query for total salary for  sales
			String query3 = "select sum(Salary) [TotalSalary] from viewAll where employeeID like 's%'";
			PreparedStatement pst3 = connection.prepareStatement(query3);
			ResultSet rs3 = pst3.executeQuery();
			String tss = rs3.getString("TotalSalary");
			System.out.println("Total Salary of salespersons: "+tss);
			dataPane.append("\nTotal Salary of salespersons: $"+tss);
			pst3.close();
			rs3.close();
			
			//query for total salary for  programmer
			String query4 = "select sum(Salary) [TotalSalary] from viewAll where employeeID like 'p%'";
			PreparedStatement pst4 = connection.prepareStatement(query4);
			ResultSet rs4 = pst4.executeQuery();
			String tsp = rs4.getString("TotalSalary");
			System.out.println("Total Salary of programmer: $"+tsp);
			dataPane.append("\nTotal Salary of programmer: $"+tsp);
			pst4.close();
			rs4.close();
			dataPane.append("\n\n\n------------------------------------------------------------------------------------\n\n");
			dataPane.append("\t\t\t\t  Number of Employees\n");
			//query for number of employees
			String query5 = "select count(EmployeeID) [TotalEmployee] from viewAll";
			PreparedStatement pst5 = connection.prepareStatement(query5);
			ResultSet rs5 = pst5.executeQuery();
			String tn = rs5.getString("TotalEmployee");
			System.out.println("Total number of all employees: "+tn);
			dataPane.append("\nTotal number of all employees: "+tn);
			pst5.close();
			rs5.close();
			//query for number of regular employees
			String query6 = "select count(EmployeeID) [TotalEmployee] from viewAll where employeeID like 'e%'";
			PreparedStatement pst6 = connection.prepareStatement(query6);
			ResultSet rs6 = pst6.executeQuery();
			String tne = rs6.getString("TotalEmployee");
			System.out.println("Total number of regular employees: "+tne);
			dataPane.append("\nTotal number of regular employees: "+tne);
			pst6.close();
			rs6.close();
			//query for number of managers
			String query7 = "select count(EmployeeID) [TotalEmployee] from viewAll where employeeID like 'm%'";
			PreparedStatement pst7 = connection.prepareStatement(query7);
			ResultSet rs7 = pst7.executeQuery();
			String tnm = rs7.getString("TotalEmployee");
			System.out.println("Total number of managers: "+tnm);
			dataPane.append("\nTotal number of managers: "+tnm);
			pst7.close();
			rs7.close();
			//query for number of sales
			String query8 = "select count(EmployeeID) [TotalEmployee] from viewAll where employeeID like 's%'";
			PreparedStatement pst8 = connection.prepareStatement(query8);
			ResultSet rs8 = pst8.executeQuery();
			String tns = rs8.getString("TotalEmployee");
			System.out.println("Total number of salespersons: "+tns);
			dataPane.append("\nTotal number of salespersons: "+tns);
			pst8.close();
			rs8.close();
			//query for number of programmer
			String query9 = "select count(EmployeeID) [TotalEmployee] from viewAll where employeeID like 'p%'";
			PreparedStatement pst9 = connection.prepareStatement(query9);
			ResultSet rs9 = pst9.executeQuery();
			String tnp = rs9.getString("TotalEmployee");
			System.out.println("Total number of programmer: "+tnp);
			dataPane.append("\nTotal number of programmer: "+tnp);
			pst9.close();
			rs9.close();
			//query for total sales volume
			dataPane.append("\n\n\n------------------------------------------------------------------------------------\n\n");
			dataPane.append("\t\t\t\t   Total Sales Volume\n");
			String query10 = "select sum(SalesVolume) [SalesVolume] from SalesPerson";
			PreparedStatement pst10 = connection.prepareStatement(query10);
			ResultSet rs10 = pst10.executeQuery();
			String tsv = rs10.getString("SalesVolume");
			System.out.println("Total sales volume: "+tsv);
			dataPane.append("\nTotal sales volume: "+tsv);
			pst10.close();
			rs10.close();
			//query for top ten employee
			String query11 = "select * from gradeView order by Grade COLLATE NOCASE desc";
			PreparedStatement pst11 = connection.prepareStatement(query11);
			ResultSet rs11 = pst11.executeQuery();
			int counter = 0;
			int ranking = 1;
			dataPane.append("\n\n\n------------------------------------------------------------------------------------\n\n");
			dataPane.append("\t\t\t\t Top 10 Employees\n");
			while(rs11.next())
			{
				if(counter!=10)
				{
					String eid = rs11.getString("EmployeeID");
					String name = rs11.getString("Name");
					String surname = rs11.getString("Surname");
					String grade = rs11.getString("Grade");
					System.out.println("Top " +ranking+ " Employee: \nEmployeeID: "+eid+"\nFirst Name: "+name+"\nLast Name: "+surname+"\nGrade: "+grade+"\n");
					dataPane.append("\nTop " +ranking+ " Employee: \nEmployeeID: "+eid+"\nFirst Name: "+name+"\nLast Name: "+surname+"\nGrade: "+grade+"\n");
					ranking += 1;
					counter += 1;
				}
			}
			counter = 0;
			ranking = 1;
			
			
			pst11.close();
			rs11.close();
			dataPane.setCaretPosition(0);
			
			
		}
		catch(Exception e)
		{
			
		}
	}
}
