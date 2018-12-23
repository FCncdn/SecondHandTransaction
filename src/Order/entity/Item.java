package Order.entity;

public class Item {
	private String itemID;
  private String itemName;
  private String status;
  private String itemSeller;
  private String itemPrize;

  public String getitemID() {
      return itemID;
  }
  public void setitemID(String itemID) {
      this.itemID = itemID;
  }
  public String getStatus(){
	  return status;
  }
  
  public void setStatus(String status){
	  this.status = status;
  }

  public String getItemSeller() {
      return itemSeller;
  }
  public void setItemSeller(String itemSeller) {
      this.itemSeller = itemSeller;
  }

  public String getItemName() {
      return itemName;
  }
  public void setItemName(String itemName) {
      this.itemName = itemName;
  }



 

}
