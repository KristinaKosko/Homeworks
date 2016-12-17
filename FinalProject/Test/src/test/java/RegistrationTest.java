import org.openqa.selenium.By;
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
 * Tests on checking the ability to sign up
 *
 * @author Kristina Kosko
 */
public class RegistrationTest {

    //WebDriver of GoogleChrome
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    //Path to the Chrome Driver
    private static final String DRIVER_PATH = "C:\\Users\\Kristina\\Downloads\\chromedriver_win32\\chromedriver.exe";

    //String of symbols to generate random note
    public static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static SecureRandom rnd = new SecureRandom();

    //The length of the generating username
    public static int len = 7;

    WebDriver driver = null;

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeTest
    public static void setGoogleChromeDriver() {
        setDriver(DRIVER_PROPERTY, DRIVER_PATH);
    }

    /**
     * Checks the existence of the registration button
     */
    @Test
    public void positiveIfThereIsRegistration() {
            driver.get("http://127.0.0.1:8888/wp-login.php?action=register");
            Assert.assertEquals( driver.getTitle(),"EPAM TAT 2016 ‹ Регистрационная форма");
    }

    /**
     * Checks the ability of registration of new user
     */
    @Test
    public void positiveRegistration() {
        driver.get("http://127.0.0.1:8888/wp-login.php?action=register");
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        String charSequence = "";
        charSequence = sb.toString();
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginField.sendKeys(charSequence);
        WebElement passwdField = driver.findElement(By.xpath("//input[@id='user_email']"));
        passwdField.sendKeys(charSequence+"@gmail.com");

        WebElement registerButton = driver.findElement(By.xpath("//input[@name='wp-submit']"));
        registerButton.click();

        WebElement registrationMessage = driver.findElement(By.xpath("//p[@class='message']"));
        Assert.assertEquals(registrationMessage.getText(),"Регистрация завершена. Проверьте вашу почту.");
    }

    /**
     * Checks the case if the user tries to sign up with the existing username or email
     */
    @Test
    public void negativeRegistration() {
        driver.get("http://127.0.0.1:8888/wp-login.php?action=register");
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginField.sendKeys("admin");
        WebElement passwdField = driver.findElement(By.xpath("//input[@id='user_email']"));
        passwdField.sendKeys("test@gmail.com");

        WebElement registrationButton = driver.findElement(By.xpath("//input[@name='wp-submit']"));
        registrationButton.click();

        WebElement registrationError = driver.findElement(By.xpath("//div[@id='login_error']"));

        Assert.assertNotNull(registrationError);
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
