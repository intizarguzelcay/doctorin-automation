package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AppointmentPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AppointmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locators
    private final By appointmentModuleLink = By.xpath("//a[contains(@href,'appointment-service/appointments') and .//p[text()='Randevu']]");
    private final By filterButton = By.cssSelector("button[data-testid='filter-button']");
    private final By branchDropdownIcon = By.xpath("(//span[contains(@class,'e-ddl')]//span[contains(@class,'e-ddl-icon')])[1]");
    private final By acceptButton = By.xpath("//button[text()='Kabul et']");
    private final By firstEmptyAppointmentCell = By.xpath("//td[contains(@class,'e-work-cells') and contains(@class,'sf-active-cell')]");
    private final By patientSearchInput = By.xpath("//input[@data-testid='appointment-patient-search']");
    private final By patientSearchButton = By.xpath("//button[text()='Ara']");
    private final By patientSearchResults = By.xpath("//div[@data-testid='patient-item-0']");
    private final By saveAppointmentButton = By.xpath("//button[@data-testid='save-button']");
    private final By saveSuccessToast = By.xpath("//div[contains(@class,'toast-success')]");
    private final By appointmentCell = By.xpath("//span[text()='İNTİZAR GÜZELÇAY']");
    private final By checkInButton = By.xpath("//button[@data-testid='status-button']");
    private final By deleteButton = By.cssSelector("button[data-testid='appointment-delete-button']");
    private final By deleteSuccessToast = By.xpath("//div[contains(@class,'toast-success')]");


    public void openAppointmentModule() {
        clickElement(appointmentModuleLink);
    }
    public void clickFilterButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(branchDropdownIcon));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.e-ddl.e-lib.e-input-group"))); // departman container
    }

    public void selectBranch(String branchName) {
        WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(branchDropdownIcon));
        icon.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@role='option' and text()='" + branchName + "']")));
        option.click();
    }


    public void selectDepartment(String departmentName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span.e-ddl.e-lib.e-input-group")
        ));
        dropdown.click();

        By optionLocator = By.xpath("//li[contains(@class,'e-list-item') and text()='" + departmentName + "']");
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(option).perform();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

        WebElement input = driver.findElement(By.id("dropdownlist-205c1b46-d30a-446a-8cc7-bdc27b2b524e"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(input, departmentName));
    }

    public void clickAcceptButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        button.click();
    }


    public void clickFirstEmptyAppointmentCell() {
        clickElement(firstEmptyAppointmentCell);
    }

    public void searchAndSelectPatient(String patientName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(patientSearchInput));
        searchBox.clear();
        searchBox.sendKeys(patientName);
        clickElement(patientSearchButton);

        List<WebElement> results = findElements(patientSearchResults);
        if (!results.isEmpty()) {
            results.get(0).click();
        } else {
            Assert.fail("Patient not found: " + patientName);
        }
    }

    public void saveAppointment() {
        clickElement(saveAppointmentButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveSuccessToast));
    }

    public boolean isAppointmentSaved() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(saveSuccessToast));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSavedAppointment() {
        clickElement(appointmentCell);
    }

    public void checkIn() {
        clickElement(checkInButton);
    }

    public void deleteAppointment() {
        clickElement(deleteButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessToast));
    }

    public boolean isAppointmentDeleted() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessToast));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
