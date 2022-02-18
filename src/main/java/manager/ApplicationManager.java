package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user; //!=null
    HelperContact contact;



    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
       // wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        user =new HelperUser(wd);
        contact = new HelperContact(wd);

    }

    public void stop(){
        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }


    public HelperContact contact() {
        return contact;
    }

    }
