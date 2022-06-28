public class NegativeBankAmountException extends Exception{
    public NegativeBankAmountException(){
        super(); 
    }
    
    public NegativeBankAmountException(String message){
        super(message); 
    }
}