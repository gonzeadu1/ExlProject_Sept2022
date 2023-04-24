package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BasePage {

    public char generateRandomChar(int boundary){
        Random rnd = new Random();
        char rndChar = (char) (rnd.nextInt(boundary) + 'a');
        return rndChar;
    }

    public int generateRandomNum(int boundNum){
        Random rnd = new Random();
        int rndChar = (rnd.nextInt(boundNum));
        return rndChar;
    }

    public void selectFromDropDown(WebElement element, String visibleText) {
        Select sel = new Select(element);
        sel.selectByVisibleText(visibleText);
    }

    public void waitForElement(WebDriver driver, int waitTime, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
