package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2 button"));
        //click(By.xpath("//b"));
        //pause(3000);
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();//not count
    }

    public boolean isContactCreateByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list) {
            if(el.getText().equals(name))
                return true;
        }
        return false;
    }
    public boolean isContactCreateByPhone(String phone){
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list) {
            if(el.getText().equals(phone))
                return true;
        }
        return false;
    }
}
