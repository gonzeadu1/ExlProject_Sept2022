package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
    WebDriver driver;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }
    //WebElement

    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_PAGE;
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")WebElement FULLNAME_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")WebElement COMPANY_DROPDOWN_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")WebElement PHONE_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")WebElement ADDRESS_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")WebElement CITY_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")WebElement STATE_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")WebElement ZIP_ELEMENT;
    @FindBy(how = How.XPATH, using = "//select[@name = 'country']")WebElement COUNTRY_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")WebElement SAVE_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_ON_PROFILE_ELEMENT;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]") WebElement CONFIRM_DELETE_BUTTON_ELEMENT;


    //Interactable Methods
   public void validateAddContactPage(){
       Assert.assertTrue(ADD_CONTACT_PAGE.isDisplayed(), "Add contact page not found!");
   }

    String insertedName;
   public void insertFullName(String fullName){
      insertedName = fullName + generateRandomChar(26);
       FULLNAME_ELEMENT.sendKeys(" " + insertedName);
       //FULLNAME_ELEMENT.sendKeys(fullName  + " " + generateRandomChar(26));

   }

    public void selectFromCompany(String companyName){
        selectFromDropDown(COMPANY_DROPDOWN_ELEMENT, companyName);
    }

    public void insertEmailAddress(String email){
       EMAIL_ELEMENT.sendKeys( generateRandomNum(9999) + email);
   }

    public void insertPhoneNumber(String phone){
       PHONE_ELEMENT.sendKeys(phone + generateRandomNum(999));
    }

    public void insertAddress(String address){
        ADDRESS_ELEMENT.sendKeys(address);
    }

    public void insertCity(String city){
        CITY_ELEMENT.sendKeys(city);
    }

    public void insertState(String state){
        STATE_ELEMENT.sendKeys(state);
    }

    public void insertZip(String zip){
        ZIP_ELEMENT.sendKeys(zip);
    }

    public void selectCountry(String country){
        selectFromDropDown(COUNTRY_ELEMENT, country);
    }

    public void clickSaveButton(){
        SAVE_ELEMENT.click();
    }

    public void validateProfilePage(){
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(SUMMARY_ON_PROFILE_ELEMENT));
        waitForElement(driver, 5, SUMMARY_ON_PROFILE_ELEMENT);
        Assert.assertTrue(SUMMARY_ON_PROFILE_ELEMENT.isDisplayed(), "Profile page not found!");
    }

    public void validateInsertedNamePageAndDelete() throws InterruptedException {
       //tbody/tr/td[3]
        //tbody/tr[2]/td[3]
        //tbody/tr[3]/td[3]
        //tbody/tr[4]/td[3]
        ///////=============deleteButton
        //tobody/tr[1]/td[7]/a[2]
        String before_xpath = "//tbody/tr[";
        String after_xpath =  "]/td[3]";
        String after_xpath_delete = "]/td[7]/a[2]";

        System.out.println("The names of the rows here: ");
        for(int i =1; i<=5; i++){
           String names = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
            System.out.println(names);
            if(names.contains(insertedName)){
                Thread.sleep(2000);
                driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
            }
       }
        System.out.println("============ " + insertedName);
    }

//    public void validateConfirmDeleteButton(){
//    waitForElement(driver, 5, CONFIRM_DELETE_BUTTON_ELEMENT);
//    Assert.assertFalse(CONFIRM_DELETE_BUTTON_ELEMENT.isDisplayed());
//    }



}
