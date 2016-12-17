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
 * Tests of the ability to add, delete and change comments
 *
 * @author Kristina Kosko
 */
public class CommentingTest {

    //WebDriver of GoogleChrome
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    //Path to the Chrome Driver
    private static final String DRIVER_PATH = "C:\\Users\\Kristina\\Downloads\\chromedriver_win32\\chromedriver.exe";

    //String of symbols to generate random note
    public static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static SecureRandom rnd = new SecureRandom();

    //The length of the generating note
    public static int len = 15;

    WebDriver driver = null;

    //Generated notes
    String charSequence = "";
    String charCommentSequence = "";

    /**
     * Creates new Chrome driver; opens login page; logs in with user name "admin" and password "admin";
     * Generates comments
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
        StringBuilder sbComment = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
            sbComment.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        charSequence = sb.toString();
        charCommentSequence = sbComment.toString();
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
     * Checks the ability of adding comments to the post
     */
    @Test
    public void positiveAddComment() {
        driver.get("http://127.0.0.1:8888/?p=4");

        driver.findElement(By.xpath("//span[@class='comments-link']")).click();
        driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys(charSequence);
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        WebElement check = driver.findElement(By.xpath("//p[text()='"+charSequence+"']"));
        Assert.assertNotNull(check.getText());

        driver.get("http://127.0.0.1:8888/?p=4");
        driver.findElement(By.xpath("//span[@class='comments-link']")).click();
        driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys(charCommentSequence);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
    }


    /**
     * Checks the changing of the comment
     */
    @Test(dependsOnMethods = { "positiveAddComment" })
    public void positiveChangeComment() {
        driver.get("http://127.0.0.1:8888/");
        WebElement post = driver.findElement(By.linkText("Разработка"));
        post.click();
        WebElement commentArticle = driver.findElement(By.xpath("//p[text()='"+charSequence+"']/../.."));
        String commentID = commentArticle.getAttribute("id").replace("div-comment-","");
        driver.get("http://127.0.0.1:8888/wp-admin/comment.php?action=editcomment&c="+commentID);
        WebElement findComment = driver.findElement(By.xpath("//textarea[@class='wp-editor-area']"));
        findComment.sendKeys("CHANGED");
        WebElement save = driver.findElement(By.xpath("//input[@id='save']"));
        save.click();

        WebElement commentTextChanged = driver.findElement(By.xpath("//p[text()='"+charSequence+"CHANGED']"));
        Assert.assertNotNull(commentTextChanged);
    }

    /**
     * Checks the deletion of the comment
     */
    @Test (dependsOnMethods = { "positiveAddComment" }, expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
    public void positiveDeleteComment() {
        driver.get("http://127.0.0.1:8888/");
        driver.findElement(By.linkText("Разработка")).click();
        WebElement commentArticle = driver.findElement(By.xpath("//p[text()='"+charSequence+"']/../.."));
        String commentID = commentArticle.getAttribute("id").replace("div-comment-","");
        driver.get("http://127.0.0.1:8888/wp-admin/comment.php?action=editcomment&c="+commentID);
        WebElement delete = driver.findElement(By.xpath("//a[@class='submitdelete deletion']"));
        delete.click();
        WebElement commentTextDeleted = driver.findElement(By.xpath("//p[text()='"+charSequence+"']"));
        Assert.assertNull(commentTextDeleted);
    }

    /**
     * Checks the ability to cancel deletion of the comment (restores the comment)
     */
    @Test (dependsOnMethods = { "positiveAddComment" })
    public void positiveDeleteCancel_Delete() {
        driver.get("http://127.0.0.1:8888/");
        driver.findElement(By.linkText("Разработка")).click();

        WebElement commentArticle = driver.findElement(By.xpath("//p[text()='"+charCommentSequence+"']/../.."));
        String commentID = commentArticle.getAttribute("id").replace("div-comment-","");

        driver.get("http://127.0.0.1:8888/wp-admin/edit-comments.php");
        driver.findElement(By.xpath("//input[@id='cb-select-"+commentID+"']")).click();
        driver.findElement(By.xpath("//select[@id='bulk-action-selector-top']/option[@value='trash']")).click();
        driver.findElement(By.xpath("//input[@id='doaction']")).click();
        driver.findElement(By.xpath("//a[text()='Отменить']")).click();
    }

    /**
     * Checks the case of adding an empty comment
     */
    @Test
    public void negativeAddEmptyComment() {
        driver.get("http://127.0.0.1:8888/?p=4");

        driver.findElement(By.xpath("//span[@class='comments-link']")).click();
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        WebElement check = driver.findElement(By.xpath("//body[@id='error-page']"));
        Assert.assertNotNull(check);
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
