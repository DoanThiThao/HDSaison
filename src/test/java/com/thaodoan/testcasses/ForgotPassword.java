package com.thaodoan.testcasses;

import com.thaodoan.common.BaseTest;
import com.thaodoan.devices.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ForgotPassword extends BaseTest {
    @Test
    public void Forgot_Password(){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));

        WebElement login1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Đăng nhập\"]")));
        login1.click();

        WebElement forgotPass = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Quên mật khẩu"));
        forgotPass.click();
        System.out.println("Hiển thị màn hình Quên mật khẩu");

        
    }
}
