import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JButton btnOk;
	private JTextField tfLogin;
	private String userLogin = "admin";
	private char[] userPassword = {'a', 'd', 'm', 'i', 'n'};
	private JPasswordField tfPass;

	
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
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);/*center frame*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		splash();
		setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/icon.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 287);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOk = new JButton("Login >>");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
				
			}
		});
		btnOk.setBounds(236, 203, 77, 23);
		contentPane.add(btnOk);
		

		
		tfLogin = new JTextField();	
		tfLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfLogin.setBounds(23, 80, 290, 30);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		tfPass = new JPasswordField();
		tfPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	                login();
	            }
			}
		});
		tfPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPass.setBounds(23, 150, 290, 30);

		contentPane.add(tfPass);
		
		JLabel lblLogin = new JLabel("Username:");
		lblLogin.setBounds(23, 60, 89, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 130, 60, 14);
		contentPane.add(lblPassword);
		
		/*JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Resources/bg.jpg"));
		lblNewLabel.setBounds(0, 0, 337, 248);
		contentPane.add(lblNewLabel);*/


		

	}
	public void login()
	{
		
		if(userLogin.equalsIgnoreCase(tfLogin.getText()))
		{
			if(Arrays.equals(userPassword, tfPass.getPassword())) /*http://www.codejava.net/java-se/swing/jpasswordfield-basic-tutorial-and-examples*/			
			{
				JOptionPane.showMessageDialog(null, "Login Success");
				/*setVisible(false);*/
				dispose();
				Main_Admin_GUI adminFrame = new Main_Admin_GUI();
				adminFrame.setVisible(true);
				adminFrame.setLocationRelativeTo(null);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect Password");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "User not found");
		}
	}
	public void splash()
	{
		try
		{
			Thread.sleep(1800);
			
		}
			catch (Exception e)
		{
			
		}
	}
}
