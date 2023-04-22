package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;


public class MainPageTest {

    // создали драйвер для браузера Chrome.
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);
    MainPage objMainPage = new MainPage(driver);
    // перешли на страницу тестового приложения
    String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void testPreparing(){
        driver.get(url);
        objMainPage.clickButtonEveryoneIsUsedToIt();

        new WebDriverWait(driver,3);
    }

    //private WebDriver driver;

    @Test
    public void checkFAQ() {

        // Создай объект класса Страницы заказа.
        MainPage objMainPage = new MainPage(driver);
        // Скролл до аккордиона
        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        objMainPage.openFAQ1();
        // Ожидание, что кнопка станет кликабельной; ожидание не больше 4 секунд
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-0")));
        // Найди ответ и получи его текст
        String actual = driver.findElement(By.id("accordion__panel-0")).getText();
        // Метод assertEquals проверяет, что два значения равны (ожидаемое и фактическое + добавиди сообщение, если будет ошибка)
        assertEquals("FAQ1 текст не соответствует", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", actual);

        objMainPage.openFAQ2();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-1")));
        actual = driver.findElement(By.id("accordion__panel-1")).getText();
        assertEquals("FAQ2 текст не соответствует", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", actual);

        objMainPage.openFAQ3();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-2")));
        actual = driver.findElement(By.id("accordion__panel-2")).getText();
        assertEquals("FAQ3 текст не соответствует", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", actual);

        objMainPage.openFAQ4();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-3")));
        actual = driver.findElement(By.id("accordion__panel-3")).getText();
        assertEquals("FAQ4 текст не соответствует", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", actual);

        objMainPage.openFAQ5();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-4")));
        actual = driver.findElement(By.id("accordion__panel-4")).getText();
        assertEquals("FAQ5 текст не соответствует", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", actual);

        objMainPage.openFAQ6();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-5")));
        actual = driver.findElement(By.id("accordion__panel-5")).getText();
        assertEquals("FAQ6 текст не соответствует", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", actual);

        objMainPage.openFAQ7();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-6")));
        actual = driver.findElement(By.id("accordion__panel-6")).getText();
        assertEquals("FAQ7 текст не соответствует", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", actual);

        objMainPage.openFAQ8();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-7")));
        actual = driver.findElement(By.id("accordion__panel-7")).getText();
        assertEquals("FAQ8 текст не соответствует", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", actual);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}