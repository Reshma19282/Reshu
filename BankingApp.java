 import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Welcome to the Console Banking Application ---");

        while (running) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    bankService.createAccount(accNum, name, initialDeposit);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAcc = scanner.nextLine();
                    BankAccount dAcc = bankService.getAccount(depAcc);
                    if (dAcc != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double amt = scanner.nextDouble();
                        dAcc.deposit(amt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withAcc = scanner.nextLine();
                    BankAccount wAcc = bankService.getAccount(withAcc);
                    if (wAcc != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double amt = scanner.nextDouble();
                        wAcc.withdraw(amt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String checkAcc = scanner.nextLine();
                    BankAccount cAcc = bankService.getAccount(checkAcc);
                    if (cAcc != null) {
                        System.out.println("Account Holder: " + cAcc.getAccountHolder());
                        System.out.println("Current Balance: $" + cAcc.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Your Account Number: ");
                    String src = scanner.nextLine();
                    System.out.print("Enter Destination Account Number: ");
                    String dest = scanner.nextLine();
                    System.out.print("Enter Transfer Amount: ");
                    double transAmt = scanner.nextDouble();
                    bankService.transferFunds(src, dest, transAmt);
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
        scanner.close();
    }
}
 
    

