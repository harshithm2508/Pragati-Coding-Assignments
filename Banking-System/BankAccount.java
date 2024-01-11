
//  Bank Account class
public class BankAccount{
    String accHolderName;
    long accNumber;
    long accBalance;


    //  Bank Account Constructor
    BankAccount(String accName,long accNumber,long accBalance){
        this.accHolderName = accName;
        this.accNumber = accNumber;
        this.accBalance = accBalance;
    }


    //  Method for checking bank balance
    long getBalance(){
        long amountLeft =  this.accBalance;
        return amountLeft;
    }

    //  Depositing money (adding deposit money to the account balance)
    void deposit(long cash){
        this.accBalance += cash;
    }

    //  Withdrawing money
    void withdraw(long cash){
        if(this.accBalance >= cash){
            this.accBalance -= cash;
        }else{
            System.out.printf("There is no sufficient funds to withdraw (Balance : %d)",this.accBalance);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BankAccount customer_01 = new BankAccount("Harshith Muthangi",1258,50000);
        System.out.println("Account Holder Name : "+customer_01.accHolderName);
        System.out.println("Account Number      : "+customer_01.accNumber);
        System.out.println("Account Balance     : "+customer_01.accBalance);
        System.out.println(" ------------------------------- ");
        customer_01.deposit(20000);
        customer_01.withdraw(50000);
        System.out.println(customer_01.getBalance());
    }
}