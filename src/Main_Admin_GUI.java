/*Created by Team Rocket for Semester 2, Programming 2015, Unitec, New Zealand
Team Rocket is:
Nikko Jucutan
Francis Faminial
KG Udanga*/

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Main_Admin_GUI extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private String[] options = {"Add","Edit","Cancel"};

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
					Main_Admin_GUI frame = new Main_Admin_GUI();
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
	public Main_Admin_GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		setTitle("Admin Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton empBtn = new JButton("Maintain Employee(s)");
		empBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				empBtn.setIcon(new ImageIcon("Resources/employeeH.gif"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				empBtn.setIcon(new ImageIcon("Resources/employee.png"));
			}
		});
		empBtn.setIcon(new ImageIcon("Resources/employee.png"));

		empBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int choice = JOptionPane.showOptionDialog(null, "Please select an option", "Employees", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (choice == 0)//http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
				{
					/*setVisible(false);*/
					dispose();
					Add_Emp_GUI addEmp = new Add_Emp_GUI();
					addEmp.setVisible(true);
					addEmp.setLocationRelativeTo(null);
				}
				else if (choice == 1)
				{
					/*setVisible(false);*/
					dispose();
					Edit_Emp_GUI editEmp = new Edit_Emp_GUI();
					editEmp.setVisible(true);
					editEmp.setLocationRelativeTo(null);
				}
			}
		});
		empBtn.setBounds(10, 79, 191, 45);
		contentPane.add(empBtn);
		
		JButton salesBtn = new JButton("Maintain Salesperson(s)");
		salesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				salesBtn.setIcon(new ImageIcon("Resources/salesH.gif"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				salesBtn.setIcon(new ImageIcon("Resources/sales.png"));
			}
		});
		salesBtn.setIcon(new ImageIcon("Resources/sales.png"));
		salesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int choice = JOptionPane.showOptionDialog(null, "Please select an option", "Manager", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (choice == 0)
				{
					/*setVisible(false);*/
					dispose();
					Add_Sales_GUI addSal = new Add_Sales_GUI();
					addSal.setVisible(true);
					addSal.setLocationRelativeTo(null);
				}
				else if (choice == 1)
				{
					/*setVisible(false);*/
					dispose();
					Edit_Sales_GUI editSal = new Edit_Sales_GUI();
					editSal.setVisible(true);
					editSal.setLocationRelativeTo(null);
				}
			}
		});

		salesBtn.setBounds(10, 135, 191, 45);
		contentPane.add(salesBtn);
		
		JButton viewBtn = new JButton("View All");
		viewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				viewBtn.setIcon(new ImageIcon("Resources/viewallH.gif"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				viewBtn.setIcon(new ImageIcon("Resources/viewall.png"));
			}
		});
		viewBtn.setIcon(new ImageIcon("Resources/viewall.png"));
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View_All_GUI viewAll = new View_All_GUI();
				viewAll.setVisible(true);
				viewAll.setLocationRelativeTo(null);
			}
		});

		viewBtn.setBounds(10, 191, 191, 45);
		contentPane.add(viewBtn);
		
		JButton mgrBtn = new JButton("Maintain Manager(s)");
		mgrBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mgrBtn.setIcon(new ImageIcon("Resources/managerH.gif"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mgrBtn.setIcon(new ImageIcon("Resources/manager.png"));
			}
		});
		mgrBtn.setIcon(new ImageIcon("Resources/manager.png"));

		mgrBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int choice = JOptionPane.showOptionDialog(null, "Please select an option", "Manager", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (choice == 0)
				{
					/*setVisible(false);*/
					dispose();
					Add_Mgr_GUI addMgr = new Add_Mgr_GUI();
					addMgr.setVisible(true);
					addMgr.setLocationRelativeTo(null);
				}
				else if (choice == 1)
				{
					dispose();
					Edit_Mgr_GUI editMgr = new Edit_Mgr_GUI();
					editMgr.setVisible(true);
					editMgr.setLocationRelativeTo(null);
				}
	
			}
		});
		mgrBtn.setBounds(213, 79, 191, 45);
		contentPane.add(mgrBtn);
		
		JButton progBtn = new JButton("Maintain Programmer(s)");
		progBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				progBtn.setIcon(new ImageIcon("Resources/programmerH.gif"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				progBtn.setIcon(new ImageIcon("Resources/programmer.png"));
			}
		});
		progBtn.setIcon(new ImageIcon("Resources/programmer.png"));
		progBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int choice = JOptionPane.showOptionDialog(null, "Please select an option", "Programmer", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (choice == 0)
				{
					/*setVisible(false);*/
					dispose();
					Add_Prog_GUI addProg = new Add_Prog_GUI();
					addProg.setVisible(true);
					addProg.setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
					addProg.setLocationRelativeTo(null);
				}
				else if (choice == 1)
				{
					/*setVisible(false);*/
					dispose();
					Edit_Prog_GUI editProg = new Edit_Prog_GUI();
					editProg.setVisible(true);
					editProg.setLocationRelativeTo(null);
				}
			}
		});

		progBtn.setBounds(213, 135, 191, 45);
		contentPane.add(progBtn);
		
		JButton genBtn = new JButton("Generate Report");
		genBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				genBtn.setIcon(new ImageIcon("Resources/reportH.gif"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				genBtn.setIcon(new ImageIcon("Resources/report.png"));
			}
		});
		genBtn.setIcon(new ImageIcon("Resources/report.png"));
		genBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/*View_All_GUI viewAll = new View_All_GUI();
				viewAll.setVisible(true);
				viewAll.setLocationRelativeTo(null);*/
				GenerateReport gen = new GenerateReport();
				gen.setVisible(true);
				gen.setLocationRelativeTo(null);
			}
		});

		genBtn.setBounds(213, 191, 191, 45);
		contentPane.add(genBtn);
		
		JLabel about = new JLabel("");
		about.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					About ap = new About();
					ap.setVisible(true);
					ap.setLocationRelativeTo(null);
			}
		});
		about.setIcon(new ImageIcon("Resources/about.png"));
		about.setToolTipText("About");
		about.setBounds(387, 11, 16, 16);
		contentPane.add(about);
		
		JLabel logout = new JLabel("");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","Confirm logout",JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.YES_OPTION)
				{
					dispose();
					Login login = new Login();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
				}
			}
		});
		logout.setIcon(new ImageIcon("Resources/logout.png"));
		logout.setToolTipText("Logout");
		logout.setBounds(10, 11, 16, 16);
		contentPane.add(logout);
	}
	public void cancel()
	{
		/*setVisible(false);*/
		dispose();
		Main_Admin_GUI mainFrame = new Main_Admin_GUI();
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
	}
}
