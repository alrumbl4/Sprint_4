import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.model.MainPageScooter;
import ru.yandex.praktikum.model.OrderPageScooter;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.containsString;

//Указываем, что тесты класса будет запускать параметр Parameterized
@RunWith(Parameterized.class)
public class CreatingAnOrderTest {
    //Ниже задаем переменные
    private WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String comment;
    //Создаем конструктор класса CreatingAnOrderTest
    public CreatingAnOrderTest(String name, String lastName, String address, String phone, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }
    //Создаем метод, где указываем конкретные значения параметров
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {"Алексей", "Румянцев", "г. Иваново, ул. Сосновая", "+79999999999", "Пожалуйста, быстрее"},
                {"Митя", "Киселев", "Москва", "89999999999", ""},
        };
    }

    //Задали общие действия, которые будут выполнять перед каждым запущенным тестом
    @Before
    public void setUp() {
        //driver = new SafariDriver();
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        //Ожидание появления элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Переход на нужную страницу
        driver.get("https://qa-scooter.praktikum-services.ru");
    }
    //Создали набор тестов с точкой входа вверху страницы
    @Test
    public void firstOrder() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickHeaderOrderButton();
        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        objOrderPageScooter.order(name, lastName, address, phone, comment);
        String actual = objOrderPageScooter.hasBeenPlaced();
        String expected = "Заказ оформлен";
        MatcherAssert.assertThat("Текст не совпадает", actual, containsString(expected));
    }

    //Создали набор тестов с точкой входа в середине страницы
    @Test
    public void secondOrder() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        objMainPageScooter.clickMiddleOrderButton();
        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        objOrderPageScooter.order(name, lastName, address, phone, comment);
        String actual = objOrderPageScooter.hasBeenPlaced();
        String expected = "Заказ оформлен";
        MatcherAssert.assertThat("Текст не совпадает", actual, containsString(expected));
    }
    //Задаем общие действия, которые будут выполняться после каждого теста
    @After
    public void cleanUp() {
        driver.quit();
    }
}