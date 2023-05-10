package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ClientFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textClientName;
	private JTextField textAdressClient;
	public static String inputNameClient;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrm frame = new ClientFrm();
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
	public ClientFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(90, 39, 272, 48);
		contentPane.add(lblNewLabel);
		
		textClientName = new JTextField();
		textClientName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textClientName.getText();
				
			}
		});
		textClientName.setBounds(42, 118, 354, 48);
		contentPane.add(textClientName);
		textClientName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(42, 95, 135, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(42, 182, 56, 13);
		contentPane.add(lblNewLabel_1_1);
		
		textAdressClient = new JTextField();
		textAdressClient.setColumns(10);
		textAdressClient.setBounds(42, 205, 354, 48);
		contentPane.add(textAdressClient);
		
		JButton btnConfirm = new JButton("Xác nhận");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNameClient = textClientName.getText();
				ClientFrm clfrm = new ClientFrm();
				clfrm.dispose();
				OrderFoodFrm orFoodFrm = new OrderFoodFrm();
				orFoodFrm.setVisible(true);
			}
		});
		btnConfirm.setBounds(266, 280, 135, 48);
		contentPane.add(btnConfirm);
	}
}
