package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;


    //Constructor to receive the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Page Locators
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()=' Login ']")
    private WebElement loginButton;

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void doLogin() {
        userNameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

    }


}