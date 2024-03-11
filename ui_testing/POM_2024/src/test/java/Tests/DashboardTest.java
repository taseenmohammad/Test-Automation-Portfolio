package Tests;

import Base.TestBase;
import Pages.DashboardPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardTest extends TestBase {

    @BeforeClass
    public void DashboardSetUp() {
        dashboardPage = loginPage.doLogin();

    }

    @Test
    public void verifyLogout(){
        dashboardPage.doLogout();

    }
}
