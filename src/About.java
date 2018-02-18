import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class About extends JFrame {

	private JPanel contentPane;

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
					About frame = new About();
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
	public About() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Icon = new JLabel("");
		Icon.setIcon(new ImageIcon("Resources/Icon.png"));
		Icon.setBounds(24, 26, 64, 64);
		contentPane.add(Icon);
		
		JLabel version = new JLabel("AucklandHRM 1.0.0 (Build 0001) [32-bit]");
		version.setForeground(UIManager.getColor("Button.shadow"));
		version.setBounds(24, 115, 202, 14);
		contentPane.add(version);
		
		JLabel TR = new JLabel("");
		TR.setIcon(new ImageIcon("Resources/TR.png"));
		TR.setBounds(98, 26, 168, 64);
		contentPane.add(TR);
		
		JTextArea dataPane = new JTextArea();
		dataPane.setEditable(false);
		dataPane.setOpaque(false);
		dataPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dataPane.setText("\u00A92015 Team Rocket, Corp.\r\nAll Rights Reserved.\r\n\r\n\r\nThis program was developed and designed by \r\nFrancis Faminial,  KG Udanga and Nikolai Jucutan.\r\n\r\nThanks to www.IconArchive.com for the icons.");
		dataPane.setBounds(24, 140, 264, 130);
		contentPane.add(dataPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 290, 305, 14);
		contentPane.add(separator);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.setIcon(new ImageIcon("Resources/back.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCancel.setBounds(199, 306, 89, 23);
		contentPane.add(btnCancel);
	}
}
