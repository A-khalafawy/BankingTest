module com.example.testing {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.testing to javafx.fxml;
    exports com.example.testing;
    exports com.example.testing.Controllers;
    exports com.example.testing.Classes;
    opens com.example.testing.Controllers to javafx.fxml;
    exports com.example.testing.Tests.TestSuites;
    exports com.example.testing.Tests.UnitTest;
    exports com.example.testing.Tests.IntegrationTest;
}