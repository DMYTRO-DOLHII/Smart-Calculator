package exception;

public class NotArithmeticSymbolException extends Exception{

    public NotArithmeticSymbolException(){ }

    public NotArithmeticSymbolException(String message){
        super(message);
    }
}
