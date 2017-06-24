package SeleniumExample;

/**
 * Created by Николай on 08.08.2016.
 */

import HS.Card;
import HS.CardPO;
import HS.CardtoPOConverter;
import HS.Hibernate.HibernateUtil;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.hibernate.Session;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass {

    private WebDriver webDriver;

    /**
     * initialize driver.
     *
     * @param  browser
     */
    public WebDriver initDriver(final Browser browser) throws MalformedURLException {

        switch (browser) {

            case Chrome :

                // assign object to type interface and not specific implementation
//                System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();
                break;

            case FF :
                webDriver = new FirefoxDriver();
                break;

            case IE :
                webDriver = new InternetExplorerDriver();
                break;

            default :
                System.out.println("Invalid Browser!!!");
        }

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

    /**
     * launch web application.
     */
    public void launchApp() {
        webDriver.get("http://www.google.com/");
    }

    /**
     * shut down driver.
     */
    public void shutDownDriver() {
        webDriver.close();
        webDriver.quit();
    }

    public static void main(final String[] args) throws MalformedURLException {

        TestClass testClass = new TestClass();
        Browser browser = Browser.Chrome;
        WebDriver webDriver = testClass.initDriver(browser);
        testClass.launchApp();
        HSPage hsPage = new HSPage(webDriver);
        List<Card> search = hsPage.search();
        List<CardPO> cardPOs = CardtoPOConverter.convertListToPO(search);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (CardPO cardPO : cardPOs) {
            session.save(cardPO);
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testClass.shutDownDriver();
    }
}
