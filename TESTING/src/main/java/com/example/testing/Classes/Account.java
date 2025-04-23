package com.example.testing.Classes;

import java.text.DecimalFormat;

public class Account {
    public static DecimalFormat decfor = new DecimalFormat("0.00");
    private double balance;
    private String transactions[] = new String[10];
    private int transactionIndex;
    private static int idCounter = 0;
    private final int id = idCounter;

    public Account(double balance) {
        if(balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
        idCounter++;
        transactionIndex = 0;
    }

    private void withdrawTransaction(double amount){
        if(transactions[9] == null){
            transactions[transactionIndex] = "W" + decfor.format(amount);
            transactionIndex++;
        }else{
            for(int i = 0; i < 9; i++)
                transactions[i] = transactions[i+1];
            transactions[9] = "W" + amount;
        }
    }

    private void depositTransaction(double amount){
        if(transactions[9] == null){
            transactions[transactionIndex] = "D" + decfor.format(amount);
            transactionIndex++;
        }else{
            for(int i = 0; i < 9; i++)
                transactions[i] = transactions[i+1];
            transactions[9] = "D" + amount;
        }
    }

    private boolean checkAmount(double inputAmount){
        if(inputAmount <= 0)
            return false;
        return balance >= inputAmount;
    }

    private boolean withdraw(double inputAmount) {
        if (checkAmount(inputAmount)) {
            balance -= inputAmount;
            withdrawTransaction(inputAmount);
            return true;
        } else{
            return false;
        }
    }

    public void deposit(double inputAmount) {
        if (inputAmount > 0) {
            balance += inputAmount;
            depositTransaction(inputAmount);
        }
    }

    public double getBalance(){
        return balance;
    }

    public boolean payFor(Item item) {
        double price = item.getPrice();
        if (withdraw(price))
            return true;
        else
            return false;
    }

    public boolean payFor(Bill bill) {
        double price = bill.getPrice();
        if (withdraw(price)) return true;
        else return false;
    }

    public boolean transferMoney(User user,double amount){
        if (withdraw(amount)) {
            user.acceptMoney(amount);
            return true;
        } else{
            return false;
        }
    }

    public String[] getStatements(){
        return transactions;
    }

}


