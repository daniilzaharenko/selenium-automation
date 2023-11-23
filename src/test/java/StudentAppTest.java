import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import lv.acodemy.page_object.AddStudentPage;
import lv.acodemy.page_object.MainPage;
import lv.acodemy.page_object.Notifications;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.LocalDriverManager;

import static java.time.Duration.ofSeconds;
import static utils.ConfigurationProperties.getConfiguration;
@Slf4j
public class StudentAppTest {

    Faker fakeData = new Faker();
    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(LocalDriverManager.getInstance(), ofSeconds(getConfiguration().getLong("wait.time")));
    AddStudentPage addStudentPage = new AddStudentPage();
    Notifications notifications = new Notifications(wait);

    @Test
    public void createStudentTest() {
        LocalDriverManager.getInstance().manage().timeouts().implicitlyWait(ofSeconds(getConfiguration().getLong("wait.time")));
        logger.info("Will open now: " + getConfiguration().getString("app.url"));
        LocalDriverManager.getInstance().get(getConfiguration().getString("app.url"));


        WebElement addStudentButton = By.id("addStudentButton").findElement(LocalDriverManager.getInstance());
        addStudentButton.click();

        //Finding NAME field


        addStudentPage.setNameField((fakeData.name().fullName()));



        addStudentPage.setEmailField(fakeData.internet().emailAddress());

        addStudentPage.setGender("female");

        addStudentPage.submitStudent();

        notifications.getNotificationLocator();
        Assertions.assertThat(notifications.getNotificationSuccessMessage()).isEqualTo("Student successfully added");

    }

    @AfterMethod
    public void tearDown() {
       LocalDriverManager.closeDriver();
    }
}
