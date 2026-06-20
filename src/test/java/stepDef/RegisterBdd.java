package stepDef;

import pages.homePage;
import pages.registerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.env_target;
import java.time.Duration;
import java.util.Random;

public class RegisterBdd extends env_target {
    @Given("User is on para bank homepage")
    public void userIsOnParaBankHomepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(paraBank);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']/h2"))
        );
    }

    @When("User click register link button")
    public void userClickRegisterLinkButton() {
        driver.findElement(By.xpath("//a[contains(@href,'register')]")).click();
    }

    @Then("User is in register page")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Signing up is easy!')]"))
        );
    }

    @When("User input name")
    public void userInputName() {
        registerPage fillInputName = new registerPage(driver);
        fillInputName.inputNameData("User", "Argo");
    }

    @And("User input address detail")
    public void userInputAddressDetail() {
        driver.findElement(By.id("customer.address.street")).sendKeys("Sweet home");
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("Jakarta");
        driver.findElement(By.cssSelector("#customer\\.address\\.state")).sendKeys("Indonesia");
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.zipCode']")).sendKeys("123123");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("081234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("12345678");
    }

    @And("User fill valid username and password")
    public void userFillValidUsernameAndPassword() {
        // Make random username
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.id("customer.username")).sendKeys("user"+userRand);
        driver.findElement(By.id("customer.password")).sendKeys("12345");
    }

    @And("User input valid password confirmation")
    public void userInputValidPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("12345");
    }

    @When("User click register button")
    public void userClickRegisterButton() {
        homePage btnRegister = new homePage(driver);
        btnRegister.clickRegister();
    }

    @Then("User register successfully")
    public void userRegisterSuccessfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/p[1]"))
        );
        driver.quit();
    }

    @And("User input invalid password confirmation")
    public void userInputInvalidPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("65656");
    }

    @Then("User get error password did not match")
    public void userGetErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                // xpath: //*[@id="repeatedPassword.errors"]
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repeatedPassword.errors']"))
        );
        driver.quit();
    }
}
