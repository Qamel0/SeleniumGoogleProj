package Objects;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected  final WebDriver driver;

    public BasePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isUrlContain(String text) {
        return getPageUrl().contains(text);
    }

    public void quit() {
        driver.quit();
    }
}
