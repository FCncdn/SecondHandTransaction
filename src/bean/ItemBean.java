package bean;

import Publish.ItemDaoImp;
import Publish.Items;
import search.Item;
import search.ItemDao;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemBean implements Serializable {
    String itemName;
    String itemPrice;
    String seller;
    ArrayList<Items> itemsArrayList;

    public ItemBean(){
        itemsArrayList = new ArrayList<Items>();
        itemName = "";
        itemPrice = "";
        seller = "";
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getSeller() {
        return seller;
    }

    public ArrayList<Items> getRecommendItemList(){
        System.out.println("ItemBean - getRecommendItemList:start");
        ArrayList<Items> recommendItemList = new ArrayList<Items>();
        ItemDaoImp itemDaoImp = new ItemDaoImp();
        recommendItemList =  itemDaoImp.getItemList("recommend");
        System.out.println("ItemBean - getRecommendItemList:success, list size:" + Integer.toString(recommendItemList.size()));

        return recommendItemList;
    }

    public Items getItem(int itemId){
        System.out.println("ItemBean - getItem:start");
        Items items = new Items();
        ItemDaoImp itemDaoImp = new ItemDaoImp();
        items = itemDaoImp.getItem(itemId);
        System.out.println("ItemBean - getItem:success");
        return items;
    }
}
