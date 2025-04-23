package com.example.testing.Tests.TestSuites;

import com.example.testing.Tests.UnitTest.AccountTest;
import com.example.testing.Tests.UnitTest.BillTest;
import com.example.testing.Tests.UnitTest.ItemTest;
import com.example.testing.Tests.UnitTest.UserTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BillTest.class,
        ItemTest.class,
        AccountTest.class,
        UserTest.class
})

public class UnitTestSuite {
}
