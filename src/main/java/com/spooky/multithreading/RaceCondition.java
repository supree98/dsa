package com.spooky.multithreading;

public class RaceCondition {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(100);

        Thread t1 = new Thread(bankAccount);
        t1.setName("Lionel Messi");
        Thread t2 = new Thread(bankAccount);
        t2.setName("Cristiano Ronaldo");

        t1.start();
        t2.start();
    }
}

class BankAccount implements Runnable {

    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is about make a withdrawal...");
        makeWithdrawal(70);
        if (balance < 0) {
            System.out.println("Amount somehow overdrawn!");
        }
    }

    private /*synchronized*/ void makeWithdrawal(int amount) {
        if (amount < balance) {
             /* t1 might have entered the condition and released,
             in this scenario t2 will also enter the block and make withdraw
             because, t1 has not deducted the amount yet since it has just entered the block and released
             Amount will be Overdrawn in this scenario!!! */
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrawn Rs." + amount);
        }
    }
}
