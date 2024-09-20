import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.out.println("Инициализация драйвера и открытие сайта...");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://www.mts.by");

        // Принятие cookie
        System.out.println("Ожидание элемента cookie и его принятие...");
        WebElement cookie = wait.until(ExpectedConditions.elementToBeClickable(By.className("cookie__ok")));
        cookie.click();
        System.out.println("Cookie принято.");
    }

    @Test(priority = 1)
    public void testHeaderPay() {
        System.out.println("Начало теста: проверка заголовка блока 'Оплата'...");

        WebElement headerPay = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String textHeaderPay = headerPay.getText();
        System.out.println("Заголовок найден: " + textHeaderPay);

        Assert.assertTrue(textHeaderPay.contains("Онлайн пополнение") && textHeaderPay.contains("без комиссии"),
                "Ошибка: Заголовки не совпадают.");
        System.out.println("Заголовки совпадают.");
    }

    @Test(priority = 2)
    public void testLogoPay() {
        System.out.println("Начало теста: проверка наличия логотипов платёжных систем...");

        List<WebElement> logoPay = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li/img"));
        int elementsCount = logoPay.size();
        System.out.println("Найдено логотипов: " + elementsCount);

        Assert.assertEquals(elementsCount, 5, "Ошибка: Платежные логотипы отсутствуют.");
        System.out.println("Платежные логотипы присутствуют.");
    }

    @Test(priority = 3)
    public void testServiceLink() {
        System.out.println("Начало теста: проверка работы ссылки 'Подробнее о сервисе'...");

        WebElement linkInfo = driver.findElement(By.linkText("Подробнее о сервисе"));
        linkInfo.click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Переход по ссылке. Текущий URL: " + currentUrl);

        Assert.assertEquals(currentUrl, "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                "Ошибка: Ссылка некорректная.");
        System.out.println("Ссылка работает корректно.");
    }

    @Test(priority = 4)
    public void testContinueButton() throws InterruptedException {
        System.out.println("Начало теста: проверка работы кнопки 'Продолжить'...");

        WebElement home = driver.findElement(By.className("page-header__logo"));
        home.click();
        System.out.println("Переход на главную страницу...");

        WebElement dropdownToggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        dropdownToggle.click();
        System.out.println("Открытие выпадающего списка...");

        WebElement option = driver.findElement(By.xpath("//*[text()='Услуги связи']"));
        option.click();
        System.out.println("Выбор опции 'Услуги связи'...");

        WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
        phoneNumber.sendKeys("297777777");
        System.out.println("Ввод номера телефона...");

        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.sendKeys("29");
        System.out.println("Ввод суммы...");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        System.out.println("Нажатие на кнопку 'Продолжить'...");

        Thread.sleep(2000);
        WebElement modalWindow = driver.findElement(By.className("bepaid-app"));
        if (modalWindow.isDisplayed()) {
            System.out.println("Кнопка 'Продолжить' работает корректно.");
        } else {
            System.out.println("Ошибка: Кнопка 'Продолжить' НЕ работает.");
        }
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Закрытие браузера...");
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Тест завершен.");
    }
}


