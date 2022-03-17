package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

   @Test(groups = {"web"})
    public void registrationTestPositive() {

       int i = (int) (System.currentTimeMillis() / 1000) % 3600;
       String email = "noa" + i + "@gmail.com";
       String password = "Nnoa12345$";
       System.out.println("Email: " + email);

       app.getUser().openLoginRegistrationForm();
       app.getUser().fillLoginRegistrationForm(email, password);
       app.getUser().submitRegistration();

      // Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
       Assert.assertTrue(app.getUser().isLogged());
   }
    @Test
    public void registrationTestWrogEmail(){
        app.getUser().takeScreenshot("src/test/screenshots/rst.png"); // screenshots

        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "noa" +i+ "gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " +email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();
           //Assert.assertFalse(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertFalse(app.getUser().isLogged());
    }


   }
