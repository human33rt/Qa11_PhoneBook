package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    //protected static ApplicationManager app = new ApplicationManager();
 //  @BeforeMethod
//  public void startLogger(Method m){
//      logger.info("Test name ----->" +m.getName());
//    }
//    @AfterMethod(alwaysRun = true)
//    public void endLogger(Method m){
//        logger.info("Test end" +m.getName());

    @BeforeSuite
    public void setUp(){
app.init();
    }


    @AfterSuite
    public void tearDown(){
        app.stop();

    }


}
