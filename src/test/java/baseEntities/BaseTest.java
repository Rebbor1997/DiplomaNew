package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import utils.Listener;
import utils.Waits;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    protected ReadProperties properties;
    protected Waits waits;
    protected final Logger logger = LogManager.getLogger(this);



    @BeforeTest
    public void setupTest(){
        properties = ReadProperties.getInstance();
    }

    @BeforeMethod
    public void setupMethod(){
        driver = new BrowserService().getDriver();
        waits = new Waits(driver, ReadProperties.getInstance().getTimeOut());

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}