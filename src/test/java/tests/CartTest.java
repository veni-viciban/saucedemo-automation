package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Get product name
        String productName = driver.findElement(By.className("inventory_item_name")).getText();

        // Add to cart
        driver.findElement(By.cssSelector(".btn_inventory")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Validate
        String cartProduct = driver.findElement(By.className("inventory_item_name")).getText();
        String quantity = driver.findElement(By.className("cart_quantity")).getText();

        Assert.assertEquals(cartProduct, productName);
        Assert.assertEquals(quantity, "1");
    }
}
