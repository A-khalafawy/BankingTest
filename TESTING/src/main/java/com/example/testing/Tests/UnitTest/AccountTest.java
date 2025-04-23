package com.example.testing.Tests.UnitTest;

import com.example.testing.Classes.Account;
import com.example.testing.Classes.Bill;
import com.example.testing.Classes.Item;
import com.example.testing.Classes.User;
import org.junit.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void getBalanceTest1() {
        Account acc = new Account(1500);
        assertEquals(1500, acc.getBalance(), 2);
    }
    @Test
    public void getBalanceTest2() {
        Account acc = new Account(1);
        assertEquals(1, acc.getBalance(),2);
    }
    @Test
    public void getBalanceTest3() {
        Account acc = new Account(0);
        assertEquals(0, acc.getBalance(),2);
    }
    @Test
    public void getBalanceTest4() {
        Account acc = new Account(-1);
        assertEquals(0, acc.getBalance(),2);
    }
    @Test
    public void getBalanceTest5() {
        Account acc = new Account(-100);
        assertEquals(0, acc.getBalance(),2);
    }

    @Test
    public void depositTest1() {
        Account acc3 = new Account(1000);
        acc3.deposit(100);
        assertEquals(1100, acc3.getBalance(),2);
    }
    @Test
    public void depositTest2() {
        Account acc3 = new Account(1500);
        acc3.deposit(-100);
        assertEquals(1500, acc3.getBalance(),2);
    }
    @Test
    public void depositTest3() {
        Account acc3 = new Account(1500);
        acc3.deposit(0);
        assertEquals(1500, acc3.getBalance(),2);
    }
    @Test
    public void depositTest4() {
        Account acc3 = new Account(1500);
        acc3.deposit(100);
        assertEquals(1600, acc3.getBalance(),2);
    }
    @Test
    public void depositTest5() {
        Account acc3 = new Account(1500);
        acc3.deposit(-5);
        assertEquals(1500, acc3.getBalance(),2);
    }

    @Test
    public void payForTest1() {
        Account acc4 = new Account(1500);
        assertFalse(acc4.payFor(new Item(0)));
        assertEquals(1500, acc4.getBalance(),2);
    }
    @Test
    public void payForTest2() {
        Account acc4 = new Account(1500);
        assertTrue(acc4.payFor(new Item(150)));
        assertEquals(1350, acc4.getBalance(),2);
    }
    @Test
    public void payForTest3() {
        Account acc4 = new Account(1500);
        assertFalse(acc4.payFor(new Item(-50)));
        assertEquals(1500, acc4.getBalance(),2);
    }
    @Test
    public void payForTest4() {
        Account acc4 = new Account(1500);
        assertTrue(acc4.payFor(new Item(1))); //0 -> should be false//
        assertEquals(1499, acc4.getBalance(),2);
    }
    @Test
    public void payForTest5() {
        Account acc5 = new Account(1500);
        assertFalse(acc5.payFor(new Bill(-1)));
        assertEquals(1500, acc5.getBalance(),2);
    }
    @Test
    public void payForTest6() {
        Account acc4 = new Account(1000);
        assertFalse(acc4.payFor(new Item(0)));
        assertEquals(1000, acc4.getBalance(),2);
    }
    @Test
    public void payForTest7() {
        Account acc4 = new Account(1500);
        assertTrue(acc4.payFor(new Item(100)));
        assertEquals(1400, acc4.getBalance(),2);
    }
    @Test
    public void payForTest8() {
        Account acc4 = new Account(1500);
        assertFalse(acc4.payFor(new Item(-100)));
        assertEquals(1500, acc4.getBalance(),2);
    }
    @Test
    public void payForTest9() {
        Account acc4 = new Account(1500);
        assertTrue(acc4.payFor(new Item(1))); //0 -> should also be false//
        assertEquals(1499, acc4.getBalance(),2);
    }
    @Test
    public void payForTest10() {
        Account acc5 = new Account(1500);
        assertFalse(acc5.payFor(new Item(-1)));
        assertEquals(1500, acc5.getBalance(),2);
    }
    @Test
    public void payForTest11() {
        Account acc5 = new Account(1500);
        assertFalse(acc5.payFor(new Item(1501)));
        assertEquals(1500, acc5.getBalance(),2);
    }
    @Test
    public void payForTest12() {
        Account acc5 = new Account(1500);
        assertFalse(acc5.payFor(new Bill(1700)));
        assertEquals(1500, acc5.getBalance(),2);
    }

    @Test
    public void TransferMoneyTest1() {
        Account acc7 = new Account(1500);
        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertFalse(acc7.transferMoney(user, 0));
        assertEquals(1500, user.getAccount().getBalance(),2);
        assertEquals(1500, acc7.getBalance(),2);
    }
    @Test
    public void TransferMoneyTest2() {
        Account acc7 = new Account(1500);
        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "20201500");
        assertTrue(acc7.transferMoney(user, 1));
        assertEquals(1501, user.getAccount().getBalance(),2);
        assertEquals(1499, acc7.getBalance(),2);
    }
    @Test
    public void TransferMoneyTest3() {
        Account acc7 = new Account(1500);
        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertFalse(acc7.transferMoney(user, -1));
        assertEquals(1500, user.getAccount().getBalance(),2);
        assertEquals(1500, acc7.getBalance(),2);
    }
    @Test
    public void TransferMoneyTest4() {
        Account acc7 = new Account(1500);
        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertFalse(acc7.transferMoney(user, -500));
        assertEquals(1500, user.getAccount().getBalance(),2);
        assertEquals(1500, acc7.getBalance(),2);
    }
    @Test
    public void TransferMoneyTest5() {
        Account acc7 = new Account(1500);
        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertTrue(acc7.transferMoney(user, 500));
        assertEquals(2000, user.getAccount().getBalance(),2);
        assertEquals(1000, acc7.getBalance(),2);
    }
    @Test
    public void TransferMoneyTest6() {
        Account acc7 = new Account(1400);
        User user = new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1500 ,"0202020", "2020100");
        assertFalse(acc7.transferMoney(user, 1500));
        assertEquals(1500, user.getAccount().getBalance(),2);
        assertEquals(1400, acc7.getBalance(),2);
    }

    @Test
    public void getStatementsTest() {
        Account acc8 = new Account(1500);
        acc8.payFor(new Bill(100));
        acc8.payFor(new Item(50));
        acc8.payFor(new Item(-50));//no change due to the presence of a negative number
        //Transfer 200 to other user
        acc8.transferMoney( new User("Abdallah", "Elkhalafawy", "ak", "01020011111",1000 ,"0202020", "2020100"),200);
        String[] list = acc8.getStatements();
        assertEquals("W100.00",list[0]);
        assertEquals("W50.00",list[1]);
        assertEquals("W200.00",list[2]);

    }

    @Test
    public void withdrawTransactionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawTransactionMethod = Account.class.getDeclaredMethod("withdrawTransaction", double.class);
        withdrawTransactionMethod.setAccessible(true);

        // Invoke the private method
        withdrawTransactionMethod.invoke(account, 50.0);

        String[] statements = account.getStatements();

        assertEquals("W50.00", statements[0]);
    }

    @Test
    public void depositTransactionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method depositTransactionMethod = Account.class.getDeclaredMethod("depositTransaction", double.class);
        depositTransactionMethod.setAccessible(true);

        // Invoke the private method
        depositTransactionMethod.invoke(account, 100.0);

        String[] statements = account.getStatements();

        assertEquals("D100.00", statements[0]);
    }

    @Test
    public void withdrawTest1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        boolean result = (boolean) withdrawMethod.invoke(account, 100);

        assertTrue(result);

        assertEquals(1400, account.getBalance(),2);
    }
    @Test
    public void withdrawTest2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        boolean result = (boolean) withdrawMethod.invoke(account, 1);

        assertTrue(result);

        assertEquals(1499, account.getBalance(),2);
    }
    @Test
    public void withdrawTest3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        boolean result = (boolean) withdrawMethod.invoke(account, 0);

        assertFalse(result);

        assertEquals(1500, account.getBalance(),2);
    }
    @Test
    public void withdrawTest4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        // Invoke the private method
        boolean result = (boolean) withdrawMethod.invoke(account, -1);

        assertFalse(result);

        assertEquals(1500, account.getBalance(),2);
    }
    @Test
    public void withdrawTest5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        // Invoke the private method
        withdrawMethod.invoke(account, -100.0);

        boolean result = (boolean) withdrawMethod.invoke(account, -100.0);

        assertFalse(result);

        assertEquals(1500, account.getBalance(),2);
    }
    @Test
    public void withdrawTest6() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method withdrawMethod = Account.class.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);

        // Invoke the private method
        withdrawMethod.invoke(account, -100.0);

        boolean result = (boolean) withdrawMethod.invoke(account, 1501.0);

        assertFalse(result);

        assertEquals(1500, account.getBalance(),2);
    }

    @Test
    public void checkAmountTest1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1000);

        // Use reflection to access the private method withdrawTransaction()
        Method checkAmountMethod = Account.class.getDeclaredMethod("checkAmount", double.class);
        checkAmountMethod.setAccessible(true);

        // Invoke the private method
        boolean result = (boolean)checkAmountMethod.invoke(account, 100.0);

        assertTrue(result);
    }
    @Test
    public void checkAmountTest2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method checkAmountMethod = Account.class.getDeclaredMethod("checkAmount", double.class);
        checkAmountMethod.setAccessible(true);

        // Invoke the private method
        boolean result = (boolean)checkAmountMethod.invoke(account, 0);

        assertFalse(result);
    }
    @Test
    public void checkAmountTest3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method checkAmountMethod = Account.class.getDeclaredMethod("checkAmount", double.class);
        checkAmountMethod.setAccessible(true);

        // Invoke the private method
        boolean result = (boolean)checkAmountMethod.invoke(account, -100.0);

        assertFalse(result);
    }
    @Test
    public void checkAmountTest4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method checkAmountMethod = Account.class.getDeclaredMethod("checkAmount", double.class);
        checkAmountMethod.setAccessible(true);

        // Invoke the private method
        boolean result = (boolean)checkAmountMethod.invoke(account, -1);

        assertFalse(result);
    }
    @Test
    public void checkAmountTest5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method checkAmountMethod = Account.class.getDeclaredMethod("checkAmount", double.class);
        checkAmountMethod.setAccessible(true);

        // Invoke the private method
        boolean result = (boolean)checkAmountMethod.invoke(account, 1);

        assertTrue(result);
    }
    @Test
    public void checkAmountTest6() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Account account = new Account(1500);

        // Use reflection to access the private method withdrawTransaction()
        Method checkAmountMethod = Account.class.getDeclaredMethod("checkAmount", double.class);
        checkAmountMethod.setAccessible(true);

        // Invoke the private method
        boolean result = (boolean)checkAmountMethod.invoke(account, 1600);

        assertFalse(result);
    }

    @Before
    public void setupBeforeEach() {
        System.out.println("--AccountTest-- test case started");
    }

    @After
    public void tearDownAfterEach() {
        System.out.println("--AccountTest-- test case ended");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("--AccountTest-- Class Testing ended");
    }

}