package lv.acodemy.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.LocalDriverManager;

public class AddStudentPage {

    ChromeDriver driver = LocalDriverManager.getInstance();

    private final By nameField = By.id("name");
    private final By emailField = By.id("email");

    public void setNameField(String input) {
        driver.findElement(nameField).sendKeys(input);
    }
    public void setEmailField(String input) {
        driver.findElement(emailField).sendKeys(input);
    }
    public void setGender(String genderValue) {
        driver.findElement(By.id("gender")).click();
        driver.findElement(By.xpath(String.format("//div[@class='rc-virtual-list-holder-inner']//div[text()='%s']", genderValue.toUpperCase()))).click();
    }
    public void submitStudent(){
        driver.findElement(By.xpath("//span[text()='Submit']//parent::button")).click();
    }
}
