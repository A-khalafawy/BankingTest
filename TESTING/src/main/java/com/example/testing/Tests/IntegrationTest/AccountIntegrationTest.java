package com.example.testing.Tests.IntegrationTest;

import com.example.testing.Classes.Account;
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

public class AccountIntegrationTest {
    @Test
    public void deposit_payForTest() {
        Account acc = new Account(1500);
        acc.deposit(100);
        assertEquals(1600, acc.getBalance(),2);

        assertTrue(acc.payFor(new Item(200)));
        assertEquals(1400, acc.getBalance(),2);
    }

    @Test
    public void deposit_payFor_transferTest() {
        Account acc = new Account(1500);
        acc.deposit(100);
        assertEquals(1600, acc.getBalance(),2);

        assertTrue(acc.payFor(new Item(200)));
        assertEquals(1400, acc.getBalance(),2);

        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "12345678912345");
        assertTrue(acc.transferMoney(user, 300));
        assertEquals(1800, user.getAccount().getBalance(),2);
        assertEquals(1100, acc.getBalance(),2);
    }

    @Test
    public void deposit_payFor_transfer_statementsTest() {
        Account acc = new Account(1500);
        acc.deposit(100);
        assertEquals(1600, acc.getBalance(),2);

        assertTrue(acc.payFor(new Item(200)));
        assertEquals(1400, acc.getBalance(),2);

        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertTrue(acc.transferMoney(user, 300));
        assertEquals(1800, user.getAccount().getBalance(),2);
        assertEquals(1100, acc.getBalance(),2);

        String[] list = acc.getStatements();
        assertEquals("D100.00",list[0]);
        assertEquals("W200.00",list[1]);
        assertEquals("W300.00",list[2]);
    }

    @Test
    public void deposit_payFor_transfer_statements_withdrawTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account acc = new Account(1500);
        acc.deposit(100);
        assertEquals(1600, acc.getBalance(),2);

        assertTrue(acc.payFor(new Item(200)));
        assertEquals(1400, acc.getBalance(),2);

        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertTrue(acc.transferMoney(user, 300));
        assertEquals(1800, user.getAccount().getBalance(),2);
        assertEquals(1100, acc.getBalance(),2);

        String[] list = acc.getStatements();
        assertEquals("D100.00",list[0]);
        assertEquals("W200.00",list[1]);
        assertEquals("W300.00",list[2]);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        boolean result = (boolean) withdrawMethod.invoke(acc, 100);

        assertTrue(result);

        assertEquals(1000, acc.getBalance(),2);
    }

    @Test
    public void deposit_payFor_transfer_statements_withdraw_checkBalanceTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account acc = new Account(1500);
        acc.deposit(100);
        assertEquals(1600, acc.getBalance(), 2);

        assertTrue(acc.payFor(new Item(200)));
        assertEquals(1400, acc.getBalance(), 2);

        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertTrue(acc.transferMoney(user, 300));
        assertEquals(1800, user.getAccount().getBalance(), 2);
        assertEquals(1100, acc.getBalance(), 2);

        String[] list = acc.getStatements();
        assertEquals("D100.00", list[0]);
        assertEquals("W200.00", list[1]);
        assertEquals("W300.00", list[2]);

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
    }

    @Test
    public void deposit_payFor_transfer_statements_withdraw_checkBalance_depositTransactionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account acc = new Account(1500);
        acc.deposit(100);
        assertEquals(1600, acc.getBalance(), 2);

        assertTrue(acc.payFor(new Item(200)));
        assertEquals(1400, acc.getBalance(), 2);

        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertTrue(acc.transferMoney(user, 300));
        assertEquals(1800, user.getAccount().getBalance(), 2);
        assertEquals(1100, acc.getBalance(), 2);

        String[] list = acc.getStatements();
        assertEquals("D100.00", list[0]);
        assertEquals("W200.00", list[1]);
        assertEquals("W300.00", list[2]);

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

        assertEquals("D100.00", statements[4]);
    }

    @Test
    public void deposit_payFor_transfer_statements_withdraw_checkBalance_depositTransaction_Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account acc = new Account(1500);
        acc.deposit(100);
        assertEquals(1600, acc.getBalance(), 2);

        assertTrue(acc.payFor(new Item(200)));
        assertEquals(1400, acc.getBalance(), 2);

        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertTrue(acc.transferMoney(user, 300));
        assertEquals(1800, user.getAccount().getBalance(), 2);
        assertEquals(1100, acc.getBalance(), 2);

        String[] list = acc.getStatements();
        assertEquals("D100.00", list[0]);
        assertEquals("W200.00", list[1]);
        assertEquals("W300.00", list[2]);

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

        assertEquals("D100.00", statements[4]);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawTransactionMethod = Account.class.getDeclaredMethod("withdrawTransaction", double.class);
        withdrawTransactionMethod.setAccessible(true);

        // Invoke the private method
        withdrawTransactionMethod.invoke(acc, 50.0);

        statements = acc.getStatements();

        assertEquals("W50.00", statements[5]);

    }

    @Before
    public void setupBeforeEach() {
        System.out.println("--AccountIntegrationTest-- test case started");
    }

    @After
    public void tearDownAfterEach() {
        System.out.println("--AccountIntegrationTest-- test case ended");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("--AccountIntegrationTest-- Class Testing ended");
    }

}

