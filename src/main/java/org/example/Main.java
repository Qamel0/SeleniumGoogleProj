package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com.ua/");

        driver.findElement(By.id("APjFqb")).sendKeys("Java");

        driver.findElement(By.name("btnK")).submit();
    }
}