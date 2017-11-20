package lastTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
public class lastTest {

    WebDriver driver = null;

    @Test
    public void signIntest() {
        System.setProperty("webdriver.gecko.driver", "/users/innalevina/Downloads/fakeUITest-master/drivers/geckodriver-18.0-mac");
        driver = new FirefoxDriver();

        driver.get("https://lingualeo.com/ru?uid=2f903d16f0d1d5824c493a70adaaf89e&publisher_id=191415&utm_source=admitad&utm_medium=aff&utm_campaign=191415&utm_term=ps");

        driver.findElement(By.id("registerFormEmail")).sendKeys("inna.levina@gmail.com");
        driver.findElement(By.id("registerFormPassword")).sendKeys("Nikita123!");
        driver.findElement(By.id("registerFormBtn")).click();
        WebElement tab = driver.findElement(By.linkText("Задания"));
        System.out.println("tab " + tab);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"glossaryPage\"]/div[3]/div[2]/div[1]/div[2]/div/div/form/input")).sendKeys("dog");
        driver.findElement(By.xpath("//*[@id=\"glossaryPage\"]/div[3]/div[2]/div[1]/div[2]/div/div/form/button/span")).click();


        // driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[1]/a[1]/span")).click();

        ArrayList<WebElement> list = new ArrayList<WebElement>();
        list = (ArrayList<WebElement>) driver.findElements(By.className("transword__text"));
       if(list.size()>0) list.get(0).click();

       //driver.findElement(By.xpath("//*[@id=\"glossaryPage\"]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[6]"));
       // String element = driver.findElement(By.xpath("//*[@id=\"glossaryPage\"]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[6]")).getText();
        //System.out.println("element " + element);

        //String expectedErrorMessage = "Пароль/email введены неверно";

        //assertEquals(errorMessage, expectedErrorMessage);
       // WebElement tab1 = driver.findElement(By.linkText("Мой прогресс"));
        //System.out.println("tab1 " + tab1);
        //driver.findElement(By.linkText("Мой прогресс")).click();
       // String leo = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[3]/div/div[1]/div")).getText();
        //System.out.println("text " + leo);

        //driver.close();
    }

}
