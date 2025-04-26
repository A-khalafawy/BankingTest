package com.example.testing.Tests.TestSuites;

import com.example.testing.Tests.IntegrationTest.AccountIntegrationTest;
import com.example.testing.Tests.IntegrationTest.UserIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountIntegrationTest.class,
        UserIntegrationTest.class
})

public class LayerOneIntegration {
}
