package frontEnd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backEnd.HandyMethods;

public class SignInScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Username;
	private JPasswordField pwSignIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInScreen frame = new SignInScreen();
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
	public SignInScreen() {
		setResizable(false);
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\naido\\Documents\\School\\IT\\PAT\\attachment_36434417-e1531897536884.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 462);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(30, 53, 64, 16);
		contentPane.add(lblUsername);

		textField_Username = new JTextField();
		textField_Username.setBounds(30, 82, 242, 32);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(30, 141, 72, 16);
		contentPane.add(lblPassword);
		
		JLabel lblSignInError = new JLabel("");
		lblSignInError.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSignInError.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignInError.setBounds(30, 216, 242, 29);
		contentPane.add(lblSignInError);
		
		pwSignIn = new JPasswordField();
		pwSignIn.setBounds(30, 170, 242, 33);
		contentPane.add(pwSignIn);
		
		JPanel panel = new JPanel();
		panel.setBounds(317, 0, 308, 487);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				lblX.setForeground(Color.DARK_GRAY);
			}
		});
		lblX.setFont(new Font("High Tower Text", Font.BOLD, 18));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.DARK_GRAY);
		lblX.setBounds(281, 13, 27, 16);
		panel.add(lblX);
		
		JLabel lblWheelPic = new JLabel("");
		lblWheelPic.setIcon(new ImageIcon(SignInScreen.class.getResource("/Images/biomega_sin_cuv_3[1].jpg")));
		lblWheelPic.setBounds(0, -222, 308, 449);
		panel.add(lblWheelPic);
		
		JLabel lblSignIn = new JLabel("SIGN IN");
		lblSignIn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSignIn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSignIn.setForeground(Color.WHITE);
		lblSignIn.setBounds(0, 229, 296, 234);
		panel.add(lblSignIn);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				btnLogin.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnLogin.setBackground(new Color(255, 99, 71));
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					if(Launcher.c.checkEmployeeLoginDetails(textField_Username.getText(),HandyMethods.getMd5(pwSignIn.getText())) == true)
					{
						System.out.println("Employee Login Successful!");
						EmployeeOptions eo = new EmployeeOptions();
						eo.setVisible(true);
						dispose();
					}
					else
					{
						lblSignInError.setText("INCORRECT PASSWORD");
						lblSignInError.setForeground(new Color(255, 99, 71));
					}
				}
				catch(SQLException e)
				{
					System.out.println("Invalid username or password. "+e);
				}
				
				try
				{
					if(Launcher.c.checkManagerLoginDetails(textField_Username.getText(),HandyMethods.getMd5(pwSignIn.getText())) == true)
					{
						System.out.println("Manager Login Successsful!");
						ManagerOptions mo = new ManagerOptions();
						mo.setVisible(true);
						dispose();
					}
					else
					{
						lblSignInError.setText("INCORRECT PASSWORD");
						lblSignInError.setForeground(new Color(255, 99, 71));
					}
				}
				catch(SQLException e)
				{
					System.out.println("Invalid username or password. "+e);
				}
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(255, 99, 71));
		btnLogin.setBounds(30, 258, 242, 40);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnRegister.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btnRegister.setBackground(new Color(255, 99, 71));
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegisterOptionsScreen rs = new RegisterOptionsScreen();
				rs.setVisible(true);
				dispose();
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBackground(new Color(255, 99, 71));
		btnRegister.setBounds(30, 321, 242, 40);
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		contentPane.add(btnRegister);
		
		JButton btnForgotPassword = new JButton("FORGOT PASSWORD");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				CheckSecurityQuestion csq = new CheckSecurityQuestion();
				csq.setVisible(true);
				dispose();
			}
		});
		btnForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				btnForgotPassword.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btnForgotPassword.setBackground(new Color(255, 99, 71));
			}
		});
		btnForgotPassword.setBackground(new Color(255, 99, 71));
		btnForgotPassword.setForeground(Color.WHITE);
		btnForgotPassword.setBounds(30, 384, 242, 40);
		btnForgotPassword.setFocusPainted(false);
		btnForgotPassword.setBorderPainted(false);
		contentPane.add(btnForgotPassword);
		
		setUndecorated(true); 
	}
}
