package com.example.testing.Tests.UnitTest;

import com.example.testing.Classes.Item;
import org.junit.*;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void getPriceTest1() {
        Item item = new Item(1000);
        assertEquals(1000, item.getPrice(), 2);
    }

    @Test
    public void getPriceTest2() {
        Item item = new Item(1);
        assertEquals(1, item.getPrice(), 2);
    }

    @Test
    public void getPriceTest3() {
        Item item = new Item(0);
        assertEquals(0, item.getPrice(), 2);
    }

    @Test
    public void getPriceTest4() {
        Item item = new Item(-1);
        assertEquals(0, item.getPrice(),2);
    }

    @Test
    public void getPriceTest5() {
        Item item = new Item(-1000);
        assertEquals(0, item.getPrice(),2);
    }

    @Before
    public void setupBeforeEach() {
        System.out.println("--ItemTest-- test case started");
    }

    @After
    public void tearDownAfterEach() {
        System.out.println("--ItemTest-- test case ended");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("--ItemTest-- Class Testing ended");
    }

}