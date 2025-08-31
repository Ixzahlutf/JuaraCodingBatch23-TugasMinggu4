package com.juaracoding.swagmobile;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.swagmobile.screens.InventoryScreen;
import com.juaracoding.swagmobile.screens.LoginScreen;
import com.juaracoding.swagmobile.screens.Product01Page;
import com.juaracoding.swagmobile.utils.DriverUtil;
import com.juaracoding.swagmobile.utils.GestureUtil;

public class PinchOutTest {
  @Test
  public void TC0001() throws MalformedURLException {
    DriverUtil driverUtil = new DriverUtil();
    LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
    InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());
    Product01Page product01Page = new Product01Page(driverUtil.getDriver());
    GestureUtil gestureUtil = new GestureUtil(driverUtil.getDriver());
    loginScreen.login("standard_user", "secret_sauce");
    
    inventoryScreen.clickProduct1();

    gestureUtil.pinchOut(product01Page.getImageElement(), 200);
    
    // driverUtil.quitApp();
  }
}
