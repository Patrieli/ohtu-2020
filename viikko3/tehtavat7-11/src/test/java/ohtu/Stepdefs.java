package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String string, String string2) {
        logInWith(string, string2);
    }

    @Then("nonexistent user is not logged in and error message is given")
    public void nonexistentUserIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
    }

    @When("a valid username {string} and password {string} and matching password {string} confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2, String string3) {
        signUpWith(string, string2, string3);
    }

    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("invalid username {string} and valid password {string} and matching password {string} confirmation are entered")
    public void invalidUsernameAndValidPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2, String string3) {
        signUpWith(string, string2, string3);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String string) {
        pageHasContent(string);
    }

    @When("a valid username {string} and invalid password {string} and matching password {string} confirmation are entered")
    public void aValidUsernameAndInvalidPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2, String string3) {
        signUpWith(string, string2, string3);
    }

    @Then("user is not created with invalid password and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported2(String string) {
        pageHasContent(string);
    }

    @When("a valid username {string} and password {string} and not matching password {string} confirmation are entered")
    public void aValidUsernameAndPasswordAndNotMatchingPasswordConfirmationAreEntered(String string, String string2, String string3) {
        signUpWith(string, string2, string3);
    }

    @Then("user is not created with non matching passwords and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported3(String string) {
        pageHasContent(string);
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String string, String string2) {
        commandNewUserIsSelected();
        signUpWith(string, string2, string2);
        loginIsSelected();
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String string, String string2) {
        commandNewUserIsSelected();
        signUpWith(string, string2, string2);
        loginIsSelected();
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void signUpWith(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        driver.findElement(By.name("signup")).click(); 
    } 
}
