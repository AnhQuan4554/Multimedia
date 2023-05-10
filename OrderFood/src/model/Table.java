package model;
import java.io.Serializable;
import java.util.Date;
public class Table   implements Serializable{
	private String	 numberTable;
	private String clientName;
	private int maxClient;
	private String orderDay;
	
	public Table() {
		super();
	}
	public Table(String numberTable,String clientName,int maxClient, String  orderDay) {
		super();
		this.numberTable = numberTable;
		this.clientName = clientName;
		this.maxClient = maxClient;
		this.orderDay  = orderDay;
		
	}
	public  String getNumberTable() {
		return numberTable;
	}
	public void setNumberTable(String numberTable) {
		this.numberTable = numberTable;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getMaxClient() {
		return maxClient;
	}
	public void setMaxClient(int maxClient) {
		this.maxClient = maxClient;
	}
	public String getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}
	
}
