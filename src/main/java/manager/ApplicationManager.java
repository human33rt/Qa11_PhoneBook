package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;

    HelperUser user; //!=null
    HelperContact contact;





    public void init(){
        //wd=new ChromeDriver();
        wd =  new EventFiringWebDriver(new ChromeDriver());
       logger.info("All tests starts in Chrome browser");
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
       logger.info("Link ------->" +wd.getCurrentUrl());
       // wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        user =new HelperUser(wd);
        contact = new HelperContact(wd);
        wd.register(new MyListener());

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
