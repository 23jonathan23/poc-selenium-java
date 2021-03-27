import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebSiteAmazonTest {

    @BeforeClass
    public static void Setup() {
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
    }
    
    @Test
    public void When_to_navigate_to_website_and_get_title_page_then_must_be_return_title_page_expected() {
        //Arrange
        var expectedTitle = "Amazon.com.br | Compre livros, Kindle, Echo, Fire Tv e mais.";
        
        WebDriver driver = new ChromeDriver();
        
        driver.navigate().to("https://www.amazon.com.br/");
        
        //Act
        var actualTitle = driver.getTitle();
        driver.quit();

        //Assert
        assertEquals(expectedTitle, actualTitle);
    }
}