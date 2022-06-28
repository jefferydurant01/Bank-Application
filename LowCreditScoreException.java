public class LowCreditScoreException extends Exception{
    public LowCreditScoreException(){
        super(); 
    }

    public LowCreditScoreException(String message){
        super(message); 
    }
}
