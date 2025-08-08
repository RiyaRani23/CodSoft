import java.util.Scanner;
 class Bank_account{
    private double currBalance;
    // Showing BankBalance
    public Bank_account(double startBalance){
        if(startBalance >= 0){
            currBalance = startBalance;
        }  
        else {
            currBalance = 0 ;
            System.out.println("Starting Balance cannot be negative !!\n Set your current Balance = $0.000000  ");
        }
    }
    // CHECK BALANCE
    public void CheckBalance(){
           System.out.println(" -----******-------\nYour Current Balance : $" + currBalance);
    }
    // DEPOSIT 
    public void DepositAmount(double amount){
        if (amount <= 0){
            System.out.println("Deposit Amount must be Positive \n It cannot be Negative.");
            return;
        }
        currBalance += amount;
          System.out.println(" -----*****----- \n Successfully deposited $" + amount + ".\n Your New Balance is $" + currBalance);
    }
    // WITHDRAW
    public void WithDraw_Amount(double amount){
        if(amount <= 0){
            System.out.println("Negative amount cannot be withdrawal \n Amount must be Positive ");
            return;
        }
        if (amount > currBalance){
            System.out.println(" You have not sufficient Balance ");
            return;
        }
        currBalance -= amount;
        System.out.println(" -----******------\n Successfully Withdrew $" + amount + "\nAfter Withdrawal \n Your Current Balance is $" + currBalance);
        return ;
    }
 }

public class ATM_interface {
     private Bank_account account;

    public ATM_interface(Bank_account account) {
        this.account = account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---***--- ATM Menu ---***----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter 1-4: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.CheckBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    account.DepositAmount(deposit);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    account.WithDraw_Amount(withdraw);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter your initial amount : ");
        double startBalance = sc.nextDouble();
        Bank_account userAccount = new Bank_account(startBalance);
        ATM_interface atm = new ATM_interface(userAccount);
        atm.start();
        sc.close();

    }
}
