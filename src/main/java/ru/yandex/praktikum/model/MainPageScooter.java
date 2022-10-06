package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageScooter {
    //Задали переменную driver
    private final WebDriver driver;

    //Создали конструктор класса MainPageScooter
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Зададим переменную, которой присовим локатор для кнопки "Заказать"
    private final By ORDER_BUTTON_HEADER = By.xpath(".//button[@class = 'Button_Button__ra12g' and text()='Заказать']");
    private final By ORDER_BUTTON_MIDDLE = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    //Создали метод для клика по элементу из списка
    public void clickListOfImportantQuestions(int index) {
        //Задали переменную locator, которой назначили локатор с заданным индексом
        By locator = By.id("accordion__heading-" + index);
        //Нашли на странице элемент с заданным локатором и выполнили клик по нему
        driver.findElement(locator).click();
    }

    //Создали метод для получения текста из элемента на странице
    public String getTextFromTheList(int index) {
        //Задали переменную locator, которой назначили локатор с заданным индексом
        By locator = By.id("accordion__panel-" + index);
        //Нашли на странице элемент с заданным локатором, получили и вернули его текст
        return driver.findElement(locator).getText();
    }

    //Создали метод для клика по кнопке "Заказать" в шапке сайта
    public void clickHeaderOrderButton() {
        driver.findElement(ORDER_BUTTON_HEADER).click();
    }

    //Создали метод для клика по кнопке "Заказать" в середине сайта
    public void clickMiddleOrderButton() {
        driver.findElement(ORDER_BUTTON_MIDDLE).click();
    }
}