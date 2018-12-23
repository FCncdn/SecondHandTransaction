package search;

public class Item {
    public int id,alexa;
    public String name;
    public String url;
    public String country;
    private String price;
    private String hrefPath;

    public Item() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getalexa() {
        return alexa;
    }
    public void setalexa(int alexa) {
        this.alexa = alexa;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String geturl() {
        return url;
    }
    public void seturl(String url) {
        this.url = url;
    }
    public String getcountry() {
        return country;
    }
    public void setcountry(String country) {
        this.country = country;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHrefPath() {
        return hrefPath;
    }

    public void setHrefPath(String hrefPath) {
        this.hrefPath = hrefPath;
    }
}