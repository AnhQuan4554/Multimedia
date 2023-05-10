package dao;

import java.sql.*;
import java.sql.Statement;

import model.orderDetail;

public class orderDetailDAO extends DAO {
	public orderDetailDAO() {
		super();
	}
	public boolean addOrderDetail(orderDetail orderdetail) {
		String sqlAddFood = "INSERT INTO orderfood.orderdetail(numberTable, foodName, quantity, price) VALUES(?,?,?,?)";
		try{
			
			PreparedStatement ps = con.prepareStatement(sqlAddFood, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, orderdetail.getNumberTable());
			ps.setString(2, orderdetail.getFoodName());
			ps.setDouble(3, orderdetail.getQuantity());
			ps.setDouble(4, orderdetail.getPrice());
			ps.executeUpdate();	
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
