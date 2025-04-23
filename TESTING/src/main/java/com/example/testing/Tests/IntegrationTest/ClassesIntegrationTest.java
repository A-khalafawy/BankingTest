package com.example.testing.Tests.IntegrationTest;

import com.example.testing.Classes.Account;
import com.example.testing.Classes.Bill;
import com.example.testing.Classes.Item;
import com.example.testing.Classes.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClassesIntegrationTest {
    @Test
    public void Item_BillTest(){
        Bill bill = new Bill(100);
        assertEquals(100, bill.getPrice(),2);

        Item item = new Item(250);
        assertEquals(250, item.getPrice(),2);
    }

    @Test
    public void Item_Bill_UserTest(){
        Bill bill = new Bill(100);
        assertEquals(100, bill.getPrice(),2);

        Item item = new Item(250);
        assertEquals(250, item.getPrice(),2);

        User user1 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertEquals(1500 ,user1.getAccount().getBalance(),2);
        user1.acceptMoney(100);
        assertEquals("2020100", user1.getNationalId());
        assertEquals("0202020", user1.getPassword());
        assertEquals("ak", user1.getUsername());
        assertEquals(1600, user1.getAccount().getBalance(), 2);
    }

    @Test
    public void Item_Bill_User_AccountTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Bill bill = new Bill(100);
        assertEquals(100, bill.getPrice(),2);

        Item item = new Item(300);
        assertEquals(300, item.getPrice(),2);

        User user1 = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertEquals(1500 ,user1.getAccount().getBalance(),2);
        user1.acceptMoney(100);
        assertEquals("2020100", user1.getNationalId());
        assertEquals("0202020", user1.getPassword());
        assertEquals("ak", user1.getUsername());
        assertEquals(1600, user1.getAccount().getBalance(), 2);

        Account acc = user1.getAccount();
        acc.deposit(100);
        assertEquals(1700, acc.getBalance(), 2);

        //item costs 300
        assertTrue(acc.payFor(item));
        assertEquals(1400, acc.getBalance(), 2);

        User newUser = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertTrue(acc.transferMoney(newUser, 300));
        assertEquals(1800, newUser.getAccount().getBalance(), 2);
        assertEquals(1100, acc.getBalance(), 2);

        String[] list = acc.getStatements();
        assertEquals("D100.00", list[0]);
        assertEquals("D100.00", list[1]);
        assertEquals("W300.00", list[2]);
        assertEquals("W300.00", list[3]);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        boolean result = (boolean) withdrawMethod.invoke(acc, 100);

        assertTrue(result);

        assertEquals(1000, acc.getBalance(), 2);


        // Use reflection to access the private method withdrawTransaction()
        Method checkAmountMethod = Account.class.getDeclaredMethod("checkAmount", double.class);
        checkAmountMethod.setAccessible(true);

        // Invoke the private method
        boolean result2 = (boolean) checkAmountMethod.invoke(acc, 100.0);

        assertTrue(result2);

        // Use reflection to access the private method withdrawTransaction()
        Method depositTransactionMethod = Account.class.getDeclaredMethod("depositTransaction", double.class);
        depositTransactionMethod.setAccessible(true);

        // Invoke the private method
        depositTransactionMethod.invoke(acc, 100.0);

        String[] statements = acc.getStatements();

        assertEquals("D100.00", statements[5]);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawTransactionMethod = Account.class.getDeclaredMethod("withdrawTransaction", double.class);
        withdrawTransactionMethod.setAccessible(true);

        // Invoke the private method
        withdrawTransactionMethod.invoke(acc, 50.0);

        statements = acc.getStatements();

        assertEquals("W50.00", statements[6]);

    }

    @Before
    public void setupBeforeEach() {
        System.out.println("--ClassesIntegrationTest-- test case started");
    }

    @After
    public void tearDownAfterEach() {
        System.out.println("--ClassesIntegrationTest-- test case ended");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("--ClassesIntegrationTest-- Class Testing ended");
    }

}
