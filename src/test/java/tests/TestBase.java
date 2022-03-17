package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    //protected static ApplicationManager app = new ApplicationManager();
 //  @BeforeMethod
//  public void startLogger(Method m){
//      logger.info("Test name ----->" +m.getName());
//    }
//    @AfterMethod(alwaysRun = true)
//    public void endLogger(Method m){
//        logger.info("Test end" +m.getName());

    @BeforeSuite (alwaysRun = true)
    public void setUp(){
app.init();
    }


    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        app.stop();

    }


}
