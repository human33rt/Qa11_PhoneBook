import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
WebDriver wd;

    @BeforeMethod
    public void init(){
    wd=new ChromeDriver();
    wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
    //wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositiveTest(){
        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        loginBtn.click();

        //find 'email'
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        //print
        emailInput.sendKeys("noa@gmail.com");

        //find 'pass'
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        //print
        passInput.sendKeys("Nnoa12345$");

        //find login btn
        wd.findElement(By.xpath("//button[1]")).click();

        // chk sign out is present

        //Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']"))).size() > 0;

    }
    @AfterMethod
    public void tearDown(){
    wd.quit();
    }
}
