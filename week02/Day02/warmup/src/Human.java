public class Human {
    // fields
    private String name;
    public String livingType;
    public boolean hasKids;
    public boolean hasPets;
    private int age;
    public int energyLevel;

    // constructor

    public Human() { }

    public Human(String name, String livingType, boolean hasKids, boolean hasPets, int age, int energyLevel) {
        this.name = name;
        this.livingType = livingType;
        this.hasKids = hasKids;
        this.hasPets = hasPets;
        this.age = age;
        this.energyLevel = energyLevel;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLivingType() {
        return livingType;
    }

    public void setLivingType(String livingType) {
        this.livingType = livingType;
    }

    public boolean isHasKids() {
        return hasKids;
    }

    public void setHasKids(boolean hasKids) {
        this.hasKids = hasKids;
    }

    public boolean isHasPets() {
        return hasPets;
    }

    public void setHasPets(boolean hasPets) {
        this.hasPets = hasPets;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    // override to string

    @Override
    public String toString() {
        return "Human{" +
                "name ='" + name + '\'' +
                ", livingType ='" + livingType + '\'' +
                ", hasKids =" + hasKids +
                ", hasPets =" + hasPets +
                ", age =" + age +
                ", energyLevel =" + energyLevel +
                '}';
    }


}
