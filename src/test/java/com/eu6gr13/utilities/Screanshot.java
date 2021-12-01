package com.eu6gr13.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public abstract class Screanshot {

    public static Scenario message;

    public static void takeScreenShot() {
        byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
        message.attach(screenshot, "image/png", "Step Screenshot");
    }
}
