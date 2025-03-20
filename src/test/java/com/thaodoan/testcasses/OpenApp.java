package com.thaodoan.testcasses;

import com.thaodoan.common.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.thaodoan.devices.DriverManager.getDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OpenApp extends BaseTest {
    @Test
    public void testFirstLaunchBehavior() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15)); // Wait up to 15 seconds

        try {
            // Wait for the popup to appear
            WebElement onetimeButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button")));
            WebElement onlyButton = getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
            WebElement denyButton = getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button"));

            // Check which button is displayed and click it
            if (onetimeButton.isDisplayed()) {
                onetimeButton.click();
                System.out.println("Selected 'While using the app'");
            } else if (onlyButton.isDisplayed()) {
                onlyButton.click();
                System.out.println("Selected 'Only this time'");
            } else if (denyButton.isDisplayed()) {
                denyButton.click();
                System.out.println("Selected 'Don't allow'");
            }

        } catch (Exception e) {
            System.out.println("Permission popup not found. This may be the second time opening the app.");
        }
    }

}