package ee.page;

import ee.driver.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    private WebDriver webDriver;
    private int numberOfRowsOnPage;

    public BasePage() {
        webDriver = WebDriverConfig.getDriver();
    }

    public BasePage firstName(String firstName) {
        webDriver.findElement(By.id("firstname")).sendKeys(firstName);
        return this;
    }

    public BasePage surname(String surname) {
        webDriver.findElement(By.id("lastname")).sendKeys(surname);
        return this;
    }

    public BasePage price(String totalPrice) {
        webDriver.findElement(By.id("totalprice")).sendKeys(totalPrice);
        return this;
    }

    public BasePage deposit(String deposit) {
        Select depositeFlag = new Select(webDriver.findElement(By.id("depositpaid")));
        depositeFlag.selectByVisibleText(deposit);
        return this;
    }

    public BasePage checkIn(String checkInDate) {
        webDriver.findElement(By.id("checkin")).sendKeys(checkInDate);
        return this;
    }

    public BasePage checkOut(String checkOutDate) {
        webDriver.findElement(By.id("checkout")).sendKeys(checkOutDate);
        return this;
    }

    public BasePage saveDate() {
        numberOfRowsOnPage = this.getCurrentNumberOfRowsOnPaege();
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.findElement(By.xpath("//*[contains(@value,'Save')]")).click();
        return this;
    }

    public Boolean searchRecords(List<String> dataFields) {
        List<String> testDataField = getExpectedStringList(dataFields);

        this.waitUntilRowsHaveBeenRefreshed();

        List<WebElement> allRowData = webDriver.findElements(By.className("row"));
        for (int i = 0; i < allRowData.size(); i++) {
            List<WebElement> rowData = allRowData.get(i).findElements(By.tagName("p"));
            List<String> extractedRowData = new ArrayList<>();
            for (int j = 0; j< rowData.size(); j++) {
                extractedRowData.add(rowData.get(j).getText());
            }
            if (extractedRowData.equals(testDataField)) {
                return true;
            }
        }
        return false;
    }

    private List<String> getExpectedStringList(List<String> dataFields) {
        List<String> testDataField = new ArrayList<>();
        testDataField.add(dataFields.get(1));
        testDataField.add(dataFields.get(3));
        testDataField.add(dataFields.get(5));
        testDataField.add(dataFields.get(7));
        testDataField.add(dataFields.get(9));
        testDataField.add(dataFields.get(11));
        return testDataField;
    }

    public void bookingTableIsVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookings")));
    }

    public int getLatestRecordId() {
        List<WebElement> allRows = webDriver.findElements(By.className("row"));
        String id = allRows.get(allRows.size() - 2).getAttribute("id");
        return Integer.parseInt(id);
    }

    public BasePage deleteBookingBasedOnId(int bookingId) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.findElement(By.xpath("//*[contains(@onclick,'deleteBooking(" + bookingId + ")')]")).click();
        return this;
    }

    private int getCurrentNumberOfRowsOnPaege() {
        return webDriver.findElements(By.className("row")).size();
    }

    private Boolean waitUntilRowsHaveBeenRefreshed() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                if (numberOfRowsOnPage < webDriver.findElements(By.className("row")).size()) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Unable to wait on the page.");
            }
        }
        return false;
    }
}
