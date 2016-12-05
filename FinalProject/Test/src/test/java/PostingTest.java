import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.security.SecureRandom;

/**
 * Testing the ability of creating, changing and deleting posts
 *
 * @author Kristina Kosko
 */
public class PostingTest {

    //WebDriver of GoogleChrome
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    //Path to the Chrome Driver
    private static final String DRIVER_PATH = "C:\\Users\\Kristina\\Downloads\\chromedriver_win32\\chromedriver.exe";

    //String of symbols to generate random note
    public static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static SecureRandom rnd = new SecureRandom();

    //The length of the generating note
    public static int len = 15;
    public static int lenOfCategory = 7;

    WebDriver driver = null;

    //Generated notes
    String charSequence = "";
    String charCategorySequence = "";
    String charTitleSequence = "";

    /**
     * Creates new Chrome driver; opens login page; logs in with user name "admin" and password "admin";
     * Generates posts with its title and category
     */
    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8888/wp-login.php");
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginField.sendKeys("admin");
        WebElement passwdField = driver.findElement(By.xpath("//input[@id='user_pass']"));
        passwdField.sendKeys("admin");
        WebElement login = driver.findElement(By.xpath("//input[@name='wp-submit']"));
        login.click();
        StringBuilder sb = new StringBuilder(len);
        StringBuilder sbCategory = new StringBuilder(lenOfCategory);
        StringBuilder sbTitle = new StringBuilder(lenOfCategory);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        for (int i = 0; i < lenOfCategory; i++) {
            sbCategory.append(AB.charAt(rnd.nextInt(AB.length())));
            sbTitle.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        charSequence = sb.toString();
        charCategorySequence = sbCategory.toString();
        charTitleSequence = sbTitle.toString();
    }

    /**
     * Closes opened page
     */
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeTest
    public static void setGoogleChromeDriver() {
        setDriver(DRIVER_PROPERTY, DRIVER_PATH);
    }

    /**
     * Creates post and generates its title
     */
    @Test
    public void positiveAddPostFromSubmenuWithTitle() {
        driver.findElement(By.xpath("//a[@href='http://127.0.0.1:8888/wp-admin/post-new.php']")).click();

        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(charTitleSequence);
        driver.findElement(By.xpath("//button[@id='content-html']")).click();
        driver.findElement(By.xpath("//textarea[@class='wp-editor-area']")).sendKeys(charSequence);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@id='publish']")).click();
        WebElement checkCreation = driver.findElement(By.xpath("//a[text()='Просмотреть запись']"));
        Assert.assertNotNull(checkCreation);
    }

    /**
     * Creates category and makes post under this category
     */
    @Test
    public void positiveAddPostFromSubmenuWithNewCategory() {
        driver.findElement(By.xpath("//a[@href='http://127.0.0.1:8888/wp-admin/post-new.php']")).click();

        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(charTitleSequence);
        driver.findElement(By.xpath("//button[@id='content-html']")).click();
        driver.findElement(By.xpath("//textarea[@class='wp-editor-area']")).sendKeys(charSequence);

        driver.findElement(By.xpath("//a[@href='#category-add']")).click();
        driver.findElement(By.xpath("//input[@id='newcategory']")).sendKeys(charCategorySequence);
        driver.findElement(By.xpath("//input[@id='category-add-submit']")).click();

        ((JavascriptExecutor) driver).executeScript("scroll(0,-500)"); //scroll up

        driver.findElement(By.xpath("//input[@id='publish']")).click();

        WebElement checkCreation = driver.findElement(By.xpath("//a[text()='Просмотреть запись']"));
        Assert.assertNotNull(checkCreation);
    }

    /**
     * Checks the case if user creates empty post
     */
    @Test
    public void negativeAddEmptyPostFromSubmenu() {
        driver.get("http://127.0.0.1:8888/");
        driver.findElement(By.xpath("//a[@href='http://127.0.0.1:8888/wp-admin/post-new.php']")).click();
        driver.findElement(By.xpath("//input[@id='publish']")).click();

        WebElement checkCreation = driver.findElement(By.xpath("//a[text()='Просмотреть запись']"));
        Assert.assertNotNull(checkCreation);
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
