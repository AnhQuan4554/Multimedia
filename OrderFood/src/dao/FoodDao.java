package dao;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.Food;
import model.Table;

public class FoodDao extends DAO  {
	public FoodDao() {
		super();
	}
	public ArrayList<Food> searchFood(String foodName){
		String sql = "SELECT * FROM orderfood.food WHERE foodName LIKE ?";
		ArrayList<Food> result = new ArrayList<Food>();
		try{
		PreparedStatement ps = con.prepareStatement(sql);
//			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + foodName + "%");
			ResultSet rs = ps.executeQuery();
			Food rm = new Food();
			while(rs.next()){
				
				rm.setIdFood(rs.getString("idFood"));
				rm.setFoodName(rs.getString("foodName"));
				rm.setDes(rs.getString("describe"));
				rm.setPrice(rs.getInt("price"));
				result.add(rm);		
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}
		return result;	
		
	}
	public static void main(String[] args) {
		FoodDao fooddao = new FoodDao();
		ArrayList<Food> foods = 	fooddao.searchFood("sào tỏi");
		for (Food food : foods) {
		    System.out.println(food.getFoodName());
		}
	}
}
