import java.sql.SQLOutput;
import java.util.Scanner;
public class App {
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        // Dog ada = new Dog("Ada", "Bali Dog", "brindle", true, false, 5, 3);
        // ada.description();
        Dog noa = addDog();
       // noa.description();
       // ada.description();
        Human evann = addHuman();
        // System.out.println(evann);

       // Human scott = new Human("Scott", "Apartment", false, false, 27, 6);
        // System.out.println(scott);

        isMatch(evann,noa);



    }

    // Helper Classes
    // these are not instance based, therefore static is fine but not preferred
    // could create "Helper" class and drop the read methods there

    public static String readString(String prompt) {
        String str;
        do {
            System.out.println(prompt);
            str = console.nextLine();
            if (str.isBlank()) {
                System.out.println("You must enter a value.");
            }
        } while(str.isBlank());
        return str;
    }
    public static int readInt(String prompt) {
        String input = readString(prompt);
        return Integer.parseInt(input);
    }
    public static boolean readBoolean(String prompt) {
        String result = readString(prompt);
        return result.equalsIgnoreCase("yes");
    }

    public static Dog addDog() {

        System.out.println();
        System.out.println("Add a new dog");
        System.out.println("=============");
        Dog dog = new Dog();
        dog.setName(readString("What is the dog's name?: "));
        dog.setAge(readInt("How old is the dog?: "));
        dog.setBreed(readString("What breed is the dog?: "));
        dog.setColor(readString("What color is the dog?: "));
        dog.setEnergyLevel(readInt("What is the dog's energy level? [1-10]: "));
        dog.setKids(readBoolean("Is this dog good with kids?: "));
        dog.setOtherPets(readBoolean("Is this dog good with other pets?: "));
        return dog;
    }

    public static Human addHuman() {

        System.out.println();
        System.out.println("Add a new human");
        System.out.println("===============");
        Human human = new Human();
        human.setAge(readInt("How old is the human?: "));
        human.setLivingType(readString("What type of home does the human live in?: "));
        human.setEnergyLevel(readInt("What is the human's energy level? [1-10]: "));
        human.setHasKids(readBoolean("does this human have children in the home?: "));
        human.setHasPets(readBoolean("Does this human have other pets in the home?"));
        return human;
    }

    // write a method to see if we can match human and dog
    // in order for the human and the dog to match:
        // if human has kids or pets, and dog is not good with kids or pets, do not match
        // if dog's energy level is > 6 and the human lives in an apartment, do not match
        // if human's energy level is not within 3 points of dog, do not match

    public static boolean isMatch(Human human, Dog dog) {
        if ((dog.kids == human.hasKids) && (dog.otherPets == human.hasPets)) {
            if (dog.energyLevel > 6 && human.livingType.equalsIgnoreCase("apartment")){
                System.out.println("Sorry, this dog is not for you");
                return false;
            } else if (dog.energyLevel >= (human.getEnergyLevel() + 3) || dog.energyLevel <=(human.energyLevel) - 3) {
                System.out.println("Sorry, this dog is not for you");
                return false;
            } else {
                System.out.println("This dog might be your perfect match, please arrange a time to meet them!");
                return true;
            }
        } else {
            System.out.println("Sorry, this dog is not for you");
            return false;
        }
    }


}
