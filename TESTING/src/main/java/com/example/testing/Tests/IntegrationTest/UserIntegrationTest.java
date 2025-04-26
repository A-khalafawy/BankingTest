package com.example.testing.Tests.IntegrationTest;

import com.example.testing.Classes.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserIntegrationTest {
    @Test
    public void getNationalId_PasswordTest(){
        User user1 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertEquals("2020100", user1.getNationalId());
        assertEquals("0202020", user1.getPassword());
    }

    @Test
    public void getNationalId_Password_UsernameTest(){
        User user1 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertEquals("2020100", user1.getNationalId());
        assertEquals("0202020", user1.getPassword());
        assertEquals("ak", user1.getUsername());
    }

    @Test
    public void getNationalId_Password_Username_AccountTest(){
        User user1 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertEquals("2020100", user1.getNationalId());
        assertEquals("0202020", user1.getPassword());
        assertEquals("ak", user1.getUsername());
        assertEquals(1500 ,user1.getAccount().getBalance(),2);
    }

    @Test
    public void getNationalId_Password_Username_Account_acceptMoneyTest(){
        User user1 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertEquals(1500 ,user1.getAccount().getBalance(),2);
        user1.acceptMoney(100);
        assertEquals("2020100", user1.getNationalId());
        assertEquals("0202020", user1.getPassword());
        assertEquals("ak", user1.getUsername());
        assertEquals(1600, user1.getAccount().getBalance(), 2);
    }

    @Before
    public void setupBeforeEach() {
        System.out.println("--UserIntegrationTest-- test case started");
    }

    @After
    public void tearDownAfterEach() {
        System.out.println("--UserIntegrationTest-- test case ended");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("--UserIntegrationTest-- Class Testing ended");
    }

}
