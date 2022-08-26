package learn.collections;

public class CityAnimal {

    private String name;
    private String species;
    private int researchNumber;

    //Constructors

    public CityAnimal(String name, String species, int researchNumber) {
        this.name = name;
        this.species = species;
        this.researchNumber = researchNumber;
    }

    public CityAnimal() {
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getResearchNumber() {
        return researchNumber;
    }

    public void setResearchNumber(int researchNumber) {
        this.researchNumber = researchNumber;
    }

    // override some built-in methods
    // toString - by default shows location of object in memory - we want to override so its more useful to us
    @Override
    public String toString() {
        return String.format("Name: %s - species: %s - Research Number: %s%n", name, species, researchNumber);
    }

    // stringOne.equals(stringTwo);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityAnimal animal = (CityAnimal) o;
        return researchNumber == animal.researchNumber; // this is what determines uniqueness
    }

    @Override
    public int hashCode() {
        return 1; // this is for performance
    }
}
