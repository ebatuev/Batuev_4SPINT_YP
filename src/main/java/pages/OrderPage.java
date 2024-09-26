package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// Страница заказа (Создали page object — класс для страницы.)
public class OrderPage {

    private final WebDriver driver;
    private WebDriver driver1; // Добавили поле driver

    // Добавляем локаторы:
    // локатор поля "Имя"
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // локатор поля "Фамилия"
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор поля "Адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор поля "Станция метро"
    private By metroField = By.className("select-search__input");
    // локатор поля "Телефон"
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор кнопки "Далее"
    private By nextButton = By.xpath("//div[contains(@class,'Order_NextButton')]//button[text()='Далее']");
    // локатор поля "Когда привезти самокат"
    private By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор поля "Срок аренды"
    private By inputPeriod = By.xpath(".//div/div[2]/div[2]/div[2]/div[1]/div[1]");
    // локатор выбора чекбокса "Цвет самоката"
    private By selectColor = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]");
    // локатор поля"Комментарий для курьера"
    private By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки "Заказать"
    private By orderButton = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
    // локатор кнопки "Да"
    private By yesButton = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Да']");


    // Добавили конструктор класса page object
    public OrderPage(WebDriver driver){
        this.driver = driver; // Инициализировали в нём поле driver
    }


    // Методы:
    /** Объявил методы для страницы "Для кого самокат" с ожиданием, когда поле станет кликабельным (знаю, что можно без него :) )**/
    // метод для проверки открытости поля «Имя» и ввода нового значения из параметра
    public void setNameField(String newNameField) { //установить новое Занятие
        // дождаться, пока поле не станет кликабельным
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(nameField));
        //ввод нового значения из параметра
        driver.findElement(nameField).sendKeys(newNameField);
    }
    // метод для проверки открытости поля «Фамилия» и ввода нового значения из параметра
    public void setSurnameField(String newSurnameField) { //установить новое Занятие
        // дождаться, пока поле не станет кликабельным
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(surnameField));
        //ввод нового значения из параметра
        driver.findElement(surnameField).sendKeys(newSurnameField);
    }
    // метод для проверки открытости поля «Адрес» и ввода нового значения из параметра
    public void setAddressField(String newAddressField) { //установить новое Занятие
        // дождаться, пока поле не станет кликабельным
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(addressField));
        //ввод нового значения из параметра
        driver.findElement(addressField).sendKeys(newAddressField);
    }
    // метод выбора поля «Станция метро» - список
    public void choiceMetroField() {
            driver.findElement(metroField).sendKeys("Площадь революции");
            driver.findElement(By.xpath(".//button[@value='58']")).click();
        }
    // метод для проверки открытости поля «Телефон» и ввода нового значения из параметра
    public void setPhoneField(String newPhoneField) { //установить новое Занятие
        // дождаться, пока поле не станет кликабельным
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(phoneField));
        //ввод нового значения из параметра
        driver.findElement(phoneField).sendKeys(newPhoneField);
    }
    // метод для нажатия кнопки "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    /** Объявил методы для заполнения страницы "Про аренду" **/
    // метод для "Когда привезти самокат" - календарь
    public void inputDates(String date) {
        driver.findElement(inputDate).sendKeys(date, Keys.ENTER); // это загуглил :)
    }
    // метод для "Срок аренды" - список
    public void clickPeriod() {
        driver.findElement(inputPeriod).click();
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[2]")).click();
    }
    // метод для "Цвет самоката" - чекбокс
    public void clickColor() {
        driver.findElement(selectColor).click();
    }
    // метод для "Комментарий для курьера"
    public void inputComment(String commentary){
        driver.findElement(inputComment).sendKeys(commentary);
    }
    // метод для кнопки "Заказать"
    public void clickOrder() {
        driver.findElement(orderButton).click();
    }

    /** Объявил методы для заполнения окна "Хотите оформить заказ?" **/
    // метод для кнопки "Да" для окна "Хотите оформить заказ?"
    public void clickYes() {
        driver.findElement(yesButton).click();
    }

}
