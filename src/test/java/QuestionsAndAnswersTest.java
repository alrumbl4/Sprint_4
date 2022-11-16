import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.praktikum.model.MainPageScooter;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class QuestionsAndAnswersTest {
    private WebDriver driver;

    //Задали общие действия, которые будут выполнять перед каждым запущенным тестом
    @Before
    public void setUp() {
        //driver = new SafariDriver();
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //Ожидание появления элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Переход на нужную страницу
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Скролл до нужного элемента на странице
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    @Test
    public void checkTheList_0() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(0);
        String actual = objMainPageScooter.getTextFromTheList(0);
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    @Test
    public void checkTheList_1() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(1);
        String actual = objMainPageScooter.getTextFromTheList(1);
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    @Test
    public void checkTheList_2() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(2);
        String actual = objMainPageScooter.getTextFromTheList(2);
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    @Test
    public void checkTheList_3() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(3);
        String actual = objMainPageScooter.getTextFromTheList(3);
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    @Test
    public void checkTheList_4() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(4);
        String actual = objMainPageScooter.getTextFromTheList(4);
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    @Test
    public void checkTheList_5() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(5);
        String actual = objMainPageScooter.getTextFromTheList(5);
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    @Test
    public void checkTheList_6() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(6);
        String actual = objMainPageScooter.getTextFromTheList(6);
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    @Test
    public void checkTheList_7() {
        MainPageScooter objMainPageScooter = new MainPageScooter(driver);
        objMainPageScooter.clickListOfImportantQuestions(7);
        String actual = objMainPageScooter.getTextFromTheList(7);
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals ("Текст не совпадает", actual, expected);
    }
    //Задаем общие действия, которые будут выполняться после каждого теста
    @After
    public void cleanUp() {
        driver.quit();
    }
}
