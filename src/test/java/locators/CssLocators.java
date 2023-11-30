package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CssLocators {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testBox() {
        driver.get("https://demoqa.com/text-box");

        WebElement inputFullName = driver.findElement(By.cssSelector("input[id='userName']"));
        System.out.println("inputFullName.getAttribute --> " + inputFullName.getAttribute("placeholder"));

        WebElement currentAddress = driver.findElement(By.cssSelector("[placeholder='Current Address']"));
        System.out.println("currentAddress.getTagName -->" + currentAddress.getTagName());

        WebElement permanentAddress = driver.findElement(By.cssSelector("label[id='permanentAddress-label']"));
        permanentAddress = driver.findElement(By.cssSelector("#permanentAddress-label"));
        permanentAddress = driver.findElement(By.id("permanentAddress-label"));

        System.out.println("permanentAddress.getText --> " + permanentAddress.getText());
    }

    @Test
    public void checkBox() {
        driver.get("https://demoqa.com/checkbox");

        WebElement svg = driver.findElement(By.cssSelector("span[class='rct-text']>label>span[class='rct-node-icon']>svg"));
        System.out.println("svg -->" + svg.getAttribute("fill"));
    }

    @Test
    public void radioButton() {
        driver.get("https://demoqa.com/radio-button");
        WebElement radioButton = driver.findElement(By.cssSelector("label[class='custom-control-label']"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement p = driver.findElement(By.cssSelector(".mt-3"));
        System.out.println(p.getText());
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
