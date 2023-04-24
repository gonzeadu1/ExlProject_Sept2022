package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;


public class AddCustomerTest {
    WebDriver driver;
    ExcelReader excelReader = new ExcelReader("src/main/resources/testData/2023-02-19--TF_TestData.xlsx");
    String userName = excelReader.getCellData("LoginInfo", "UserName", 2);
    String password = excelReader.getCellData("LoginInfo","Password", 2);
    String fullName = excelReader.getCellData("AddContactInfo","FullName", 2);
    String companyName = excelReader.getCellData("AddContactInfo","CompanyName", 2);
    String emailAddress = excelReader.getCellData("AddContactInfo","Email", 2);
    String city = excelReader.getCellData("AddContactInfo","City", 2);
    String country = excelReader.getCellData("AddContactInfo","Country", 2);
    String state = excelReader.getCellData("AddContactInfo","State", 2);
    String zip = excelReader.getCellData("AddContactInfo","Zip", 2);
    String phoneNumber = excelReader.getCellData("AddContactInfo","Phone", 2);
    String streetAddress = excelReader.getCellData("AddContactInfo","Address", 2);




    @Test
    public void userShouldBeAbleToAddCustomer() throws InterruptedException {
     driver = BrowserFactory.init();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUserName(userName);
        loginPage.insertPassword(password);
        loginPage.clickOnSigninButton();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.validateDashboard();
        dashboardPage.clickCustomerMenuElement();
        dashboardPage.clickAddCustomerMenuElement();

        AddCustomerPage addCustomerPage= PageFactory.initElements(driver, AddCustomerPage.class);
        addCustomerPage.validateAddContactPage();
        addCustomerPage.insertFullName(fullName);
        addCustomerPage.selectFromCompany(companyName);
        addCustomerPage.insertEmailAddress(emailAddress);
        addCustomerPage.insertPhoneNumber(phoneNumber);
        addCustomerPage.insertAddress(streetAddress);
        addCustomerPage.insertCity(city);
        addCustomerPage.insertState(state);
        addCustomerPage.insertZip(zip);
        addCustomerPage.selectCountry(country);
        addCustomerPage.clickSaveButton();
        addCustomerPage.validateProfilePage();
        dashboardPage.clickListCustomerMenuElement();
        addCustomerPage.validateInsertedNamePageAndDelete();
        //addCustomerPage.validateConfirmDeleteButton();
    }
}
