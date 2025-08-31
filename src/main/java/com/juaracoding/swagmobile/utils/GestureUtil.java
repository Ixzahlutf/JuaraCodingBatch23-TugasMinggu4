package com.juaracoding.swagmobile.utils;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtil {
    private AndroidDriver driver;

    public GestureUtil(AndroidDriver driver) {
        this.driver = driver;
    }

    public void pinchOut(WebElement element, int offset){

        // koordinat tengah gambar
        int centerX = element.getRect().getX() + (element.getRect().getWidth()/2);
        int centerY = element.getRect().getY() + (element.getRect().getHeight()/2);

        // inisialisasi dua jari
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        // inisialisasi urutan gerakan jari 1
        Sequence seq1 = new Sequence(finger1, 1);
        seq1.addAction(finger1.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), centerX, centerY));
        seq1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq1.addAction(finger1.createPointerMove(Duration.ofMillis(500),
                PointerInput.Origin.viewport(), centerX - offset, centerY - offset));
        seq1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // inisialisasi urutan gerakan jari 2
        Sequence seq2 = new Sequence(finger2, 1);
        seq2.addAction(finger2.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), centerX, centerY));
        seq2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq2.addAction(finger2.createPointerMove(Duration.ofMillis(500),
                PointerInput.Origin.viewport(), centerX + offset, centerY + offset));
        seq2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // gabungkan kedua urutan gerakan
        driver.perform(Arrays.asList(seq1, seq2));
    }
}