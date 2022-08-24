package inventory;

public class Flavors {
    private String itemName;
    private int count;

    public Flavors(){
    }

    public Flavors(String itemName, int count) {
        this.itemName = itemName;
        this.count = count;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", itemName, count);
    }
}
