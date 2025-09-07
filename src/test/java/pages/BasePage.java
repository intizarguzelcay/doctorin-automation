package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = Driver.getDriver();
        this.wait = Driver.getWait();
    }

    public void clickElement(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = waitForClickability(locator);
                element.click();
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                attempts++;
                sleep(200);
            }
        }
    }

    public void sendKeys(By locator, String text) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = waitForClickability(locator);
                element.clear();
                element.sendKeys(text);
                break;
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                attempts++;
                sleep(200);
            }
        }
    }

    public void pressEnter(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = waitForClickability(locator);
                element.sendKeys(Keys.ENTER);
                break;
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                attempts++;
                sleep(200);
            }
        }
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = waitForVisibility(locator);
            return element.isDisplayed();
        } catch (TimeoutException | StaleElementReferenceException e) {
            return false;
        }
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}
