package org.Tests;

import Objects.SearchPage;
import Objects.SearchResultPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTests {
    SearchPage searchPage;
    SearchResultPage searchResultPage;

    @BeforeClass
    public void setUpDriver() {
        ChromeDriver driver = new ChromeDriver();

        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @AfterClass
    public void closeUpDriver() {
        searchResultPage.quit();
    }

    @Test
    public void testIsDriverWork() {
        Assert.assertNotNull(searchPage, "Driver is not initialized");
    }

    @Test(dependsOnMethods = "testIsDriverWork")
    public void testIsPageLoad() {
        searchPage.getPage();

        Assert.assertNotNull(searchPage.getPageUrl(), "UrlIsNull");

        Assert.assertTrue(searchPage.isUrlContain("https://www.google.com"), "Wrong Url");

        Assert.assertEquals(searchPage.title(), "Google", "Wrong page title");
    }

    @Test(dependsOnMethods = "testIsPageLoad")
    public void testIsTextEntered() {
        searchPage.sendSearchText("Java");

        Assert.assertEquals(searchPage.getSearchText(), "Java",
                "The text entered into the search is different");
    }

    @Test(dependsOnMethods = "testIsTextEntered")
    public void testIsSearchWork() {
        searchPage.submitSearch();

        Assert.assertTrue( searchResultPage.isUrlContain("sorry")
                || searchResultPage.isUrlContain("search"), "Wrong Url");
    }
}