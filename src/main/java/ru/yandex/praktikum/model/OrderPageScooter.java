package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageScooter {
    //Задали переменную driver
    private final WebDriver driver;
    //Создали конструктор класса OrderPageScooter
    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }
    //Поле имя
    private final By NAME = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //Поле фамилия
    private final By LAST_NAME = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //Поле адрес
    private final By ADDRESS = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //Поле станция метро
    private final By SUBWAY = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    //Выбор станции метро из списка
    private final By STATION_SUBWAY = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[3]");
    //Поле телефон
    private final By PHONE = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    //Кнопка "Далее"
    private final By NEXT_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    //Поле когда привезти самокат
    private final By DATE = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //Выбор конкретной даты, когда привезти самокат
    private final By ORDER_DATE = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]");
    //Поле срок аренды
    private final By RENTAL_PERIOD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div");
    //Выбор конкретного срока аренды
    private final By CHOOSING_THE_RENTAL_PERIOD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]");
    //Выбор цвета самоката
    private final By COLOR = By.id("black");
    //Поле комментарий
    private final By COMMENT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    //Кнопка "Заказать"
    private final By ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    //Кнопка "Да" в модальном окне "Хотите оформить заказ?"
    private final By WANT_TO_PLACE_YES = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    //Модальное окно "Заказ оформлен"
    private final By ORDER_HAS_BEEN_PLACED = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    //Создали метод для ввода имени
    public void setName(String name) {
        driver.findElement(NAME).sendKeys(name);
    }
    //Создали метод для ввода фамилии
    public void setLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }
    //Создали метод для ввода адреса
    public void setAddress(String address) {
        driver.findElement(ADDRESS).sendKeys(address);
    }
    //Создали метод для клика по полю "Станция метро"
    public void clickSubway() {
        driver.findElement(SUBWAY).click();
    }
    //Создали метод для выбора определенной станции метро
    public void clickSubwaySelection() {
        driver.findElement(STATION_SUBWAY).click();
    }
    //Создали метод для ввода номера телефона
    public void setPhone(String phone) {
        driver.findElement(PHONE).sendKeys(phone);
    }
    //Создали метод для клика на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }
    //Создали метод для клика по полю "Когда привезут самокат"
    public void clickDate() {
        driver.findElement(DATE).click();
    }
    //Создали метод для выбора конкретного дня недели
    public void clickOrderDate() {
        driver.findElement(ORDER_DATE).click();
    }
    //Создали метод для клика по полю "Срок аренды"
    public void clickRentalPeriod() {
        driver.findElement(RENTAL_PERIOD).click();
    }
    //Создали метод для выбора конкретного срока аренды
    public void clickChoosingTheRentalPeriod() {
        driver.findElement(CHOOSING_THE_RENTAL_PERIOD).click();
    }
    //Создали метод для выбора цвета самокаты
    public void clickColor() {
        driver.findElement(COLOR).click();
    }
    //Создали метод для ввода комментария
    public void setComment(String comment) {
        driver.findElement(COMMENT).sendKeys(comment);
    }
    //Создали метод для клика по кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }
    //Создали метод для клика по кнопке "Да" в модальном окне "Хотите заказать?"
    public void clickWantToPlaceYes() {
        driver.findElement(WANT_TO_PLACE_YES).click();
    }
    //Создали метод для получения текста из модального окна "Заказ оформлен"
    public String hasBeenPlaced() {
        return  driver.findElement(ORDER_HAS_BEEN_PLACED).getText();


    }
    public void order (String name, String lastName, String address, String phone, String comment) {
        setName(name);
        setLastName(lastName);
        setAddress(address);
        clickSubway();
        clickSubwaySelection();
        setPhone(phone);
        clickNextButton();
        clickDate();
        clickOrderDate();
        clickRentalPeriod();
        clickChoosingTheRentalPeriod();
        clickColor();
        setComment(comment);
        clickOrderButton();
        clickWantToPlaceYes();
    }
}
