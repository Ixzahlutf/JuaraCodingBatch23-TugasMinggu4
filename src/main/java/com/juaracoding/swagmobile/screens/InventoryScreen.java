package com.juaracoding.swagmobile.screens;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class InventoryScreen {
  private AndroidDriver driver;
  private By headerProduct = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
  private By productCards = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]");
  private By scrollView = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]");
  private By product1 = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup");

  public InventoryScreen(AndroidDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.findElement(headerProduct).getText();
  }

  public int getTotalProduct() {
    return driver.findElements(productCards).size();
  }

  public void scrollDown(double percent) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("elementId", driver.findElement(scrollView));
    params.put("direction", "down");
    params.put("percent", percent);
    params.put("speed", 1000);

    js.executeScript("mobile: scrollGesture", params);
  }

  public void clickProduct1() {
    driver.findElement(product1).click();
  }

}
