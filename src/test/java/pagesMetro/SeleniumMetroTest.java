package pagesMetro;

// ЭТО ПОСЛЕДНЕЕ ЗАДАНИЕ ПО СИЛЕНИЕМУ ИЗ КУРСА
// ДОБАВИЛ ЕГО СЮДА ЧТОБЫ ПРОВЕРИТЬ - ОН СКОРЕЕ ВСЕГО НЕ ЗАПУСТИТСЯ ИЗ-ЗА ДРАЙВЕРА ХРОМА

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumMetroTest {

    // создай поля для драйвера и страницы
    private WebDriver driver;
    private MetroHomePage metroPage;


    // создай константы для тестовых данных
    private static final String CITY_SAINTP = "Санкт-Петербург";
    private static final String STATION_SPORTIVNAYA = "Спортивная";

    // добавь константы для станций «Лубянка» и «Красногвардейская»
    private static final String STATION_LUBYANKA = "Лубянка";
    private static final String STATION_KRASNOGVARD = "Красногвардейская";

    // все предварительные действия вынеси в Before
    @Before
    public void setUp() {
        // открой браузер Chrome
        ChromeOptions options = new ChromeOptions(); //Драйвер для браузера
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // перейди на страницу тестового приложения
        driver.get("https://qa-metro.stand-2.praktikum-services.ru/");
        // создай объект класса страницы стенда
        metroPage = new MetroHomePage(driver);
        // дождись загрузки страницы
        metroPage.waitForLoadHomePage();
    }


    // проверь, как работает выбор города
    @Test
    public void checkChooseCityDropdown() {
        // выбери Санкт-Петербург в списке городов
        metroPage.chooseCity(CITY_SAINTP);
        // проверь, что станция метро «Спортивная» видна через 8 секунд
        metroPage.waitForStationVisibility(STATION_SPORTIVNAYA); // Чтобы проверить видимость станции метро «Спортивная», используй метод waitForStationVisibility. Передай в него параметр STATION_SPORTIVNAYA.
    }

    // проверь отображение времени маршрута
    @Test
    public void checkRouteApproxTimeIsDisplayed() {
        // построй маршрут от «Лубянки» до «Красногвардейской»
        metroPage.buildRoute(STATION_LUBYANKA, STATION_KRASNOGVARD); // Чтобы построить маршрут, нужно указать названия станций как аргументы метода buildRoute.
        // проверь, что у первого маршрута списка отображается нужное примерное время поездки
        Assert.assertEquals("≈ 36 мин.", metroPage.getApproximateRouteTime(0)); // Проверить время поездки можно с помощью метода getApproximateRouteTime из Page Object. Ещё потребуется метод assertEquals() класса Assert. Тебе нужно проверить, что время первого маршрута равно ≈ 36 мин.. Не забывай: это нулевой элемент в коллекции времён всех маршрутов.
    }

    // проверь отображение станции «Откуда» в карточке маршрута
    @Test
    public void checkRouteStationFromIsCorrect() {
        // построй маршрут от «Лубянки» до «Красногвардейской»
        metroPage.buildRoute(STATION_LUBYANKA, STATION_KRASNOGVARD); // Чтобы построить маршрут, укажи названия станций как аргументы
        // проверь, что отображается корректное название станции начала маршрута
        Assert.assertEquals(STATION_LUBYANKA, metroPage.getRouteStationFrom()); // Чтобы проверить название станции «Откуда», используй метод assertEquals() класса Assert. Затем сопоставь ожидаемое значение с результатом метода metroPage.getRouteStationFrom(). Они должны совпадать.
    }

    // проверь отображение станции «Куда» в карточке маршрута
    @Test
    public void checkRouteStationToIsCorrect() {
        // построй маршрут от «Лубянки» до «Красногвардейской»
        metroPage.buildRoute(STATION_LUBYANKA, STATION_KRASNOGVARD); // Чтобы построить маршрут, укажи названия станций как аргументы
        // проверь, что отображается корректное название станции конца маршрута
        Assert.assertEquals(STATION_KRASNOGVARD, metroPage.getRouteStationTo()); // Чтобы проверить название станции «Откуда», используй метод assertEquals() класса Assert. Проверь, что ожидаемое значение совпадает с результатом метода metroPage.getRouteStationFrom().
    }


    // добавь метод с аннотацией After для закрытия браузера
    @After
    public void tearDown() {
        // закрой браузер
        driver.quit();
    }

}
