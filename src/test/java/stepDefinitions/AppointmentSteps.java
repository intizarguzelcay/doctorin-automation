package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AppointmentPage;
import utilities.Driver;

public class AppointmentSteps {

    private WebDriver driver = Driver.getDriver();
    private AppointmentPage appointmentPage = new AppointmentPage(driver);

    @When("The user goes to the Appointment module")
    public void goToAppointmentModule() {
        appointmentPage.openAppointmentModule();
    }

    @And("The user opens the filter and selects {string} as branch and {string} as department")
    public void applyFilter(String branch, String department) {
        appointmentPage.clickFilterButton();
        appointmentPage.selectBranch(branch);
        appointmentPage.selectDepartment(department);
        appointmentPage.clickAcceptButton();
    }

    @When("The user clicks the first empty appointment cell")
    public void clickFirstAppointmentCell() {
        appointmentPage.clickFirstEmptyAppointmentCell();
    }

    @When("The user searches for and selects the patient {string}")
    public void searchAndSelectPatient(String patientName) {
        appointmentPage.searchAndSelectPatient(patientName);
    }

    @When("The user saves the appointment")
    public void saveAppointment() {
        appointmentPage.saveAppointment();
    }

    @Then("The appointment should be saved successfully")
    public void verifyAppointmentSaved() {
        Assert.assertTrue(appointmentPage.isAppointmentSaved(), "Appointment kaydedilemedi");
    }

    @When("The user clicks the saved appointment")
    public void clickSavedAppointment() {
        appointmentPage.clickSavedAppointment();
    }

    @When("The user performs check-in")
    public void checkIn() {
        appointmentPage.checkIn();
    }

    @When("The user deletes the appointment")
    public void deleteAppointment() {
        appointmentPage.deleteAppointment();
    }

    @Then("The appointment should be deleted successfully")
    public void verifyAppointmentDeleted() {
        Assert.assertTrue(appointmentPage.isAppointmentDeleted(), "Appointment silinemedi");
    }
}
