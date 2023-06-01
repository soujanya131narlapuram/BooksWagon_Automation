package com.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

    WebDriver driver;
    @CacheLookup
    @FindBy(id = "ctl00_phBody_ShippingAddress_txtRecipientName")
    WebElement rName;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_ShippingAddress_txtCompanyName")
    WebElement cName;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_ShippingAddress_txtAddress")
    WebElement address;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_ShippingAddress_ddlState")
    WebElement state;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_ShippingAddress_ddlCities")
    WebElement city;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_ShippingAddress_txtPincode")
    WebElement pincode;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_ShippingAddress_txtMobile")
    WebElement mobile;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ShippingAddress_imgSubmit\"]")
    WebElement saveNext;

    @CacheLookup
    @FindBy(linkText = "soujanya")
    WebElement account;

    @CacheLookup
    @FindBy(xpath = "/html/body/form/div[10]/div/div/div/div/div/div[5]/div/a/img")
    WebElement address2;

    @CacheLookup
    @FindBy(linkText = "Add Address")
    WebElement address3;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAddress() throws InterruptedException {
        account.click();
        Thread.sleep(500);
        address2.click();
        Thread.sleep(500);
        address3.click();
        Thread.sleep(500);
        rName.sendKeys("Soujanya");
        Thread.sleep(500);
        cName.sendKeys("flipkart");
        Thread.sleep(500);
        address.sendKeys("");
        Thread.sleep(500);
        Select state1 = new Select(state);
        state1.selectByValue("telengana");
        Thread.sleep(500);
        Select city1 = new Select(city);
        city1.selectByValue("hyderabad");
        pincode.sendKeys("500088");
        Thread.sleep(500);
        mobile.sendKeys("9381220872");
        Thread.sleep(500);
        saveNext.click();
        Thread.sleep(500);
    }
}
