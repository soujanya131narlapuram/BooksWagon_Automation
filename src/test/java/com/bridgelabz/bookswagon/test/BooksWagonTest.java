package com.bridgelabz.bookswagon.test;

import com.bridgelabz.base.Baseclass;
import com.bridgelabz.base.TestNGListeners;
import com.bridgelabz.pages.*;
import com.bridgelabz.utility.DataProviderLogic;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
@Listeners(TestNGListeners.class)

public class BooksWagonTest extends Baseclass {




        LoginPage login;
        WishlistPage wish;
        HomePage home;
        AddToCart addBook;

        AddressPage address;

        @BeforeMethod
        public void initialization() throws IOException {
            setup();

            login = new LoginPage(driver);
            home = new HomePage(driver);
            wish = new WishlistPage(driver);
            addBook = new AddToCart(driver);
            address = new AddressPage(driver);
        }



        @Test(priority = 0, dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
        public void homepageSearch(String mob, String pass) throws InterruptedException, AWTException {
            login.loginToBooksWagon(mob, pass);
            Thread.sleep(500);
            home.searchBook();
            home.logout();
        }

        @Test(priority = 1, dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
        public void wishlistCheck(String mob, String pass) throws InterruptedException, AWTException {
            login.loginToBooksWagon(mob, pass);
            Thread.sleep(500);
            wish.wishlistCheck();
            Thread.sleep(500);
            home.logout();
        }
        @Test(priority = 2, dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
        public void placeOrder(String mob, String pass) throws InterruptedException, AWTException {
            login.loginToBooksWagon(mob, pass);
            addBook.addToCart();
            Thread.sleep(3000);
        }

        @Test(priority = 3, dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
        public void yourAddressSaving(String mob, String pass) throws InterruptedException, AWTException {
            login.loginToBooksWagon(mob, pass);
            Thread.sleep(1000);
            address.fillAddress();
            Thread.sleep(500);
            home.logout();
            Thread.sleep(500);
        }
        @AfterMethod
        public void tearDown() {
            closeWindow();
        }

}
