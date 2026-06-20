package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    WebDriver webDriver;

    public homePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Locator from register button
    By RegisterButton = By.xpath("//*[@class='button'][@value='Register']");
    // Method Click register button
    public void clickRegister() {
        webDriver.findElement(RegisterButton).click();
    }
}
