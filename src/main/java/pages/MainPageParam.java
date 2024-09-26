package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Главная страница (Создали page object — класс для страницы)
public class MainPageParam {

    private WebDriver driver; // Добавили поле driver

    // Добавляем локаторы:
    //локатор ответа
    private By openAnswerText = By.xpath("//div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p");
    // кнопка "Куки"
    private By cookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    // локатор до текста "Вопросы о важном"
    private By mainQuestionText = By.xpath("//div[text()='Вопросы о важном']");

    // Добавили конструктор класса page object
    public MainPageParam(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }


    // Методы:
    // кликнуть по кнопке «Куки»
    public void clickSignInButton() {
        driver.findElement(cookiesButton).click();
    }
    // скролл до текста "Вопросы о важном"
    public void scrollToMainQuestion() {
        WebElement element = driver.findElement(mainQuestionText);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // метод получения текста ответа
    public String getOpenAnswerText() {
        String textElement = driver.findElement(openAnswerText).getText();
        return textElement;
    }

}
