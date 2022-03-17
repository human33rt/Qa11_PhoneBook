package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    //WebDriver wd;
    EventFiringWebDriver wd;

    HelperUser user; //!=null
    HelperContact contact;
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        //wd=new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)){
            wd =  new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests starts in 'Chrome' browser");
        } else  if(browser.equals(BrowserType.EDGE)){
            wd =  new EventFiringWebDriver(new EdgeDriver());
            logger.info("All tests starts in 'Edge' browser");
        }else  if (browser.equals(BrowserType.FIREFOX)){
            wd =  new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests starts in 'Firefox' browser");
        }


        //wd =  new EventFiringWebDriver(new ChromeDriver());
       //.info("All tests starts in Chrome browser");
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
