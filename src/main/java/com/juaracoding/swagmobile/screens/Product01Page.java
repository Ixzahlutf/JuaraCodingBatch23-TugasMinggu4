package com.juaracoding.swagmobile.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Product01Page {
    private AndroidDriver driver;
    private By image = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView");
    
    public Product01Page(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getImageElement() {
        return driver.findElement(image);
    }
    
}
