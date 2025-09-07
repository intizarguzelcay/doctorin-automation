package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Driver;

public class LoginPage extends BasePage {


    private By changeButton = By.id("AbpTenantSwitchLink");
    private By customerNameInput = By.id("Input_Name");
    private By saveButton = By.cssSelector("button[type='submit']");
    private By usernameInput = By.id("LoginInput_UserNameOrEmailAddress");
    private By passwordInput = By.id("password-input");
    private By loginButton = By.cssSelector("button[type='submit'][name='Action'][value='Login']");
    private By homeHeader = By.xpath("//a[text()='Randevu']");


    public LoginPage() {
        super(Driver.getDriver()); // Burada driver'ı Driver sınıfından alıyoruz
    }

    public void login(String customer, String username, String password) {
        clickElement(changeButton);
        sendKeys(customerNameInput, customer);
        clickElement(saveButton);

        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        clickElement(loginButton);
    }

    public boolean isLoggedIn() {
        By appointmentModule = By.xpath("//p[text()='Randevu']");
        return isElementDisplayed(appointmentModule);
    }
}
