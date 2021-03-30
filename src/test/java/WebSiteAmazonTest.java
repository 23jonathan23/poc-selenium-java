import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
    public void When_to_navigate_to_website_and_get_title_page_then_must_be_return_title_page_expected() throws IOException {
        //Arrange
        var expectedTitle = getTitle();
        
        WebDriver driver = new ChromeDriver();
        
        driver.navigate().to("https://www.amazon.com.br/");
        
        //Act
        var actualTitle = driver.getTitle();
        driver.quit();

        //Assert
        assertEquals(expectedTitle, actualTitle);
    }

    private String getTitle() throws IOException {
        var file = new File("src/test/java/utils/arquivo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        return br.readLine();
    }
}