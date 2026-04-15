package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutFlow() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add product
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();

        // Fill form
        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        // Validate
        String message = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(message, "Thank you for your order!");

        // Back home
        driver.findElement(By.id("back-to-products")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}
