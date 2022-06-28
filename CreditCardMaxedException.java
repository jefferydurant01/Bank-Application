public class CreditCardMaxedException extends Exception{
    public CreditCardMaxedException(){
        super(); 
    }
    
    public CreditCardMaxedException(String message){
        super(message); 
    }
}