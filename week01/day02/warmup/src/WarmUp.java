public class WarmUp {

    public static void main(String[] args) {
        int magicalNumber = 12;
        int birthMonth = 6;
        int birthDay = 4;

        magicalNumber = ((((((((magicalNumber * birthMonth - 1) * 13) + birthDay + 3) * 11) - birthDay - birthMonth)/ 10) + 11) / 100);

        System.out.println(magicalNumber);

        /* create a variable called magicalNumber and save your favourite number to it
        create a variable with your birth month represented by a number
        create a variable with the day of your birth
        update the value of magicalNumber with each of the following:
        Multiply by the month of your birth
        Subtract 1
        Multiply by 13
        Add the day of your birth
        Add 3
        Multiply by 11
        Subtract the month of your birth
        Subtract the day of your birth
        Divide by 10
        Add 11
        Divide by 100
        Print your magicalNumber
         */
    }
}
