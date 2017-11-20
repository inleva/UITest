import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by macbook on 11/14/17.
 */

public class LoginTest {

    WebDriver driver = null;

    // выполниться прежде чем методы с аннотацией @Test
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/users/innalevina/Downloads/fakeUITest-master/drivers/geckodriver-18.0-mac");
        driver = new FirefoxDriver(); // выбираем с каким браузером запуститься всем тестам в этом класса
    }

    // отделяем обычный метод в Java от метода, которые будет содержать проверки
    // так же помогает библиотеке формировать отчеты отделя методы, которые просто выполнились
    // от методов, которые будут отображать результат прохождения тестов
    @Test
    public void successfulLoginTest() {
        driver.get("https://lingualeo.com/ru?uid=2f903d16f0d1d5824c493a70adaaf89e&publisher_id=191415&utm_source=admitad&utm_medium=aff&utm_campaign=191415&utm_term=ps");

        WebElement email = driver.findElement(By.id("registerFormEmail"));
        Actions builder = new Actions(driver);
        Actions serieseOfActions = builder.moveToElement(email).click().sendKeys("inna.levina@gmail.com");
        serieseOfActions.perform();
        WebElement password = driver.findElement(By.id("registerFormPassword"));
        Actions builder1 = new Actions(driver);
        Actions serieseOfActions1 = builder.moveToElement(password).click().sendKeys("Nikita123!");
        serieseOfActions.perform();
        WebElement login = driver.findElement(By.id("registerFormBtn"));
        Actions builder2 = new Actions(driver);
        Actions serieseOfActions2 = builder.moveToElement(login).click();
        serieseOfActions.perform();

        //driver.navigate().to("http://google.com"); // переходим на сайт
        String appTitle = driver.getTitle();
        System.out.println("Application title is :: " + appTitle);

        String expectedTitle = "Lingualeo — английский язык онлайн";

        assertEquals(appTitle, expectedTitle); // с помощью библиотеки TestNG выполняем сравнение занчений.
        // Если значения совпадут, то тесты буду зелеными
        // Если значения не совпадут, то тесты буду красными/оранжевыми

        // driver.close();// закрываем окно браузера
    }

    @Test
    public void failedTest() {

        driver.get("https://lingualeo.com/ru#welcome");

        driver.findElement(By.xpath("//*[@id=\"headEnterBtn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/input")).sendKeys("inna.levina@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/input")).sendKeys("blabla");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();

        String errorMessage = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/p")).getText();
        System.out.println("texterror " + errorMessage);

        String expectedErrorMessage = "Пароль/email введены неверно";

        assertEquals(errorMessage, expectedErrorMessage); // с помощью библиотеки TestNG выполняем сравнение занчений.
        // Если значения совпадут, то тесты буду зелеными
        // Если значения не совпадут, то тесты буду красными/оранжевыми

        driver.close();

    }

}
