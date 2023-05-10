package dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class DAO {
	public static Connection con;
	public DAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/orderfood?autoReconnect=true&useSSL=false";
			String dbClass = "com.mysql.jdbc.Driver";

			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "100502");
				 System.out.println("Connected to MySQL!");
			}catch(Exception e) {
				 System.out.println("An error occurred while connecting MySQL!");
				e.printStackTrace();
			}
		}
	}
	

}
