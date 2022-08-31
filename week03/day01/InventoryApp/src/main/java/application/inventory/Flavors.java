package application.inventory;

public class Flavors {
    private CookieFlavor flavorName;
    private int count;

    // constructor

    public Flavors(CookieFlavor flavorName, int count) {
        this.flavorName = flavorName;
        this.count = count;
    }

    public Flavors(){

    }
    // getters and setters

    public CookieFlavor getFlavorName() {

        return flavorName;
    }

    public void setFlavorName(CookieFlavor flavorName) {
        this.flavorName = flavorName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString(){
        return String.format("%s - %s", flavorName, count);
    }
}
