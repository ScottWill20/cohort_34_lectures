package application.inventory;

public enum CookieFlavor {
    PEANUTBUTTER("Peanut Butter"),
    CHOCOLATE_CHIP("Chocolate Chip"),
    SNICKERDOODLE("Snickerdoodle"),
    WHITE_CHOCLATE("White Chocolate Macadamia Nut"),
    OATMEAL_RASIN("Oatmeal Rasin");

    private final String displayText;

    CookieFlavor(String displayText){
        this.displayText = displayText;
    }

    public String getDisplayText(){
        return displayText;
    }

}
