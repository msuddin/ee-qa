package ee.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ee.page.BasePage;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinition {

    private BasePage bookingPage = new BasePage();
    private List<String> dataFields;

    @When("^I am on the booking form and enter data$")
    public void enterDataIntoBookingForm(DataTable formData) {
        dataFields = formData.asList(String.class);
        bookingPage.firstName(dataFields.get(1));
        bookingPage.surname(dataFields.get(3));
        bookingPage.price(dataFields.get(5));
        bookingPage.deposit(dataFields.get(7));
        bookingPage.checkIn(dataFields.get(9));
        bookingPage.checkOut(dataFields.get(11));
    }

    @When("^I save it$")
    public void saveDate() {
        bookingPage.saveDate();
    }

    @Then("^I should see the booking$")
    public void shouldSeeBooking() {
        assertThat(bookingPage.searchRecords(dataFields), is(true));
    }
}
