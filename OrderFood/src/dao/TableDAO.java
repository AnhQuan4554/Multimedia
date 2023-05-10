package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import model.Table;
public class TableDAO extends DAO {
	public TableDAO() {
		super();
	}
	// Cập nhật thông tin 
	public boolean updateTable(String numberTable,String clientName){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(calendar.getTime());
		String sql = "UPDATE orderfood.table SET clientName=?, orderDay= ? WHERE numberTable=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, clientName);
			ps.setString(2, currentDate);
			ps.setString(3, numberTable);
			System.out.println();
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
		return true;
	}
// Search Table xem có còn bàn hay ko 	
	public boolean searchTable(String numberTable){
		String sql = "SELECT * FROM orderfood.table WHERE numberTable LIKE ?";
		try{
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + numberTable + "%");
			ResultSet rs = ps.executeQuery();
			Table rm = new Table();
			while(rs.next()){
				
				rm.setClientName(rs.getString("clientName"));;
				System.out.println("Ket qua la");
				System.out.println( rm.getClientName());
				if(rm.getClientName()== null) {
					return false;
				}else {
					return true;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;	
		
	}
	public static void main(String[] args) {
	System.out.println("HELLO TABLE");
	TableDAO table = new TableDAO();
	boolean x =table.updateTable("t1","QUAN NGH");
	System.out.println(x);
//	table.searchDateTable("t3");
	
	
	
}
	
}