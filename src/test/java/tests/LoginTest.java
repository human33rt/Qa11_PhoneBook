package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test(dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class,enabled = false)
    public void loginSuccessTestDataProvider(String email, String password){
        logger.info("User starts login process with email: "+email+" && password : "+password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test(dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class,enabled = false )
    public void loginSuccessTestModelDataProvider(User user){
        logger.info("User starts login process with data: ---->"+ user.toString());

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLogged());
    }



    //@Test
   // public void loginPositiveTest(){
       // WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
       // loginBtn.click();
        //find 'email'
       // WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        //emailInput.click();
        //emailInput.clear();
        //print
        //emailInput.sendKeys("noa@gmail.com");
        //find 'pass'
       // WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        //passInput.click();
        //passInput.clear();
        //print
       // passInput.sendKeys("Nnoa12345$");
        //find login btn
       // wd.findElement(By.xpath("//button[1]")).click();
        // chk sign out is present
        //Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0);

    @Test(groups = {"web"})
    public void loginTest2(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        //String email = "noa@gmail.com";
        //String password = "Nnoa12345$";
        logger.info(user.toString());

        app.getUser().openLoginRegistrationForm();
        //app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitLogin();
        app.getUser().pause(5000);
        //Assert.assertTrue(isElementPresent(By.xpath("//button[text() = 'Sign Out']")));
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test(enabled = false)
    public void loginNegativeWrongPassword(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345");

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        //Assert.assertTrue(isElementPresent(By.xpath("//button[text() = 'Sign Out']")));
        //Assert.assertTrue(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }


}
