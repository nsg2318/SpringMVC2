package hello.springmvc.basic;


public class SeonkiData {
    private String itemName;
    private String price;

    public SeonkiData(String itemName, String price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
