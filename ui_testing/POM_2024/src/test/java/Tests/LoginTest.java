package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {



    @Test
    public void loginPageTitleTest(){
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle,"OrangeHRM");
    }


    @Test
    public void loginTest(){
        loginPage.doLogin();
    }

}
