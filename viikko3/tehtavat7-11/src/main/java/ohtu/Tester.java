package ohtu;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester {

    public static void main(String[] args) {
        Random r = new Random();
        WebDriver driver = new FirefoxDriver();
        final String URL = "http://localhost:4567";
        driver.get(URL);

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(2);
        driver.findElement(By.name("logout")).click();

        sleep(2);
        element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("jaa");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(2);
        driver.findElement(By.name("return")).click();

        sleep(2);
        element = driver.findElement(By.linkText("register new user"));
        element.click();


        element = driver.findElement(By.name("username"));
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana123");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana123");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        sleep(2);
        driver.findElement(By.xpath("//a[@href ='ohtu']")).click();

        sleep(2);
        driver.findElement(By.name("logout")).click();

        sleep(3);

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
