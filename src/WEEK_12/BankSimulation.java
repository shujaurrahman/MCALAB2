package WEEK_12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
        }
    }
}



// Main class


public class BankSimulation {
    public static void main(String[] args) {
        // Create an AccountManager instance
        AccountManager accountManager = new AccountManager();

        // Add some bank accounts
        accountManager.addAccount(new BankAccount(101, 1000));
        accountManager.addAccount(new BankAccount(102, 2000));
        accountManager.addAccount(new BankAccount(103, 3000));

        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit deposit and withdrawal tasks to the executor service
        executorService.submit(() -> accountManager.deposit(101, 500));
        executorService.submit(() -> accountManager.withdraw(102, 300));
        executorService.submit(() -> accountManager.deposit(103, 1000));

        // Shutdown the executor service
        executorService.shutdown();
        accountManager.printBalances();
    }
}


