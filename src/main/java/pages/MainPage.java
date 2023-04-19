package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// Главная страница (Создали page object — класс для страницы.)
public class MainPage {

    private WebDriver driver; // Добавили поле driver
    // Добавляем локаторы:
    // локатор кнопки куки "да все привыкли" окна "И здесь куки! В общем, мы их используем."
    private By buttonEveryoneIsUsedToIt = By.id("rcc-confirm-button");
    // локатор верхней кнопке "Заказать"
    private By buttonOrderTop = By.xpath("//div[contains(@class,'Header')]//button[text()='Заказать']");
    // локатор нижней кнопке "Заказать"
    private By buttonOrderBottom = By.xpath("//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");
    // локаторы для кнопок «Вопросы о важном»
    private By FAQ1 = By.xpath("//*[@id='accordion__heading-0']");
    private By FAQ2 = By.xpath("//*[@id='accordion__heading-1']");
    private By FAQ3 = By.xpath("//*[@id='accordion__heading-2']");
    private By FAQ4 = By.xpath("//*[@id='accordion__heading-3']");
    private By FAQ5 = By.xpath("//*[@id='accordion__heading-4']");
    private By FAQ6 = By.xpath("//*[@id='accordion__heading-5']");
    private By FAQ7 = By.xpath("//*[@id='accordion__heading-6']");
    private By FAQ8 = By.xpath("//*[@id='accordion__heading-7']");


    // Добавили конструктор класса page object
    public MainPage (WebDriver driver){
        this.driver = driver; // Инициализировали в нём поле driver
    }

    // Методы:
    /** Объявил методы для закрытия окна "И здесь куки! В общем, мы их используем." **/
    // метод кликает на кнопку "да все привыкли"
    public void clickButtonEveryoneIsUsedToIt() {
        driver.findElement(buttonEveryoneIsUsedToIt).click();
    }

    /** Объявил методы для верхней и нижней кнопки "Заказать" + скролл до неё **/
    // метод кликает по верхней кнопке "Заказать"
    public void clickButtonOrderTop() {
        driver.findElement(buttonOrderTop).click();
    }
    // метод кликает по нижней кнопке "Заказать"
    public void clickButtonOrderBottom() {
        driver.findElement(buttonOrderBottom).click();
    }
    // метод скролл до нижней кнопке "Заказать"
    public void scrollToButtonOrderBottom() {
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    /** Объявил методы клика по каждому вопросу в «Вопросы о важном» **/
    // методы клика по «Вопросы о важном»
    public void openFAQ1() { driver.findElement(FAQ1).click(); }
    public void openFAQ2(){
        driver.findElement(FAQ2).click();
    }
    public void openFAQ3(){
        driver.findElement(FAQ3).click();
    }
    public void openFAQ4(){
        driver.findElement(FAQ4).click();
    }
    public void openFAQ5(){
        driver.findElement(FAQ5).click();
    }
    public void openFAQ6(){
        driver.findElement(FAQ6).click();
    }
    public void openFAQ7(){
        driver.findElement(FAQ7).click();
    }
    public void openFAQ8(){
        driver.findElement(FAQ8).click();
    }


}









