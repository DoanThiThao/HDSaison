package com.thaodoan.testcasses;

import com.thaodoan.common.BaseTest;
import com.thaodoan.devices.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.thaodoan.devices.DriverManager.getDriver;

public class LoginApp extends BaseTest {
    @Test
    public void Login_success() {
        /*WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        WebElement login1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Đăng nhập\"]")));
        login1.click();
        //input username
        WebElement inputUsername = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[1]")));
        inputUsername.click();
        inputUsername.sendKeys("1996doanthao052196007306");
        //input password
        WebElement inputPassword = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[2]")));
        inputPassword.click();
        inputPassword.sendKeys("Thao@123456");
        //Click button Login
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Đăng nhập\"]"));*/
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));

        WebElement login1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Đăng nhập\"]")));
        login1.click();

        List<WebElement> editTexts = DriverManager.getDriver().findElements(AppiumBy.className("android.widget.EditText"));
        System.out.println("Số lượng EditText: " + editTexts.size());

        if (editTexts.size() >= 2) {

            WebElement inputUsername = wait.until(ExpectedConditions.elementToBeClickable(editTexts.get(0)));
            inputUsername.click();
            inputUsername.sendKeys("1996doanthao052196007306");
            System.out.println("Username nhập thành công!");

            WebElement btnLogin = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Đăng nhập\"]"));
            boolean isDisable = !btnLogin.isDisplayed();
            if (isDisable) {
                System.out.println("Button Login disable");
            } else {
                System.out.println("Button Login enable");
            }

            WebElement inputPassword = wait.until(ExpectedConditions.elementToBeClickable(editTexts.get(1)));
            inputPassword.click();
            inputPassword.sendKeys("Thao@123456789");
            System.out.println("Password nhập thành công!");

            btnLogin.click();
            System.out.println("Click Button Đăng Nhập!");

            /*try {
                WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Thông tin không hợp lệ, bạn còn 3 lần thử.")));
                if (errorMessage.isDisplayed()) {
                    System.out.println("Đăng nhập thất bại: " + errorMessage.getAttribute("content-desc"));
                }
            } catch (Exception ex) {
                System.out.println("Không xác định được trạng thái đăng nhập.");
            }*/

        } else {
            System.out.println("Không tìm thấy đủ 2 ô nhập liệu!");
        }
    }
}

