package dao;

import java.sql.PreparedStatement;
import java.sql.Statement;

import model.Order;


public class OrderDAO  extends DAO{
	public OrderDAO() {
		super();
	}
	public boolean addOrder(Order order) {
		String sqlAddFood = "INSERT INTO orderfood.order(numberTable, clientName, totalPrice) VALUES(?,?,?)";
		try{
			
			PreparedStatement ps = con.prepareStatement(sqlAddFood, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getNumberTable());
			ps.setString(2, order.getClientName());
			ps.setDouble(3, order.getTotalPrice());
			ps.executeUpdate();	
			System.out.println("tạo thành công order");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args)  {
//		OrderDAO orDAO = new OrderDAO();
//		Order or = new Order("t3","QUAN454",200000) ;
//		orDAO.addOrder(or);
	}
}
