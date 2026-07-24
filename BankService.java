import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void createAccount(String accNum, String name, double initialDeposit) {
        if (accounts.containsKey(accNum)) {
            System.out.println("Account number already exists!");
            return;
        }
        BankAccount newAccount = new BankAccount(accNum, name, initialDeposit);
        accounts.put(accNum, newAccount);
        System.out.println("Account created successfully for " + name);
    }

    public BankAccount getAccount(String accNum) {
        return accounts.get(accNum);
    }

    public void transferFunds(String sourceAcc, String destAcc, double amount) {
        BankAccount from = accounts.get(sourceAcc);
        BankAccount to = accounts.get(destAcc);

        if (from == null || to == null) {
            System.out.println("One or both account numbers are invalid.");
            return;
        }

        if (from.withdraw(amount)) {
            to.deposit(amount);
            System.out.println("Transfer of $" + amount + " completed successfully.");
        }
    }
}
