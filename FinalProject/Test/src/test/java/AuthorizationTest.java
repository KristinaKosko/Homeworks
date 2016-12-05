import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


/**
 * Tests of authorization on WordPress
 *
 * @author Kristina Kosko
 */
public class AuthorizationTest {

    //WebDriver of GoogleChrome
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    //Path to the Chrome Driver
    private static final String DRIVER_PATH = "C:\\Users\\Kristina\\Downloads\\chromedriver_win32\\chromedriver.exe";
    //XML-file with invalid data for logging in
    private static final String CONFIG_PATH = "loginData.xml";

    //For searching in XML data file
    private static final String INVALID_LOGIN = "invalidLogin";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    WebDriver driver = null;

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
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
     * Checks if there is a button "Войти" on the page
     */
    @Test
    public void positiveIfThereIsAuthorization() {
        driver.get("http://127.0.0.1:8888/wp-login.php");
        Assert.assertEquals( driver.getTitle(),"EPAM TAT 2016 ‹ Войти");
    }

    /**
     * Checks logging in with valid login and password
     */
    @Test
    public void positiveAuthorization() {
        driver.get("http://127.0.0.1:8888/wp-login.php");
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginField.sendKeys("admin");
        WebElement passwdField = driver.findElement(By.xpath("//input[@id='user_pass']"));
        passwdField.sendKeys("admin");
        WebElement login = driver.findElement(By.xpath("//input[@name='wp-submit']"));
        login.click();
        Assert.assertEquals(driver.getTitle(),"Консоль ‹ EPAM TAT 2016 — WordPress");
    }

    /**
     * Checks password recovery. Click "Забыли пароль?"
     */
    @Test
    public void positiveLostPassword() {
        driver.get("http://127.0.0.1:8888/wp-login.php");
        WebElement forgotPwd = driver.findElement(By.linkText("Забыли пароль?"));
        forgotPwd.click();
        Assert.assertEquals( driver.getTitle(),"EPAM TAT 2016 ‹ Забыли пароль?");
    }


    /**
     *  Checks logging in with invalid login and password
     */
    @Test
    public void negativeAuthorization(){
        driver.get("http://127.0.0.1:8888/wp-login.php");

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("incorrectLogin");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("incorrectPassword");
        driver.findElement(By.xpath("//input[@name='wp-submit']")).click();

        WebElement loginError = driver.findElement(By.xpath("//div[@id='login_error']"));
        Assert.assertNotNull(loginError);
    }

    /**
     * Gets login and password for authorization in String-format
     *
     * @param attributes
     * @return String[] - login, password
     */
    private static Object[] resultArray(NamedNodeMap attributes) {
        return new String[]{
                attributes.getNamedItem(LOGIN) == null ? null : new String(attributes.getNamedItem(LOGIN).getNodeValue()),
                attributes.getNamedItem(PASSWORD) == null ? null : new String (attributes.getNamedItem(PASSWORD).getNodeValue())
        };
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
