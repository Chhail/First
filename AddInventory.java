package frontEnd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backEnd.HandyMethods;

public class AddInventory extends JFrame {

	private JPanel contentPane;
	private JTextField txtPartName;
	private JTextField txtCar;
	private JTextField txtPriceOfPart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInventory frame = new AddInventory();
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
	public AddInventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 409);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 292, 454);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAddInventory = new JLabel("ADD INVENTORY");
		lblAddInventory.setForeground(Color.WHITE);
		lblAddInventory.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddInventory.setBounds(12, 0, 280, 409);
		panel.add(lblAddInventory);

		JLabel lblPartName = new JLabel("PART NAME:");
		lblPartName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPartName.setBounds(322, 52, 85, 16);
		contentPane.add(lblPartName);

		txtPartName = new JTextField();
		txtPartName.setBounds(322, 81, 349, 39);
		contentPane.add(txtPartName);
		txtPartName.setColumns(10);

		JLabel lblCar = new JLabel("CAR:");
		lblCar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCar.setBounds(322, 134, 32, 16);
		contentPane.add(lblCar);

		txtCar = new JTextField();
		txtCar.setBounds(322, 163, 349, 39);
		contentPane.add(txtCar);
		txtCar.setColumns(10);

		JLabel lblPriceOfPart = new JLabel("PRICE OF PART:");
		lblPriceOfPart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPriceOfPart.setBounds(322, 218, 110, 16);
		contentPane.add(lblPriceOfPart);

		txtPriceOfPart = new JTextField();
		txtPriceOfPart.setBounds(322, 247, 349, 39);
		contentPane.add(txtPriceOfPart);
		txtPriceOfPart.setColumns(10);

		JLabel lblAddInventoryError = new JLabel("");
		lblAddInventoryError.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddInventoryError.setForeground(new Color(255, 99, 71));
		lblAddInventoryError.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddInventoryError.setBounds(322, 299, 349, 27);
		contentPane.add(lblAddInventoryError);
		
		JLabel lblPartNameRequirement = new JLabel("Must start with Uppercase");
		lblPartNameRequirement.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartNameRequirement.setForeground(Color.GRAY);
		lblPartNameRequirement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPartNameRequirement.setBounds(419, 53, 252, 16);
		contentPane.add(lblPartNameRequirement);
		
		JLabel lblCarRequirement = new JLabel("Must start with Uppercase");
		lblCarRequirement.setForeground(Color.GRAY);
		lblCarRequirement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCarRequirement.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarRequirement.setBounds(366, 135, 305, 16);
		contentPane.add(lblCarRequirement);

		JButton btnAddInventory = new JButton("ADD INVENTORY");
		btnAddInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(txtPartName.getText().isEmpty() || txtCar.getText().isEmpty() || txtPriceOfPart.getText().isEmpty())
				{
					lblAddInventoryError.setText("All fields are required");
				}
				
				char a = txtPartName.getText().charAt(0);
				char b = txtCar.getText().charAt(0);
				
				if(Character.isUpperCase(a) && Character.isUpperCase(b))
				{
					try
					{
						Launcher.c.addInventory(txtPartName.getText(),txtCar.getText(),Double.parseDouble(txtPriceOfPart.getText()));
					}
					catch(NumberFormatException e1)
					{
						e1.printStackTrace();
					}
					catch(SQLException e1)
					{
						JOptionPane.showMessageDialog(null, "Item was not added to Inventory");
					}
					
					ManagerInventory mi = new ManagerInventory();
					mi.setVisible(true);
					dispose();
				}
				else
				{
					lblPartNameRequirement.setForeground(new Color(255, 99,71));
					lblPartNameRequirement.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblCarRequirement.setForeground(new Color(255, 99, 71));
					lblCarRequirement.setFont(new Font("Tahoma", Font.BOLD, 15));
				}
			}
		});
		btnAddInventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnAddInventory.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btnAddInventory.setBackground(new Color(255, 99, 71));
			}
		});
		btnAddInventory.setBackground(new Color(255, 99, 71));
		btnAddInventory.setForeground(Color.WHITE);
		btnAddInventory.setFocusPainted(false);
		btnAddInventory.setBorderPainted(false);
		btnAddInventory.setBounds(322, 331, 349, 39);
		contentPane.add(btnAddInventory);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
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
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setFont(new Font("High Tower Text", Font.BOLD, 18));
		lblX.setForeground(Color.BLACK);
		lblX.setBounds(657, 13, 14, 16);
		contentPane.add(lblX);

		JLabel lblBackArrow = new JLabel("New label");
		lblBackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ManagerInventory mi = new ManagerInventory();
				mi.setVisible(true);
				dispose();
			}
		});
		lblBackArrow.setIcon(new ImageIcon(AddInventory.class.getResource("/Images/BackArrow.png")));
		lblBackArrow.setBounds(298, 12, 56, 27);
		contentPane.add(lblBackArrow);

		lblBackArrow.setIcon(HandyMethods.resizePicture("C:\\Users\\naido\\Documents\\School\\IT\\PAT\\BackArrow.png", lblBackArrow));

		setUndecorated(true);
	}
}
