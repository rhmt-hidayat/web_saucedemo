package stepDef;

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

public class LoginBdd extends env_target {
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        // set path driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // set URL
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }

    @When("User fill username and password valid")
    public void userFillUsernameAndPasswordValid() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User fill username and password invalid")
    public void userFillUsernameAndPasswordInvalid() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("user-name")).sendKeys("standard_test");
        driver.findElement(By.id("password")).sendKeys("secret_sau");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {
        // Write code here that turns the phrase above into concrete actions
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header_container']/div[2]/span"))
        );

        try {
            // set time
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Then("User get error message")
    public void UserGetErrorMessage() {
        // Write code here that turns the phrase above into concrete actions
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"))
        );

        try {
            // set time
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}