package WEEK_12;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {
    private final Map<Integer, BankAccount> accounts;
    private final Lock lock;

    public AccountManager() {
        this.accounts = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void deposit(int accountNumber, double amount) {
        lock.lock();
        try {
            BankAccount account = accounts.get(accountNumber);
            if (account != null) {
                account.deposit(amount);
                System.out.println("Deposited " + amount + " into account " + accountNumber);
            } else {
                System.out.println("Account " + accountNumber + " not found");
            }
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int accountNumber, double amount) {
        lock.lock();
        try {
            BankAccount account = accounts.get(accountNumber);
            if (account != null) {
                account.withdraw(amount);
                System.out.println("Withdrawn " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Account " + accountNumber + " not found");
            }
        } finally {
            lock.unlock();
        }
    }

    public void printBalances() {
        lock.lock();
        try {
            for (BankAccount account : accounts.values()) {
                System.out.println("Account " + account.getAccountNumber() + ": Balance = " + account.getBalance());
            }
        } finally {
            lock.unlock();
        }
    }
}
