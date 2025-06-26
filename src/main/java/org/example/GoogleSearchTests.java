package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTests {
    WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        driver = new EdgeDriver();
    }

    @Test
    public void testIsDriverWork() {
        Assert.assertNotNull(driver, "Driver is not initialized");
    }

    @Test(dependsOnMethods = "testIsDriverWork")
    public void testIsPageLoad() {
        driver.get("https://www.google.com.ua/");
        String currentUrl = driver.getCurrentUrl();

        Assert.assertNotNull(currentUrl, "UrlIsNull");

        Assert.assertTrue(currentUrl.contains("https://www.google.com"), "Wrong Url");

        Assert.assertEquals(driver.getTitle(), "Google", "Wrong page title");
    }

    @Test(dependsOnMethods = "testIsPageLoad")
    public void testIsTextEntered() {
        WebElement element = driver.findElement(By.id("APjFqb"));

        element.sendKeys("Java");

        Assert.assertEquals(element.getAttribute("value"), "Java",
                "The text entered into the search is different");
    }

    @Test(dependsOnMethods = "testIsTextEntered")
    public void testIsSearchWork() {
        driver.findElement(By.name("btnK")).submit();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertNotNull(currentUrl, "UrlIsNull");

        Assert.assertTrue(currentUrl.contains("sorry") || currentUrl.contains("search"),
                "Wrong Url");
    }
}