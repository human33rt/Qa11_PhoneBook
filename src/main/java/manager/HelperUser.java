package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }



    public void openLoginRegistrationForm() {
        click(By.xpath("//a[text()='LOGIN']"));
    }


    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
        //type(By locator, email);
    }
    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
        //type(By locator, email);
    }

    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
        if(alert==null){
            return false;
        }else {
            wd.switchTo().alert();
            alert.accept();//ok
            //alert.dismiss();//cancel
            //alert.sendKeys("Hello");//type in alert
            //alert.getText(); //get text
            return true;
        }

    }
    public void login(User user){

        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();


    }
}
