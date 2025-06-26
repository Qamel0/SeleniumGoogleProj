package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private final By searchFieldLocator = By.id("APjFqb");
    private final By searchButtonLocator = By.name("btnK");

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void getPage() {
        driver.get("https://www.google.com.ua");
    }

    public String title() {
        return driver.getTitle();
    }

    public void sendSearchText(String text) {
        driver.findElement(searchFieldLocator).sendKeys(text);
    }

    public String getSearchText() {
        return driver.findElement(searchFieldLocator).getAttribute("value");
    }

    public void submitSearch() {
        driver.findElement(searchButtonLocator).submit();
    }
}
