package Tests;

import Base.TestBase;
import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginPageTitleTest() {
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM");
    }


    @Test
    public void loginTest() {

        Assert.assertTrue(loginPage.doLogin().isLogOutLinkExist());
    }

}
