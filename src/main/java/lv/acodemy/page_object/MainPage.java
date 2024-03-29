package lv.acodemy.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.LocalDriverManager;

public class MainPage {

    ChromeDriver driver = LocalDriverManager.getInstance();

    private final By addStudentButton = By.id("addStudentButton");

    public void addStudent() {
        driver.findElement(addStudentButton).click();
    }
}
