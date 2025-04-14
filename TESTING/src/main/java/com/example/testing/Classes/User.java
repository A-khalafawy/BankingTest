package com.example.testing.Classes;


public class User {
    private String fName;
    private String lName;
    private String username;
    private String phoneNumber;
    private Account account;
    private String password;
    private String nationalId;
    private static int idCounter = 0;
    private final int id = idCounter;

    public User(String fName, String lName, String username, String phoneNumber,String password,String nationalId) {
        this.fName=fName;
        this.lName = lName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationalId = nationalId;
        account = new Account(1500);
        idCounter++;
    }

    public User(String fName, String lName, String username, String phoneNumber, int balance,String password,String nationalId) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationalId = nationalId;
        account = new Account(balance);
        idCounter++;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getPassword() {
        return password;
    }

    public void acceptMoney(double amount){
        account.deposit(amount);
    }

    public Account getAccount() {return account;}

    public String getUsername() {
        return username;
    }

}



