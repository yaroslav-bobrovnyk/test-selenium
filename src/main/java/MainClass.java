import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","/Users/givemeshowme/IdeaProjects/test-selenium/drivers/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.asos.com/asos-design/asos-design-co-ord-festival-in-washed-dusty-purple-with-raw-edges/grp/29609?colourwayid=16658128&SearchQuery=&cid=13517");
        listChoose("XXS","2");
        listChoose("L","1");
    }

    public static void listChoose(String size,String number){
        String listSize1=String.format("(//select[@data-id=\"sizeSelect\"])[%s]",number);
        String selectSize=String.format("(//select[@data-id=\"sizeSelect\"])[%s]/option[starts-with(text(),\"%s\")]",number,size);
        driver.findElement(By.xpath(listSize1)).click();
        driver.findElement(By.xpath(selectSize)).click();
    }
}
