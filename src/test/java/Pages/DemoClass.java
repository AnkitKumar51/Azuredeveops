package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://192.168.1.16:8025/");
        driver.findElement(By.xpath("//input[@id='cmdLogin']")).click();

        boolean isGrecaptchaDefined = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return typeof grecaptcha !== 'undefined';"
        );

        if (isGrecaptchaDefined) {
            System.out.println("grecaptcha is defined.");
        } else {
            System.out.println("grecaptcha is not defined. The issue needs to be investigated and fixed.");
        }

        driver.close();

    }
}
