public class Dog {
    // classes should represent a single real world idea
    // fields

    private String name;
    private String breed;
    private String color;
    public boolean kids;
    public boolean otherPets;
    private int age;
    public int energyLevel;
    private String trick;

    // constructor
    public Dog() {
    }

    public Dog(String name, String breed, String color, boolean kids, boolean otherPets, int age, int energyLevel) {
        // assign parameters to fields
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.kids = kids;
        this.otherPets = otherPets;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isKids() {
        return kids;
    }

    public void setKids(boolean kids) {
        this.kids = kids;
    }

    public boolean isOtherPets() {
        return otherPets;
    }

    public void setOtherPets(boolean otherPets) {
        this.otherPets = otherPets;
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

    public String getTrick() {
        return trick;
    }

    public void setTrick(String trick) {
        this.trick = trick;
    }

    // Methods

    public void description() {
        System.out.printf("%s is a %s. They are %s years old and their energy level is %s.%n", name, breed, age, energyLevel);
    }

    public void hasTricks(String trick) {
        System.out.printf("%s knows %s.", name, trick);
    }


    // override to string
    @Override
    public String toString() {
        return String.format("%s is a %s.", name, breed);
    }

}



