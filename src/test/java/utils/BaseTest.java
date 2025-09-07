package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://testapp.doctorin.app");
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
