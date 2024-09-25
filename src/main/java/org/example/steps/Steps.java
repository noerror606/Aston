package org.example.steps;

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

    public String getHeaderText(){
        return paySection.getHeaderPay().getText();
    }

    public int getLogoCount() {
        List<WebElement> logos = paySection.getLogoPay();
        return logos.size();
    }

    public void clickServiceLink() {
        paySection.getServiceLink().click();
    }

    public void backPage() {
        paySection.getHome().click();
    }

    public void enterDetailsAndContinue(String phone, String sum) {
        paySection.getDropdownToggle().click();
        paySection.getOptionServicePhone().click();
        paySection.getPhoneNumberFill().sendKeys(phone);
        paySection.getSumFill().sendKeys(sum);
        paySection.getContinueButton().click();
    }

    public void setCloseModalWindow() {
        WebElement frame = paySection.getFrame();
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.elementToBeClickable(paySection.getCloseModalButton())).click();
        driver.switchTo().defaultContent();
    }

    public void clickDropdownButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(paySection.getDropdownButton())).click();
    }

    public void selectPaymentType(String paymentType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(paySection.getPaymentType(paymentType))).click();
    }

    public boolean isModalWindowDisplayed(){
        try {
            WebElement modal = paySection.getModal();
            return modal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void fillSpecialField(String paymentType, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement specialField = wait.until(ExpectedConditions.visibilityOf(paySection.getSpecialField(paymentType)));
        specialField.clear();
        specialField.sendKeys(text);
    }

    public void fillSumField(String sumAmount) {
        WebElement sumField = paySection.getSumField();
        sumField.clear();
        sumField.sendKeys(sumAmount);
    }

    public void fillEmailField(String email) {
        WebElement emailField = paySection.getEmailField();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void submitPayment() {
        paySection.clickContinueButton();
    }

    public boolean isModalDisplayed() {
        return payPopup.isModalDisplayed();
    }

    public String getSum(){
        return payPopup.getSum();
    }

    public String getSumOnButton() {
        return payPopup.getSumOnButton();
    }

    public String getPhoneNumber() {
        return payPopup.getPhoneNumber();
    }

    public boolean verifyCardPlaceholders(String[] expectedPlaceholders) {
        return payPopup.verifyCardPlaceholders(expectedPlaceholders);
    }

    public boolean verifyPaymentIcons(String[] expectedIcons) {
        return payPopup.verifyPaymentIcons(expectedIcons);
    }

}