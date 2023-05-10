package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import dao.TableDAO;
import model.Table;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TableFrm extends JFrame {

	private JPanel contentPane;
	public static String dataTable; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableFrm frame = new TableFrm();
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
	public TableFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNum1 = new JButton("1");
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum1.getText());
				if(!checkTable) {
					dataTable = btnNum1.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum1.setBounds(43, 121, 93, 43);
		contentPane.add(btnNum1);
		
		JButton btnNum4 = new JButton("4");
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum4.getText());
				if(!checkTable) {
					dataTable = btnNum4.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum4.setBounds(43, 185, 93, 43);
		contentPane.add(btnNum4);
		
		JButton btnNum7 = new JButton("7");
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum7.getText());
				if(!checkTable) {
					dataTable = btnNum7.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum7.setBounds(43, 244, 93, 43);
		contentPane.add(btnNum7);
		
		JButton btnNum8 = new JButton("8");
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum8.getText());
				if(!checkTable) {
					dataTable = btnNum8.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum8.setBounds(159, 244, 93, 43);
		contentPane.add(btnNum8);
		
		JButton btnNum5 = new JButton("5");
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum5.getText());
				if(!checkTable) {
					dataTable = btnNum5.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum5.setBounds(159, 185, 93, 43);
		contentPane.add(btnNum5);
		
		JButton btnNum2 = new JButton("2");
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum2.getText());
				if(!checkTable) {
					dataTable = btnNum2.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum2.setBounds(159, 121, 93, 43);
		contentPane.add(btnNum2);
		
		JButton btnNum3 = new JButton("3");
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table tb = new Table();
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum3.getText());
				if(!checkTable) {
					dataTable = btnNum3.getText();// biến để chuyển số bàn giữa các JFrame
					tb.setNumberTable(btnNum3.getText());
					System.out.println(tb.getNumberTable());
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum3.setBounds(284, 121, 93, 43);
		contentPane.add(btnNum3);
		
		JButton btnNum6 = new JButton("6");
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum6.getText());
				if(!checkTable) {
					dataTable = btnNum6.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum6.setBounds(284, 185, 93, 43);
		contentPane.add(btnNum6);
		
		JButton btnNum9 = new JButton("9");
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableDAO tblDAO = new TableDAO();
				Boolean checkTable =  tblDAO.searchTable(btnNum9.getText());
				if(!checkTable) {
					dataTable = btnNum4.getText();
					  JFrame currentFrame = (JFrame)SwingUtilities.getWindowAncestor(getContentPane());
			           currentFrame.setVisible(false);
			           ClientFrm cliFrm = new ClientFrm();
			           cliFrm.setVisible(true);
				}
			}
		});
		btnNum9.setBounds(284, 244, 93, 43);
		contentPane.add(btnNum9);
		
		JLabel lblNewLabel = new JLabel("Chọn số bàn ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(91, 48, 245, 43);
		contentPane.add(lblNewLabel);
	}
}