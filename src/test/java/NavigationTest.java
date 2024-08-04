import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class NavigationTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterEach

    public void teardown() {

        driver.quit();
    }

    @Test
    public void RegisterUser() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://test-qa.inlaze.com/auth/sign-up");
        driver.findElement(By.id("full-name")).sendKeys("Alberto Eduardo");
        driver.findElement(By.id("email")).sendKeys("asdf@123.com");
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1010Asd");
        driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("1010Asd");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }

    @Test
    public void samePassword() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://test-qa.inlaze.com/auth/sign-up");
        driver.findElement(By.id("full-name")).sendKeys("Alberto Eduardo");
        driver.findElement(By.id("email")).sendKeys("asdf@123.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1010Asd");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("1010Asd");
        driver.findElement(By.xpath("//span[@class='label-text-alt text-error']"));


    }

    @Test
    public void passwordValidation() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


        driver.get("https://test-qa.inlaze.com/auth/sign-up");
        driver.findElement(By.id("full-name")).sendKeys("Alberto Eduardo");
        driver.findElement(By.id("email")).sendKeys("asdf@123.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1010Asd*");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("1010Asd*");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }


    @Test
    public void loginOk() throws InterruptedException {

        driver.get("https://test-qa.inlaze.com/auth/sign-in");
        driver.findElement(By.id("email")).sendKeys("sad123123.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12Asdf*");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://test-qa.inlaze.com/panel";

    }

    @Test
    public void loginFailed() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://test-qa.inlaze.com/auth/sign-in");
        driver.findElement(By.id("email")).sendKeys("asd");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("321Asd*");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ml-3 text-sm font-normal']")));
        driver.findElement(By.xpath("//div[@class='ml-3 text-sm font-normal']"));

    }

}
