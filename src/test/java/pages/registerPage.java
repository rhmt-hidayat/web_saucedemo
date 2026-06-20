package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage {
    WebDriver webDriver;

    public registerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Locator from input register
    By firstnameField = By.id("customer.firstName");
    By lastnameField = By.id("customer.lastName");

    // Input value form
    public void inputNameData(String firstname, String lastname) {
        webDriver.findElement(firstnameField).sendKeys(firstname);
        webDriver.findElement(lastnameField).sendKeys(lastname);
    }
}
