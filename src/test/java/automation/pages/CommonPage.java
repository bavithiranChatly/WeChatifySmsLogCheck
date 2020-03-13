package automation.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jline.internal.Log;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CommonPage {

	public WebDriver driver;

	// loginusername
	@FindBy(xpath = "//input[@id='username']")
	private WebElement loginUsername;

	// loginButton
	@FindBy(xpath = "//input[@id='submit-btn']")
	private WebElement loginButton;

	// loginPassword
	@FindBy(xpath = "//input[@id='password']")
	private WebElement loginPassword;

	public void launchBrowser(String url, String browser) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", readDefaultProperties(browser));
		driver = new ChromeDriver();
		launchApplication(driver);

	}

	public String readDefaultProperties(String toRead) throws IOException {
		Properties defaultProperties = new Properties();
		FileInputStream serenityFile = new FileInputStream(System.getProperty("user.dir") + "\\application.properties");
		defaultProperties.load(serenityFile);
		String result = defaultProperties.getProperty(toRead);

		return result;

	}

	public void launchApplication(WebDriver driver) throws IOException, InterruptedException {
		// launch Application
		String urlToLaunch = "SFurl";
		driver.get(readDefaultProperties(urlToLaunch));

		// Maximize the Window
		driver.manage().window().maximize();

	}

	public void login() {

		Log.info("****************************************************************");
		driver.findElement(org.openqa.selenium.By.xpath("//input[@id='username']")).clear();
		driver.findElement(org.openqa.selenium.By.xpath("//input[@id='username']")).sendKeys("QA login");

		driver.findElement(org.openqa.selenium.By.xpath("//input[@id='submit-btn']")).click();

		driver.findElement(org.openqa.selenium.By.xpath("//input[@id='password']")).clear();
		driver.findElement(org.openqa.selenium.By.xpath("//input[@id='password']")).sendKeys("Password8*");

		driver.findElement(org.openqa.selenium.By.xpath("//input[@id='submit-btn']")).click();

		// Alternate Solution for Login() function
		/**
		 * Log.info(loginUsername); loginUsername.clear(); loginUsername.sendKeys("QA
		 * login"); loginButton.click();
		 * 
		 * loginPassword.clear(); loginPassword.sendKeys("Password8*");
		 * loginButton.click();
		 **/
	}

	public void parentMenuSelection(String parentMenuName) throws Exception {

		Thread.sleep(5000);
		driver.findElement(org.openqa.selenium.By.xpath(
				"//li[@class='mc-app-switcher-group some-provisioned']//div[@class='mc-app-name-container']//span[text()='"
						+ parentMenuName + "']"))
				.click();

	}

	public void childMenuSelection(String childMenuName) {
		driver.findElement(org.openqa.selenium.By
				.xpath("//ul[@class='mc-app-group-dropdown-apps']//li//span[text()='" + childMenuName + "']")).click();

	}
}
