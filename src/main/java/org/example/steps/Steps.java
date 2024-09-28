package org.example.steps;

import io.qameta.allure.Step;
import org.example.page.PayPopup;
import org.example.page.PaySection;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Steps {
    private final PaySection paySection;
    private final PayPopup payPopup;
    private WebDriver driver;
    private WebDriverWait wait;

    // Конструктор класса Steps
    public Steps(WebDriver driver) {
        this.paySection = new PaySection(driver);
        this.payPopup = new PayPopup(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Получаем заголовок страницы")
    public String getHeaderText() {
        return paySection.getHeaderPay().getText();
    }

    @Step("Получаем количество логотипов платежных систем")
    public int getLogoCount() {
        List<WebElement> logos = paySection.getLogoPay();
        return logos.size();
    }

    @Step("Кликаем на ссылку 'Подробнее'")
    public void clickServiceLink() {
        paySection.getServiceLink().click();
    }

    @Step("Возвращаемся на главную страницу")
    public void backPage() {
        paySection.getHome().click();
    }

    @Step("Вводим данные и нажимаем 'Продолжить': телефон {phone}, сумма {sum}")
    public void enterDetailsAndContinue(String phone, String sum) {
        paySection.getDropdownToggle().click();
        paySection.getOptionServicePhone().click();
        paySection.getPhoneNumberFill().sendKeys(phone);
        paySection.getSumFill().sendKeys(sum);
        paySection.getContinueButton().click();
    }

    @Step("Закрываем модальное окно")
    public void setCloseModalWindow() {
        WebElement frame = paySection.getFrame();
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.elementToBeClickable(paySection.getCloseModalButton())).click();
        driver.switchTo().defaultContent();
    }

    @Step("Нажимаем на кнопку выпадающего списка")
    public void clickDropdownButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(paySection.getDropdownButton())).click();
    }

    @Step("Выбираем тип оплаты: {paymentType}")
    public void selectPaymentType(String paymentType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(paySection.getPaymentType(paymentType))).click();
    }

    @Step("Проверяем, отображается ли модальное окно")
    public boolean isModalWindowDisplayed() {
        try {
            WebElement modal = paySection.getModal();
            return modal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Заполняем специальное поле для {paymentType}: {text}")
    public void fillSpecialField(String paymentType, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement specialField = wait.until(ExpectedConditions.visibilityOf(paySection.getSpecialField(paymentType)));
        specialField.clear();
        specialField.sendKeys(text);
    }

    @Step("Заполняем поле суммы: {sumAmount}")
    public void fillSumField(String sumAmount) {
        WebElement sumField = paySection.getSumField();
        sumField.clear();
        sumField.sendKeys(sumAmount);
    }

    @Step("Заполняем поле Email: {email}")
    public void fillEmailField(String email) {
        WebElement emailField = paySection.getEmailField();
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Подтверждаем оплату")
    public void submitPayment() {
        paySection.clickContinueButton();
    }

    @Step("Проверяем, отображается ли модальное окно с оплатой")
    public boolean isModalDisplayed() {
        return payPopup.isModalDisplayed();
    }

    @Step("Получаем отображаемую сумму")
    public String getSum() {
        return payPopup.getSum();
    }

    @Step("Получаем сумму на кнопке оплаты")
    public String getSumOnButton() {
        return payPopup.getSumOnButton();
    }

    @Step("Получаем номер телефона")
    public String getPhoneNumber() {
        return payPopup.getPhoneNumber();
    }

    @Step("Проверяем плейсхолдеры для полей карты")
    public boolean verifyCardPlaceholders(String[] expectedPlaceholders) {
        return payPopup.verifyCardPlaceholders(expectedPlaceholders);
    }

    @Step("Проверяем иконки платежных систем")
    public boolean verifyPaymentIcons(String[] expectedIcons) {
        return payPopup.verifyPaymentIcons(expectedIcons);
    }
}
