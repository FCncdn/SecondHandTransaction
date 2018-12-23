package fuck;

public class Goods{
	private int idGood;
	private int idSeller;
	private String goodName;
	private float price;
	private Object itemImage;
	public Goods() {
		super();
	}
	public Goods(int idGood ,int idSeller,String goodNname,float price,Object itemImage) 
	{
		super();
		this.idGood=idGood;
		this.idSeller=idSeller;
		this.goodName=goodNname;
		this.price=price;
		this.itemImage = itemImage;
	}
	public int getIdGood() {
		return idGood;
	}
	public int getIdSeller() {
		return idSeller;
	}
	public String getGoodName() {
		return goodName;
	}
	public float getPrice() {
		return price;
	}
	public Object getItemImage() {
		return itemImage;
	}
}
