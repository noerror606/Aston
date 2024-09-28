package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaySection extends BasePage {
    private final WebDriverWait wait;

    private final By headerPay = By.xpath("//div[@id='pay-section']//h2");
    private final By logoPay = By.xpath("//div[@id='pay-section']//ul/li/img");
    private final By serviceLink = By.linkText("Подробнее о сервисе");
    private final By home = By.className("page-header__logo");
    private final By dropdownToggle = By.xpath("//div[@id='pay-section']//div[contains(@class, 'select')]//button");
    private final By optionServicePhone = By.xpath("//*[text()='Услуги связи']");
    private final By phoneNumberFill = By.id("connection-phone");
    private final By sumFill = By.id("connection-sum");
    private final By frame = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By modal = By.className("bepaid-app");
    private final By closeModalButton = By.className("header__close-icon");
    private final By dropdownButton = By.xpath("//div[contains(@class, 'select')]");
    private final By paymentTypes = By.xpath("//div[contains(@class, 'select')]//ul[@class='select__list']/li/p");
    private final By sumField = By.xpath("//form[contains(@class, 'pay-form') and contains(@class, 'opened')]//input[@placeholder='Сумма']");
    private final By emailField = By.xpath("//form[contains(@class, 'pay-form') and contains(@class, 'opened')]//input[@placeholder='E-mail для отправки чека']");
    private final By continueButton = By.xpath("//form[@id='pay-connection']//button[@type='submit' and contains(@class, 'button__default')]");


    public PaySection(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Явные ожидания
    }

    public WebElement getHeaderPay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerPay));
    }

    public List<WebElement> getLogoPay() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logoPay));
    }

    public WebElement getFrame(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(frame));
    }

    public WebElement getModal(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
    }

    public WebElement getServiceLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(serviceLink));
    }

    public WebElement getHome(){
        return driver.findElement(home);
    }

    public WebElement getDropdownToggle() {
        return driver.findElement(dropdownToggle);
    }

    public WebElement getPhoneNumberFill(){
        return driver.findElement(phoneNumberFill);
    }

    public WebElement getSumFill(){
        return driver.findElement(sumFill);
    }

    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }

    public WebElement getCloseModalButton(){
        return driver.findElement(closeModalButton);
    }

    public WebElement getDropdownButton() {
        return driver.findElement(dropdownButton);
    }

    public WebElement getOptionServicePhone(){
        return driver.findElement(optionServicePhone);
    }

    public WebElement getPaymentType(String paymentType) {
        WebElement elementType = null;
        for (WebElement type : driver.findElements(paymentTypes)) {
            if (type.getText().equals(paymentType)) {
                elementType = type;
            }
        }
        return elementType;
    }

    public WebElement getSpecialField(String paymentType) {
        String fieldId;
        switch (paymentType) {
            case "Услуги связи":
                fieldId = "connection-phone";
                break;
            case "Домашний интернет":
                fieldId = "internet-phone";
                break;
            case "Рассрочка":
                fieldId = "score-instalment";
                break;
            case "Задолженность":
                fieldId = "score-arrears";
                break;
            default:
                throw new IllegalStateException("Неизвестный тип оплаты: " + paymentType);
        }
        return driver.findElement(By.id(fieldId));
    }

    public WebElement getSumField() {
        return driver.findElement(sumField);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}

