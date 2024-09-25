import org.example.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task {
    private Steps steps;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        steps = new Steps(driver);

        driver.get("https://www.mts.by/");
        WebElement cookie = wait.until(ExpectedConditions.elementToBeClickable(By.className("cookie__ok")));
        cookie.click();
    }

    @DataProvider(name = "paymentData")
    public static Object[][] paymentData() {
        return new Object[][]{
                {"Услуги связи", "297777777", "25", "noerror@gmail.com"},
                {"Домашний интернет", "297777777", "50", "noerror66@mail.ru"},
                {"Рассрочка", "444232080982", "75", "noerror606@yandex.ru"},
                {"Задолженность", "207321262446", "90", "noerror101@gmail.com"}
        };
    }

    @Test(description = "Проверка заголовков")
    public void testHeaderPay(){
        String textHeaderPay = steps.getHeaderText();
        assertTrue(textHeaderPay.contains("Онлайн пополнение") && textHeaderPay.contains("без комиссии"),
                "Ошибка: Заголовки не совпадают.");
    }

    @Test(description = "Проверка логотипов")
    public void testLogoPay(){
        int elementsCount = steps.getLogoCount();
        Assert.assertEquals(elementsCount, 5, "Ошибка: Платежные логотипы отсутствуют.");
    }

    @Test(description = "Проверка ссылки \"Подробнее\"")
    public void testServiceLink() {
        steps.clickServiceLink();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                "Ошибка: Ссылка некорректная.");
        steps.backPage();
    }

    @Test(description = "Проверка кнопки \"Продолжить\"")
    public void testContinueButton() {
        steps.enterDetailsAndContinue("297777777", "29");
        Assert.assertTrue(steps.isModalWindowDisplayed(), "Ошибка: Кнопка 'Продолжить' НЕ работает.");
        steps.setCloseModalWindow();
    }

    @Test(description = "Проверка заполнения полей для различных типов оплаты", dataProvider = "paymentData")
    public void paymentTypeTest(String type, String specText, String sum, String email) {
        steps.clickDropdownButton();
        steps.selectPaymentType(type);
        steps.fillSpecialField(type, specText);
        steps.fillSumField(sum);
        steps.fillEmailField(email);
    }

    @Test(description = "Проверка корректности данных в модальном окне после нажатия на кнопку 'Продолжить'")
    public void paymentModalTest() {
        steps.clickDropdownButton();
        steps.selectPaymentType("Услуги связи");
        steps.fillSpecialField("Услуги связи", "297777777");
        steps.fillSumField("50");
        steps.fillEmailField("connection@mail.ru");
        steps.submitPayment();

        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(frame);

        assertTrue(steps.isModalDisplayed(), "Модальное окно не отображается.");
        assertEquals(steps.getSum(), "50.00 BYN", "Сумма в заголовке некорректна.");
        assertEquals(steps.getSumOnButton(), "Оплатить 50.00 BYN", "Сумма на кнопке некорректна.");
        assertEquals(steps.getPhoneNumber(), "Оплата: Услуги связи Номер:375297777777", "Номер телефона некорректен.");

        String[] expectedCardPlaceholders = {"Номер карты", "CVC"};
        assertTrue(steps.verifyCardPlaceholders(expectedCardPlaceholders), "Placeholder'ы для полей карты некорректны.");

        String[] expectedPaymentIcons = {"Visa", "MasterCard", "Белкарт", "Мир"};
        assertTrue(steps.verifyPaymentIcons(expectedPaymentIcons), "Иконки платёжных систем некорректны или отсутствуют.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
