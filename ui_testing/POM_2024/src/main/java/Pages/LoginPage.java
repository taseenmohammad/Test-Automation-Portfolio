package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementUtil;

public class LoginPage {
    ElementUtil elementUtil;
    WebDriver driver;


    //Constructor to receive the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtil = new ElementUtil(driver);

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





    public DashboardPage doLogin() {
        elementUtil.waitForElementVisible(userNameField,5).sendKeys("Admin");
        elementUtil.doSendKeys(passwordField,"Admin123");
        loginButton.click();
        return new DashboardPage(driver);
    }




}