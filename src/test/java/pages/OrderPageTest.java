package pages;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;

public class OrderPageTest {

    private WebDriver driver;


    @Test
    public void checkButtonOrderTop() {
        // создали драйвер для браузера Chrome.
        System.setProperty("webdriver.chrome.driver", "/Users/evgeniybatuev/Downloads/chromedriver_mac64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // перешли на страницу тестового приложения.
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создай объект класса Страницы заказа
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonEveryoneIsUsedToIt();
        objMainPage.clickButtonOrderTop();
        // создай объект класса Главной страницы
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setNameField("Евгений");
        objOrderPage.setSurnameField("Батуев");
        objOrderPage.setAddressField("Москва, ул.Ленина, дом 1");
        objOrderPage.choiceMetroField();
        objOrderPage.setPhoneField("+79199660616");
        objOrderPage.clickNextButton();
        objOrderPage.inputDates("15.04.2023");
        objOrderPage.clickPeriod();
        objOrderPage.clickColor();
        objOrderPage.inputComment("Хочется гулять, а не вот это вот все...");
        objOrderPage.clickOrder();

        String answer =   driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[1]")).getText();
        assertEquals("Заказ оформлен", answer);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

    @Test
    public void checkButtonOrderBottom() {
        // создали драйвер для браузера Chrome
        System.setProperty("webdriver.chrome.driver", "/Users/evgeniybatuev/Downloads/chromedriver_mac64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");


        // создай объект класса Страницы заказа
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonEveryoneIsUsedToIt();
        objMainPage.scrollToButtonOrderBottom(); // скрол до нижней кнопки "Заказать"
        objMainPage.clickButtonOrderBottom();
        // создай объект класса Главной страницы
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setNameField("ТестИмя");
        objOrderPage.setSurnameField("ТестФамилия");
        objOrderPage.setAddressField("ТестАдрес");
        objOrderPage.choiceMetroField();
        objOrderPage.setPhoneField("+79199660617");
        objOrderPage.clickNextButton();
        objOrderPage.inputDates("20.08.2023");
        objOrderPage.clickPeriod();
        objOrderPage.clickColor();
        objOrderPage.inputComment("Тест Комментарий ʕ•́ᴥ•̀ʔっ");
        objOrderPage.clickOrder();

        String answer =   driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[1]")).getText();
        assertEquals("Заказ оформлен", answer);
    }

}

