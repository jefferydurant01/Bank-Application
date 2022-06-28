import java.util.*;
import java.util.Random; 

public class CreditCard{
    private static final double balance = 1000; 
    private static double amountSpent = 0; 

    public CreditCard(){
        //no arg constructor 
    }

    public void run(){
        try
        {
            try
            {
                main();
            }
            catch (CreditCardMaxedException ccme)
            {
                ccme.printStackTrace();
            }
        }
        catch (LowCreditScoreException lcse)
        {
            lcse.printStackTrace();
        } 
    }

    public void main() throws LowCreditScoreException, CreditCardMaxedException{
        System.out.println("Hello, welcome to our Credit Card program. What is your name?"); 
        Scanner input = new Scanner(System.in); 
        String userName = input.next(); 
        System.out.println("Welcome, " + userName); 
        System.out.println(); 
        System.out.println("What would you like to do today?"); 
        System.out.println("1. Check Balance"); 
        System.out.println("2. Sign up for Credit Card"); 
        Scanner selection = new Scanner(System.in); 
        int choice = selection.nextInt(); 

        switch(choice){
            case 1:
                System.out.println("You selected: Check Balance"); 
                System.out.println("Displaying the total Balance: "); 
                System.out.println("Starting Balance: " + balance); 
                System.out.println("Total amount spent: " + amountSpent); 
                System.out.println("Current Balance: " + (balance - amountSpent)); 
                if (this.balance == this.amountSpent){
                    throw new CreditCardMaxedException("BALANCE REACHED. CARD WILL NOW BE LOCKED"); 
                }
                return; 

            case 2: 
                System.out.println("You selected: Sign up for Credit Card"); 
                System.out.println("First Name: "); 
                Scanner input1 = new Scanner(System.in); 
                String firstName = input1.next(); 
                System.out.println("Last Name: "); 
                Scanner input2 = new Scanner(System.in); 
                String lastName = input2.next(); 
                System.out.println("Credit Score: "); 
                Scanner input3 = new Scanner(System.in); 
                int creditScore = input3.nextInt(); 

                if (creditScore < 600){
                    throw new LowCreditScoreException(); 
                } else {
                    Random rand = new Random(); 
                    int upperBound = 999; 
                    int randomNum1 = rand.nextInt(upperBound); 
                    int randomNum2 = rand.nextInt(upperBound); 
                    int randomNum3 = rand.nextInt(upperBound); 
                    int randomNum4 = rand.nextInt(upperBound); 
                    System.out.println("Card Name: " + firstName + lastName);
                    System.out.println("Card Number: " + randomNum1 + " " + randomNum2 + " " + randomNum3 + " " + randomNum4); 
                    Random rand2 = new Random(); 
                    int upperBound2 = 12; 
                    int randomNum5 = rand2.nextInt(upperBound2); 

                    Random rand3 = new Random(); 
                    int upperBound3 = 31; 
                    int randomNum6 = rand3.nextInt(upperBound3); 
                    System.out.println("Expiration date: " + randomNum2 + "/" + randomNum3); 
                    System.out.println("Starting Balance: $1000"); 
                    
                    Random rand4 = new Random(); 
                    int upperBound4 = 999; 
                    int randomNum7 = rand4.nextInt(upperBound4); 
                    System.out.println("CCV Number: " + randomNum7); 
                }
                
                System.out.println("Thank you!"); 
                System.exit(0); 
                return; 

            default:
                System.out.println("No option chosen"); 
                return; 
        }
    }
    
    public double getBalance(){
        return this.balance; 
    }
    
    public double getAmountSpent(){
        return this.amountSpent; 
    }
}
