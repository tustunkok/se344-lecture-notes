import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMoodle {

    private static ChromeDriver driver;
    
    @BeforeAll
    public static void initAll() {
        driver = new ChromeDriver();
    }
    
    @Test
    @DisplayName("Check if login page opening.")
    public void testLogin() {
        driver.get("https://moodle.atilim.edu.tr/");
        WebElement loginLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.findElement(By.xpath("//a[text() = 'Log in']")));
        loginLink.click();
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.findElement(By.xpath("//button[@id = 'loginbtn']")));
        
        assertEquals(loginButton.getText(), "Log in"); 
    }
    
    @Test
    @DisplayName("Check if SE344 course does exist.")
    public void testSE344Course() {
        driver.get("https://moodle.atilim.edu.tr/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement moodleCoursesLink = wait.until(d -> d.findElement(By.xpath("//a[text() = 'Moodle Courses']")));
        moodleCoursesLink.click();
        
        WebElement searchMoodleCoursesInput = wait.until(d -> d.findElement(By.xpath("//input[@name = 'q']")));
        searchMoodleCoursesInput.sendKeys("SE 344");
        searchMoodleCoursesInput.sendKeys(Keys.RETURN);
        
        assertTrue(driver.getPageSource().contains("System Software Validation and Testing"));

    }
    
    @AfterAll
    public static void tearDownAll() {
        if (driver != null) {
            driver.close();
        }
    }
}
