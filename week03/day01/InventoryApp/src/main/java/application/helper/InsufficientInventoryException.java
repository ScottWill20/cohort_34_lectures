package application.helper;

public class InsufficientInventoryException extends Exception{

    public InsufficientInventoryException(String message){
        super(message);
    }

    public InsufficientInventoryException(){
        super("You cannot create a flavor with no inventory");
    }
}
