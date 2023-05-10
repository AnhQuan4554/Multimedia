package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import dao.FoodDao;
import dao.OrderDAO;
import dao.orderDetailDAO;
import model.Food;
import model.Order;
import model.Table;
import model.orderDetail;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OrderFoodFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField inputFoodName;
	private JButton btnSearch;
	
	ArrayList<Food> result = new ArrayList<Food>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFoodFrm frame = new OrderFoodFrm();
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
	private void updateDataTable(ArrayList<Food> result) {
	    Object[][] data = new Object[result.size()][4];
	    for (int i = 0; i < result.size(); i++) {
	        Object[] newObj = {result.get(i).getFoodName(), result.get(i).getDes(), result.get(i).getPrice(),0};
	        data[i] = newObj;
	    }
	    table.setModel(new DefaultTableModel(
	            data,
	            new String[] {
	                "Tên món ăn", "Mô tả", "Giá","Số lượng",
	            }
	        ) {
	            Class[] columnTypes = new Class[] {
	                String.class, String.class,  Double.class,Double.class
	            };
	            public Class getColumnClass(int columnIndex) {
	                return columnTypes[columnIndex];
	            }
	        });
	}

	public OrderFoodFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 144, 602, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		Object[][] data = new Object[result.size()][4];
		for (int i = 0;i<result.size();i++) {
			System.out.println(result.get(i).getFoodName());
		    Object[] newObj = {result.get(i).getFoodName(), result.get(i).getDes(), result.get(i).getPrice(),3};
		    data[i] = newObj;
		  
		}
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"T\u00EAn m\u00F3n \u0103n", "M\u00F4 t\u1EA3", "Gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.setBackground(new Color(255, 128, 128));
		
		inputFoodName = new JTextField();
		inputFoodName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inputFoodName.setBounds(10, 31, 287, 48);
		contentPane.add(inputFoodName);
		inputFoodName.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodDao foodDao = new FoodDao();
				
				result =  foodDao.searchFood(inputFoodName.getText());
				System.out.println(result.get(0).getFoodName());
				updateDataTable(result);
				
			}
		});
		btnSearch.setBounds(350, 39, 147, 38);
		contentPane.add(btnSearch);
		
		JButton btnConfirm = new JButton("Xác nhận");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hêlll");
				for (int i = 0; i < table.getRowCount(); i++) {
		            Double quantity = (Double) table.getValueAt(i, 3);
		            String tableNumber = TableFrm.dataTable;
		            if (quantity >0 ) {
		             //  đưa các thông tin trừ tổng tiền vào tron orderDetail
		                String foodName = (String) table.getValueAt(i, 0);
		                String description = (String) table.getValueAt(i, 1);
		                Double price = (Double) table.getValueAt(i, 2);
		               Double totalPrice = price * quantity;
		               System.out.println(totalPrice);
		               // cần điền thông tin bàn cùng các thông tin
		                orderDetail order_detail = new orderDetail(TableFrm.dataTable,foodName,quantity,price);
		                orderDetailDAO or_detail_Dao  = new orderDetailDAO();
		                or_detail_Dao.addOrderDetail(order_detail);
//		                // add vao order
		                Order or = new Order(TableFrm.dataTable,ClientFrm.inputNameClient,totalPrice);
		                System.out.println("Thong tin lư vao ORder là ");
		                System.out.println(or);
		                OrderDAO orDao = new OrderDAO();
		                orDao.addOrder(or);
//		               // dong Jrame hien tai
		                OrderFoodFrm orFrm = new OrderFoodFrm();
		                orFrm.dispose();
		                SuccessFrm sucFrm = new SuccessFrm();
		                sucFrm.setVisible(true);
		                
		            }
		        }
			}
		});

		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirm.setBounds(445, 337, 157, 38);
		contentPane.add(btnConfirm);
	}
}