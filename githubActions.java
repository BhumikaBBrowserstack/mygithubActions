// Sample test in Java to run Automate session.

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class githubActions {

  public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
  public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
  public static final String LOCAL_IDENTIFIER = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
  public static final String BUILD_NAME = System.getenv("BROWSERSTACK_BUILD_NAME");
  public static final String PROJECT_NAME = System.getenv("BROWSERSTACK_PROJECT_NAME");

  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "latest");
    caps.setCapability("browserstack.local", "true");
    caps.setCapability("browserstack.localIdentifier", LOCAL_IDENTIFIER);
    caps.setCapability("project", PROJECT_NAME);
    caps.setCapability("build", BUILD_NAME);
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://localhost:8099"); // HTTP Server should be running on 8099 port of GitHub runner
    System.out.println(driver.getTitle());
    driver.quit();
  }
}
