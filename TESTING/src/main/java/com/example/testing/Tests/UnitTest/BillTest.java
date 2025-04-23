package com.example.testing.Tests.UnitTest;

import com.example.testing.Classes.Bill;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BillTest {

    @Before
    public void setupBeforeEach() {
        System.out.println("--BillTest-- test case started");
    }

    @After
    public void tearDownAfterEach() {
        System.out.println("--BillTest-- test case ended");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("--BillTest-- Class Testing ended");
    }


    @Test
    public void getPriceTest1() {
        Bill bill = new Bill(1500);
        assertEquals(1500, bill.getPrice(),2);
    }

    @Test
    public void getPriceTest2() {
        Bill bill = new Bill(1);
        assertEquals(1, bill.getPrice(), 2);
    }

    @Test
    public void getPriceTest3() {
        Bill bill = new Bill(0);
        assertEquals(0, bill.getPrice(), 2);
    }

    @Test
    public void getPriceTest4() {
        Bill bill = new Bill(-1);
        assertEquals(0, bill.getPrice(), 2);
    }

    @Test
    public void getPriceTest5() {
        Bill bill = new Bill(-1000);
        assertEquals(0, bill.getPrice(), 2);
    }

}