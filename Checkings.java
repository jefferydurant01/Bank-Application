import java.util.*;

public class Checkings{
    private double balance; 
    public Checkings(){
        this.balance = 0; 
    }

    public Checkings(double amount) throws NegativeBankAmountException {
        if (amount < 0){
            System.out.println("You are trying to set balance to zero. Do you want to transfer the money in the account? Type Y/N"); 
            Scanner input = new Scanner(System.in); 
            String answer = input.next(); 
            switch (answer){
                case "Y": 
                    Checkings newAccount = new Checkings(); 
                    transferMoney(newAccount); 
                    return; 
                case "N":
                    this.balance = 0; 
                    return; 
            }
        }
        this.balance = amount; 
    }

    public double getBalance(){
        return this.balance; 
    }

    public void setBalance(double amount) throws NegativeBankAmountException{
        if (amount < 0){
            throw new NegativeBankAmountException(); 
        } else {
            this.balance = amount; 
        }
    }

    public void transferMoney(Checkings account) throws NegativeBankAmountException {
        if(this.balance == 0){
            throw new NegativeBankAmountException("Error, no money to transfer"); 
        } 
        double oldBalance = this.getBalance(); 
        double newBalance = account.getBalance(); 
        newBalance += oldBalance; 
        account.setBalance(newBalance); 
    }

    public double withdraw(double amount) throws NegativeBankAmountException {
        if (amount > balance){
            System.out.println("Error, amount to be withdrawn is greater than balance"); 
            throw new NegativeBankAmountException("Invalid Withdraw"); 
        } 
        return balance - amount; 
    }

    public void deposit(double amount){
        double newBalance = amount + this.getBalance(); 
        try
        {
            setBalance(newBalance);
        }
        catch (NegativeBankAmountException nbae)
        {
            nbae.printStackTrace();
        } 
    }
}