package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

   WebDriver driver;

    ExcelReader excelReader = new ExcelReader("src/main/resources/testData/2023-02-19--TF_TestData.xlsx");
    String userName = excelReader.getCellData("LoginInfo", "UserName", 2);
    String password = excelReader.getCellData("LoginInfo","Password", 2);



    @Test
    public void validUserShouldBeAbleToLogin(){
        this.driver =  BrowserFactory.init();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUserName(userName);
        loginPage.insertPassword(password);
        loginPage.clickOnSigninButton();

        DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.validateDashboard();




        BrowserFactory.tearDown();
    }
}
