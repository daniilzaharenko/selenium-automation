import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ChromeDeiverTest {
    ChromeDriver driver = new ChromeDriver();
    @Test
    public void chromeDriveTest() {
                                          //otkryvaet stranicu get
        driver.get("https://google.com");
        WebElement acceptButton = driver.findElement(By.xpath("//div[text()='Принять все']//parent::button"));
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("mazda RX-7");
        driver.close();   // zakryt okno
        driver.quit();   // cistit driver
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
