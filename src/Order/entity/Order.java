package Order.entity;

public class Order {

	private String seller;
	private String buyer;
	private String item;
	private String orderID;
	private String address;
	private String phone;

	public Order(){}

	public Order(String idorders, String seller, String buyer, String itemId, String phone, String address){
		this.seller = seller;
		this.buyer = buyer;
		this.phone = phone;
		this.address = address;
	}
	
	public void setID(String id){
		orderID = id;
	}
	
	public String getID(){
		return orderID;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setSeller(String seller){
		this.seller = seller;
	}
	
	public String getSeller(){
		return seller;
	}
	
	public void setbuyer(String buyer){
		this.buyer = buyer;
	}
	
	public String getBuyer(){
		return buyer;
	}
	
	public void setItem(String item){
		this.item = item;
	}
	
	public String getItem(){
		return item;
	}
}
