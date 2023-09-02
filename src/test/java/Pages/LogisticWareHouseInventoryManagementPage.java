package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class LogisticWareHouseInventoryManagementPage {
    WebDriver driver;
    String parentWindow;
    String childWindow;

    @FindBy(xpath = "(//a[contains(text(),'Logistics')])[1]")
    private WebElement LogisticsMenu;

    @FindBy(xpath = "//a[contains(text(),'Whs Management')]")
    private WebElement WhsManagementList;


    @FindBy(xpath = "//a[contains(text(),'Manage Whs Inventory')]")
    private WebElement manageWhsInventory;

    @FindBy(xpath = "(//*[@id=\"CurrentInventory\"]/tbody/tr/td[6]/a)[1]")
    private WebElement pushItem;

    @FindBy(xpath = "(//input[@type='number'])[1]")
    private WebElement addNumberInCMD;

    @FindBy(xpath = "//*[@id=\"FluidContent_rptInventory_ddlPushTo_2\"]")
    private WebElement dropDown;

    @FindBy(xpath = "//*[@id=\"FluidContent_rptInventory_ddlPushTo_2\"]/option[2]")
    private WebElement selectFromDopDown;

    @FindBy(xpath = "//*[@id='FluidContent_rptInventory_btnPush_2']")
    private WebElement clickOnPush;

    public LogisticWareHouseInventoryManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLogisticSection() {
        Actions actions = new Actions(driver);
        actions.moveToElement(LogisticsMenu).perform();

        Actions ac = new Actions(driver);
        ac.moveToElement(WhsManagementList).perform();
    }

    public void goToWhsManagementSection() {
        manageWhsInventory.click();
        pushItem.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void newWindow() {
        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = handle.iterator();
        parentWindow = it.next();
        childWindow = it.next();
        driver.switchTo().window(childWindow);
    }

    public void actionOnNewWindow() {
        addNumberInCMD.sendKeys("2");

//        Select select = new Select(dropDown);
//        try {
//            Thread.sleep(2);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        select.selectByVisibleText("HOU-T02-1-C-12");
        dropDown.click();
        selectFromDopDown.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, 1200);");
        clickOnPush.click();
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}
