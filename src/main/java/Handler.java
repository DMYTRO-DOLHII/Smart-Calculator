import exception.ExceptionHandler;

/**
 * This class connects exception.ExceptionHandler and Calculator
 *
 * @author Dmytro Dolhii
 */
public class Handler {


    private final String input;
    private final ExceptionHandler exceptionHandler;


    /**
     * Constructor. Stores the given expression
     *
     * @param input Expression that will be solved
     */
    public Handler(String input){
        this.input = input;
        exceptionHandler = new ExceptionHandler();
    }


    /**
     * @return
     */
    public boolean checkForExceptions(){
        return exceptionHandler.hasException(this.input);
    }


}
