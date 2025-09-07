package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utilities.Driver;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("The user goes to the Doctorin test page")
    public void openDoctorinTestPage() {
        Driver.getDriver().get("https://testapp.doctorin.app");
    }

    @When("The user enters {string} as customer, {string} as username, and {string} as password")
    public void enterCustomerUsernameAndPassword(String customer, String username, String password) {
        loginPage.login(customer, username, password);
    }

    @And("The user is logged in")
    public void theUserIsLoggedIn() {
        Assert.assertTrue(loginPage.isLoggedIn(), "Login başarısız!");
    }

}

