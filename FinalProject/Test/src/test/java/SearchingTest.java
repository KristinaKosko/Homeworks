import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 *
 */
public class SearchingTest {

    //WebDriver of GoogleChrome
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    //Path to the Chrome Driver
    private static final String DRIVER_PATH = "C:\\Users\\Kristina\\Downloads\\chromedriver_win32\\chromedriver.exe";

    WebDriver driver = null;

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public static void setGoogleChromeDriver() {
        setDriver(DRIVER_PROPERTY, DRIVER_PATH);
    }

    /**
     * Closes opened page
     */
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void positiveCheckSearch() {
        driver.get("http://127.0.0.1:8888/");
        driver.findElement(By.xpath("//aside[@id='search-2']/form/label")).click();
        driver.findElement(By.xpath("//aside[@id='search-2']/form/label/input")).sendKeys("Никола Тесла");
        driver.findElement(By.xpath("//aside[@id='search-2']/form/label/input")).sendKeys(Keys.RETURN);

        WebElement check = driver.findElement(By.xpath("//h1[@class='page-title']"));
        Assert.assertEquals(check.getText(), "Результаты поиска: Никола Тесла");
    }

    /**
     * Searches not existing post
     */
    @Test
    public void negativeCheckSearch() {
        driver.get("http://127.0.0.1:8888/");
        driver.findElement(By.xpath("//aside[@id='search-2']/form/label")).click();
        driver.findElement(By.xpath("//aside[@id='search-2']/form/label/input")).sendKeys("Not found search");
        driver.findElement(By.xpath("//aside[@id='search-2']/form/label/input")).sendKeys(Keys.RETURN);

        WebElement check = driver.findElement(By.xpath("//h1[@class='page-title']"));
        Assert.assertEquals(check.getText(), "Ничего не найдено");
    }

    /**
     * Sets Google Chrome driver to run browser Chrome
     *
     * @param driverProperty - String, driver property
     * @param driverPath - String, path to the folder with Chrome-driver
     */
    private static void setDriver(String driverProperty, String driverPath) {
        if (System.getProperty(driverProperty) == null) {
            File driverFile = new File(driverPath);
            System.setProperty(driverProperty, driverFile.getAbsolutePath());
        }
    }
}
