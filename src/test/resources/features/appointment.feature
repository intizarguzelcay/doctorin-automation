Feature: Appointment Management

  Background:
    Given The user goes to the Doctorin test page
    And The user enters "Nişantaşı Klinik" as customer, "Test" as username, and "Test123." as password
    And The user is logged in

  Scenario: Create and complete an appointment
    When The user goes to the Appointment module
    And The user opens the filter and selects "Nişantaşı" as branch and "Çocuk Hastalıkları" as department
    And The user clicks the first empty appointment cell
    And The user searches for and selects the patient "İNTİZAR GÜZELÇAY"
    And The user saves the appointment
    Then The appointment should be saved successfully
    And The user clicks the saved appointment
    And The user performs check-in
    And The user deletes the appointment
    Then The appointment should be deleted successfully
