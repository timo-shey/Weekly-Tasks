package CustomException;

public class UsageException extends Exception {
    private String errorMessage;

    public UsageException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
