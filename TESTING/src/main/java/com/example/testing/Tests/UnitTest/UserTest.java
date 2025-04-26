package com.example.testing.Tests.UnitTest;

import com.example.testing.Classes.User;
import org.junit.*;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void getNationalIdTest(){
        User user1 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111", 1500, "akkk", "12345678912345");
        assertEquals("12345678912345", user1.getNationalId());
    }

    @Test
    public void getPasswordTest(){
        User user2 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111", 1500, "akkk", "12345678912345");
        assertEquals("akkk", user2.getPassword());
    }

    @Test
    public void getAccountTest(){
        User user3 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111", 1500, "akkk", "12345678912345");
        assertEquals(1500 ,user3.getAccount().getBalance(),2);
    }

    @Test
    public void acceptMoneyTest(){
        User user4 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111", 1500, "akkk", "12345678912345");
        user4.acceptMoney(100);
        assertEquals(1600, user4.getAccount().getBalance(), 2);
    }

    @Test
    public void getUsernameTest(){
        User user5 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111", 1000, "akkk", "12345678912345");
        assertEquals("ak", user5.getUsername());
    }

    @Before
    public void setupBeforeEach() {
        System.out.println("--UserTest-- test case started");
    }

    @After
    public void tearDownAfterEach() {
        System.out.println("--UserTest-- test case ended");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("--UserTest-- Class Testing ended");
    }

}